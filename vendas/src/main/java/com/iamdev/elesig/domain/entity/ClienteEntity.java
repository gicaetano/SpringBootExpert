package com.iamdev.elesig.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column
	private Integer id;
	
	@Column(name = "nome", length = 100)
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
