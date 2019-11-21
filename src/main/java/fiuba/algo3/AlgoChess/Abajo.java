package fiuba.algo3.AlgoChess;

public class Abajo implements Direccion{
    @Override
    public Posicion avanzar(Posicion posicion){
        int filaAbajo = posicion.getFila() + 1;

        return new Posicion(filaAbajo, posicion.getColumna());
    }
}
