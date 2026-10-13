package com.actividad5.actividad5;

public class PedidoFinal {
    private String cliente;
    private int totalProductos;
    private double precioTotal;
    private String message;
    public PedidoFinal(String cliente, int totalProductos, double precioTotal, String message) {
        this.cliente = cliente;
        this.totalProductos = totalProductos;
        this.precioTotal = precioTotal;
        this.message = message;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(int totalProductos) {
        this.totalProductos = totalProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
