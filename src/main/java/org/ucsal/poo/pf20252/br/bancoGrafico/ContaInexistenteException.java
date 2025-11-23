package org.ucsal.poo.pf20252.br.bancoGrafico;

/**
 * Exceção lançada quando uma operação tenta acessar uma conta que não existe
 * ou quando são detectadas inconsistências nos dados da conta.
 *
 * @author SeuNome
 * @version 1.0
 */
public class ContaInexistenteException extends RuntimeException {

    /**
     * Cria uma nova exceção com a mensagem de erro especificada.
     *
     * @param message Mensagem detalhando o motivo da exceção
     */
    public ContaInexistenteException(String message) {
        super(message);
    }

    /**
     * Cria uma nova exceção sem mensagem específica.
     */
    public ContaInexistenteException() {
        super();
    }
}