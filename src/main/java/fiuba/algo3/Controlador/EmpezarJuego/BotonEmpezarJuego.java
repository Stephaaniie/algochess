package fiuba.algo3.Controlador.EmpezarJuego;

import fiuba.algo3.Vista.Juego.VistaJuego;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

public class BotonEmpezarJuego extends Button {

	public BotonEmpezarJuego(VistaJuego vista) {
        this.setMinSize(132,66);
        this.setMaxSize(132,66);
        this.setText("COMENZAR");
        this.setPrefSize(300,150);
        this.setStyle("-fx-font: 30 arial; -fx-base: #000000; -fx-border-color: #6d1fd8; -fx-text-fill: #f4ed15");
        this.setTextAlignment(TextAlignment.CENTER);
        this.setOnAction(new EmpezarJuegoHendler(vista));
    }
}