package com.ej4.actividad4.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class actividad4Controller {
    @GetMapping("/tabla")
    public String tabla(
            @RequestParam(name = "filas", defaultValue = "1" ) Integer filas,
            @RequestParam(name = "columnas", defaultValue = "1") Integer columnas) {

        int numfila = Integer.parseInt(String.valueOf(filas));
        int numcolumna = Integer.parseInt(String.valueOf(columnas));


        // para el aparatado de rango del 1 al 20
        if(numfila < 1)
            numfila = 1;
        if(numfila > 20)
            numfila = 20;
        if(numcolumna < 1)
            numcolumna = 1;
        if(numcolumna > 20)
            numcolumna = 20;

        String tablahtml = """
                <h1>Tabla</h1>
                <table style="border: 4px dotted salmon;">
                """;
        // para el encabezado con columnas numeradas
        tablahtml = tablahtml + "<tr>";
        for (int j =1; j <= numcolumna; j++) {
            tablahtml = tablahtml + "<th style=\"border: 2px solid pink;\">Columna " + j + "</th>";
        }
        tablahtml = tablahtml + "</tr>";

        for (int i = 1; i <= numfila; i++) {
            tablahtml = tablahtml + "<tr>";
            for (int j = 1; j <= numcolumna; j++) {
                tablahtml = tablahtml + "<td style=\"border: 2px solid salmon;\">Fila " + i + ", Columna " + j + "</td>";
            }
            tablahtml = tablahtml + "</tr>";
        }
        tablahtml = tablahtml + "</table>";
        return tablahtml;
    }
    @ExceptionHandler(NumberFormatException.class)
            public String error(){
            return "Debes introducir un número.";
    }
}
