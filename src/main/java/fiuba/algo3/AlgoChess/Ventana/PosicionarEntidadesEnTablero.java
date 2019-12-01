package fiuba.algo3.AlgoChess.Ventana;

import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Tablero.Tablero;
import javafx.scene.input.MouseEvent;

public class PosicionarEntidadesEnTablero {
	
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
		
	}
}
