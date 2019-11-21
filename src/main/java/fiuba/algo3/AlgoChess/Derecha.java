package fiuba.algo3.AlgoChess;

public class Derecha implements Direccion {
    @Override
    public Posicion avanzar(Posicion posicion) {
        int columnaDerecha = posicion.getColumna() + 1;

        return new Posicion(posicion.getFila(), columnaDerecha);
    }
}
