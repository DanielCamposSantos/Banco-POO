module org.ucsal.poo.pf20252.br {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.ucsal.poo.pf20252.br to javafx.fxml;
    exports org.ucsal.poo.pf20252.br;
    exports org.ucsal.poo.pf20252.br.bancoGrafico;
    opens org.ucsal.poo.pf20252.br.bancoGrafico to javafx.fxml;
}