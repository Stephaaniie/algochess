package fiuba.algo3.Controlador.MoverControlador;


import fiuba.algo3.Controlador.Juego.Manejador;
import fiuba.algo3.Modelado.Direccion.AbajoDerecha;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import javafx.scene.input.MouseEvent;

public class MoverAbajoDerechaControlador extends Mover {
		
	private AbajoDerecha diagonal;

	public MoverAbajoDerechaControlador(Entidad entidad, VistaEntidad vistaEntidad) {
		super(entidad, vistaEntidad);	
	}

	public void handle(MouseEvent click) {
		entidad.mover(this.diagonal);
		vistaEntidad.setFrameUp();
		vistaEntidad.change();
		Manejador.getInstancia().resetPanes();
	}
}