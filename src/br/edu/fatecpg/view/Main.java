package br.edu.fatecpg.view;

import java.util.Scanner;
import br.edu.fatecpg.model.*;

public class Main {
	static Scanner entrada = new Scanner(System.in);
	
	public static void exercicio6() {
		Celular cel1 = new Celular();
		
		cel1.marca = "Apple";
		cel1.modelo = "Iphone 15";
		cel1.preco = 4256.50;
		cel1.estado = "Usado";
		cel1.defeito = "Tela Quebrada";
		
		System.out.println("\n---- Relatório do celular ----"
					   + "\nmarca: " + cel1.marca
					   + "\nmodelo: " + cel1.modelo
					   + "\npreço: R$" + cel1.preco
					   + "\nestado: " + cel1.estado
					   + "\ndefeito: " + cel1.defeito);
	}
	
	public static void exercicio7() {
		ContaBancaria cb1 = new ContaBancaria();
		
		cb1.setTitular("Roberto Carlos");
		cb1.setNumeroConta(19631);
		cb1.depositar(17564.55);
		
		System.out.println("\n---- Informações da Conta ----"
					   + "\nTitular: " + cb1.getTitular()
					   + "\nNúmero da Conta: " + cb1.getNumeroConta()
					   + "\nSaldo: R$" + cb1.getSaldo());
	}
	
	public static void exercicio8() {
		PostoCombustivel posto1 = new PostoCombustivel();
		
		posto1.tiposCombustivel = new String[] {"Etanol", "Gasolina Aditivada", "Gasolina Comum"};
		posto1.precosLitro = new double[] {4.39, 7.02, 6.7};
		posto1.litrosDisponiveis = new int[] {1100, 750, 100};
		
		int subopt = 0;
		
		do {
			System.out.print("\n------ Exercicio 8 ------"
						 + "\n1 - Gerar relatório das bombas"
						 + "\n2 - Ver patrimônio"
						 + "\n3 - Analisar inventário"
						 + "\n4 - Vender"
						 + "\n5 - Reabastecer"
						 + "\n0 - Sair"
						 + "\n-----------------------------------"
						 + "\n\nEscolha uma opção: ");
			
			subopt = entrada.nextInt();
			
			switch(subopt) {
			case 1:
				posto1.gerarRelatório();
				break;
			case 2:
				posto1.verPatrimonio();
				break;
			case 3:
				posto1.analisarInventario();
				break;
			case 4:
				System.out.print("\nDigite o número da bomba: ");
				int bombaV = entrada.nextInt();
				System.out.print("\nDigite a quantidade de litros que será vendida: ");
				int litrosV = entrada.nextInt();
				posto1.vender(bombaV - 1, litrosV);
				break;
			case 5:
				System.out.print("\nDigite o número da bomba: ");
				int bombaR = entrada.nextInt();
				System.out.print("\nDigite a quantidade de litros que será abastecida na bomba: ");
				int litrosR = entrada.nextInt();
				posto1.reabastecer(bombaR - 1, litrosR);
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção Inválida!");
			}
		}while(subopt != 0);
	}
	
	public static void main(String[] args) {
		int opt = 0;
		
		do {
			System.out.print("\n------ COMPLEMENTO PARA A P1 ------"
						 + "\n6 - Visualizar exercicio 6"
						 + "\n7 - Visualizar exercicio 7"
						 + "\n8 - Visualizar exercicio 8"
						 + "\n0 - SAIR"
						 + "\n-----------------------------------"
						 + "\n\nEscolha uma opção: ");
			
			opt = entrada.nextInt();
			
			switch(opt) {
			case 6:
				exercicio6();
				break;
			case 7:
				exercicio7();
				break;
			case 8:
				exercicio8();
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção Inválida!");
			}
		}while(opt != 0);
		
		entrada.close();
	}
}
