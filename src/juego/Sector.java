package juego;

import java.util.ArrayList;

public class Sector {
	ArrayList<Casillero> casilleros = new ArrayList<Casillero>();
	Jugador jugadorSector;
	
	public void agregarCasillero(Casillero casillero) {
		casilleros.add(casillero); 
	}
	
	public void agregarJugador(Jugador jugador){
		this.jugadorSector = jugador;
	}
	
	public void agregarContenidoEnCasillero(Jugador jugador, Object contenido, int fila, int columna) {
		if(jugador != jugadorSector) throw new ColocaUnidadEnSectorEnemigoExcepcion;
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
		
		
	}
	
}
