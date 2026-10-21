package com.utn.unidades.unidad7.actividad4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoConProveedor {
    private String codigo;
    private String nombre;
    private String proveedor;
    private double precio;
}
