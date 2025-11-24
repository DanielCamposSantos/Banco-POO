package org.ucsal.poo.pf20252.br.bancoGrafico;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.ucsal.poo.pf20252.br.ContaPoupanca;


public class ExtratoController extends GeraisController{

    @FXML private Label nomeCompleto;
    @FXML private Label cpf;
    @FXML private Label endereco;
    @FXML private Label numeroConta;
    @FXML private Button avancarMes;



    public void carregarInfoPessoal(){
        nomeCompleto.setText(getContaAlvo().getCliente().getNome());
        cpf.setText(getContaAlvo().getCliente().getCpf());
        endereco.setText(getContaAlvo().getCliente().getEndereco());
        numeroConta.setText(String.valueOf(getContaAlvo().getNumero()));
    }

    public void carregarBotaoAvancarMes(){
        if (getContaAlvo() instanceof ContaPoupanca){
            avancarMes.setVisible(true);
        } else {
            avancarMes.setVisible(false);
        }
    }


    @FXML
    public void clickAvancarMes(){
        ((ContaPoupanca) getContaAlvo()).atualizarSaldo();
        esconderSaldo();
        alertaPassagemTempo();
    }

    private void alertaPassagemTempo(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("O tempo avançou em um mes");
        alert.show();
    }



}
