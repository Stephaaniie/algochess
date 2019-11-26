package fiuba.algo3.AlgoChess.entidades;

import java.util.ArrayList;

import fiuba.algo3.AlgoChess.Ataques.ArmaParaDistanciaLarga;
import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.distancia.EntidadesACiertaDistancia;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CatapultaNoSeMueveExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;

public class Catapulta implements Entidad, ArmaParaDistanciaLarga {
	private final static int ENEMIGOS = 2;
	private final int DISTANCIADEATAQUE = 6;
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
        throw new CatapultaNoSeMueveExcepcion("No se puede realizar dicha accion");
    }

    @Override
    public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion {
        throw new CasilleroOcupadoExcepcion("No se puede realizar dicha accion");
    }

    @Override
    public Posicion getPosicion() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
        return this.posicion;
    }

    @Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}

	@Override
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

	@Override
	public void objetosASerLanzados() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		ArrayList<Entidad> listaAux = EntidadesACiertaDistancia.entidadesCerca(ENEMIGOS,this,DISTANCIADEATAQUE);
		for(Entidad entidadAux : listaAux) {
			atacarEnemigo(entidadAux);
		}
	}
}