package com.iamdev.elesig.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cliente")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column(name = "nome", length = 100)
	private String nome;
	
	@Column(name = "cpf", length = 11)
	private String cpf;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private Set<PedidoEntity> pedidos;
	
	public Set<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}

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
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Cliente {" +
				"id=" + id + 
				", nome='" + nome + '\''+
				'}';
	}
	
}
