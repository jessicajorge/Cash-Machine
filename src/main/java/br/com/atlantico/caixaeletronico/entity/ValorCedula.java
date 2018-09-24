package br.com.atlantico.caixaeletronico.entity;

public enum ValorCedula {
	Dois(2), Cinco(5), Dez(10), Vinte(20), Cinquenta(50);
	
	private int valor;
	
	ValorCedula(int valor){
		this.valor = valor;
	}
	
	

}
