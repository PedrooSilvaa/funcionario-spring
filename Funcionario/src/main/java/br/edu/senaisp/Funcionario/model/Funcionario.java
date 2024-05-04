package br.edu.senaisp.Funcionario.model;

public class Funcionario {

	private Integer id;
	private String nome;
	private int anoNascimento;
	private String funcao;
	
	public Funcionario(Integer id, String nome, int anoNascimento, String funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.funcao = funcao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
	
}
