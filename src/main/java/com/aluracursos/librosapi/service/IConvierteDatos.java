package com.aluracursos.librosapi.service;

public interface IConvierteDatos {
    //<T> T = tipos de datos genericos
    <T> T convierteDatos (String json, Class<T> clase);
}
