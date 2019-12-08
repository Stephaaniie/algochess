package fiuba.algo3.AlgoChess.Ventana;

import fiuba.algo3.AlgoChess.Entidades.Catapulta;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.Jinete;
import fiuba.algo3.AlgoChess.Entidades.Soldado;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;
import fiuba.algo3.Algochess.EntidadesVista.CatapultaVista;
import fiuba.algo3.Algochess.EntidadesVista.CuranderoVista;
import fiuba.algo3.Algochess.EntidadesVista.JineteVista;
import fiuba.algo3.Algochess.EntidadesVista.SoldadoVista;
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
