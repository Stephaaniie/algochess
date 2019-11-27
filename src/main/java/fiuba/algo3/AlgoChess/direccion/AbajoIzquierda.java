package fiuba.algo3.AlgoChess.direccion;

import fiuba.algo3.AlgoChess.tablero.Posicion;

public class AbajoIzquierda implements Direccion{

	@Override
	public Posicion avanzar(Posicion posicion) {
			int filaAbajo = posicion.getFila() + 1;
			int colIzquierda = posicion.getColumna()-1;
	        return new Posicion(filaAbajo,colIzquierda);
	}

}
