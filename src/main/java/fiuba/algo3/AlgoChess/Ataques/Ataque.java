package fiuba.algo3.AlgoChess.Ataques;

import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public interface Ataque {

	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
	

}
