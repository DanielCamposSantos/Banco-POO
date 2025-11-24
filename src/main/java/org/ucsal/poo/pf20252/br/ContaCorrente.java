package org.ucsal.poo.pf20252.br;

public class ContaCorrente extends Conta {

	private final double LIMITE_SAQUE_ESPECIAL = 2000;

	public ContaCorrente(long numero, double saldo, Cliente cliente) {
		super(numero, saldo, cliente);
	}

	@Override
	public void transferir(double valor, Conta destino)  throws ValorInvalidoException{
		if (valor > getSaldo() + LIMITE_SAQUE_ESPECIAL){
			throw new ValorInvalidoException("Sao insuficiente");
		}
		if (valor <=0){
			throw new ValorInvalidoException("Só é possível depositar valores maiores que 0,00.");
		}

		setSaldo(getSaldo() - valor);
		destino.setSaldo(destino.getSaldo() + valor);

	}
	
	@Override
	public void sacar(double valor) throws ValorInvalidoException{
		if (valor > getSaldo() + LIMITE_SAQUE_ESPECIAL){
			throw new ValorInvalidoException("Sao insuficiente");
		}
		if (valor <=0){
			throw new ValorInvalidoException("Só é possível depositar valores maiores que 0,00.");
		}
		setSaldo(getSaldo() - valor);
	}

}