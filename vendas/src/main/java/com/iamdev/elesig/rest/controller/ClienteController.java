package com.iamdev.elesig.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iamdev.elesig.domain.entity.ClienteEntity;
import com.iamdev.elesig.domain.repository.ClientesRepository;

@Controller
public class ClienteController {
	
	private ClientesRepository clientes;
	
	public ClienteController(ClientesRepository clientes) {
		this.clientes = clientes;
	}

	@GetMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity<Object> getClienteById(@PathVariable Integer id) {
		Optional<ClienteEntity> cliente = clientes.findById(id);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/api/clientes")
	@ResponseBody
	public ResponseEntity<Object> save(@RequestBody ClienteEntity cliente) {
		ClienteEntity clienteSalvo = clientes.save(cliente);
		return ResponseEntity.ok(clienteSalvo);
	}
	
	@DeleteMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity<Object> delete(@PathVariable Integer id) {
		Optional<ClienteEntity> cliente = clientes.findById(id);
		
		if(cliente.isPresent()) {
			clientes.delete(cliente.get());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity<Object> update( @PathVariable Integer id, 
								  @RequestBody ClienteEntity cliente) {
		return clientes
				.findById(id)
				.map( clienteExistente -> {
					cliente.setId(clienteExistente.getId());
					clientes.save(cliente);
					return ResponseEntity.noContent().build();
				}).orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/api/clientes")
	public ResponseEntity<?> find(ClienteEntity filtro){
		ExampleMatcher matcher = ExampleMatcher
									.matching()
									.withIgnoreCase()
									.withStringMatcher(
											StringMatcher.CONTAINING);
		Example<ClienteEntity> example = Example.of(filtro, matcher);
		List<ClienteEntity> lista = clientes.findAll(example);
		return ResponseEntity.ok(lista);
	}
}
