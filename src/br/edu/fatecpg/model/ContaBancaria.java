package br.edu.fatecpg.model;

public class ContaBancaria {
	private String titular;
	private int numeroConta;
	private double saldo = 0;
	
	public void setTitular(String tl) {
		this.titular = tl;
	}
	
	public void setNumeroConta(int nc) {
		this.numeroConta = nc;
	}
	
	public void depositar(double valor) {
		if(valor > 0) this.saldo += valor;
	}
	
	public void sacar(double valor) {
		if(valor > 0) {
			this.saldo = valor >= this.saldo 
					? this.saldo - this.saldo 
					: this.saldo - valor;
		}
	}
	
	public String getTitular() {
		return this.titular;
	}
	
	public int getNumeroConta() {
		return this.numeroConta;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
}
