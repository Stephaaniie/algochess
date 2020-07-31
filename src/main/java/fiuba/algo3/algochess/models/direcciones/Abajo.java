package fiuba.algo3.Modelado.Direccion;

import fiuba.algo3.Modelado.Tablero.Posicion;

public class Abajo implements Direccion {
    @Override
    public Posicion avanzar(Posicion posicion){
        return new Posicion(posicion.getFila() + 1, posicion.getColumna());
    }
}
