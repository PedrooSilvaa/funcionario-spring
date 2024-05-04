package br.edu.senaisp.Funcionario.repository;

import java.util.List;

import br.edu.senaisp.Funcionario.model.Funcionario;

public interface ICrud {
	
	public List<Funcionario> lista();
	
	public Funcionario buscarPorId(int id);
	
	public Funcionario alterar(Funcionario funcionario, int id);
	
	public  List<Funcionario> inserir(Funcionario funcionario);
	
	public void delete(int id);

}
