package fiuba.algo3.AlgoChess.MoverControlador;

import fiuba.algo3.AlgoChess.Direccion.Derecha;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MoverDerechaControlador implements EventHandler<MouseEvent> {
	private Derecha derecha;
	private Entidad entidad;
	
	public MoverDerechaControlador(Entidad entidad) {
		this.entidad = entidad;
		this.derecha = new Derecha();
	}
	
	public void handle(MouseEvent click) {
		entidad.mover(this.derecha);
		Manejador.getInstancia().resetPanes();
	}
}