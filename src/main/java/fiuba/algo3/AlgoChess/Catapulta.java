package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class Catapulta implements EntidadFija {

	private String bando = new String();
	private int vida = 50;
	private int costo = 5;
	private int danioADistancia = 20;

	public Catapulta(String bando) {
		
		this.bando = bando;
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) {

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

	
	public void atacarEnemigo1(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion{
		
		
	}

}