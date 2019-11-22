package fiuba.algo3.AlgoChess.entidades;
import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Curandero implements Entidad {

	private Bando bando;
	
	private final int VIDAINICIAL = 75;

	private final int CURACION = 15;
	
	private int vida = VIDAINICIAL;

	private int costo = 2;

	public int curacion = 15;
	
	private Posicion posicion;


	public Curandero(Bando bando, int fila, int columna) {

		this.bando = bando;
		this.posicion = new Posicion(fila, columna);

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

	public void mover(Direccion direccion) throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.quitarEntidadDePosicion(this.posicion);
		this.posicion = direccion.avanzar(this.posicion);
		tablero.agregarContenidoEnCasillero(this, this.posicion.getFila(), this.posicion.getColumna());
	}

	@Override
	public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion {
		throw new CasilleroOcupadoExcepcion("No se puede realizar dicha acción");
	}

	public Posicion getPosicion() {
		
		return this.posicion;
	}
}
