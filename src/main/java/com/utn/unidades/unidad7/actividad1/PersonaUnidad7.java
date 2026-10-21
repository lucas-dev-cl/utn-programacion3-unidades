package com.utn.unidades.unidad7.actividad1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaUnidad7 {
    private String nombre;
    private int edad;

    @Override
    public String toString() {
        return "PersonaUnidad7 [nombre=" + nombre + ", edad=" + edad + "]";
    }
}
