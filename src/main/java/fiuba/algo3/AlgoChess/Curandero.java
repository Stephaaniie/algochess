package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class Curandero implements Entidad {

	private String bando = new String();

	private final int VIDAINICIAL = 75;

	private final int CURACION = 15;
	
	private int vida = VIDAINICIAL;

	private int costo = 2;

<<<<<<< HEAD
	public int curacion = 15;
	
	private Posicion posicion;
/*
	public Curandero(String bando, int fila, int columna) {

		this.bando = bando;
		this.posicion = new Posicion(fila, columna);

	}*/

=======
	public Curandero(String bando) {
		
		this.bando = bando;
	}
	
	public String getBando() {
		
		return this.bando;
	}
	
>>>>>>> 0bbbcc4f1b9d2b1a13a939e499fad4257733596b
	public int getVida() {
		
		return this.vida;
	}

	
	public int getCosto() {
		
		return this.costo;
	}
	
	public void recibirDanio(int danio) {

		this.vida -= danio;
	}
	
	public void curarEntidad(EntidadMovil entidadACurar) 
			throws CuranderoCuraHastaLaMaximaVidaExcepcion {
		
		try {
			entidadACurar.reponerVida(CURACION);
		} catch (ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
		
			//e.printStackTrace();
		}
		
		if(entidadACurar == this) {
			
			autoReponerVida();
		}
		
	}
	
	public void autoReponerVida()
			throws CuranderoCuraHastaLaMaximaVidaExcepcion{

		if ((this.vida += CURACION) > VIDAINICIAL){

			this.vida = VIDAINICIAL;

		}
	}

}
