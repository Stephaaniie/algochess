package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CuranderoNoCuraAunaEntidadFija;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public interface Entidad {

	public void recibirDanio(int danio) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

	public void reponerVida(int curacion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion, CuranderoCuraHastaLaMaximaVidaExcepcion, CuranderoNoCuraAunaEntidadFija;

}
