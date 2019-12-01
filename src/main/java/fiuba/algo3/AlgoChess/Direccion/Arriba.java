package fiuba.algo3.AlgoChess.Direccion;

import fiuba.algo3.AlgoChess.Tablero.Posicion;

public class Arriba implements Direccion {
	
    @Override
    public Posicion avanzar(Posicion posicion) {
        int filaArriba = posicion.getFila() - 1;

        return new Posicion(filaArriba, posicion.getColumna());
    }
}
