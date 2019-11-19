package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class Catapulta implements EntidadFija {

	private String bando = new String();
	private int vida = 50;
	private int costo = 5;
	private int danioADistancia = 20;
	private Posicion posicion;

	public Catapulta(String bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
	    entidadAtacada.recibirDanio(this.danioADistancia);
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