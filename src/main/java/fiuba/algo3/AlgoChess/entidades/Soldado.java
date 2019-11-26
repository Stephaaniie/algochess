package fiuba.algo3.AlgoChess.entidades;

import java.util.ArrayList;

import fiuba.algo3.AlgoChess.Ataques.ArmaParaCuerpoACuerpo;
import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.distancia.EntidadesACiertaDistancia;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Soldado implements Entidad, ArmaParaCuerpoACuerpo {
	private final static int ALIADOS  = 1;
	private final static int ENEMIGOS = 2;
	private final int DISTANCIADEATAQUE = 2;
	private final int VIDAINICIAL = 100;
	private Bando bando;
	private int danioACuerpo = 10;
	private int vida = VIDAINICIAL;
	private int costo = 1;
	private Posicion posicion;
	
	public Soldado(Bando bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
	}

	public int getVida() {
		return this.vida;
	}

	@Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}

	@Override
	public int getCosto() {
		return this.costo;
	}

	@Override
	public void reponerVida(int curacion) throws CuranderoCuraHastaLaMaximaVidaExcepcion{
		if ((this.vida += curacion) > VIDAINICIAL){
			this.vida = VIDAINICIAL;
		}
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		entidadAtacada.recibirDanio(this.danioACuerpo);
	}

	@Override
	public void mover(Direccion direccion) throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Tablero tablero = Tablero.getInstanciaTablero();
		if(tablero.mover(this, this.posicion, direccion.avanzar(this.posicion)) == 0){
			this.posicion = direccion.avanzar(this.posicion);
		}
	}

    @Override
    public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion {
        throw new CasilleroOcupadoExcepcion("NO se pude realizar dicha acción");
    }

    public Posicion getPosicion() {
		return this.posicion;
	}

	@Override
	public void espada() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion{		
		ArrayList<Entidad> listaAux = EntidadesACiertaDistancia.entidadesCerca(ENEMIGOS,this,DISTANCIADEATAQUE);
		for(Entidad entidadAux : listaAux) {
			atacarEnemigo(entidadAux);
		}
	}
}
