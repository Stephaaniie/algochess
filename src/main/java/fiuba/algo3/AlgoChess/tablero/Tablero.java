package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.entidades.Posicion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;

public class Tablero {
	private int cantidadEntidades = 0;
	private int cantidadFilas = 20;
	private int cantidadColumas = 20;
	private int cantidadCasilleros = 400;
	private Sector sectorAliado  = new Sector();
	private Sector sectorEnemigo = new Sector();
	public Sector sectorGlobal  = new Sector();
	private static Tablero instanciaTablero = new Tablero();

	private Tablero() {
		for (int i = 0; i < this.cantidadFilas; i++) {
			for (int j = 0; j < this.cantidadColumas; j++) {
				Posicion posicion = new Posicion(i,j);
				if (i < cantidadFilas / 2) {
					sectorAliado.agregarCasillero(posicion);
				} else {
					sectorEnemigo.agregarCasillero(posicion);
				}
				this.sectorGlobal.agregarCasillero(posicion);
			}
		}

		//sectorAliado.agregarJugador(jugador1);
		//sectorEnemigo.agregarJugador(jugador2);
	}

	public static Tablero getInstanciaTablero(){
		return instanciaTablero;
	}

	public int getCantidadEntidades() {
		return cantidadEntidades;
	}

	public void quitarEntidadDePosicion(Posicion posicion){
		if(posicion.getFila() < cantidadFilas / 2){
			sectorAliado.quitarEntidadDePosicion(posicion);
		}else{
			sectorEnemigo.quitarEntidadDePosicion(posicion);
		}
	}

	public void agregarContenidoEnCasillero(Jugador jugador, Entidad contenido, int fila, int columna) throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Posicion posicion = new Posicion(fila, columna);
		if (fila < cantidadFilas / 2) {
			sectorAliado.agregarContenidoEnCasillero(jugador, contenido, posicion);
		} else {
			sectorEnemigo.agregarContenidoEnCasillero(jugador, contenido, posicion);
		}
		this.cantidadEntidades++;
	}
	
	public int getCantidadDeFila() {
		
		return this.cantidadFilas;
	}
	
	public int getCantidadDeColumnas() {
		
		return this.cantidadColumas;
	}

	public int getCantidadCasilleros(){
		return this.cantidadCasilleros;
	}
}