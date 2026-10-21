package com.utn.unidades.unidad6.actividad3;

import java.util.Objects;

public class ProductoActividad3 {
    private String codigo;
    private String descripcion;

    // Constructor
    public ProductoActividad3(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // equals() basado en el código
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoActividad3 producto = (ProductoActividad3) o;
        return Objects.equals(codigo, producto.codigo);
    }

    // hashCode() basado en el código
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    // toString()
    @Override
    public String toString() {
        return "Producto [código=" + codigo + ", descripción=" + descripcion + "]";
    }
}
