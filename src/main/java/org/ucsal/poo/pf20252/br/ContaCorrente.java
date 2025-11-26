package org.ucsal.poo.pf20252.br;

/**
 * Representa uma Conta Corrente, que herda as operações básicas da Conta.
 * Permite saques e transferências utilizando um limite especial (cheque especial).
 *
 * @author Gabriela
 * @version 1.0
 * @since 2025-02
 */

public class ContaCorrente extends Conta {

    /**
     * Limite máximo de saque que o cliente pode sacar além do saldo atual
     */

    private final double LIMITE_SAQUE_ESPECIAL = 2000;

    /**
     * Construtor da conta corrente
     *
     * @param numero Número da conta-corrente
     * @param saldo  Saldo da conta
     * @param cliente Identifica o cliente proprietário da conta
     */

	public ContaCorrente(long numero, double saldo, Cliente cliente) {
		super(numero, saldo, cliente);
	}

    /**
     * Realiza uma transferência, permitindo que o valor utilize o LIMITE_SAQUE_ESPECIAL.
     *
     * @param valor O valor a ser transferido.
     * @param destino A Conta que receberá o valor.
     * @throws ValorInvalidoException Se o valor for inválido ou exceder o saldo + limite.
     */

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

    /**
     * Realiza o saque na conta corrente do cliente
     *
     * @param valor Valor cujo cliente possui disponível em conta
     * @throws ValorInvalidoException Gera um erro de exceção caso o valor a ser sacado seja menor que o saldo
     */


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