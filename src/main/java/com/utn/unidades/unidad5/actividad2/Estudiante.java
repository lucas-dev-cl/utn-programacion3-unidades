package com.utn.unidades.unidad5.actividad2;

public class Estudiante extends Persona {
    private String carrera;

    public Estudiante(String nombre, int edad, String carrera) {
        super(nombre, edad);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante [carrera=" + carrera + ", nombre=" + getNombre() + ", edad=" + getEdad() + "]";
    }
}
