package org.ucsal.poo.pf20252.br;


public class ContaPoupanca extends Conta {
	private final double TAXA_DE_JUROS = 0.005;

    public ContaPoupanca(long numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
    }


    @Override
    protected void atualizarSaldo() {
    	setSaldo(getSaldo() + (getSaldo()*TAXA_DE_JUROS));
    	System.out.println(getSaldo());
	}
}