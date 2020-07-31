package fiuba.algo3.Controlador.EntidadesControlador;

import java.util.List;

import fiuba.algo3.Controlador.Juego.Manejador;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Jugador.TurnoSiguiente;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public abstract class EntidadControladora implements EventHandler<MouseEvent> {

	private Entidad entidad;
	
	private VistaEntidad vistaEntidad;
	
	private VistaDelTablero vistaDelTablero;
	
	public EntidadControladora(Entidad entidad, VistaEntidad vistaEntidad, VistaDelTablero vistaDelTablero) {
		
		this.entidad = entidad;
		
		this.vistaDelTablero = vistaDelTablero;
		
		this.vistaEntidad = vistaEntidad;
		
	}
	
	public void handle(MouseEvent mouseEvent) {
		
		if(TurnoSiguiente.getInstancia().getBandoJugadorActual().equals(entidad.getBando())) {
			List<Pane> panes  = this.vistaDelTablero.panesADirigirseEnTablero(entidad, vistaEntidad);
			panes.add(vistaDelTablero.paneActual(entidad));
			Manejador.getInstancia().agregarEntidad(entidad, panes);
		}else {
			Manejador.getInstancia().agregarEntidadEnemiga(entidad);
		}
	}
}
