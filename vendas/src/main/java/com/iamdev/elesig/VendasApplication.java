package com.iamdev.elesig;

import java.util.List;

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
			clientes.salvar(new ClienteEntity("Douglas"));
			clientes.salvar(new ClienteEntity("Outro Cliente"));

			List<ClienteEntity> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Atualizando Clientes");
			todosClientes.forEach(c -> {
				c.setNome(c.getNome() + " atualizado.");
				clientes.atualizar(c);
			});

			todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);

			System.out.println("Buscando Clientes");
			clientes.buscarPorNome("Cli").forEach(System.out::println);

			System.out.println("Deletando Clientes");
			clientes.obterTodos().forEach(c -> {
				clientes.deletar(c);
			});

			todosClientes = clientes.obterTodos();
			if (todosClientes.isEmpty()) {
				System.out.println("Nenhum cliente encontrado.");
			} else {
				todosClientes.forEach(System.out::println);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
