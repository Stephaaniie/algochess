package fiuba.algo3.AlgoChess.tablero;
import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.entidades.Posicion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;

public class Sector {
	Map<Posicion, Casillero> casilleros = new HashMap<Posicion, Casillero>();
	
	public Jugador jugador;

	public void agregarCasillero(Posicion posicion) {
		Casillero casillero = new Casillero(posicion);
		casilleros.put(posicion, casillero);
	}
	public Sector getSector() {
		
		return this;
	}
	
	public Casillero getCasilleroDelSector(Posicion posicionClave) {
		
		Casillero casillero = casilleros.get(posicionClave);
		
		return casillero;
	}

	public void agregarJugador(Jugador jugador) {
		this.jugador = jugador;

	}

	public void agregarContenidoEnCasillero(Jugador jugador, Entidad contenido, Posicion posicion) throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		if(this.jugador != jugador) throw new ColocarUnidadEnSectorEnemigoExcepcion();
		Casillero casillero = casilleros.get(posicion);
		casillero.agregarContenido(contenido);
	}

}
