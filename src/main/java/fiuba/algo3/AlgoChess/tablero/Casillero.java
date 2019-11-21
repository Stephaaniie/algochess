package fiuba.algo3.AlgoChess.tablero;

import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.entidades.ObjetoNull;
import fiuba.algo3.AlgoChess.entidades.Posicion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;

public class Casillero {
	private Posicion posicion;
	private Entidad contenido = new ObjetoNull();

	public Casillero(Posicion posicion){
		this.posicion = posicion;
	}

	public void agregarContenido(Entidad contenido) throws CasilleroOcupadoExcepcion {
		this.contenido = this.contenido.agregar(contenido);
	}
	
	public Casillero getCasillero() {
		
		return this;
	}
	
	public Posicion getPosicionDeCasillero() {
		
		return this.getCasillero().posicion;
	}
	public Entidad getContenido() {
		
		return this.contenido;
	}

    public void quitarEntidad() {
		this.contenido = new ObjetoNull();
    }
}
