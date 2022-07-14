package br.com.dell;

import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 * Programa para gerenciamento de hotéis
 * 
 * @author Thamara Amaral
 * @version 1.0
 * 
 */
public class Principal {

	public static void main(String[] args) {

		// instancia o objeto hospede
		Hospede hospede = new Hospede();
		// instancia o objeto quarto
		Quarto quarto = new Quarto();

		/**
		 * Início do cadastro das informações do hóspede e do quarto Foi realizado
		 * tratamento de erros com try/catch.
		 * 
		 * @exception NumberFormatException se foi informado um número inválido.
		 */
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

		/**
		 * Validação do nome Verificando se String nome recebe apenas letras ou espaço
		 * em branco.
		 *
		 */
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

		// criando HashSet com a relação de quarto e hóspede
		HashSet relacaoQuartoHospede = new HashSet();

		relacaoQuartoHospede.add(quarto);

		// mensagem com todas as informações do quarto e do hóspede
		JOptionPane.showMessageDialog(null, relacaoQuartoHospede);
	}

}
