package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Modelado.Direccion.ArribaIzquierda;
import fiuba.algo3.Modelado.Entidades.Entidad;
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