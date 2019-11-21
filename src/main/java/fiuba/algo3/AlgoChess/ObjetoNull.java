package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.MovimientoInvalidoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class ObjetoNull implements EntidadMovil, EntidadFija{

	@Override
	public boolean aliadosCerca() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe y no puede recibir dicho daño");
	}

	@Override
	public boolean enemigosCerca() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe y no puede recibir dicho daño");
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
	public Posicion getPosicion() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		return null;
	}

	@Override
	public void mover(String direccion)
			throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion, MovimientoInvalidoExcepcion {
		
	}

}
