package com.iamdev.elesig.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamdev.elesig.domain.entity.ProdutoEntity;

public interface ProdutosRepository extends JpaRepository<ProdutoEntity, Integer> {
}
