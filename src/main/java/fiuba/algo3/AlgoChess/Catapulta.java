package fiuba.algo3.AlgoChess;

import java.util.ArrayList;

public class Catapulta implements EntidadFija {

	private Casillero posicion;
	private Distancia calculadorDistancia = new Distancia();
	private String bando = new String();
	private int vida = 50;
	private int costo = 5;
	private int danioADistancia = 20;

	public Catapulta(String bando, Casillero casillero) {
		this.bando = bando;
		this.posicion = casillero;
	}

	@Override
	public void atacarEnemigo() {

	}

	@Override
	public void restarVida(int danio) {
		this.vida -= danio;
	}

	public int getCosto() {
		// TODO Auto-generated method stub
		return this.costo;
	}

	public int getVida() {
		return this.vida;
	}
}
