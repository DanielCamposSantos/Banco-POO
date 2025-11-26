package org.ucsal.poo.pf20252.br.bancoGrafico;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.ucsal.poo.pf20252.br.Conta;
import org.ucsal.poo.pf20252.br.ContaInexistenteException;
import org.ucsal.poo.pf20252.br.BancoMain;
import org.ucsal.poo.pf20252.br.ValorInvalidoException;

/**
 * Controlador para a tela de transferência da aplicação bancária.
 * Gerencia a operação de transferência entre contas com validações de segurança.
 *
 * @author Daniel
 * @version 1.0
 * @see GeraisController
 * @see ValorInvalidoException
 * @see ContaInexistenteException
 */
public class TransferirController extends GeraisController {
    private
    Conta[] contas = {
            BancoMain.getContaCorrente(),
            BancoMain.getContaPoupanca()
    };

    private Conta contaAlvoTransferencia;

    @FXML private TextField numConta;

    /**
     * Executa a operação de transferência entre contas.
     * Realiza validações do valor, número da conta destino e impede transferência para a própria conta.
     * Trata exceções relacionadas a formato numérico, saldo insuficiente e conta inexistente.
     */
    @FXML
    protected void transferirBtn() {
        try {
            double valor = Double.parseDouble(getCampoInput().getText().trim().replace(",", "."));
            long numeroDestino = Long.parseLong(numConta.getText().trim());

            if (getContaAlvo().getNumero() == numeroDestino) {
                throw new ContaInexistenteException("Não é possível transferir para a própria conta");
            }

            if (contas[0].getNumero() == numeroDestino) {
                contaAlvoTransferencia = contas[0];
            } else if (contas[1].getNumero() == numeroDestino) {
                contaAlvoTransferencia = contas[1];
            } else {
                throw new ContaInexistenteException("A conta alvo da transferência não existe");
            }

            getContaAlvo().transferir(valor, contaAlvoTransferencia);
            mostrarSucesso("Transferência concluída");

        } catch (NumberFormatException e) {
            mostrarErro("Digite um número válido");
        } catch (ValorInvalidoException | ContaInexistenteException e) {
            mostrarErro(e.getMessage());
        } finally {
            getCampoInput().setText("");
            numConta.setText("");
            esconderSaldo();
        }
    }

}