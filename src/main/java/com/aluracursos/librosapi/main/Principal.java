package com.aluracursos.librosapi.main;

import com.aluracursos.librosapi.client.Client;

import java.io.IOException;

public class Principal {
 public void mostraMensaje(){
        System.out.println("Mensaje de prueba");
 }
 public void conectarApi() throws IOException, InterruptedException {
     Client client = new Client();
     String json = client.http("https://gutendex.com/books?languages=es");
     System.out.println(json);
 }
}

