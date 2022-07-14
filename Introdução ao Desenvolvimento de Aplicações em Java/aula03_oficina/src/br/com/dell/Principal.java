package br.com.dell;

import java.util.HashSet;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		Hospede hospede = new Hospede();

		Quarto quarto = new Quarto();

		try {
			hospede.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do hóspede: ")));
		} catch (NumberFormatException exception) {
			System.err.println("O valor informado não é válido.\nDigite apenas números.");
			hospede.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do hóspede: ")));
		}

		try {
			hospede.setRg(Long.parseLong(JOptionPane.showInputDialog("Digite o RG do hóspede: ")));
		} catch (NumberFormatException exception) {
			System.err.println("O valor informado não é válido. \nDigite apenas números.");
			hospede.setRg(Long.parseLong(JOptionPane.showInputDialog("Digite o RG do hóspede: ")));
		}

		hospede.setNome(JOptionPane.showInputDialog("Digite o NOME do hóspede: "));
		String nome = hospede.getNome();

		boolean valido = hospede.validarNome(nome);

		while (valido == false) {
			hospede.setNome(JOptionPane.showInputDialog("Digite o NOME do hóspede: "));
			nome = hospede.getNome();
			valido = hospede.validarNome(nome);
		}

		try {
			hospede.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a IDADE do hóspede: ")));
		} catch (NumberFormatException exception) {
			System.err.println("O valor informado não é válido.\nDigite apenas números.");
			hospede.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a IDADE do hóspede: ")));
		}

		hospede.setEndereco(JOptionPane.showInputDialog("Digite o ENDEREÇO do hóspede: "));

		quarto.setHospede(hospede);

		quarto.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o NÚMERO do QUARTO:")));

		/*
		 * Escolhi fazer um HashSet para armazenar as informações a partir do objeto
		 * quarto Optei por isso já que a classe Quarto tem como atributos o número do
		 * quarto (que para mim é único justificando a escolha do HashSet) e as
		 * informações do hóspede que está naquele quarto.
		 */
		HashSet relacaoQuartoHospede = new HashSet();

		relacaoQuartoHospede.add(quarto);

		JOptionPane.showMessageDialog(null, relacaoQuartoHospede);
	}

}
