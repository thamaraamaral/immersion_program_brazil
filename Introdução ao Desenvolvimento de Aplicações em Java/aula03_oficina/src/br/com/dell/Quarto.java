package br.com.dell;

public class Quarto {

	private int numero;
	private Hospede hospede;

	public Quarto() {
		
	}

	public Quarto(int numero, Hospede hospede) {
		super();
		this.numero = numero;
		this.hospede = hospede;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	@Override
	public String toString() {
		return "No QUARTO nº " + numero + ", encontra-se hospedado:\n" + hospede;
	}

}
