package com.iamdev.elesig.domain.entity;

public class ClienteEntity {
	
	private Integer id;
	private String nome;
	
	public ClienteEntity() {
	}
	
	public ClienteEntity(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public ClienteEntity(String nome) {
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cliente {" +
				"id=" + id + 
				", nome='" + nome + '\''+
				'}';
	}
	
	
	
}
