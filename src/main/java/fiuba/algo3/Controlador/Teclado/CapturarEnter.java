package fiuba.algo3.Controlador.Teclado;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CapturarEnter implements EventHandler<KeyEvent> {

	private Button boton;

	public CapturarEnter(Button boton) {
		this.boton = boton;
	}
	
	@Override
	public void handle(KeyEvent event) {
		if(event.getCode() == KeyCode.ENTER) {
			Event.fireEvent(boton, new ActionEvent());
		}
	}
	


}
