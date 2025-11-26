package org.ucsal.poo.pf20252.br;

/**
 * Representa um cliente do banco, contendo suas informações básicas de identificação.
 *
 * @author João
 * @version 1.0
 * @since 2025-02
 */

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;

    /**
     * Construtor da classe Cliente.
     *
     * @param cpf      O Cadastro de Pessoa Física do cliente.
     * @param endereco O endereço residencial completo do cliente.
     * @param nome     O nome completo do cliente.
     */

    public Cliente(String cpf, String endereco, String nome) {
        this.cpf = cpf;
        this.endereco = endereco;
        this.nome = nome;
    }

    /**
     * Retorna o CPF do cliente.
     *
     * @return CPF do cliente
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Retorna o nome completo do cliente.
     *
     * @return Nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o endereço do cliente.
     *
     * @return Endereço do cliente
     */
    public String getEndereco() {
        return endereco;
    }

}