package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Controlador.Juego.Manejador;
import fiuba.algo3.Modelado.Direccion.Abajo;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import javafx.scene.input.MouseEvent;

public class MoverAbajoControlador extends Mover {
	private Abajo abajo;
	
	public MoverAbajoControlador(Entidad entidad, VistaEntidad vistaEntidad) {
		super(entidad, vistaEntidad);
	}

	public void handle(MouseEvent click) {
		entidad.mover(this.abajo);
		vistaEntidad.setFrameUp();
		vistaEntidad.change();
		Manejador.getInstancia().resetPanes();
	}
}