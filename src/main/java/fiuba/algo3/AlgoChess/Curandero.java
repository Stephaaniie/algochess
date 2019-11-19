package fiuba.algo3.AlgoChess;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.teclado.Direccion;

public class Curandero implements Entidad {

	private String bando = new String();

	private final String ARRIBA    = "arriba";
	
	private final String ABAJO     = "abajo";
	
	private final String DERECHO   = "derecho";
	
	private final String IZQUIERDA = "izquierda";
	
	private final int VIDAINICIAL = 75;

	private final int CURACION = 15;
	
	private int vida = VIDAINICIAL;

	private int costo = 2;

	public int curacion = 15;
	
	public Posicion posicion;
	
	public Direccion direccion = new Direccion();

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

	@Override
	public void reponerVida(int curacion) {
		
			if ((this.vida += CURACION) > VIDAINICIAL){

				this.vida = VIDAINICIAL;

			}
	}
	/*
	public void mover(String direccion) {
		
		swich(direccion){
			
			case ARRIBA :
			{
				this.posicion = this.direccion.arriba()
			}
			
			
		}*/
		
	
	}
	
	public Posicion getPosicion() {
		
		return this.posicion;
	}
}
