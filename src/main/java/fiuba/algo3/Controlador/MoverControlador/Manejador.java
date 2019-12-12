package fiuba.algo3.Controlador.MoverControlador;

import java.util.List;

import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.ObjetoNull;
import javafx.scene.layout.Pane;

public class Manejador {

	private Entidad entidad;
	
	private List<Pane> panes;
	
	private Manejador() {
		ObjetoNull objetoNull = new ObjetoNull();
		entidad = objetoNull;
	}
	
	private static final Manejador instancia = new Manejador();
	
	public static Manejador getInstancia() {
		return instancia;
	}
	
	public void agregarEntidad(Entidad entidad) {
		atacar(entidad);
	}

	public void agregarEntidad(Entidad entidad,List<Pane> panes) {
		this.entidad = entidad;
		this.panes = panes;
	}
	
	public void atacar(Entidad entidad) {
		if(this.entidad != entidad) {
			entidad.atacarEnemigo();
			resetPanes();
		}
	}

	public void resetPanes() {
		this.panes.stream().forEach(x -> { x.setStyle("-fx-background: #CCFF66"); x.setOnMouseClicked(new MovimientoNull());});
	}
	
	public boolean tieneEntidad() {
		ObjetoNull objetoNull = new ObjetoNull();
		return entidad != objetoNull ;
	}
}
