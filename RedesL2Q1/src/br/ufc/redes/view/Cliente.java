package br.ufc.redes.view;

import java.io.IOException;
import java.util.Scanner;

import br.ufc.redes.net.TCPClient;

public class Cliente{
	
	private TCPClient cliente;
	
	public Cliente(){
		try {
			cliente = TCPClient.Builder()
					.serverHost("127.0.0.1")
					.serverPort(7896)
					.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Cliente cliente = new Cliente();
		TCPClient tcp = cliente.getTCPClient(); 
		
		System.out.println("Digite a operação: ");
		String operacao = entrada.nextLine();
		tcp.sendRequest(operacao);
		String resposta = tcp.getResponse();
		
		System.out.println("Resposta do Servidor: " + resposta);
	}
	
	public TCPClient getTCPClient(){
		return this.cliente;
	}
	
}