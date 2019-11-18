package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public interface Entidad {

    public void restarVida(int danio) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

}
