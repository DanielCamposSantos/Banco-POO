package org.ucsal.poo.pf20252.br;

/**
 * Representa uma Conta Poupança, que herda as operações básicas da Conta.
 * Permite o acúmulo de juros sobre o saldo.
 *
 * @author [Preencher com nome dos autores]
 * @version 1.0
 * @since 2025-02
 */

public class ContaPoupanca extends Conta {

    /**
     * Taxa percentual de juros aplicada ao saldo (0.5%).
     */

	private final double TAXA_DE_JUROS = 0.005;

    /**
     * Construtor da Conta Poupança.
     *
     * @param numero O número da conta.
     * @param saldo O saldo inicial da conta.
     * @param cliente O cliente proprietário da conta.
     */

    public ContaPoupanca(long numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
    }

    /**
     * Aplica a taxa de juros ao saldo atual da conta poupança.
     */

    @Override
    public void atualizarSaldo() {
    	setSaldo(getSaldo() + (getSaldo()*TAXA_DE_JUROS));
	}
}