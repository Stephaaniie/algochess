package fiuba.algo3.AlgoChess.Direccion;

import fiuba.algo3.AlgoChess.Tablero.Posicion;

public class ArribaDerecha implements Direccion{

	@Override
	public Posicion avanzar(Posicion posicion) {
		int filaArriba = posicion.getFila()    - 1;
		int colDerecha = posicion.getColumna() + 1;
        return new Posicion(filaArriba,colDerecha);
	}

}
