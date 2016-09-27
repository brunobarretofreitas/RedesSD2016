package br.ufc.redes.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientBuilder {

	private TCPClient cliente;
	
	public TCPClientBuilder(){
		this.cliente = new TCPClient();
	}
	
	public TCPClientBuilder serverHost(String serverHost){
		this.cliente.setServerHost(serverHost);
		return this;
	}
	
	public TCPClientBuilder serverPort(int serverPort){
		this.cliente.setServerPort(serverPort);
		return this;
	}
	
	public TCPClient build() throws UnknownHostException, IOException{
		Socket socket = new Socket(
				this.cliente.getServerHost(),
				this.cliente.getServerPort());
		
		DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		if(out == null)
			System.out.println("E aqui mah");
		
		cliente.setDataInputStream(in);
		cliente.setDataOutputStream(out);
		cliente.setSocket(socket);
		
		return this.cliente;
	}
	
}