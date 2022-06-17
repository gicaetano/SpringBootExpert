package com.iamdev.elesig.rest.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity getClienteById(@PathVariable Integer id) {
		Optional<ClienteEntity> cliente = clientes.findById(id);
		
		if(cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/api/clientes")
	@ResponseBody
	public ResponseEntity save(@RequestBody ClienteEntity cliente) {
		ClienteEntity clienteSalvo = clientes.save(cliente);
		return ResponseEntity.ok(clienteSalvo);
	}
	
	@DeleteMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity delete(@PathVariable Integer id) {
		Optional<ClienteEntity> cliente = clientes.findById(id);
		
		if(cliente.isPresent()) {
			clientes.delete(cliente.get());
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/api/clientes/{id}")
	@ResponseBody
	public ResponseEntity update( @PathVariable Integer id, 
								  @RequestBody ClienteEntity cliente) {
		return clientes
				.findById(id)
				.map( clienteExistente -> {
					cliente.setId(clienteExistente.getId());
					clientes.save(cliente);
					return ResponseEntity.noContent().build();
				}).orElseGet( () -> ResponseEntity.notFound().build());
	}
}
