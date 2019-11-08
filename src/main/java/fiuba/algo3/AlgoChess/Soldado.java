package fiuba.algo3.AlgoChess;

import java.util.ArrayList;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;

public class Soldado implements EntidadMovil {
	private final int VIDAINICIAL = 100;
	private String bando = new String();
	private Casillero posicion;
	private int danioACuerpo = 10;
	private int danioADistancia = 0;
	private int vida = VIDAINICIAL;
	private int costo = 1;

	public Soldado(String bando, Casillero casillero) {
		this.bando = bando;
		this.posicion = casillero;
	}

	public int getVida() {
		return this.vida;
	}

	@Override
	public void atacarEnemigo() {
		// ArrayList<Object> enemigos = new ArrayList<Object>();
		// enemigos = calculadorDistancia.distanciaCercana(posicion);

		// enemigos.forEach(enemigo -> enemigo.restarVida(this.danioACuerpo));

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

	public int getCosto() {
		
		return this.costo;
	}

	@Override
	public void reponerVida(int curacion) throws CuranderoCuraHastaLaMaximaVidaExcepcion{

		if ((this.vida += curacion) > VIDAINICIAL){

			this.vida = VIDAINICIAL;

			new CuranderoCuraHastaLaMaximaVidaExcepcion("El curandero ya tiene el valor maximo de vida");

		}
	}
}
