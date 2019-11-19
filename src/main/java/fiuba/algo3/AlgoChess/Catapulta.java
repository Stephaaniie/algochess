package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class Catapulta implements EntidadFija {

	private String bando = new String();
	private int vida = 50;
	private int costo = 5;
	private int danioADistancia = 20;
<<<<<<< HEAD
	private Posicion posicion;
/*
	public Catapulta(String bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
=======

	public Catapulta(String bando) {
		
		this.bando = bando;
>>>>>>> 0bbbcc4f1b9d2b1a13a939e499fad4257733596b
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