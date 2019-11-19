package fiuba.algo3.AlgoChess.teclado;

import fiuba.algo3.AlgoChess.Posicion;

public class Direccion {

    public Posicion arriba(Posicion posicion) {
    	
        int filaDeArriba = posicion.getFila() - 1;

        return new Posicion(filaDeArriba, posicion.getColumna());
    }

    public Posicion abajo(Posicion posicion) {
    	
        int filaDeAbajo = posicion.getFila() + 1;

        return new Posicion(filaDeAbajo, posicion.getColumna());
    }
    
    public Posicion derecha(Posicion posicion) {
    	
        int siguienteColumna = posicion.getColumna() + 1;

        return new Posicion(posicion.getFila(), siguienteColumna);
    }
    
    public Posicion izquierda(Posicion posicion) {
    	
        int columnaAnterior = posicion.getColumna() - 1;

        return new Posicion(posicion.getFila(), siguienteColumna);
    }
}