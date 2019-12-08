package fiuba.algo3.AlgoChess.EntidadesHendler;

import fiuba.algo3.AlgoChess.Entidades.Soldado;
import fiuba.algo3.AlgoChess.Tablero.Tablero;
import fiuba.algo3.AlgoChess.Ventana.PosicionarEntidadesEnTablero;
import fiuba.algo3.AlgoChess.Ventana.VistaDelTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarHandlerSoldado implements EventHandler<ActionEvent>{

	Tablero tablero;
	
	VistaDelTablero vista;

	public ComprarHandlerSoldado(Tablero tablero, VistaDelTablero vista) {
		this.tablero = tablero;
		this.vista   = vista;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			Soldado soldado = new Soldado();
			//tablero.agergarJugador().comprarEntidad(soldado);
			vista.setOnMousePressed(new PosicionarEntidadesEnTablero(soldado,tablero,vista));
		}catch(RuntimeException e) {
			System.out.println("Lo sentimos, pero ya no contas con puntos suficientes para adquierir un soldado");
		}	
	}

}
