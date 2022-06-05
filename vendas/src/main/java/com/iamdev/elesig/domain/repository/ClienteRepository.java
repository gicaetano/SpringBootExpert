package com.iamdev.elesig.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iamdev.elesig.domain.entity.ClienteEntity;

@Repository
public class ClienteRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public ClienteEntity salvar(ClienteEntity cliente) {
		entityManager.persist(cliente);
		return cliente;
	}
	
	@Transactional
	public ClienteEntity atualizar(ClienteEntity cliente) {
		entityManager.merge(cliente);
		return cliente;
	}
	
	@Transactional
	public void deletar(ClienteEntity cliente) {
		if(!entityManager.contains(cliente)) {
			cliente = entityManager.merge(cliente);
		}
		entityManager.remove(cliente);
	}
	
	@Transactional
	public void deletar(Integer id) {
		ClienteEntity cliente = entityManager.find(ClienteEntity.class, id);
		deletar(cliente);
	}
	
	@Transactional(readOnly = true)
	public List<ClienteEntity> buscarPorNome(String nome) {
		String jpql = "select c from ClienteEntity c where c.nome like :nome ";
		TypedQuery<ClienteEntity> query = entityManager.createQuery(jpql, ClienteEntity.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.getResultList();
	}
	
	public List<ClienteEntity> obterTodos() {
		return entityManager
				.createQuery("from ClienteEntity", ClienteEntity.class)
				.getResultList();			
}

	private RowMapper<ClienteEntity> obterClienteMapper() {
		return new RowMapper<ClienteEntity>() {
			@Override
			public ClienteEntity mapRow(ResultSet resultSet, int i) throws SQLException {
				Integer id = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				return new ClienteEntity(id, nome);
			}
		};
	}
}

