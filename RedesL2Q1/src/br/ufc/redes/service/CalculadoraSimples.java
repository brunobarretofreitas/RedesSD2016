package br.ufc.redes.service;

public class CalculadoraSimples implements Calculadora{

	@Override
	public int somar(int a, int b) {
		return a + b;
	}

	@Override
	public int subtrair(int a, int b) {
		return a - b;
	}

	@Override
	public int multiplicar(int a, int b) {
		return a * b;
	}

	@Override
	public int dividir(int a, int b) {
		return a / b;
	}

}
