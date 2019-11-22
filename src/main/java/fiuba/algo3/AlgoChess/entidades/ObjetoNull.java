package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;

public class ObjetoNull implements Entidad {

	@Override
	public Posicion getPosicion() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad");
	}

	@Override
	public void recibirDanio(int danio)throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe y no puede recibir dicho daño");
		
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe y no puede recibir dicho daño");
	}

	@Override
	public void reponerVida(int curacion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe y no puede recibir dicho daño");
	}

	@Override
	public void mover(Direccion direccion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe");
	}

    @Override
    public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion {
        return otraEntidad;
    }

	@Override
	public int getCosto() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe");
	}
}
