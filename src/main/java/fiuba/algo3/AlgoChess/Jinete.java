package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class Jinete implements EntidadMovil {
	private final int VIDAINICIAL = 100;
	private String bando = new String();
	private int danioACuerpo = 5;
	private int danioADistancia = 15;
	private int vida = VIDAINICIAL;
	private int costo = 3;

	public Jinete(String bando) {
		
		this.bando = bando;
		
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
	public void recibirDanio(int danio) {
		
		this.vida -= danio;
	}

	public int getVida() {
		
		return this.vida;
	}

	public int getCosto() {
		
		return this.costo;
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) {
		
	}

	@Override
	public void reponerVida(int curacion){
		
		if ((this.vida += curacion) > VIDAINICIAL){

			this.vida = VIDAINICIAL;
		}
	}

	public void atacarEnemigo1(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion{
		// TODO Auto-generated method stub
		
	}

	/*public void reponerVida(int curacion) throws CuranderoCuraHastaLaMaximaVidaExcepcion{

		if ((this.vida += curacion) > VIDAINICIAL){

			this.vida = VIDAINICIAL;

			new CuranderoCuraHastaLaMaximaVidaExcepcion("El curandero ya tiene el valor maximo de vida");

		}
	}
}*/

}
