package com.iamdev.elesig.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamdev.elesig.domain.entity.ClienteEntity;

public interface ClientesRepository extends JpaRepository<ClienteEntity, Integer> {

	
//	@Query(value = " select * from clienteentity c where c.nome like '%:nome%'", nativeQuery = true)
//	List<ClienteEntity> encontrarPorNome(@Param("nome") String nome);
//	
//	List<ClienteEntity> findAll(String nome);
//	
//	boolean existsByNome(String nome);
	
//	@Query("select c from ClienteEntity c left join fetch c.pedidosRepository where c.id = :id ")
//	ClienteEntity findClienteEntityFetchPedidos( @Param("id") Integer id );
	
}

