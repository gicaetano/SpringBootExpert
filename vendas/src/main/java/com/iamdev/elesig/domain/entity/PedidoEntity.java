package com.iamdev.elesig.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoEntity {
	
	private Integer id;
	private ClienteEntity Cliente;
	private LocalDate dataPedido;
	private BigDecimal total;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ClienteEntity getCliente() {
		return Cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		Cliente = cliente;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
}
