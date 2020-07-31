package fiuba.algo3.Vista.Juego;

import fiuba.algo3.Controlador.EmpezarJuego.BotonDeEnvio;
import fiuba.algo3.Controlador.Teclado.CapturarEnter;
import fiuba.algo3.Modelado.Jugador.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CargarNombre {
	
	private VBox vBox;
	
	public CargarNombre(Jugador jugador) {
		
		TextField texto = new TextField();
	
		texto.setPromptText("NOMBRE DE : "+jugador.getBando());
		texto.setMaxWidth(132);
		
		Label etiqueta = new Label();
		
		etiqueta.setText(texto.getText());
		etiqueta.setMaxWidth(132);
		
		Button boton = new Button();
		
		boton.setText("LISTO");
		
		HBox contenedorHorizontal = new HBox(boton);
		
        contenedorHorizontal.setSpacing(0);

        vBox = new VBox(texto, contenedorHorizontal, etiqueta);
        vBox.setSpacing(0);
        vBox.setPadding(new Insets(0));
        
        BotonDeEnvio botonEnviar = new BotonDeEnvio(texto, jugador, etiqueta);
        boton.setOnAction(botonEnviar);

        CapturarEnter textoEventHandler = new CapturarEnter(boton);
        texto.setOnKeyPressed(textoEventHandler);
	}
	
	public VBox getOpcion() {
		return vBox;
	}
	
}
