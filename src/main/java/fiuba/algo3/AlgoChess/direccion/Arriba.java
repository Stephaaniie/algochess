package fiuba.algo3.AlgoChess.direccion;

import fiuba.algo3.AlgoChess.tablero.Posicion;

public class Arriba implements Direccion {
    @Override
    public Posicion avanzar(Posicion posicion) {
        int filaArriba = posicion.getFila() - 1;

        return new Posicion(filaArriba, posicion.getColumna());
    }
}
