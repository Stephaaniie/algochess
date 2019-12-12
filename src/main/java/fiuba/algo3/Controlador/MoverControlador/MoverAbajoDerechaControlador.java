package fiuba.algo3.Controlador.MoverControlador;


import fiuba.algo3.Modelado.Direccion.AbajoDerecha;
import fiuba.algo3.Modelado.Entidades.Entidad;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class MoverAbajoDerechaControlador implements EventHandler<MouseEvent> {
	private AbajoDerecha diagonal;
	private Entidad entidad;
	
	public MoverAbajoDerechaControlador(Entidad entidad) {
		this.entidad = entidad;
		this.diagonal = new AbajoDerecha();
	}
	
	public void handle(MouseEvent click) {
		entidad.mover(this.diagonal);
		Manejador.getInstancia().resetPanes();
	}
}