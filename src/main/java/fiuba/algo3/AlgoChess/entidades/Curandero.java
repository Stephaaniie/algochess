package fiuba.algo3.AlgoChess.entidades;
import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class Curandero implements Entidad {

	private String bando = new String();

	private final String ARRIBA    = "arriba";
	
	private final String ABAJO     = "abajo";
	
	private final String DERECHA   = "derecha";
	
	private final String IZQUIERDA = "izquierda";
	
	private final int VIDAINICIAL = 75;

	private final int CURACION = 15;
	
	private int vida = VIDAINICIAL;

	private int costo = 2;

	public int curacion = 15;
	
	public Posicion posicion;


	public Curandero(String bando, int fila, int columna) {

		this.bando = bando;
		this.posicion = new Posicion(fila, columna);

	}


	public String getBando() {
		
		return this.bando;
	}
	
	
	public int getVida() {
		
		return this.vida;
	}

	
	public int getCosto() {
		
		return this.costo;
	}
	
	public void recibirDanio(int danio) {

		this.vida -= danio;
	}
	
	public void curarEntidad(Entidad entidadACurar) 
			throws CuranderoCuraHastaLaMaximaVidaExcepcion, 
			ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion{
		
		entidadACurar.reponerVida(CURACION);
		
		if(entidadACurar == this) {
			
			reponerVida(CURACION);
		}
		
	}

	public void reponerVida(int curacion) {
		
			if ((this.vida += CURACION) > VIDAINICIAL){

				this.vida = VIDAINICIAL;

			}
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {

	}

	public void mover(Direccion direccion) {
		this.posicion = direccion.avanzar(this.posicion);
	}

	@Override
	public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion {
		throw new CasilleroOcupadoExcepcion();
	}

	public Posicion getPosicion() {
		
		return this.posicion;
	}
}
