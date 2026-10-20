package com.utn.unidades;

import com.utn.unidades.unidad5.actividad2.Estudiante;
import com.utn.unidades.unidad5.actividad3.Curso;
import com.utn.unidades.unidad5.actividad4.Producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

		// UNIDAD 5 ACTIVIDAD 3
		// Crear listas de estudiantes para los diferentes cursos
		List<Estudiante> alumnosEstructuras = new ArrayList<>();
		alumnosEstructuras.add(estudiantes.get(0));
		alumnosEstructuras.add(estudiantes.get(1));

		List<Estudiante> alumnosProgramacion = new ArrayList<>();
		alumnosProgramacion.add(estudiantes.get(2));

		// Instanciar los cursos pasándoles el nombre y su respectiva lista de alumnos
		Curso curso1 = new Curso("Estructuras de Datos", alumnosEstructuras);
		Curso curso2 = new Curso("Programación III", alumnosProgramacion);

		// Imprimir los cursos en consola
		System.out.println(curso1);
		System.out.println("--------------------------------------------------");
		System.out.println(curso2);

		// UNIDAD 5 ACTIVIDAD 4
		// Crear la lista de productos
		List<Producto> stock = new ArrayList<>();

		// Crear algunos productos (nota que hay dos con el mismo código "P001")
		Producto p1 = new Producto("P001", "Notebook Lenovo", 850000.0);
		Producto p2 = new Producto("P002", "Mouse Inalámbrico", 25000.0);
		Producto p3 = new Producto("P001", "Notebook Lenovo (Duplicada)", 900000.0); // Mismo código que p1

		// Intentar agregar usando contains() para evitar duplicados
		agregarProductoSiNoExiste(stock, p1);
		agregarProductoSiNoExiste(stock, p2);
		agregarProductoSiNoExiste(stock, p3); // Este debería ser rechazado por el contains()

		// Mostrar el resultado final
		System.out.println("--- Lista de Productos (Sin Duplicados) ---");
		for (Producto p : stock) {
			System.out.println(p);
		}

		// UNIDAD 5 ACTIVIDAD 5
		// Crear un HashSet de Productos
		Set<Producto> productosSet = new HashSet<>();

		// Agregar los productos al HashSet
		productosSet.add(p1);
		productosSet.add(p2);
		productosSet.add(p3); // Este debe ser rechazado

		// Imprimir el contenido del HashSet para verificar
		System.out.println("--- Elementos en el HashSet ---");
		for (Producto p : productosSet) {
			System.out.println(p);
		}

		System.out.println("Total de elementos: " + productosSet.size()); // Debería mostrar 2, no 3

	}

	// Método auxiliar para validar con contains antes de añadir
	public static void agregarProductoSiNoExiste(List<Producto> lista, Producto nuevoProducto) {
		if (!lista.contains(nuevoProducto)) {
			lista.add(nuevoProducto);
			System.out.println("Agregado exitosamente: " + nuevoProducto.getNombre());
		} else {
			System.out.println("No se pudo agregar. El producto con código [" + nuevoProducto.getCodigo() + "] ya existe.");
		}
	}

}
