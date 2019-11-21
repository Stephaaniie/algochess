package fiuba.algo3.AlgoChess.direccion;

import fiuba.algo3.AlgoChess.tablero.Posicion;

public class Izquierda implements Direccion {
    @Override
    public Posicion avanzar(Posicion posicion) {
        int columnaIzquierda = posicion.getColumna() - 1;

        return new Posicion(posicion.getFila(), columnaIzquierda);
    }
}
