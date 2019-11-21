package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.*;

public interface Entidad extends Ataque {

	public Posicion getPosicion() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

	public void recibirDanio(int danio) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

	public void reponerVida(int curacion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion, CuranderoCuraHastaLaMaximaVidaExcepcion;

	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

	public void mover(String direccion) throws MovimientoInvalidoExcepcion, CatapultaNoSeMueveExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

	public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion;
}
