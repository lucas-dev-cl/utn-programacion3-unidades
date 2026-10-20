package com.utn.unidades.unidad5.actividad3;

import com.utn.unidades.unidad5.actividad2.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private List<Estudiante> estudiantes = new ArrayList();

    public Curso(String nombre, List<Estudiante> estudiantes) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstidiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Curso [nombre=" + nombre + ", estudiantes=" + estudiantes + "]";
    }
}
