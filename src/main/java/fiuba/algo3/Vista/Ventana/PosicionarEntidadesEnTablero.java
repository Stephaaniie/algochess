package fiuba.algo3.Vista.Ventana;

import fiuba.algo3.Modelado.Entidades.Catapulta;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.Jinete;
import fiuba.algo3.Modelado.Entidades.Soldado;
import fiuba.algo3.Modelado.Tablero.Posicion;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.EntidadesVista.CatapultaVista;
import fiuba.algo3.Vista.EntidadesVista.CuranderoVista;
import fiuba.algo3.Vista.EntidadesVista.JineteVista;
import fiuba.algo3.Vista.EntidadesVista.SoldadoVista;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class PosicionarEntidadesEnTablero implements EventHandler<MouseEvent>{
	
	private Entidad entidad;
	
	private Tablero tablero;
	
	private VistaDelTablero vista;
	
	public PosicionarEntidadesEnTablero(Entidad entidad, Tablero tablero, VistaDelTablero vista) {
		this.entidad = entidad;
		this.tablero = tablero;
		this.vista   = vista;
	}
	
	public void handle(MouseEvent click) {
		
		int fila = (int) click.getX()/48;
		int columna= (int) click.getY()/38;
		Posicion posicion = new Posicion(fila,columna);
		
		try {
			tablero.agregarEntidadEnCasillero(entidad, posicion);
			if(entidad.getClass() == Soldado.class) {
				new SoldadoVista(vista,entidad);
			}else if(entidad.getClass() == Jinete.class) {
				new JineteVista(vista,entidad);
			}else if(entidad.getClass() == Catapulta.class) {
				new CatapultaVista(vista,entidad);
			}else {
				new CuranderoVista(vista,entidad);
			}
		}catch(RuntimeException e) {
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setContentText("Este sector no es el correspondiente");
			alerta.showAndWait();
		}
	}
}
