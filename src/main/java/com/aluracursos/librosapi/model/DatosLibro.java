package com.aluracursos.librosapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(  //titulo, autor(Datos autor/ nombre, fecha Nacimiento, fecha muerte),idiomas,
                           @JsonAlias("title") String titulo,
                           @JsonAlias("authors") ArrayList<Autor> autores,
                           @JsonAlias("download_count") Integer descargas
//                           @JsonAlias("summaries") String resumen

){
    @Override
    public String titulo() {
        return titulo;
    }

    @Override
    public ArrayList<Autor> autores() {
        return autores;
    }

    @Override
    public Integer descargas() {
        return descargas;
    }
}
