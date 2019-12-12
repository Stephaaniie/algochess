package fiuba.algo3.Controlador.EntidadesBotonParaComprar;

import fiuba.algo3.Controlador.EntidadesHendler.ComprarHandlerCatapulta;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

public class CatapultaBotonParaComprar extends Button {
	
	public CatapultaBotonParaComprar(Tablero tablero, VistaDelTablero vista) {
		
		super();
		this.setMinSize(320,60);
		this.setMaxSize(320, 60);
		this.setText("Catapulta");
		this.setGraphic(getVistaDeImagen());
		getTextAlignment();
		this.setTextAlignment(TextAlignment.CENTER);
		this.setOnAction(new ComprarHandlerCatapulta(tablero,vista));
		
	}

	private Node getVistaDeImagen() {
		return null;
	}
}
