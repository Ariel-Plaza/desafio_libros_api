package com.aluracursos.librosapi.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.ArrayList;

public record Data(@JsonAlias("count") Integer count,
                   @JsonAlias("next") String next,
                   @JsonAlias("previous") String previous,
                   @JsonAlias("results") ArrayList<DatosLibro> resultados) {
}
