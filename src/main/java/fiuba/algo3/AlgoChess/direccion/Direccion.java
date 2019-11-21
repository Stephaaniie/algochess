package fiuba.algo3.AlgoChess.direccion;

import fiuba.algo3.AlgoChess.tablero.Posicion;

public interface Direccion {
    public Posicion avanzar(Posicion posicion);
}