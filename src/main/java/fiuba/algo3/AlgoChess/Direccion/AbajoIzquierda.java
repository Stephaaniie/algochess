package fiuba.algo3.AlgoChess.Direccion;

import fiuba.algo3.AlgoChess.Tablero.Posicion;

public class AbajoIzquierda implements Direccion{

	@Override
	public Posicion avanzar(Posicion posicion) {
			int filaAbajo = posicion.getFila() + 1;
			int colIzquierda = posicion.getColumna()-1;
	        return new Posicion(filaAbajo,colIzquierda);
	}

}
