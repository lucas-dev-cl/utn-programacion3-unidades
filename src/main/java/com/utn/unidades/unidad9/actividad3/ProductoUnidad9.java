package com.utn.unidades.unidad9.actividad3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoUnidad9 {
    private String nombre;
    private String categoria;
    private double precio;
    private int stock;

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + ", Categoria: " + this.categoria + ", Precio: " + this.precio + ", Stock: " + this.stock;
    }
}
