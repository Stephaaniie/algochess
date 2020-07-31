package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Controlador.Juego.Manejador;
import fiuba.algo3.Modelado.Direccion.Derecha;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import javafx.scene.input.MouseEvent;

public class MoverDerechaControlador extends Mover {
	
	private Derecha derecha;

	public MoverDerechaControlador(Entidad entidad, VistaEntidad vistaEntidad) {
		super(entidad, vistaEntidad);
	}

	public void handle(MouseEvent click) {
		entidad.mover(this.derecha);
		vistaEntidad.change();
		vistaEntidad.setFrameUp();
		Manejador.getInstancia().resetPanes();
	}
}