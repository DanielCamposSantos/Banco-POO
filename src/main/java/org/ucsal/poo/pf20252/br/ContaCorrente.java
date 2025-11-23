package org.ucsal.poo.pf20252.br;

public class ContaCorrente extends Conta {

	private final double LIMITE_SAQUE_ESPECIAL = 2000;

	public ContaCorrente(long numero, double saldo, Cliente cliente) {
		super(numero, saldo, cliente);
	}

	@Override
	public void transferir(double valor, Conta destino)  throws ValorInvalidoException{
		if (valor > (getSaldo() + LIMITE_SAQUE_ESPECIAL) || valor <=0){
			throw new ValorInvalidoException();
		}
		setSaldo(getSaldo() - valor);
	}
	
	@Override
	public void sacar(double valor) throws ValorInvalidoException{
		if (valor > (getSaldo() + LIMITE_SAQUE_ESPECIAL) || valor <=0){
			throw new ValorInvalidoException();
		}
		setSaldo(getSaldo() - valor);
	}

}