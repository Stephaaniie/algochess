package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class Jinete implements EntidadMovil {
	private final int VIDAINICIAL = 100;
	private String bando = new String();
	private int danioACuerpo = 5;
	private int danioADistancia = 15;
	private int vida = VIDAINICIAL;
	private int costo = 3;
	private Posicion posicion;

	public Jinete(String bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
	}
	@Override
	public boolean aliadosCerca() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean enemigosCerca() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void recibirDanio(int danio) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		this.vida -= danio;
		
	}
	@Override
	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reponerVida(int curacion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		if ((this.vida += curacion) > VIDAINICIAL) {
			this.vida = VIDAINICIAL;
		}
	}

	public int getVida() {
		
		return this.vida;
	}

	public int getCosto() {
		
		return this.costo;
	}

}
