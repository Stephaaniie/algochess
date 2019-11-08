package fiuba.algo3.AlgoChess;

import java.util.ArrayList;
import java.util.List;

public class Sector {
	List<Casillero> casilleros = new ArrayList<Casillero>();

	public void agregarCasillero(Casillero casillero) {
		casilleros.add(casillero);
	}
	/*
	public void agregarJugador(Jugador jugador) {
		this.jugador = jugador;

	}

	public void agregarContenidoEnCasillero(Jugador jugador, Object contenido, int fila, int columna) {
		if(this.jugador != jugador) throw new ColocaUnidadEnSectorEnemigoExcepcion;
		int i = 0;
		boolean encontrado = false;
		Casillero casillero = null;
		while (i < casilleros.size() && !encontrado) {
			casillero = casilleros.get(i);
			if (casillero.fila() == fila && casillero.columna() == columna) {
				encontrado = true;
			}
		}
		if (encontrado == true) {
			casillero.agregarContenido(contenido);
		}
		
		*/
	

}
