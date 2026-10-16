package com.actividad6.actividad6.controllers;

import com.actividad6.actividad6.model.Formulario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class PruebaController {
    // creamos el mapa con clave -> valor
    private Map<String, String> usuarios = new HashMap<>();
    private Random random = new Random();

    public PruebaController() {
        usuarios.put("ana@example.com", "246810");
        usuarios.put("luis@example.com", "clave123");
    }

    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro"; // index.html
    }

    @PostMapping("/registro")
    @ResponseBody
    public String procesarRegistro(@ModelAttribute Formulario formulario){
        if (formulario.getNombre() == null || formulario.getNombre().isBlank() ||
                formulario.getCorreo() == null || formulario.getCorreo().isBlank()){
        return "Debes de introducir un nombre y un correo.";
        }

        String apellidos = formulario.getApellidos();
        if (apellidos == null) {
            apellidos = "";
        }

        String password = formulario.getPassword();
        boolean auto = false;
        if (password == null || password.isEmpty()) {
            // para generar una contraseña entre 0 y 999999 y poner los 0 a la izquierda para tener 6 dígitos.
            password = String.format("%06d", random.nextInt(1000000));
            auto = true;
        }

        usuarios.put(formulario.getCorreo(),  password);

        String respuesta = "Nombre: " + formulario.getNombre() + " " + apellidos
                + "<br> Correo: " + formulario.getCorreo();
        if (auto) {
            respuesta += "<br> Contraseña generado automáticamente: " + password;
        }
        return respuesta;
    }

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login"; // login.html
    }

    @PostMapping("/login")
    @ResponseBody
    public String procesarLogin(@RequestParam("usuario")String usuario,
                                @RequestParam("password")String password){
      // los siguientes if son para comprobar los 3 casos para iniciar sesión
        if (!usuarios.containsKey(usuario)){
            return "Usuario inexistente.";
        }

        if (!usuarios.get(usuario).equals(password)){
            return "Contraseña incorrecta.";
        }
        return "Inicio de sesión correcto.";
    }
}
