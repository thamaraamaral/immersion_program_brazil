package br.com.dell.modelos;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		
		Quarto quarto = new Quarto();
		
		quarto.setHospede(new Hospede());
		
		quarto.getHospede().setNome(JOptionPane.showInputDialog("Informe o nome do hóspede"));
		quarto.getHospede().setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do hóspede")));
		quarto.getHospede().setCpf(Long.parseLong(JOptionPane.showInputDialog("Informe o cpf do hóspede:")));
		quarto.getHospede().setRg(Long.parseLong(JOptionPane.showInputDialog("Informe o rg do hóspede")));	
		quarto.getHospede().setEndereco(JOptionPane.showInputDialog("Informe o endereço do hóspede"));
		quarto.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Informe o número do quarto")));
		
		String mensagemCadastro = "Cadastro realizado com sucesso!";
		
		String mensagemDadosReserva = "=============================="
				+ "		\nDADOS DA HÓSPEDE \n" + "==============================\n"
				+ "NOME: " + quarto.getHospede().getNome() + "\n"
				+ "IDADE: " + quarto.getHospede().getIdade() + "\n"
				+ "CPF: " + quarto.getHospede().getCpf() + "\n" 
				+ "RG: " + quarto.getHospede().getRg() + "\n"
				+ "ENDEREÇO: " + quarto.getHospede().getEndereco() + "\n" 
				+ "\n==============================\n" 
				+ "		DADOS DA RESERVA \n" 
				+ "==============================\n"
				+ "Hóspede locado no quarto nº " + quarto.getNumero();
				
		JOptionPane.showMessageDialog(null, mensagemCadastro);
		JOptionPane.showMessageDialog(null, mensagemDadosReserva);
	}

}
