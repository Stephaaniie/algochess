package fiuba.algo3.Vista.Juego;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.Controlador.Juego.ButonParaPasarTurno;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.EntidadesAComprar.VistaDeCompra;
import fiuba.algo3.Vista.Ventana.Observer;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaJuego implements Observer{
	
	private static final String STYLE_PATH = "ChatStyle.css";

	private Stage stage;
	
	private List<Node> escenas = new ArrayList<>();
	
	private VistaDelTablero vistaDelTablero;
		
	public VistaJuego(Stage stage) {
	        
		this.stage = stage;

	    Tablero tablero = new Tablero();
	        
	    this.vistaDelTablero = new VistaDelTablero(tablero);

	    Menu menu = new Menu(tablero, this);

	    escenas.add(new VistaDeCompra( null, vistaDelTablero));
	    escenas.add(new ButonParaPasarTurno());

	    stage.setScene(new Scene(new HBox(menu)));
	}

	public void change() {
		VBox vBox = new VBox(escenas.get(0));
	    vBox.getStylesheets().add(new File(STYLE_PATH).toString());
	    vBox.getStyleClass().add("vbox");
	    vBox.setMinHeight(640);
	    vBox.setMaxHeight(640);
	    stage.setScene(new Scene(new HBox(vistaDelTablero, vBox)));
	    vistaDelTablero.setDisable(false);
	    escenas.remove(0);
	}
	
}
