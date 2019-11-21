package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.excepciones.*;
import fiuba.algo3.AlgoChess.tablero.Posicion;

public class Catapulta implements Entidad {

	private Bando bando;
	private int vida = 50;
	private int costo = 5;
	private int danioADistancia = 20;
	private Posicion posicion;

	public Catapulta(Bando bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
	    entidadAtacada.recibirDanio(this.danioADistancia);
	}

    @Override
    public void mover(Direccion direccion) throws CatapultaNoSeMueveExcepcion {
        throw new CatapultaNoSeMueveExcepcion();
    }

    @Override
    public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion {
        throw new CasilleroOcupadoExcepcion();
    }

    @Override
    public Posicion getPosicion() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
        return this.posicion;
    }

    @Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}

	public int getCosto() {
		return this.costo;
	}

	public int getVida() {
		return this.vida;
	}

	@Override
	public void reponerVida(int curacion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion, CuranderoCuraHastaLaMaximaVidaExcepcion {
        if ((this.vida += curacion) > 50) {
            this.vida = 50;
        }
	}
}