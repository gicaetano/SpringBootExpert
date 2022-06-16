package com.iamdev.elesig;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iamdev.elesig.domain.entity.ClienteEntity;
import com.iamdev.elesig.domain.entity.PedidoEntity;
import com.iamdev.elesig.domain.repository.ClientesRepository;
import com.iamdev.elesig.domain.repository.PedidosRepository;

@SpringBootApplication
public class VendasApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired ClientesRepository clientes,
			@Autowired PedidosRepository pedidos
			) {
		return args -> {
			System.out.println("Salvando Clientes");
			ClienteEntity fulano = new ClienteEntity("Fulano");
			clientes.save(fulano);

			PedidoEntity p = new PedidoEntity();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));
			
			pedidos.save(p);
			
//			pedidos.findByCliente(fulano).forEach(System.out::println);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
