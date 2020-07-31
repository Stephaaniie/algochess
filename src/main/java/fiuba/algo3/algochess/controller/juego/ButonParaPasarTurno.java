package fiuba.algo3.Controlador.Juego;

import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

public class ButonParaPasarTurno extends Button {

	public ButonParaPasarTurno() {
		
		super();
		
		this.setMinSize(320,56);
		
		this.setMaxSize(320,56);
		
		this.setText("SIGUIENTE");
		
		this.setTextAlignment(TextAlignment.CENTER);
	
		this.setOnAction(new HendlerParaPasarTurno());
	}
}
