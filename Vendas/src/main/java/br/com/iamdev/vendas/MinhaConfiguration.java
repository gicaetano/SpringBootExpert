package br.com.iamdev.vendas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class MinhaConfiguration {
	
	@Bean
	public CommandLineRunner executar() {
		return ergs -> {
			System.out.println("RODANDO  CONFIGURAÇÃO DE DESENVOLVIMENTO");
		};
	}
	
}
