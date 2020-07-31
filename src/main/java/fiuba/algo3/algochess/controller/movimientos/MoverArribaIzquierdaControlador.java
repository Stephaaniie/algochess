package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Controlador.Juego.Manejador;
import fiuba.algo3.Modelado.Direccion.ArribaIzquierda;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import javafx.scene.input.MouseEvent;

public class MoverArribaIzquierdaControlador extends Mover{

	private ArribaIzquierda diagonal;

	public MoverArribaIzquierdaControlador(Entidad entidad, VistaEntidad vistaEntidad) {
		super(entidad, vistaEntidad);
	}
		
	public void handle(MouseEvent click) {
		entidad.mover(this.diagonal);
		vistaEntidad.change();
		vistaEntidad.setFrameUp();
		Manejador.getInstancia().resetPanes();
	}

}