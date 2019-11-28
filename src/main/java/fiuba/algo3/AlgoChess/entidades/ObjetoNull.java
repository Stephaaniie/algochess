package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;

public class ObjetoNull implements Entidad {

	@Override
	public Posicion getPosicion() {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad");
	}

	@Override
	public void recibirDanio(int danio) {
		
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe y no puede recibir dicho daño");
		
	}

	@Override
	public void atacarEnemigo(){
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe y no puede recibir dicho daño");
	}

	@Override
	public void reponerVida(int curacion){
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe y no puede recibir dicho daño");
	}

	@Override
	public void mover(Direccion direccion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe");
	}

    @Override
    public Entidad agregar(Entidad otraEntidad) {
        return otraEntidad;
    }

	@Override
	public int getCosto() {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe");
	}

	@Override
	public Bando getBando() {
		return null;
	}

	@Override
	public int getVida() {
		return 0;
	}
}
