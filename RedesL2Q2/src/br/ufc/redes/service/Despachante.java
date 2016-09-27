package br.ufc.redes.service;

public class Despachante {
	private Esqueleto esq;
	public Despachante(){
		esq = new Esqueleto();
	}
	public String invoke(String request){
		String[] o = request.split(";");
		
		switch (o[0]) {
		case "ADD":
			return esq.add(request);
		case "SUB":
			return esq.sub(request);
		case "MULT":
			return esq.mult(request);
		case "DIV":
			return esq.div(request);
		default:
			return null;
		}
	}
}
