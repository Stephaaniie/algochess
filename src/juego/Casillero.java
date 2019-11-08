package juego;

import excepciones.CasilleroOcupadoExcepcion;

public class Casillero {
	private Object contenido;
	private int fila;
	private int columna;
	
	public Casillero(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
		this.contenido = null;
	}
	
	public void agregarContenido(Object contenido) throws CasilleroOcupadoExcepcion {
		if(this.contenido == null) {
			this.contenido = contenido;
		}else throw new CasilleroOcupadoExcepcion();
	}
	
	public int fila() {
		return fila;
	}
	
	public int columna() {
		return columna;
	}
}
