package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class Soldado implements EntidadMovil {
	private final int VIDAINICIAL = 100;
	private String bando = new String();
	private int danioACuerpo = 10;
	private int danioADistancia = 0;
	private int vida = VIDAINICIAL;
	private int costo = 1;
	private Posicion posicion;
/*
	public Soldado(String bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
	}

	public int getVida() {
		return this.vida;
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) {
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
	public void recibirDanio(int danio) {

		this.vida -= danio;
	}
	
	public int getCosto() {
		
		return this.costo;
	}

	@Override
	public void reponerVida(int curacion){
		
		if ((this.vida += curacion) > VIDAINICIAL){

			this.vida = VIDAINICIAL;

		}
	}
/*
	@Override
	public void reponerVida(int curacion) throws CuranderoCuraHastaLaMaximaVidaExcepcion{

		if ((this.vida += curacion) > VIDAINICIAL){

			this.vida = VIDAINICIAL;

			new CuranderoCuraHastaLaMaximaVidaExcepcion("El curandero ya tiene el valor maximo de vida");

		}
	}

*/
/*
	@Override
	public void reponerVida(int curacion) throws CuranderoCuraHastaLaMaximaVidaExcepcion {
		// TODO Auto-generated method stub
		
	}*/

	public void atacarEnemigo1(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reponerVida(int curacion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		// TODO Auto-generated method stub
		
	}
		
	@Override
	public void mover(Posicion nuevaPosicion) {
		this.posicion = nuevaPosicion;
	}
	
	public int getPosicion() {
		return this.posicion;
	}
}
