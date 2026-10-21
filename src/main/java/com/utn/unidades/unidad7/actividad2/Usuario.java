package com.utn.unidades.unidad7.actividad2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {
    private int id;
    private String nombre;
    private String email;

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
    }
}
