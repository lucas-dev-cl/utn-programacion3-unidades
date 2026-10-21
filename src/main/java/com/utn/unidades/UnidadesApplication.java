package com.utn.unidades;

import com.utn.unidades.unidad5.actividad2.Estudiante;
import com.utn.unidades.unidad5.actividad2.Persona;
import com.utn.unidades.unidad5.actividad3.Curso;
import com.utn.unidades.unidad5.actividad4.Producto;
import com.utn.unidades.unidad6.actividad2.Alumno;
import com.utn.unidades.unidad6.actividad3.ProductoActividad3;
import com.utn.unidades.unidad6.actividad4.CursoActividad4;
import com.utn.unidades.unidad7.actividad1.PersonaUnidad7;
import com.utn.unidades.unidad7.actividad2.Usuario;
import com.utn.unidades.unidad7.actividad3.ProductoDTO;
import com.utn.unidades.unidad7.actividad3.ProductoUnidad7;
import com.utn.unidades.unidad7.actividad4.ProductoConProveedor;
import com.utn.unidades.unidad7.actividad4.ProductoRecord;
import com.utn.unidades.unidad8.actividad3.Caja;
import com.utn.unidades.unidad9.actividad2.AlumnoUnidad9;
import com.utn.unidades.unidad9.actividad3.ProductoUnidad9;
import com.utn.unidades.unidad9.actividad3.ResumenCategoria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class UnidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnidadesApplication.class, args);

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa la unidad que desea ver: ");
        int unidadElegida = Integer.parseInt(sc.next());

        switch (unidadElegida) {
            case 5:
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
                break;

            case 6:

                // UNIDAD 6 ACTIVIDAD 2
                // Almacenar varios alumnos en ArrayList (aplicando la buena práctica de usar la interfaz List)
                List<Alumno> alumnos = new ArrayList<>();

                alumnos.add(new Alumno("Ana", 9.5));
                alumnos.add(new Alumno("Carlos", 7.0));
                alumnos.add(new Alumno("Sofía", 8.5));

                // Recorrer la lista con for-each e imprimir cada alumno
                // Al imprimir el objeto directamente, Java llama automáticamente al método toString() que sobrescribimos.
                for (Alumno alumno : alumnos) {
                    System.out.println(alumno);
                }

                // UNIDAD 6 ACTIVIDAD 3
                // Crear el HashSet
                Set<ProductoActividad3> productosSetActividad3 = new HashSet<>();

                // Instanciar productos (incluyendo duplicados por código)
                ProductoActividad3 p4 = new ProductoActividad3("A01", "Teclado mecánico RGB");
                ProductoActividad3 p5 = new ProductoActividad3("A02", "Mouse ergonómico inalámbrico");
                ProductoActividad3 p6 = new ProductoActividad3("A01", "Teclado repetido (no debería agregarse)"); // Mismo código que p1

                // Insertar en el HashSet
                productosSetActividad3.add(p4);
                productosSetActividad3.add(p5);
                productosSetActividad3.add(p6); // Duplicado rechazado automáticamente

                // Recorrer el set e imprimir los productos
                System.out.println("--- Lista de productos en el HashSet ---");
                for (ProductoActividad3 p : productosSetActividad3) {
                    System.out.println(p);
                }

                // UNIDAD 6 ACTIVIDAD 4
                Map<String, CursoActividad4> mapaCursos = new HashMap<>();

                // Agregar varios cursos (Clave: Código, Valor: Objeto Curso)
                mapaCursos.put("JAVA101", new CursoActividad4("Programación en Java", "Carlos Pérez"));
                mapaCursos.put("WEB202", new CursoActividad4("Desarrollo Web Fullstack", "María Gómez"));
                mapaCursos.put("BD303", new CursoActividad4("Bases de Datos SQL", "Juan López"));

                // Recuperar un curso por su clave
                System.out.println("--- Recuperando un curso específico ---");
                CursoActividad4 cursoRecuperado = mapaCursos.get("WEB202");
                System.out.println("Encontrado: " + cursoRecuperado);
                System.out.println("----------------------------------------\n");

                // Recorrer el map con entrySet() e imprimir las entradas
                System.out.println("--- Recorriendo todo el mapa con entrySet() ---");
                for (Map.Entry<String, CursoActividad4> entrada : mapaCursos.entrySet()) {
                    String codigo = entrada.getKey();
                    CursoActividad4 curso = entrada.getValue();

                    System.out.println("Código: [" + codigo + "] -> " + curso);
                }
                break;

            case 7:
                // UNIDAD 7 ACTIVIDAD 1
                PersonaUnidad7 persona = new PersonaUnidad7("Juan", 30);
                PersonaUnidad7 persona2 = new PersonaUnidad7();
                persona2.setNombre("Ana");
                persona2.setEdad(25);

                System.out.println("Imprimimos los objetos personas: ");
                System.out.println(persona);
                System.out.println(persona2);

                // UNIDAD 7 ACTIVIDAD 2
                System.out.println("Imprimimos los objetos usuarios: ");
                Usuario usuario = Usuario.builder()
                        .id(1)
                        .nombre("Juan")
                        .email("juan@example.com")
                        .build();

                Usuario usuario2 = Usuario.builder()
                        .id(2)
                        .nombre("Ana")
                        .email("ana@example.com")
                        .build();

                System.out.println(usuario);
                System.out.println(usuario2);

                // UNIDAD 7 ACTIVIDAD 3
                // Crear varios objetos Producto originales (con su autor)
                List<ProductoUnidad7> productosOriginales = new ArrayList<>();
                productosOriginales.add(new ProductoUnidad7("B001", "Clean Code", 45.00, "Robert C. Martin"));
                productosOriginales.add(new ProductoUnidad7("B002", "Effective Java", 55.50, "Joshua Bloch"));
                productosOriginales.add(new ProductoUnidad7("B003", "Design Patterns", 50.00, "Erich Gamma"));

                // Lista donde guardaremos los DTOs ya mapeados
                List<ProductoDTO> listaDTOs = new ArrayList<>();

                // Mapear los objetos Producto a ProductoDTO usando getters y setters
                for (ProductoUnidad7 prod : productosOriginales) {
                    ProductoDTO dto = new ProductoDTO();

                    // Extraemos los datos del origen y los seteamos en el DTO (omitiendo el autor)
                    dto.setCodigo(prod.getCodigo());
                    dto.setNombre(prod.getNombre());
                    dto.setPrecio(prod.getPrecio());

                    // Guardamos el DTO en la lista
                    listaDTOs.add(dto);
                }

                // Mostrar la lista de DTOs en consola
                System.out.println("--- Lista de ProductoDTO Mapeados ---");
                for (ProductoDTO dto : listaDTOs) {
                    System.out.println(dto);
                }

                // UNIDAD 7 ACTIVIDAD 4
                // Instanciar varios objetos ProductoConProveedor de maquinarias
                List<ProductoConProveedor> maquinariasOriginales = new ArrayList<>();
                maquinariasOriginales.add(new ProductoConProveedor("M001", "Excavadora Hidráulica", "Caterpillar", 45000.00));
                maquinariasOriginales.add(new ProductoConProveedor("M002", "Compresor de Aire Industrial", "Atlas Copco", 12500.50));
                maquinariasOriginales.add(new ProductoConProveedor("M003", "Generador Diesel 50kW", "Cummins", 21000.00));

                // Lista donde guardaremos los records mapeados
                List<ProductoRecord> listaRecords = new ArrayList<>();

                // Instanciar los ProductoRecord usando los objetos ProductoConProveedor y guardarlos en una lista
                for (ProductoConProveedor prod : maquinariasOriginales) {
                    // Como los records son inmutables, pasamos los valores directamente en su constructor
                    ProductoRecord record = new ProductoRecord(prod.getCodigo(), prod.getNombre(), prod.getPrecio());

                    listaRecords.add(record);
                }

                // Mostrar los productos en consola
                System.out.println("--- Lista de ProductoRecord (Maquinarias) ---");
                for (ProductoRecord rec : listaRecords) {
                    System.out.println(rec); // Los records ya tienen un toString() automático por defecto
                }
                break;

            case 8:
                // UNIDAD 8 ACTIVIDAD 2
                try {
                    // Obtenemos el objeto Class (la puerta de entrada a Reflection)
                    Class<?> clazz = Persona.class;

                    // Obtener e imprimir sus constructores
                    System.out.println("=== 1. Obtener e imprimir constructores ===");

                    // Obtenemos los constructores declarados en la clase
                    Constructor<?>[] constructores = clazz.getDeclaredConstructors();
                    for (Constructor<?> c : constructores) {
                        System.out.println("Constructor detectado: " + c);
                    }

                    // Instanciar un objeto utilizando reflection (Aquí se crea 'personaObj')
                    System.out.println("\n=== 2. Instanciar objeto con Reflection ===");
                    // Buscamos específicamente el constructor que recibe un String y un int
                    Constructor<Persona> constructorParametrizado = Persona.class.getConstructor(String.class, int.class);

                    // Creamos la instancia de forma dinámica sin usar la palabra 'new' directamente.
                    // El resultado es un Object genérico que contiene nuestro objeto Persona.
                    Object personaObj = constructorParametrizado.newInstance("Ana", 25);
                    System.out.println("Instancia 'personaObj' creada exitosamente.");

                    // Modificar el valor de nombre en tiempo de ejecución
                    System.out.println("\n=== 3. Modificar atributo privado 'nombre' ===");
                    // Obtenemos el campo privado 'nombre' usando getDeclaredField
                    Field campoNombre = clazz.getDeclaredField("nombre");

                    // Usamos setAccessible(true) para saltarnos la regla de privacidad de Java
                    campoNombre.setAccessible(true);

                    // Modificamos el valor de ese campo en el objeto 'personaObj' de "Ana" a "Carlos"
                    campoNombre.set(personaObj, "Carlos");
                    System.out.println("Atributo privado 'nombre' modificado a 'Carlos'.");

                    // Invoca un método que muestre la información de la persona
                    System.out.println("\n=== 4. Invocar método para mostrar información ===");
                    Method metodoInfo = clazz.getMethod("toString");

                    // Ejecutamos el método pasándole el objeto al que pertenece (personaObj)
                    metodoInfo.invoke(personaObj); // Mostrará Carlos y 25

                    // Modifica el encapsulamiento de Saludar() hacia private usando reflection e invócalo
                    System.out.println("\n=== 5. Manipular e invocar método privado Saludar() ===");
                    // Obtenemos el método privado Saludar()
                    Method metodoSaludar = clazz.getDeclaredMethod("Saludar");

                    // Rompemos el encapsulamiento para poder ejecutar un método privado desde fuera
                    metodoSaludar.setAccessible(true);

                    // Invocamos el método privado sobre nuestro 'personaObj'
                    Object resultadoSaludar = metodoSaludar.invoke(personaObj);
                    System.out.println("Resultado devuelto por el método privado Saludar(): " + resultadoSaludar);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                // UNIDAD 8 ACTIVIDAD 3
                // Demostración de uso: Creando una Caja de String y una Caja de Integer
                System.out.println("=== USO DE CLASES GENÉRICAS ===");

                Caja<String> cajaDeTexto = new Caja<>();
                cajaDeTexto.guardar("Notebook Gamer");
                // cajaDeTexto.guardar(123); // Error de compilación: el compilador protege el tipo
                String texto = cajaDeTexto.obtener(); // No requiere casting explícito
                System.out.println("Contenido de cajaDeTexto: " + texto);

                Caja<Integer> cajaDeNumero = new Caja<>();
                cajaDeNumero.guardar(1500);
                Integer numero = cajaDeNumero.obtener();
                System.out.println("Contenido de cajaDeNumero: " + numero);


                // Comparación con colecciones sin genéricos (Tipos en bruto / Raw Types)
                System.out.println("\n=== COMPARACIÓN CON COLECCIONES SIN GENÉRICOS ===");

                // Una lista antigua sin <> acepta cualquier cosa porque internamente usa Object
                List listaSinGenericos = new ArrayList();
                listaSinGenericos.add("Texto de prueba");
                listaSinGenericos.add(456); // Permite mezclar tipos sin avisar

                // PROBLEMA: Para recuperar los datos, estás obligado a adivinar el tipo y hacer un cast manual.
                // Si te equivocas de tipo al hacer el cast, el programa crashea en ejecución (Runtime).
                String valorRecuperado = (String) listaSinGenericos.get(0);
                System.out.println("Valor recuperado con cast: " + valorRecuperado);

                // UNIDAD 8 ACTIVIDAD 4
                // Crear una lista de cadenas S
                List<String> listaNombres = new ArrayList<>();
                listaNombres.add("Ana");
                listaNombres.add("Carlos");
                listaNombres.add("Elena");

                // Crear una lista de enteros
                List<Integer> listaEdades = new ArrayList<>();
                listaEdades.add(25);
                listaEdades.add(30);
                listaEdades.add(42);

                // Utilizar el mismo método genérico con ambas listas
                imprimirLista(listaNombres); // El método se adapta automáticamente para trabajar con Strings
                imprimirLista(listaEdades);  // El método se adapta automáticamente para trabajar con Integers
                break;

            case 9:
                // UNIDAD 9 ACTIVIDAD 2
                // Creamos la lista con 5 alumnos distintos
                List<AlumnoUnidad9> alumnosUnidad9 = Arrays.asList(
                        new AlumnoUnidad9("carlos", 8.5, "Matemáticas"),
                        new AlumnoUnidad9("ana", 6.0, "Historia"),
                        new AlumnoUnidad9("beatriz", 9.2, "Matemáticas"),
                        new AlumnoUnidad9("david", 4.5, "Historia"),
                        new AlumnoUnidad9("elena", 7.8, "Matemáticas")
                );

                System.out.println("=== RESOLUCIÓN CON STREAMS Y LAMBDAS ===\n");

                // Nombres de alumnos aprobados (nota >= 7) en mayúsculas y ordenados
                List<String> aprobadosMayus = alumnosUnidad9.stream()
                        .filter(a -> a.getNota() >= 7.0)              // Filtramos los que tienen 7 o más
                        .map(a -> a.getNombre().toUpperCase())       // Transformamos el nombre a mayúsculas
                        .sorted()                                     // Los ordenamos alfabéticamente
                        .collect(Collectors.toList());                // Los guardamos en una lista

                System.out.println("1. Aprobados (Mayúsculas y Ordenados): " + aprobadosMayus);

                // Calcular el promedio general de notas
                double promedioGeneral = alumnosUnidad9.stream()
                        .mapToDouble(AlumnoUnidad9::getNota)                 // Mapeamos a un stream de números primitivos (double)
                        .average()                                    // Calculamos el promedio automáticamente
                        .orElse(0.0);                                 // Valor por defecto si la lista estuviera vacía

                System.out.println("2. Promedio general de notas: " + promedioGeneral);

                // Agrupar alumnos por curso usando Collectors.groupingBy()
                Map<String, List<AlumnoUnidad9>> alumnosPorCurso = alumnosUnidad9.stream()
                        .collect(Collectors.groupingBy(AlumnoUnidad9::getCurso)); // Agrupa basándose en el valor del curso

                System.out.println("3. Agrupados por curso:");
                alumnosPorCurso.forEach((curso, lista) -> {
                    System.out.println("   - " + curso + ": " + lista);
                });

                // Obtener los 3 mejores promedios
                List<AlumnoUnidad9> top3 = alumnosUnidad9.stream()
                        .sorted((a1, a2) -> Double.compare(a2.getNota(), a1.getNota())) // Orden descendente (mayor a menor)
                        .limit(3)                                     // Tomamos únicamente los primeros 3 resultados
                        .collect(Collectors.toList());

                System.out.println("4. Los 3 mejores promedios:");
                top3.forEach(a -> System.out.println("   - " + a));

                // UNIDAD 9 ACTIVIDAD 3
                List<ProductoUnidad9> productosComida = Arrays.asList(
                        new ProductoUnidad9("Aceite de Oliva Extra Virgen 1L", "Almacén", 4500.0, 35),
                        new ProductoUnidad9("Arroz Integral 1kg", "Almacén", 1200.0, 50),
                        new ProductoUnidad9("Fideos Tallarines 500g", "Almacén", 950.0, 40),
                        new ProductoUnidad9("Queso Tybo por kg", "Lácteos", 30.0, 15),
                        new ProductoUnidad9("Leche Entera Sachet 1L", "Lácteos", 50.0, 60),
                        new ProductoUnidad9("Pechuga de Pollo por kg", "Carnicería", 5200.0, 25),
                        new ProductoUnidad9("Tomate Triturado 900g", "Verdulería/Envasados", 1400.0, 30),
                        new ProductoUnidad9("Pan Flauta por kg", "Panadería", 20.0, 20)
                );

                // Listar los productos con precio mayor a 100, ordenados por precio descendente
                List<ProductoUnidad9> productosMayorA100 = productosComida.stream()
                        .filter(productoUnidad9 -> productoUnidad9.getPrecio() > 100)
                        .sorted(Comparator.comparingDouble(ProductoUnidad9::getPrecio).reversed())
                        .toList();

                System.out.println("Productos con precio mayor a 100: " + productosMayorA100);

                // Agrupar productos por categoria y calcular stock total
                Map<String, ResumenCategoria> productoPorCategoria = productosComida.stream()
                        .collect(Collectors.groupingBy(ProductoUnidad9::getCategoria,
                                Collectors.collectingAndThen(
                                        Collectors.<ProductoUnidad9>toList(),
                                        productoUnidad9s -> {
                                            int stockTotal = productoUnidad9s.stream().mapToInt(ProductoUnidad9::getStock).sum();

                                            return new ResumenCategoria(productoUnidad9s, stockTotal);
                                        }
                                )
                        ));

                System.out.println("Productos por categoria: " + productoPorCategoria);

                String productosString = productosComida.stream()
                        .map(p -> p.getNombre() + " ($" + p.getPrecio() + ")")
                        .collect(Collectors.joining("; "));

                System.out.println("3. Productos unidos por ';' : " + productosString);

                double promedioGeneralProductos = productosComida.stream()
                        .mapToDouble(ProductoUnidad9::getPrecio)
                        .average()
                        .orElse(0.0);

                System.out.println("4. Precio promedio general: $" + promedioGeneralProductos);

                Map<String, Double> promedioPorCategoria = productosComida.stream()
                        .collect(Collectors.groupingBy(
                                ProductoUnidad9::getCategoria,
                                Collectors.averagingDouble(ProductoUnidad9::getPrecio)
                        ));

                System.out.println("4. Precio promedio por categoria: ");
                // Mostrar los resultados por categoría
                promedioPorCategoria.forEach((categoria, promedio) ->
                        System.out.println("Categoría: " + categoria + " | Precio Promedio: $" + promedio)
                );
                break;

            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                break;

        }
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

	// Implementación del método genérico usando <T> (Type Parameter)
	// Este método acepta una lista de CUALQUIER tipo de dato T y la recorre con seguridad.
	public static <T> void imprimirLista(List<T> lista) {
		System.out.println("Imprimiendo elementos de la lista:");
		for (T elemento : lista) {
			System.out.println(" - " + elemento);
		}
		System.out.println();
	}

}
