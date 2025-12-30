package com.aluracursos.librosapi.main;

import com.aluracursos.librosapi.client.Client;
import com.aluracursos.librosapi.model.Autor;
import com.aluracursos.librosapi.model.Data;
import com.aluracursos.librosapi.model.DatosLibro;
import com.aluracursos.librosapi.service.ConvierteDatos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Principal {
    Client client = new Client();
    private ConvierteDatos conversor = new ConvierteDatos();

    public void conectarApi() throws IOException, InterruptedException {

        String json = client.http("https://gutendex.com/books");
        System.out.println(json);
//        var datos = conversor.convierteDatos(json, DatosLibro.class);
//        System.out.println(datos.titulo());
//        Recibo los datos de la API y recupero los datos
        var datos = conversor.convierteDatos(json, Data.class);
        System.out.println("***datos"+ datos);

        System.out.println(datos.count());
        System.out.println("***datos.resultados" + datos.resultados());

//        List<DatosLibro> datosLibros = new ArrayList<>();
////        List<DatosLibro> libros = datos.resultados();
//        List<DatosLibro> libros = new ArrayList<>();
//        libros = datosLibros.stream()
//                        .map(l -> new DatosLibro(libros))
//
//                               .collect(Collectors.toList());

        List<DatosLibro> datosLibros = datos.resultados();
        List<DatosLibro> libros = datosLibros.stream()
                .map(d -> new DatosLibro(d.titulo(), d.autores())) // Pasar atributos individuales
                .collect(Collectors.toList());
        libros.stream()
                .limit(10)
                        .forEach(System.out::println);

        System.out.println("***Libros" + libros);
        System.out.println("***Ciclo for:");
//        for (DatosLibro libro:libros){
//            System.out.println(libro.titulo());
//            System.out.println(libro.autores());
//        }

        DatosLibro primerlibro = libros.get(0);
        System.out.println(primerlibro);
        List<Autor> autores = primerlibro.autores();
        System.out.println(autores);
        Autor autor = autores.get(0);
        System.out.println(autor);
        System.out.println(autor.nombre());
        System.out.println(autor.fechaNacimiento());
        System.out.println(autor.fechaMuerte());

    }
}