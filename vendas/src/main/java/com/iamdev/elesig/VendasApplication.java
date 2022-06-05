package com.iamdev.elesig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iamdev.elesig.domain.entity.ClienteEntity;
import com.iamdev.elesig.domain.repository.ClienteRepository;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clientes) {
		return args -> {
			System.out.println("Salvando Clientes");
			clientes.save(new ClienteEntity("Douglas teste"));
			clientes.save(new ClienteEntity("Outro Cliente"));

			boolean existe = clientes.existsByNome("Douglas");
			System.out.println("existe cliente com nome Douglas = " + existe);

			
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
