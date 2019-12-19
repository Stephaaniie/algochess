package fiuba.algo3.Controlador.Juego;

import fiuba.algo3.Modelado.Jugador.TurnoSiguiente;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HendlerParaPasarTurno implements EventHandler<ActionEvent>{

	@Override
	public void handle(ActionEvent click) {
		TurnoSiguiente.getInstancia().cambiarTurno();
		System.out.println(" Turno del Contrincante ");
	}
}
