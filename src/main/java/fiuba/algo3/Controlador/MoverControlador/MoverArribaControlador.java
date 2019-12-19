package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Controlador.Juego.Manejador;
import fiuba.algo3.Modelado.Direccion.Arriba;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import javafx.scene.input.MouseEvent;

public class MoverArribaControlador extends Mover{
	
	private Arriba arriba;

	public MoverArribaControlador(Entidad entidad, VistaEntidad vistaEntidad) {
		super(entidad, vistaEntidad);
	}

	public void handle(MouseEvent click) {
		entidad.mover(this.arriba);
		vistaEntidad.setFrameUp();
		vistaEntidad.change();
		Manejador.getInstancia().resetPanes();
	}
}
