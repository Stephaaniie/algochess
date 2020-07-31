package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Controlador.Juego.Manejador;
import fiuba.algo3.Modelado.Direccion.ArribaDerecha;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import javafx.scene.input.MouseEvent;

public class MoverArribaDerechaControlador extends Mover {

	private ArribaDerecha diagonal;

	public MoverArribaDerechaControlador(Entidad entidad, VistaEntidad vistaEntidad) {
		super(entidad, vistaEntidad);
	}
	
	public void handle(MouseEvent click) {
		entidad.mover(this.diagonal);
		vistaEntidad.change();
		vistaEntidad.setFrameUp();
		Manejador.getInstancia().resetPanes();
	}

}
