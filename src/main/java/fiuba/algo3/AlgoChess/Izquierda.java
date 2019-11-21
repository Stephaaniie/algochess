package fiuba.algo3.AlgoChess;

public class Izquierda implements Direccion {
    @Override
    public Posicion avanzar(Posicion posicion) {
        int columnaIzquierda = posicion.getColumna() - 1;

        return new Posicion(posicion.getFila(), columnaIzquierda);
    }
}
