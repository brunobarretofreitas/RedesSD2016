package br.ufc.redes.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.ufc.redes.service.Calculadora;
import br.ufc.redes.service.CalculadoraSimples;

public class TCPServer {

	protected Calculadora calculadora;
	protected Socket cliente;
	protected ServerSocket listenSocket;
	protected DataOutputStream out;
	
	public TCPServer(int porta){
		this.calculadora = new CalculadoraSimples();
		try {
			listenSocket = new ServerSocket(porta);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getRequest() throws IOException{
		DataInputStream in = new DataInputStream(cliente.getInputStream());
		String request = in.readUTF();
		return request;
	}
	
	public void sendResponse(String request) throws IOException{
		String[] o = request.split(";");
		int a = Integer.valueOf(o[0]);
		int b = Integer.valueOf(o[2]);
		
		switch (o[1]) {
		case "+":
			this.out.writeUTF("Resposta: "+this.calculadora.somar(a, b));
		case "-":
			this.out.writeUTF("Resposta: "+this.calculadora.subtrair(a, b));
		case "*":
			this.out.writeUTF("Resposta: "+this.calculadora.multiplicar(a, b));
		case "/":
			this.out.writeUTF("Resposta: "+this.calculadora.dividir(a, b));
		default:
			this.out.writeUTF("Operacao Invalida");
		}

	}
	
	public static void main(String[] args) {
		try{
			System.out.println("Servidor ligando...");
			int serverPort = 7896; // the server port
			TCPServer servidor = new TCPServer(serverPort);
			while(true) {
				servidor.cliente = servidor.listenSocket.accept();
				System.out.println("Cliente conectado");
				servidor.out = new DataOutputStream(servidor.cliente.getOutputStream());
				String request = servidor.getRequest();
				servidor.sendResponse(request);
			}
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
	
}