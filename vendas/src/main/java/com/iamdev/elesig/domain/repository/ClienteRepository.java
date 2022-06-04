package com.iamdev.elesig.domain.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.iamdev.elesig.domain.entity.ClienteEntity;

@Repository
public class ClienteRepository {
	
	private static String INSERT = "insert into cliente (nome) values (?)";
	private static String SELECT_ALL = "select * from CLIENTE";
	private static String UPDATE = "update cliente set nome = ? where id = ?";
	private static String DELETE = "delete from cliente where id = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ClienteEntity salvar(ClienteEntity cliente) {
		jdbcTemplate.update( INSERT, new Object[] {cliente.getNome()});
		return cliente;
	}
	
	public ClienteEntity atualizar(ClienteEntity cliente) {
		jdbcTemplate.update( UPDATE, new Object[] {
				cliente.getNome(), cliente.getId()});
		return cliente;
	}
	
	public void deletar(ClienteEntity cliente) {
		deletar(cliente.getId());
	}
	
	public void deletar(Integer id) {
		jdbcTemplate.update(DELETE, new Object[] {id});
	}
	
	@SuppressWarnings("deprecation")
	public List<ClienteEntity> buscarPorNome(String nome) {
		return jdbcTemplate.query(
				SELECT_ALL.concat(" where nome like ?"), 
				new Object[] {"%" + nome + "%"},
				obterClienteMapper());
	}
	
	public List<ClienteEntity> obterTodos() {
		return jdbcTemplate.query(SELECT_ALL, obterClienteMapper() );			
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

