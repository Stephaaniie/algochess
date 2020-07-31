package fiuba.algo3.Modelado.Entidades;

import fiuba.algo3.Modelado.Bandos.Bando;
import fiuba.algo3.Modelado.Direccion.Direccion;
import fiuba.algo3.Modelado.Excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.Modelado.Tablero.Posicion;

public class ObjetoNull implements Entidad {

	@Override
	public Posicion getPosicion() {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion();
	}

	@Override
	public void recibirDanio(int danio) {
		
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion();
		
	}

	@Override
	public void atacarEnemigo(){
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion();
	}

	@Override
	public void reponerVida(int curacion){
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion();
	}

	@Override
	public void mover(Direccion direccion) {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion();
	}

    @Override
    public Entidad agregar(Entidad otraEntidad) {
        return otraEntidad;
    }

	@Override
	public int getCosto() {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion();
	}

	@Override
	public Bando getBando() {
		return null;
	}

	@Override
	public int getVida() {
		return 0;
	}

	@Override
	public void recibirPosicionYBando(Posicion posicion, Bando bandoJugador) {
		throw new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion();

	}
}
