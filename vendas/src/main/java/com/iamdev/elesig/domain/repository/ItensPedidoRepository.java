package com.iamdev.elesig.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamdev.elesig.domain.entity.ItemPedidoEntity;

public interface ItensPedidoRepository extends JpaRepository<ItemPedidoEntity, Integer> {

}
