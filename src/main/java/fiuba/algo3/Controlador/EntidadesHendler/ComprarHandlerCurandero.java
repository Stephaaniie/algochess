package fiuba.algo3.Controlador.EntidadesHendler;

import fiuba.algo3.Modelado.Entidades.Curandero;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.Ventana.PosicionarEntidadesEnTablero;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarHandlerCurandero implements EventHandler<ActionEvent>{

	Tablero tablero;
	
	VistaDelTablero vista;

	public ComprarHandlerCurandero(Tablero tablero, VistaDelTablero vista) {
		this.tablero = tablero;
		this.vista   = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			Curandero curandero = new Curandero();
			//tablero.agergarJugador().comprarEntidad(curandero);
			vista.setOnMousePressed(new PosicionarEntidadesEnTablero(curandero,tablero,vista));
		}catch(RuntimeException e) {
			System.out.println("Lo sentimos, pero ya no contas con puntos suficientes para adquierir un soldado");
		}	
	}

}
