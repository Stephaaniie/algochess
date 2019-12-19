package fiuba.algo3.Controlador.MoverControlador;

import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class Mover implements EventHandler<MouseEvent> {
	
	protected Entidad entidad;
	
	protected VistaEntidad vistaEntidad;
	
	public Mover(Entidad entidad, VistaEntidad vistaEntidad) {
		
		this.entidad = entidad;
		
		this.vistaEntidad = vistaEntidad;
	}
	
	public abstract void handle(MouseEvent click);
}
