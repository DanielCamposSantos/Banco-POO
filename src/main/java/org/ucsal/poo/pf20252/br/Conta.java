package org.ucsal.poo.pf20252.br;

import javafx.scene.control.Label;

/**
 * Classe abstrata que representa a base de todas as contas bancárias no sistema.
 * Implementa a interface Operavel e define o comportamento padrão de depósito,
 * saque e consulta de saldo.
 *
 * @author Gabriela
 * @version 1.0
 * @since 2025-02
 */

public abstract class Conta implements Operavel {
    private long numero;
    private boolean saldoVisivel = false;
    private double saldo;
    private Cliente cliente;

    /**
     * Construtor da classe Conta
     *
     * @param numero  O número da conta.
     * @param saldo   O saldo inicial da conta.
     * @param cliente O cliente proprietário da conta.
     */

    public Conta(long numero, double saldo, Cliente cliente) {
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    /**
     * Realiza um depósito na conta.
     *
     * @param valor O valor a ser depositado. Deve ser maior que zero.
     * @throws ValorInvalidoException Se o valor for menor ou igual a zero.
     */

    public void depositar(double valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("Só é possível depositar valores maiores que 0,00.");
        }
        saldo += valor;

    }

    /**
     * Realiza um saque na conta. O valor não pode ser maior que o saldo nem ser 0.
     *
     * @param valor Valor a ser sacado
     * @throws ValorInvalidoException Se o valor for 0 ou maior que o saldo será um erro de exceção
     */

    public void sacar(double valor) throws ValorInvalidoException {
        if (valor > saldo) {
            throw new ValorInvalidoException("Saldo insuficiente");
        }
        if (valor <= 0) {
            throw new ValorInvalidoException("Só é possível depositar valores maiores que 0,00.");
        }
        saldo -= valor;
    }

    /**
     * Realiza transferência para a conta destinada.
     * O valor a ser transferido não pode ser 0, negativo ou menor que o saldo da conta bancária.
     *
     * @param valor   Valor a ser transferido
     * @param destino Conta que receberá a transferência
     * @throws ValorInvalidoException Caso o valor for 0 ou maior que o saldo será um erro de exceção
     */

    @Override
    public void transferir(double valor, Conta destino) throws ValorInvalidoException {
        if (valor > saldo) {
            throw new ValorInvalidoException("Saldo insuficiente");
        }
        if (valor <= 0) {
            throw new ValorInvalidoException("Só é possível depositar valores maiores que 0,00.");
        }

        this.saldo -= valor;
        destino.saldo += valor;

    }

    /**
     * Realiza a consulta do saldo na conta do cliente, podendo ser também oculto ou visível para o usuário
     *
     * @param saldoConta Label onde o saldo será exibido ou ocultado, de acordo com o usuário
     */

    @Override
    public void consultarSaldo(Label saldoConta) {
        saldoVisivel = !saldoVisivel;
        if (saldoVisivel) {
            saldoConta.setText(String.format("%.2f", saldo));
        } else {
            saldoConta.setText("*****");
        }

    }

    /**
     * Método protegido que deve ser implementado por subclasses para atualizar o saldo
     * com base em regras específicas (ex: juros).
     * </p>Este método não faz nada na classe base.</p>
     */

    protected void atualizarSaldo() {
    }

    /**
     * Define o novo valor do saldo da conta.
     *
     * @param saldo Novo valor a ser atribuído ao saldo
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Retorna o valor atual do saldo da conta.
     *
     * @return Valor do saldo da instância
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Retorna o número identificador da conta.
     *
     * @return Número da conta
     */
    public long getNumero() {
        return numero;
    }

    /**
     * Retorna o cliente titular da conta.
     *
     * @return Instância do cliente associado à conta
     */
    public Cliente getCliente() {
        return cliente;
    }
}


