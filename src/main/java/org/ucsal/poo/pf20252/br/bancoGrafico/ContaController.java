package org.ucsal.poo.pf20252.br.bancoGrafico;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.ucsal.poo.pf20252.br.Conta;
import org.ucsal.poo.pf20252.br.Telas;

public class ContaController {
    private Conta contaAlvo;
    private boolean saldoVisivel = false;

    @FXML
    private Label saldoConta;

    @FXML
    private Button olhoButton;



    @FXML
    protected void onSacarBtnClick(){
        MainApplication.changeScreen(Telas.SACAR,contaAlvo);
    }

    @FXML
    protected void onDepositarBtnClick(){
        MainApplication.changeScreen(Telas.DEPOSITAR,contaAlvo);
    }

    @FXML
    protected void onTransferirBtnClick(){
        MainApplication.changeScreen(Telas.TRANSFERIR,contaAlvo);
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
