package org.ucsal.poo.pf20252.br.bancoGrafico;

/**
 * Exceção lançada quando uma operação financeira tenta usar um valor inválido.
 * Valores inválidos incluem valores negativos, zero ou valores que excedem o saldo disponível.
 *
 * @author Daniel
 * @version 1.0
 */
public class ValorInvalidoException extends RuntimeException {

    /**
     * Cria uma nova exceção indicando que o valor fornecido é inválido para a operação.
     * @param message Mensagem personalizada para indicar o erro
     */
    public ValorInvalidoException(String message) {
        super(message);
    }
}