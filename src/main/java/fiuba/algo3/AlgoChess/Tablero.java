package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;

public class Tablero {

	private int cantidadEntidades = 0;
	private int cantidadFilas = 20;
	private int cantidadColumas = 20;
	private int cantidadCasilleros = 400;
	private Sector sectorAliado = new Sector();
	private Sector sectorEnemigo = new Sector();

	public Tablero(Jugador jugador1, Jugador jugador2) {
		for (int i = 0; i < this.cantidadFilas; i++) {
			for (int j = 0; j < this.cantidadColumas; j++) {
				Posicion posicion = new Posicion(i,j);
				if (i < cantidadFilas / 2) {
					sectorAliado.agregarCasillero(posicion);
				} else
					sectorEnemigo.agregarCasillero(posicion);
			}
		}

		sectorAliado.agregarJugador(jugador1);
		sectorEnemigo.agregarJugador(jugador2);
	}

	public int getCantidadEntidades() {
		return cantidadEntidades;
	}


	public void agregarContenidoEnCasillero(Jugador jugador, Object contenido, int fila, int columna) throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Posicion posicion = new Posicion(fila, columna);
		if (fila < cantidadFilas / 2) {
			sectorAliado.agregarContenidoEnCasillero(jugador, contenido, posicion);
		} else {
			sectorEnemigo.agregarContenidoEnCasillero(jugador, contenido, posicion);
		}

		this.cantidadEntidades++;
	}

}