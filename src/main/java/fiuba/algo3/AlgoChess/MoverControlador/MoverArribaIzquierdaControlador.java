package fiuba.algo3.AlgoChess.MoverControlador;

import fiuba.algo3.AlgoChess.Direccion.ArribaIzquierda;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MoverArribaIzquierdaControlador implements EventHandler<MouseEvent> {

	private ArribaIzquierda diagonal;
	private Entidad entidad;
		
	public MoverArribaIzquierdaControlador(Entidad entidad) {
		this.entidad = entidad;
		this.diagonal = new ArribaIzquierda();
	}
		
	public void handle(MouseEvent click) {
		entidad.mover(this.diagonal);
		Manejador.getInstancia().resetPanes();
	}

}