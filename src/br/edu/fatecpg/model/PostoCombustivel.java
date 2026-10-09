package br.edu.fatecpg.model;

import java.util.ArrayList;

public class PostoCombustivel {
	public String[] tiposCombustivel;
	public double[] precosLitro;
	public int[] litrosDisponiveis;
	
	public void gerarRelatório() {
		System.out.println("---- Relatório ---");
		for(int i = 0; i < this.tiposCombustivel.length; i++) {
			System.out.println("-Bomba " + (i + 1)
						   + "\nTipo de combustível: " + this.tiposCombustivel[i]
						   + "\nPreço por litro: " + this.precosLitro[i]
						   + "\nLitros disponíveis: " + this.litrosDisponiveis[i]
						   + "\n-----------------");
		}
	}
	
	public void verPatrimonio() {
		double patrimonio = 0;
		for(int i = 0; i < this.precosLitro.length; i++) {
			patrimonio += this.precosLitro[i] * this.litrosDisponiveis[i];
		}
		System.out.println("Patrimônio total: R$" + patrimonio);
	}
	
	public void analisarInventario() {
		ArrayList<Integer> cheios = new ArrayList<>(), urgentes = new ArrayList<>();
		
		for(int i = 0; i < this.litrosDisponiveis.length; i++) {
			if(this.litrosDisponiveis[i] >= 1000){
				cheios.add(i);
			} else if(this.litrosDisponiveis[i] <= 175){
				urgentes.add(i);
			}
		}
		
		System.out.println("--- Análise de inventário ---"
						+ "\nTanques cheios: ");
		for(int j = 0; j < cheios.size(); j++) {
			System.out.println(" - Tanque " + (cheios.get(j) + 1) + ": " + this.litrosDisponiveis[cheios.get(j)] + "L");
		}
		System.out.println("Tanques em urgência");
		for(int k = 0; k < urgentes.size(); k++) {
			System.out.println(" - Tanque " + (urgentes.get(k) + 1) + ": " + this.litrosDisponiveis[urgentes.get(k)] + "L");
		}
	}
	
	public void vender(int bomba, int litros) {
		if(this.litrosDisponiveis[bomba] < litros) {
			System.out.println("A bomba tem menos combustível que a venda ("+this.litrosDisponiveis[bomba]+"L), não é possível realiza-la.");
		} else {
			this.litrosDisponiveis[bomba] -= litros;
			System.out.println("Vendendo " + litros + "L por R$" + (this.precosLitro[bomba] * litros)
					+ "\nSobrando " + this.litrosDisponiveis[bomba] + "L na bomba." );
		}
	}
	
	public void reabastecer(int bomba, int litros) {
		this.litrosDisponiveis[bomba] += litros;
		System.out.println("Abastecendo a bomba " + (bomba + 1) + " com " + litros + "L, resultando em " + this.litrosDisponiveis[bomba] + "L disponíveis.");
	}
}
