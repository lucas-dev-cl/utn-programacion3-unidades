package com.utn.unidades.unidad9.actividad2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoUnidad9 {
    private String nombre;
    private double nota;
    private String curso;

    @Override
    public String toString() {
        return nombre + " (Nota: " + nota + ", Curso: " + curso + ")";
    }
}
