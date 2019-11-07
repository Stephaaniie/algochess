package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.*;

public class Curandero implements EntidadCuradora {

	private Casillero posicion;

	private String bando = new String();

	final int VIDAINICIAL = 75;

	private int vida = VIDAINICIAL;

	private int costo = 2;

	public int curacion = 15;

	public Curandero(String bando, Casillero casillero) {

		this.bando = bando;
		this.posicion = casillero;

	}

	public int getVida() {
		return this.vida;
	}

	public int getCosto() {
		return this.costo;
	}

	@Override
	public void curarEntidad(EntidadMovil entidadACurar) {

		entidadACurar.reponerVida(curacion);
	}

	public void recibirDanio(int tipoDeDanio) {

		this.vida -= tipoDeDanio;
	}

	public void reponerVida(int curacion) throws CuranderoCuraHastaLaMaximaVidaExcepcion{

		if ((this.vida += curacion) > VIDAINICIAL){

			this.vida = VIDAINICIAL;

			new CuranderoCuraHastaLaMaximaVidaExcepcion("El curandero ya tiene el valor maximo de vida");

		}
	}

}
