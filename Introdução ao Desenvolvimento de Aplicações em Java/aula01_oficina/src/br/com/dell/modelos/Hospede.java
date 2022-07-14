package br.com.dell.modelos;

public class Hospede {

	private long cpf;
	private long rg;
	private String nome;
	private int idade;
	private String endereco;
	
	public Hospede() {
		// TODO Auto-generated constructor stub
	}

	public Hospede(long cpf, long rg, String nome, int idade, String endereco) {
		super();
		this.cpf = cpf;
		this.rg = rg;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
