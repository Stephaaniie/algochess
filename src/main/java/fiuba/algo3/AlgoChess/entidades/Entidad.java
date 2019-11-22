package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.Ataques.Ataque;
import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.excepciones.*;
import fiuba.algo3.AlgoChess.tablero.Posicion;

public interface Entidad extends Ataque {

	public Posicion getPosicion() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

	public void recibirDanio(int danio) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

	public void reponerVida(int curacion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion, CuranderoCuraHastaLaMaximaVidaExcepcion;

	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

	public void mover(Direccion direccion) throws CatapultaNoSeMueveExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion, CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion;

	public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion;

	public int getCosto() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
}
