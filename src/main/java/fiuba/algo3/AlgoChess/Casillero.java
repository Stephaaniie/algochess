package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;

public class Casillero {
	
	private Posicion posicion = new Posicion(0, 0);
	
	private Entidad contenido = null; //aca iria el objeto nulo pero falta hacerlo

	public  Casillero(Posicion posicion) {
		
		this.posicion.columna = posicion.columna;
		
		this.posicion.fila    = posicion.fila;
	}

	public void agregarContenido(Object contenido2) throws CasilleroOcupadoExcepcion {
		
		if(contenido == null) {
			
			this.contenido = contenido;
			
		}else throw new CasilleroOcupadoExcepcion(); 
	}
}
