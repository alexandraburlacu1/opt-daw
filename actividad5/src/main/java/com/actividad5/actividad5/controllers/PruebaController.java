package com.actividad5.actividad5.controllers;

import com.actividad5.actividad5.Pedido;
import com.actividad5.actividad5.PedidoFinal;
import com.actividad5.actividad5.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaController {
    @PostMapping("/pedido")
    public PedidoFinal recibirPedido(@RequestBody Pedido pedido){
    int totalProductos = 0;
    double precioTotal = 0;

        for (Producto p : pedido.getProductos()) {
            totalProductos += p.getCantidad();
            precioTotal += p.getCantidad() * p.getPrecioUnitario();
        }
        String nombreCliente = pedido.getCliente().getNombre();
        String message = "Pedido recibido correctamente";
        PedidoFinal pedidoFinal = new PedidoFinal(nombreCliente, totalProductos,precioTotal, message);
        return pedidoFinal;
    }
}
