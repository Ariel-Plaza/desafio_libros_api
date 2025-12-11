package com.aluracursos.librosapi.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {
        public String http(String URL) throws IOException, InterruptedException {
            //es la clase que actuq como cliente
            HttpClient client = HttpClient.
                    //instancia de la clase
                            //nuevo construcor
                            newBuilder()
                    //permite redirecciones
                    .followRedirects(HttpClient.Redirect.ALWAYS)
                    .build();
            //Clase que representa la petición/solicitud HTTP que vas a enviar
            HttpRequest request = HttpRequest.
                    //Crea un "constructor" de peticiones usando el patrón Builder
                            newBuilder()

                    //uri Define la dirección URL a donde vas a enviar la petición
                    //Convierte un String (tu URL) en un objeto URI
                    .uri(URI.create(String.valueOf(URL)))
                    //Finaliza la construcción y crea el objeto HttpRequest completo
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
            return response.body();
        }

    }