package fiuba.algo3.AlgoChess.tablero;

public class Sector {
	
	Posicion posicion;
	
	public Sector(int fila, int columna) {
		this.posicion = new Posicion(fila,columna);
	}
	
	public Sector getSector() {	
		return this;
	}
}
