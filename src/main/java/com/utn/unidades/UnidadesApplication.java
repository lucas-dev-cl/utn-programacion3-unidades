package com.utn.unidades;

import com.utn.unidades.unidad5.actividad2.Estudiante;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UnidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnidadesApplication.class, args);


		// UNIDAD 5 ACTIVIDAD 2
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		estudiantes.add(new Estudiante("Juan", 20, "Ingeniero en sistemas"));
		estudiantes.add(new Estudiante("María", 22, "Diseño Gráfico"));
		estudiantes.add(new Estudiante("Pedro", 21, "Medicina"));

		estudiantes.forEach(System.out::println);
	}

}
