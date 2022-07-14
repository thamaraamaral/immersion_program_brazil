package br.com.dell;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		Hospede hospede = new Hospede();
		Quarto quarto = new Quarto();

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
			System.err.print("Você inseriu um valor inválido.\nDigite apenas números. " + exception.getMessage());
			hospede.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite a IDADE do hóspede: ")));
		}

		try {
			hospede.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do hóspede: ")));
		} catch (NumberFormatException exception) {
			System.err.print("Você inseriu um valor inválido.\nDigite apenas números. " + exception.getMessage());
			hospede.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do hóspede: ")));
		}

		try {
			hospede.setRg(Long.parseLong(JOptionPane.showInputDialog("Digite o RG do hóspede: ")));
		} catch (NumberFormatException exception) {
			System.err.print("Você inseriu um valor inválido.\nDigite apenas números. " + exception.getMessage());
			hospede.setRg(Long.parseLong(JOptionPane.showInputDialog("Digite o RG do hóspede: ")));
		}

		hospede.setEndereco(JOptionPane.showInputDialog("Digite o ENDEREÇO do hóspede: "));

		quarto.setHospede(hospede);

		quarto.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Digite o número do quarto: ")));

		JOptionPane.showMessageDialog(null,
						" *** DADOS DA RESERVA *** \n" 			+ 
						"NOME: " + hospede.getNome() 			+ "\n"   + 
						"IDADE: " + hospede.getIdade()			+ "\n" 	 + 
						"CPF: " + hospede.getCpf() 				+ "\n" 	 + 
						"RG: " + hospede.getRg() 				+ "\n" 	 + 
						"ENDEREÇO: " + hospede.getEndereco() 	+ "\n\n" + 
						"*** DADOS DO QUARTO ***\n" 				+ 
						"QUARTO Nº: "+ quarto.getNumero());

	}

}
