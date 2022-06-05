package com.iamdev.elesig.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamdev.elesig.domain.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

	List<ClienteEntity> findByNomeLike(String nome);
	
	boolean existsByNome(String nome);
	
}

