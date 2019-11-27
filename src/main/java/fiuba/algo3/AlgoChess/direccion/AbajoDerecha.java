package fiuba.algo3.AlgoChess.direccion;

import fiuba.algo3.AlgoChess.tablero.Posicion;

public class AbajoDerecha implements Direccion{

	@Override
	public Posicion avanzar(Posicion posicion) {
		int filaAbajo = posicion.getFila() + 1;
		int colDerecha = posicion.getColumna()+1;
        return new Posicion(filaAbajo,colDerecha);
	}

}
