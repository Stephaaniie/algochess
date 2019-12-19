package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Controlador.Juego.Manejador;
import fiuba.algo3.Modelado.Direccion.AbajoIzquierda;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import javafx.scene.input.MouseEvent;

public class MoverAbajoIzquierdaControlador extends Mover {
	
	private AbajoIzquierda diagonal;

	public MoverAbajoIzquierdaControlador(Entidad entidad, VistaEntidad vistaEntidad) {
		super(entidad, vistaEntidad);
	}

	
	public void handle(MouseEvent click) {
		entidad.mover(this.diagonal);
		vistaEntidad.setFrameUp();
		vistaEntidad.change();
		Manejador.getInstancia().resetPanes();
	}
}