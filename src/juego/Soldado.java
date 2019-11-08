package juego;

import java.util.ArrayList;

public class Soldado implements EntidadMovil{
	
	private String bando = new String();
	private Casillero posicion;
	private int danioACuerpo = 10;
	private int danioADistancia = 0;
	private int vida = 100;
	private int costo = 1;
	private Distancia calculadorDistancia = new Distancia();
	

	public Soldado(String bando, Casillero casillero) {
		this.bando = bando;
		this.posicion = casillero;
	}
	
	public int getVida() {
		return this.vida;
	}
	
	@Override
	public void atacarEnemigo() {
		//ArrayList<Object> enemigos = new ArrayList<Object>();
		//enemigos = calculadorDistancia.distanciaCercana(posicion);
		
		
		//enemigos.forEach(enemigo -> enemigo.restarVida(this.danioACuerpo));
		
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
	public void reponerVida() {
		this.vida += 15;
	}

	@Override
	public void restarVida(int danio) {
		this.vida -= danio;
	}

	public int getCosto() {
		// TODO Auto-generated method stub
		return this.costo;
	}

}
