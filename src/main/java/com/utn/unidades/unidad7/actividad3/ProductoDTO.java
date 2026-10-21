package com.utn.unidades.unidad7.actividad3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private String codigo;
    private String nombre;
    private double precio;

    @Override
    public String toString() {
        return "ProductoDTO{codigo='" + codigo + "', nombre='" + nombre + "', precio=" + precio + "}";
    }
}
