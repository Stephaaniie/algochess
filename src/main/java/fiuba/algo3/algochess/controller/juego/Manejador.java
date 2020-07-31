package fiuba.algo3.Controlador.Juego;

import java.util.List;

import fiuba.algo3.Controlador.MoverControlador.MovimientoNull;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.ObjetoNull;
import fiuba.algo3.Modelado.Excepciones.EntidadInvalidaExcepcion;
import fiuba.algo3.Modelado.Excepciones.NoHayCeldasAlrededorDeUnaDistanciaRequeridaExcepcion;
import fiuba.algo3.Modelado.Excepciones.NoPuedeRealizarAccionesTerminoElJuegoExcepcion;
import javafx.scene.layout.Pane;

public class Manejador {

	private Entidad entidad;
	
	private List<Pane> panes;
	
	private static final Manejador instancia = new Manejador();
	
	private Manejador() {
		entidad =  new ObjetoNull();
	}
	
	
	public static Manejador getInstancia() {
		return instancia;
	}
	
	public void agregarEntidadEnemiga(Entidad entidad) {
		atacar(entidad);
	}

	public void agregarEntidad(Entidad entidad,List<Pane> panes) {
		this.entidad = entidad;
		this.panes = panes;
	}
	
	public void atacar(Entidad entidadAtacada) {
		if(!entidad.equals(entidadAtacada)) {
			try {
				entidad.atacarEnemigo();
			}catch(EntidadInvalidaExcepcion e) {
			}catch(NoHayCeldasAlrededorDeUnaDistanciaRequeridaExcepcion n) {			
			}catch(NoPuedeRealizarAccionesTerminoElJuegoExcepcion x) {
			}
			resetPanes();
		}
	}

	public void resetPanes() {
		this.panes.stream().forEach(x -> { x.setStyle("-fx-background: #CCFF66"); x.setOnMouseClicked(new MovimientoNull());});
		entidad = new ObjetoNull();
	}
	
	public boolean tieneEntidad() {
		ObjetoNull objetoNull = new ObjetoNull();
		return entidad != objetoNull ;
	}
}
