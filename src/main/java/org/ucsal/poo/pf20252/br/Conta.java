package org.ucsal.poo.pf20252.br;

import javafx.scene.control.Label;

public abstract class Conta implements Operavel {
	long numero;
	private boolean saldoVisivel = false;
	private double saldo;
	private Cliente cliente;

	public Conta(long numero, double saldo, Cliente cliente) {
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public void depositar(double valor) throws ValorInvalidoException{
		if (valor <=0){
			throw new ValorInvalidoException();
		}
		saldo += valor;

    }

	public void sacar(double valor) throws ValorInvalidoException{
		if (valor > saldo || valor <=0){
			throw new ValorInvalidoException();
		}
		saldo -= valor;
    }


	@Override
	public void transferir(double valor, Conta destino) throws ValorInvalidoException{
		if (valor > saldo || valor <=0) {
			throw new ValorInvalidoException();
		}
		saldo -= valor;
		destino.saldo += valor;

	}

	@Override
	public void consultarSaldo(Label saldoConta) {
		saldoVisivel = !saldoVisivel;
		if (saldoVisivel) {
			saldoConta.setText(String.format("%.2f", saldo));
		} else {
			saldoConta.setText("*****");
		}

	}

	public void atualizarSaldo() {
		
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}
}


