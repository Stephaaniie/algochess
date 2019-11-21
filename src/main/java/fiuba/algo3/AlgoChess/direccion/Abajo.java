package fiuba.algo3.AlgoChess.direccion;

import fiuba.algo3.AlgoChess.entidades.Posicion;

public class Abajo implements Direccion {
    @Override
    public Posicion avanzar(Posicion posicion){
        int filaAbajo = posicion.getFila() + 1;

        return new Posicion(filaAbajo, posicion.getColumna());
    }
}
