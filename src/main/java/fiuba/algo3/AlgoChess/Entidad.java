package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public interface Entidad {

	public void recibirDanio(int danio) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

}
