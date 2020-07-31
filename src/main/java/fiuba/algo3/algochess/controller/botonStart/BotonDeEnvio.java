package fiuba.algo3.Controlador.EmpezarJuego;

import fiuba.algo3.Modelado.Jugador.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BotonDeEnvio implements EventHandler<ActionEvent> {
	
	private TextField textField;
	
	private Jugador jugador;
	
	private Label label;
	
	public BotonDeEnvio(TextField textField,Jugador jugador, Label label) {
		
		this.jugador = jugador;
		
		this.label = label;
		
		this.textField = textField;
	}

	@Override
	public void handle(ActionEvent event) {
		if(this.textField.getText().trim().equals("")) {
			this.label.setText("Completar");
			this.label.setTextFill(Color.web("#FF00FF"));
		}else {
			jugador.setNombre(textField.getText());
		}
	}
}
