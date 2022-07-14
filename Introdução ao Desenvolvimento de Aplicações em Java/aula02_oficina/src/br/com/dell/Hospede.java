package br.com.dell;

import javax.swing.JOptionPane;

public class Hospede {

	private long cpf;
	private long rg;
	private String nome;
	private int idade;
	private String endereco;

	public Hospede() {
		
	}

	public Hospede(long cpf, long rg, String nome, int idade, String endereco, Quarto quarto) {
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

	public boolean validarNome(String nome) {

		boolean valido = true;
		int contCaracterEspecial = 0;

		for (int i = 0; i < nome.length(); i++) {

			if (!Character.isLetter(nome.charAt(i))
					&& (!Character.isWhitespace(nome.charAt(i)) && (Character.isDigit(nome.charAt(i))))) {

				contCaracterEspecial++;

			}

		}

		if (contCaracterEspecial > 0) {
			valido = false;
			JOptionPane.showMessageDialog(null,
					"O nome " + nome + " possui caracteres inválidos.\nPor favor, digite apenas letras.\n");
		} 
		
		if (contCaracterEspecial == 0){
			valido = true;
		}

		return valido;
	}

}
