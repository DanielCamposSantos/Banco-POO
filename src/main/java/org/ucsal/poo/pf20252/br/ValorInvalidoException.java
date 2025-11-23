package org.ucsal.poo.pf20252.br;

/**
 * Exceção lançada quando uma operação financeira tenta usar um valor inválido.
 * Valores inválidos incluem valores negativos, zero ou valores que excedem o saldo disponível.
 *
 * @author SeuNome
 * @version 1.0
 */
public class ValorInvalidoException extends RuntimeException {

    /**
     * Cria uma nova exceção indicando que o valor fornecido é inválido para a operação.
     */
    public ValorInvalidoException() {
        super();
    }
}