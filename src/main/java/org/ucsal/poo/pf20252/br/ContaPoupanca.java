package org.ucsal.poo.pf20252.br;


public class ContaPoupanca extends Conta {
	
	private final double TAXA_DE_JUROS = 0.005;
	private double extratoMensal = getSaldo();
	
    public ContaPoupanca(long numero, double saldo) {
        super(numero, saldo);
    }
    
    @Override
    public void atualizarSaldo() {
    	for (int i = 1; i <= 12; i ++) {
    		extratoMensal = getSaldo()*Math.pow((1+TAXA_DE_JUROS), i);
    		System.out.println("Saldo do mês " + i + ": " + extratoMensal);
    	}
    	
	}

}