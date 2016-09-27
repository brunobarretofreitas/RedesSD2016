package br.ufc.redes.proxy;

import java.io.IOException;

import br.ufc.redes.net.TCPClient;

public class Proxy {
	
	TCPClient cliente;
	
	public Proxy(){
		try {
			cliente = TCPClient.Builder()
					.serverHost("127.0.0.1")
					.serverPort(7896)
					.build();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double add(double a, double b) {
		String request = "ADD;"+a+";"+b;
		cliente.sendRequest(request);
		String resultado = cliente.getResponse();
		return Double.valueOf(resultado);
	}

	
	public double sub(double a, double b) {
		String request = "SUB;"+a+";"+b;
		cliente.sendRequest(request);
		String resultado = cliente.getResponse();
		return Double.valueOf(resultado);
	}

	public double mult(double a, double b) {
		String request = "MULT;"+a+";"+b;
		cliente.sendRequest(request);
		String resultado = cliente.getResponse();
		return Double.valueOf(resultado);
	}

	
	public double div(double a, double b) {
		String request = "DIV;"+a+";"+b;
		cliente.sendRequest(request);
		String resultado = cliente.getResponse();
		return Double.valueOf(resultado);
	}
	
	public void close(){
		cliente.close();
	}
	
}