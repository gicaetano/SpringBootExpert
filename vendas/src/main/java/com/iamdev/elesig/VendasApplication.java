package com.iamdev.elesig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iamdev.elesig.domain.entity.ClienteEntity;
import com.iamdev.elesig.domain.repository.ClientesRepository;

@SpringBootApplication
public class VendasApplication {
	
	@Bean
	public CommandLineRunner commandLineRunner(@Autowired ClientesRepository clientes) {
		return args -> {
			ClienteEntity c = new ClienteEntity(null, "Fulano");
			clientes.save(c);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
