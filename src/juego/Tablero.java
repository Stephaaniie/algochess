package juego;

import java.util.ArrayList;

public class Tablero {
	
	private int cantidadEntidades = 0;
	private int cantidadFilas = 20;
	private int cantidadColumas = 20;
	private int cantidadCasilleros = 400;
	private Sector sectorAliado = new Sector();
	private Sector sectorEnemigo = new Sector();
	
	public Tablero(Jugador jugador1, Jugador jugador2) {
		for(int i = 0; i < this.cantidadFilas; i++) {
			for(int j = 0; j < this.cantidadColumas; j++) {
				Casillero casillero = new Casillero(i,j);
				if(i < cantidadFilas/2 ) {
					sectorAliado.agregarCasillero(casillero);
				}else sectorEnemigo.agregarCasillero(casillero);
			}		
		}
		
		sectorAliado.agregarJugador(jugador1);
		sectorEnemigo.agregarJugador(jugador2);
	}
	
	public int getCantidadEntidades() {
		return cantidadEntidades;
	}

	public void agregarContenidoEnCasillero(Jugador jugador, Object contenido, int fila, int columna) {
		if(fila < cantidadFilas/2) {
			sectorAliado.agregarContenidoEnCasillero(jugador, contenido, fila, columna);
		}else{
			sectorEnemigo.agregarContenidoEnCasillero(jugador, contenido, fila, columna);
		}
		
		this.cantidadEntidades++;
	}
}