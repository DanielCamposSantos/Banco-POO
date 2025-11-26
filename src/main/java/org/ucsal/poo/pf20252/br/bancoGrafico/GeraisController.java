package org.ucsal.poo.pf20252.br.bancoGrafico;

import javafx.scene.control.Alert;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.ucsal.poo.pf20252.br.Conta;
import org.ucsal.poo.pf20252.br.Telas;


/**
 * Controlador abstrato base para as telas da aplicação bancária.
 * Define comportamentos e elementos comuns compartilhados entre diferentes telas.
 *
 * @author Daniel
 * @version 1.0
 * @see Conta
 * @see Telas
 */
public abstract class GeraisController  {
    private Conta contaAlvo;
    @FXML private Label saldoConta;
    @FXML private TextField campoInput;
    @FXML private Label boasVindas;

    /**
     * Aciona a consulta do saldo da conta alvo.
     * Atualiza o label de saldo com o valor atualizado ou oculto.
     */
    @FXML
    public void consultarSaldoBtn() {
        contaAlvo.consultarSaldo(saldoConta);
    }

    /**
     * Navega de volta para a tela inicial da aplicação.
     * Esconde o saldo antes de realizar a transição de tela.
     */
    @FXML
    public void voltarInicio() {
        esconderSaldo();
        MainApplication.changeScreen(Telas.INICIAL);
    }

    /**
     * Exibe uma mensagem de boas personalizada para a conta alvo
     * @param nomeCliente Nome do cliente que será exibido na mensagem
     */
    public void mensagemBoasVindas(String nomeCliente){
        String primeiroNome = nomeCliente.split(" ")[0];
        boasVindas.setText("Olá " + primeiroNome + "!");
    }


    /**
     * Exibe uma mensagem de sucesso para o usuário.
     *
     * @param mensagem Texto a ser exibido no diálogo de sucesso
     */
    protected void mostrarSucesso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setContentText(mensagem);
        alert.show();
    }

    /**
     * Exibe uma mensagem de erro para o usuário.
     *
     * @param mensagem Texto a ser exibido no diálogo de erro
     */
    protected void mostrarErro(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERRO");
        alert.setContentText(mensagem);
        alert.show();
    }

    /**
     * Oculta o saldo da conta.
     */
    protected void esconderSaldo() {
        saldoConta.setText("*****");
    }

    /**
     * Define a conta que será manipulada pelo controlador.
     *
     * @param contaAlvo Conta a ser definida como alvo das operações
     */
    public void setContaAlvo(Conta contaAlvo) {
        this.contaAlvo = contaAlvo;
    }

    /**
     * Retorna a conta atualmente definida como alvo.
     *
     * @return Conta alvo das operações
     */
    public Conta getContaAlvo() {
        return contaAlvo;
    }

    /**
     * Retorna o campo de entrada de texto para manipulação nas subclasses.
     *
     * @return Campo de entrada de texto
     */
    public TextField getCampoInput() {
        return campoInput;
    }
}
