package br.com.iamdev.vendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.iamdev.vendas.model.Cliente;
import br.com.iamdev.vendas.repository.ClientesRespository;

@Service
public class ClientesService {
	
	private ClientesRespository repository;
	
	@Autowired
	public ClientesService(ClientesRespository repository) {
		this.repository = repository;
	}
	
	public void salvarCliente(Cliente cliente) {
		validarCliente(cliente);
		this.repository.persistir(cliente);
		}
	
	public void validarCliente(Cliente cliente) {
		//Aplica validações
	}

}
