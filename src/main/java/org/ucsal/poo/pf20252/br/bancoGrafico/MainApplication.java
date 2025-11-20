package org.ucsal.poo.pf20252.br.bancoGrafico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    private static Stage stage;

    private static Scene telaInicial;
    private static Scene telaSegundaria;



    @Override
    public void start(Stage stageInicial) throws IOException {
        stage = stageInicial;
        Parent fxmlMain = FXMLLoader.load(MainApplication.class.getResource("main.fxml"));
        telaInicial = new Scene(fxmlMain, 640,400);

        Parent fxmlSegunda = FXMLLoader.load(MainApplication.class.getResource("segunda.fxml"));
        telaSegundaria =  new Scene(fxmlSegunda, 640,400);

        stageInicial.setTitle("Tela inicial");
        stageInicial.setScene(telaInicial);
        stageInicial.show();
    }

    public static void changeScreen(String novaTela){
        switch (novaTela){
            case "main" -> stage.setScene(telaInicial);
            case "segunda" -> stage.setScene(telaSegundaria);
            default -> System.err.println("Tela inesistente");
        }
    }




    public static void main(String[] args) {
        launch();
    }
}