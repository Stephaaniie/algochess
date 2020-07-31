package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Controlador.Juego.Manejador;
import fiuba.algo3.Modelado.Direccion.Izquierda;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import javafx.scene.input.MouseEvent;

public class MoverIzquierdaControlador extends Mover {
	
	private Izquierda izquierda;

	public MoverIzquierdaControlador(Entidad entidad, VistaEntidad vistaEntidad) {
		super(entidad, vistaEntidad);
	}	
	
	public void handle(MouseEvent click) {
		entidad.mover(this.izquierda);
		vistaEntidad.change();
		vistaEntidad.setFrameUp();
		Manejador.getInstancia().resetPanes();
	}
}