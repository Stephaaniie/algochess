package fiuba.algo3.AlgoChess.direccion;

import fiuba.algo3.AlgoChess.tablero.Posicion;

public class Abajo implements Direccion {
    @Override
    public Posicion avanzar(Posicion posicion){
        int filaAbajo = posicion.getFila() + 1;

        return new Posicion(filaAbajo, posicion.getColumna());
    }
}
