package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication: Questa è la classe principale dell'applicazione.
// Viene annotata con @SpringBootApplication, che è un'annotazione composta che:
// - Abilita la scansione automatica di componenti (Controller, Service, Repository)
// - Configura l'applicazione come un'applicazione Spring Boot
// - Abilita la gestione delle eccezioni (Exception Handling)
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args); // Avvia l'applicazione
	}

}
