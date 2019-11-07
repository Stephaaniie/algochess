package fiuba.algo3.AlgoChess;


import java.util.ArrayList;

public class Jinete implements EntidadMovil {

	private String bando = new String();
	private Casillero posicion;
	private int danioACuerpo = 5;
	private int danioADistancia = 15;
	private int vida = 100;
	private int costo = 3;
	private Distancia calculadorDistancia = new Distancia();

	public Jinete(String bando, Casillero casillero) {
		this.bando = bando;
		this.posicion = casillero;
	}

	@Override
	public void atacarEnemigo() {

	}

	@Override
	public boolean aliadosCerca() {
		return false;
	}

	@Override
	public boolean enemigosCerca() {
		return false;
	}

	@Override
	public void restarVida(int danio) {
		this.vida -= danio;
	}

	public int getVida() {
		return this.vida;
	}

	public int getCosto() {
		// TODO Auto-generated method stub
		return this.costo;
	}

	@Override
	public void reponerVida(int curacion) {
		
		this.vida += curacion;
	}

}
