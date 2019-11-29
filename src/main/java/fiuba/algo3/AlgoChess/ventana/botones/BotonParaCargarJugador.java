package fiuba.algo3.AlgoChess.ventana.botones;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class BotonParaCargarJugador extends Button {

    public BotonParaCargarJugador(HBox hbox, TextField nombreJugador1) {
        super();
        this.setText("JUGAR");
        this.setPrefSize(250, 120);
        this.setStyle("-fx-font: 30 arial; -fx-base: #000000; -fx-border-color: #6d1fd8; -fx-text-fill: #f4ed15");
    }
}