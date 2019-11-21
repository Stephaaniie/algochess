package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;

public class Casillero {
	private Posicion posicion;
	private Entidad contenido = new ObjetoNull();

	public Casillero(Posicion posicion){
		this.posicion = posicion;
	}

	public void agregarContenido(Entidad contenido) throws CasilleroOcupadoExcepcion {

		if(this.contenido instanceof ObjetoNull) {
			
			this.contenido = contenido;
			
		}else throw new CasilleroOcupadoExcepcion();
	}

}
