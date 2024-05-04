package br.edu.senaisp.Funcionario.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Funcionario.model.Funcionario;

@Repository
public class FuncionarioRepository implements ICrud{

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String qrSelectAll = "SELECT ID, NOME, ANONASCIMENTO, FUNCAO FROM funcionario;";
	private String qrSelectById = "SELECT ID, NOME, ANONASCIMENTO, FUNCAO FROM funcionario WHERE ID = ?;";
	private static final String qrUpdate = "UPDATE funcionario SET NOME = ?, ANONASCIMENTO = ?, FUNCAO = ? WHERE id = ?;";
	private static final String qrInsert = "INSERT INTO funcionario (NOME, ANONASCIMENTO, FUNCAO) VALUES (?, ?, ?);";
	private static final String qrDelete = "DELETE FROM funcionario WHERE ID = ?;";
	
	
	@Override
	public List<Funcionario> lista() {
		
		return jdbcTemplate.query(qrSelectAll, (rs, rowNum) ->
			{return new Funcionario(rs.getInt("id"),
									rs.getString("nome"),
									rs.getInt("anoNascimento"),
									rs.getString("funcao"));
	
			});
	}

	@Override
	public Funcionario buscarPorId(int id) {
		
		Object[] params = {id};
		
		return jdbcTemplate.queryForObject(qrSelectById, 
				params, 
				(rs, rowNum) -> {
					return new Funcionario(rs.getInt("id"),
										rs.getString("nome"),
										rs.getInt("anoNascimento"),
										rs.getString("funcao"));
				});
	}

	@Override
	public Funcionario alterar(Funcionario funcionario, int id) {
		
		Object[] params = {funcionario.getNome(), funcionario.getAnoNascimento(), funcionario.getFuncao(), id};
		
		jdbcTemplate.update(qrUpdate, params);
		
		return buscarPorId(id);
	}

	@Override
	public List<Funcionario> inserir(Funcionario funcionario) {
		Object[] params = {funcionario.getNome(), funcionario.getAnoNascimento(), funcionario.getFuncao()};
		
		jdbcTemplate.update(qrInsert, params);
		
		return lista();
	}

	@Override
	public void delete(int id) {
		Object[] params = {id};
		
		jdbcTemplate.update(qrDelete, params);
		
	}
	
	

}
