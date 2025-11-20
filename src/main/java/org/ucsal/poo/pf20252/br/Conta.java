package org.ucsal.poo.pf20252.br;

import java.util.Scanner;

public abstract class Conta implements Operavel {

	long numero;
	private double saldo;

	public Conta(long numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	public void depositar() {
		Scanner dep = new Scanner(System.in);
		System.out.println("Digite o valor do depósito: ");
		double valor = dep.nextDouble();
		if (valor > 0) {
			saldo += valor;
		} else {
			System.out.println("Só é possível depositar valores maiores que 0,00.");
		}
	}

	public void sacar() {
		Scanner saq = new Scanner(System.in);
		System.out.println("Digite o valor do saque: ");
		double valor = saq.nextDouble();
		saldo -= valor;
	}

	
	@Override
	public void transferir(double valor, Conta destino) {
		if (valor <= saldo) {
			saldo -= valor;
			destino.saldo += valor;
		}
		
	}

	@Override
	public void consultarSaldo() {
		System.out.println(getSaldo());
		
	}

	public double atualizarSaldo(int op) { 
		if (op == 1) { 
			depositar(); 
		} else if (op == 2) { 
			sacar(); 
		} else if (op == 3) {
			//transferir(valor, destino);
		} else if (op == 4) {
			consultarSaldo();
		}
		return saldo; 
	}
	
	public double getSaldo() {
		return saldo;
	}
}
