package fiuba.algo3.AlgoChess.Buscador;

import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.Tablero.Casillero;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class RadarDeEntidades {
	
	private int distanciaMin;
	
	private int distanciaMax;
	
	public RadarDeEntidades(int distanciaMin, int distanciaMax) {
		this.distanciaMin = distanciaMin;
		this.distanciaMax = distanciaMax;
	}
	
	public void posicionarEntidad(Posicion posicion, Casillero casillero, Entidad entidad, Tablero tablero, Bando bando) {
		if(estaEnElRadar(posicion)) {
			casillero.agregarEntidad(entidad);
			tablero.agregarCasillero(casillero,posicion);
		}
		else {
			throw new ColocarUnidadEnSectorEnemigoExcepcion();
		}
	}
	
	public boolean estaEnElRadar(int distancia) {
		return distancia >= distanciaMin & distancia <= distanciaMax;
	}
	
	public boolean estaEnElRadar(Posicion posicion) {
		return ((posicion.getFila() >= distanciaMin & posicion.getFila() <= distanciaMax) | (posicion.getColumna() >= distanciaMin & posicion.getColumna() <= distanciaMax));
	}
	
	public int getdistanciaMin() {
		return this.distanciaMin;
	}
	
	public int getdistanciaMax() {
		return this.distanciaMax;
	}
}
