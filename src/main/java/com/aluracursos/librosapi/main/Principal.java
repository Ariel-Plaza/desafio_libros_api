package com.aluracursos.librosapi.main;

import com.aluracursos.librosapi.client.Client;
import com.aluracursos.librosapi.model.Autor;
import com.aluracursos.librosapi.model.Data;
import com.aluracursos.librosapi.model.DatosLibro;
import com.aluracursos.librosapi.service.ConvierteDatos;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    Client client = new Client();
    List<DatosLibro> datosLibros;
    private Scanner teclado = new Scanner(System.in);

    private ConvierteDatos conversor = new ConvierteDatos();

    public void conectarApi() throws IOException, InterruptedException {

        String json = client.http("https://gutendex.com/books");
        System.out.println(json);
//      Convierte json en objeto Java
        var datos = conversor.convierteDatos(json, Data.class);
//      Obtiene resultados de los libros del objeto a travez del modelo.
        datosLibros = datos.resultados();

        mostrarDatosLibros();
//Datos de los libros
        top10LibrosDescargados();

        buscarLibroPorNombre();



//        System.out.println("***Libros" + libros);
//        System.out.println("***Ciclo for:");
//        for (DatosLibro libro:libros){
//            System.out.println(libro.titulo());
//            System.out.println(libro.autores());
//        }

//        DatosLibro primerlibro = libros.get(0);
//        System.out.println(primerlibro);
//        List<Autor> autores = primerlibro.autores();
//        System.out.println(autores);
//        Autor autor = autores.get(0);
//        System.out.println(autor);
//        System.out.println(autor.nombre());
//        System.out.println(autor.fechaNacimiento());
//        System.out.println(autor.fechaMuerte());

    }
    private void mostrarDatosLibros(){
        //      Convierte en stream para procesar
        List<DatosLibro> libros = datosLibros.stream()
                .map(d -> new DatosLibro(d.titulo(), d.autores(), d.descargas())) // Pasar atributos individuales
                .collect(Collectors.toList());
        libros.stream()
                .limit(5)
                .forEach(System.out::println);
    };


    //        TOP 10 libros mas descargados
    private void top10LibrosDescargados(){
      datosLibros.stream()
//              Ordena los libros a travez de un comparador de las descargas
                .sorted(Comparator.comparing(DatosLibro::descargas).reversed())
                .limit(10)
//              transforma el objeto en solo el titulo
                .map(DatosLibro::titulo)
                .forEach(System.out::println);
    }

    private void buscarLibroPorNombre(){
        System.out.println("Ingresa el nombre del libro que desea buscar: ");
        var nombreLibro = teclado.nextLine();
        datosLibros.stream()
                .filter(d -> d.titulo().toLowerCase().contains(nombreLibro.toLowerCase()))
                .map(d -> new DatosLibro(d.titulo(), d.autores(), d.descargas()))
                .forEach(System.out::println);
    }
}