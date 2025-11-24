package org.ucsal.poo.pf20252.br;


public class ContaPoupanca extends Conta {
	private double[] lucrosMensais = new double[12];
	private final double TAXA_DE_JUROS = 0.005;

    public ContaPoupanca(long numero, double saldo, Cliente cliente) {
        super(numero, saldo, cliente);
    }


    @Override
    protected void atualizarSaldo() {
    	for (int i = 0; i < 12; i ++) {
			lucrosMensais[i] = getSaldo()*Math.pow((1+TAXA_DE_JUROS), i+1);
    	}
	}

	public double[] getLucrosMensais() {
		atualizarSaldo();
		return lucrosMensais;
	}
}