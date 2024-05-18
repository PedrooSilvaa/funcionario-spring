package br.edu.senaisp.Funcionario.model;

import jakarta.persistence.*;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	@Column(name = "anoNascimento")
	private int anoNascimento;
	@Column(name = "funcao", length = 100, nullable = false)
	private String funcao;

	public Funcionario(Integer id, String nome, int anoNascimento, String funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.funcao = funcao;
	}

	public Funcionario() {
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
