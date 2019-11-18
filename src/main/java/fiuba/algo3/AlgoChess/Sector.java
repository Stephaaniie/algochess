package fiuba.algo3.AlgoChess;

import java.util.ArrayList;
import java.util.List;

public class Sector {
	Map<Posicion, Casillero> casilleros = new HashMap<Posicion, Casillero>();

	public void agregarCasillero(Posicion posicion) {
		Casillero casillero = new Casillero();
		casilleros.put(posicion, casillero);
	}

	public void agregarJugador(Jugador jugador) {
		this.jugador = jugador;

	}

	public void agregarContenidoEnCasillero(Jugador jugador, Entidad contenido, Posicion posicion) {
		if(this.jugador != jugador) throw new ColocaUnidadEnSectorEnemigoExcepcion();
		Casillero casillero = casilleros.get(posicion);
		casillero.agregarContenido(contenido);
	}

}
