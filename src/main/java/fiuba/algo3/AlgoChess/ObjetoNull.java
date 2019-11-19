package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class ObjetoNull implements Entidad , EntidadMovil, EntidadFija{

	@Override
	public boolean aliadosCerca() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe");
	}

	@Override
	public boolean enemigosCerca() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe");
	}

	@Override
	public Posicion getPosicion() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad");
	}

	@Override
	public void recibirDanio(int danio)throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe");
		
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe");
	}

	@Override
	public void reponerVida(int curacion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe");
	}

	@Override
	public void mover(String direccion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe");
	}


}
