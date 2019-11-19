package fiuba.algo3.AlgoChess.teclado;

import fiuba.algo3.AlgoChess.Posicion;

public class Direccion {

	private int fila;
	private int columna;

    private static Direccion arriba;
    private static Direccion abajo;
    private static Direccion derecha;
    private static Direccion izquierda;

    static {
        arriba    = new Direccion(0,1);
        abajo     = new Direccion(0,-1);
        derecha   = new Direccion(1,0);
        izquierda = new Direccion(-1,0);
    }
    
    Direccion(int fila, int columna) {
    	
    	this.fila = fila;
    	this.columna = columna;
    }

	public static Direccion abajo() {

        return abajo();
    }

    public static Direccion arriba() {

        return arriba();
    }

    public static Direccion derecha() {
        return derecha();
    }
    
    public static Direccion izquierda() {
    	return izquierda();
    }
    public Posicion siguiente(Posicion posicion) {
    	
        int siguienteFila = posicion.getFila() + 1;
        int siguienteColumna = posicion.getColumna() + 1;

        return new Posicion(siguienteFila, siguienteColumna);
    }

    public Posicion anterior(Posicion posicion) {
    	
        int siguienteFila = posicion.getFila() - 1;
        int siguienteColumna = posicion.getColumna() - 1;

        return new Posicion(siguienteFila, siguienteColumna);
    }
}