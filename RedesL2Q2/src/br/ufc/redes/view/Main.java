package br.ufc.redes.view;

import java.util.Scanner;

import br.ufc.redes.proxy.Proxy;

public class Main{
	
	private Proxy proxy;
	
	public Main(){
		proxy = new Proxy();
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Main cliente = new Main();
	 
		System.out.println("Digite a operacao: ");
		String operacao = entrada.nextLine();
		
		System.out.println("Digite um numero: ");
		double a = entrada.nextDouble();
		
		System.out.println("Digite um numero: ");
		double b = entrada.nextDouble();
		
		switch (operacao) {
		case "ADD":
			System.out.println(cliente.proxy.add(a, b));
			
		case "SUB":
			System.out.println(cliente.proxy.sub(a, b));
		case "MULT":
			System.out.println(cliente.proxy.mult(a, b));
		case "DIV":
			System.out.println(cliente.proxy.div(a, b));
		default:
			System.out.println("Erro");
		}
		cliente.proxy.close();
	}
	
}