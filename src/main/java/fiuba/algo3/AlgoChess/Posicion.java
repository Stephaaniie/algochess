package fiuba.algo3.AlgoChess;

import static java.lang.Math.abs;

import static java.lang.Math.sqrt;

public class Posicion {
	
	public int x;

	public int y;
	
	public Posicion(int x, int y) {
		
		this.x = x;
		
		this.y = y;
	}

	public Posicion siguiente(Direccion direccion) {
		
		return direccion.siguiente(this);
	}

	public int getX() {
		
		return this.x;
	}

	public int getY() {
		
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x; 
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int distanciaEntrePosiciones(Posicion posicion) {
		
		int distanciaEnX = this.x - posicion.getX();
		
		int distanciaEnY = this.y - posicion.getY();
		
		int distancia = (int) Math.sqrt(Math.pow(distanciaEnX, 2) + Math.pow(distanciaEnY, 2));

		return distancia;
	}
	
	
}