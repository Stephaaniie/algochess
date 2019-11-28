package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.entidades.ObjetoNull;

public class Casillero {
	private Posicion posicion;
	private Entidad entidad = new ObjetoNull();

	public Casillero(Posicion posicion){
		this.posicion = posicion;
	}

	public void agregarEntidad(Entidad entidad) {
		this.entidad.agregar(entidad);
	}
	
	public Casillero getCasillero() {
		return this;
	}
	
	public Posicion getPosicionDeCasillero() {
		return this.getCasillero().posicion;
	}
	
	public Entidad getEntidad() {
		return this.entidad;
	}

    public void quitarEntidad() {
		this.entidad = new ObjetoNull();
    }

}
