package fiuba.algo3.Controlador.EntidadesVista;

import java.util.List;

import fiuba.algo3.Controlador.Juego.Manejador;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CatapultaControladorVista implements EventHandler<MouseEvent> {
	
	private static final VistaEntidad vistaEntidad = null;

	private Entidad entidad;
	
	private VistaDelTablero tablero;
	
	public CatapultaControladorVista(Entidad entidad, VistaDelTablero tablero) {
		this.entidad = entidad;
		this.tablero = tablero;
	}
	
	public void handle(MouseEvent click) {
		if(!Manejador.getInstancia().tieneEntidad()) {
			List<Pane> panes = tablero.panesADirigirseEnTablero(entidad, vistaEntidad);
			panes.add(tablero.paneActual(entidad));
			Manejador.getInstancia().agregarEntidad(entidad, panes);
		}else {
			Manejador.getInstancia().agregarEntidadEnemiga(entidad);
		}
	}
}