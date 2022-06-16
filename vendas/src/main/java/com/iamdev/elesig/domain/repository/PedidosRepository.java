package com.iamdev.elesig.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamdev.elesig.domain.entity.PedidoEntity;

public interface PedidosRepository extends JpaRepository<PedidoEntity, Integer> {
	
//	@Query("select p from Pedido p left join fetch p.itens where p.id = :id")
//	PedidoEntity findPedidoByIdFetchItens(@Param("id") Long id);
	
//	List<PedidoEntity> findByCliente(ClienteEntity cliente);
}
