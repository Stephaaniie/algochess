package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Modelado.Direccion.AbajoIzquierda;
import fiuba.algo3.Modelado.Entidades.Entidad;
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