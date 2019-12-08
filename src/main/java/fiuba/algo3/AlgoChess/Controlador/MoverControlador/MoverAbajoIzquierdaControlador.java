package fiuba.algo3.AlgoChess.MoverControlador;

import fiuba.algo3.AlgoChess.Direccion.AbajoIzquierda;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MoverAbajoIzquierdaControlador implements EventHandler<MouseEvent> {
	private AbajoIzquierda diagonal;
	private Entidad entidad;
	
	public MoverAbajoIzquierdaControlador(Entidad entidad) {
		this.entidad = entidad;
		this.diagonal = new AbajoIzquierda();
	}
	
	public void handle(MouseEvent click) {
		entidad.mover(this.diagonal);
		Manejador.getInstancia().resetPanes();
	}
}