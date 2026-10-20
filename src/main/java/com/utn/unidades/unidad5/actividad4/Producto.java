package com.utn.unidades.unidad5.actividad4;

import java.util.Objects;

public class Producto {
    private String codigo;
    private String nombre;
    private double precio;

    // Constructor
    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Sobrescritura del método toString()
    @Override
    public String toString() {
        return "Producto [código=" + codigo + ", nombre=" + nombre + ", precio=$" + precio + "]";
    }

    // Sobrescritura de equals() basado en el código
    @Override
    public boolean equals(Object o) {
        // Verificamos si tienen el mismo posicionamiento en memoria, si lo tienen entonces son exactamente el mismo objeto
        if (this == o) return true;

        // Verifica si es null (o sea que directamente no es igual) o si tienen la misma clase de plantilla, si no es asi también por naturaleza son diferentes
        if (o == null || getClass() != o.getClass()) return false;

        // Si no son exactamente el mismo objeto, pero sí la misma naturaleza, entonces verificamos si el código es el mismo
        // Al ser un objeto genérico, no se saben los atributos, por eso lo convertimos a un Producto
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    // Sobrescritura de hashCode() acorde a equals()
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}