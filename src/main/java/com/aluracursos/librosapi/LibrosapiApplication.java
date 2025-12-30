package com.aluracursos.librosapi;

import com.aluracursos.librosapi.main.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrosapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibrosapiApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //  Principal principal = new Principal();
        //        principal.muestraElMenu();
        Principal principal = new Principal();
        principal.conectarApi();
//        System.out.println(principal);
    }
}
