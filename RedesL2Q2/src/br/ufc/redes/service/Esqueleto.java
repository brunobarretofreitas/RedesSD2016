package br.ufc.redes.service;

public class Esqueleto {
	CalculadoraSimples calc;
	public Esqueleto(){
		calc = new CalculadoraSimples();
	}
	public String add(String request){
		String[] o = request.split(";");
		double valor = calc.somar(Double.valueOf(o[1]), Double.valueOf(o[2]));
		return String.valueOf(valor);
	}
	public String sub(String request){
		String[] o = request.split(";");
		double valor = calc.subtrair(Double.valueOf(o[1]), Double.valueOf(o[2]));
		return String.valueOf(valor);
	}
	public String mult(String request){
		String[] o = request.split(";");
		double valor = calc.multiplicar(Double.valueOf(o[1]), Double.valueOf(o[2]));
		return String.valueOf(valor);
	}
	public String div(String request){
		String[] o = request.split(";");
		double valor = calc.dividir(Double.valueOf(o[1]), Double.valueOf(o[2]));
		return String.valueOf(valor);
	}
}
