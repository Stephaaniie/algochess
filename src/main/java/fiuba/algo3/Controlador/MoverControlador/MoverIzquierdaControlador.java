package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Modelado.Direccion.Izquierda;
import fiuba.algo3.Modelado.Entidades.Entidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MoverIzquierdaControlador implements EventHandler<MouseEvent> {
	private Izquierda izquierda;
	private Entidad entidad;
	
	public MoverIzquierdaControlador(Entidad entidad) {
		this.entidad = entidad;
		this.izquierda = new Izquierda();
	}
	
	public void handle(MouseEvent click) {
		entidad.mover(this.izquierda);
		Manejador.getInstancia().resetPanes();
	}
}