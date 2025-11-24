package org.ucsal.poo.pf20252.br.bancoGrafico;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import org.ucsal.poo.pf20252.br.ContaPoupanca;


public class ExtratoController extends GeraisController{

    @FXML private Label nomeCompleto;
    @FXML private Label cpf;
    @FXML private Label endereco;
    @FXML private HBox tabelaRendimento;
    @FXML private Label
            rendimento1,
            rendimento2,
            rendimento3,
            rendimento4,
            rendimento5,
            rendimento6,
            rendimento7,
            rendimento8,
            rendimento9,
            rendimento10,
            rendimento11,
            rendimento12;

    private Label[] rendimentos;

    @FXML
    public void initialize(){
        rendimentos = new Label[] {
                rendimento1,
                rendimento2,
                rendimento3,
                rendimento4,
                rendimento5,
                rendimento6,
                rendimento7,
                rendimento8,
                rendimento9,
                rendimento10,
                rendimento11,
                rendimento12
        };
    }



    public void carregarInfoPessoal(){
        nomeCompleto.setText(getContaAlvo().getCliente().getNome());
        cpf.setText(getContaAlvo().getCliente().getCpf());
        endereco.setText(getContaAlvo().getCliente().getEndereco());
    }


    public void gerarSaldos(){
        if (getContaAlvo() instanceof ContaPoupanca) {
            for (int i = 0; i < 12; i++) {
                rendimentos[i].setText("MODIFICAR!");
            }
            tabelaRendimento.setVisible(true);
            tabelaRendimento.setManaged(true);

        } else {
            tabelaRendimento.setVisible(false);
            tabelaRendimento.setManaged(false);
        }
    }
}
