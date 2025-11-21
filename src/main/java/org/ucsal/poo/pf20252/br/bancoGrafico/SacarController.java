package org.ucsal.poo.pf20252.br.bancoGrafico;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.ucsal.poo.pf20252.br.Conta;

public class SacarController {
    private Conta contaAlvo;

    private boolean saldoVisivel = false;


    @FXML
    private Label saldoConta;

    @FXML
    private Button olhoButton;


    @FXML
    private Label boasVindasUser;



    private void atualizarTela() {
        String nome = "NOME";
        boasVindasUser.setText("Olá " + nome + ",Saque já");
    }


    @FXML
    public void initialize() {
        olhoButton.setOnAction(event -> consultarSaldo());
    }


    public void setContaAlvo(Conta contaAlvo) {
        this.contaAlvo = contaAlvo;
    }


    private void consultarSaldo() {
        saldoVisivel = !saldoVisivel;

        if (saldoVisivel) {
            saldoConta.setText(String.format("%.2f", contaAlvo.getSaldo()));
        } else {
            saldoConta.setText("*****");
        }
    }





}