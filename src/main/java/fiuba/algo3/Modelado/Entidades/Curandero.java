package fiuba.algo3.AlgoChess.Entidades;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.CuranderoNoPuedeAtacarExepcion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class Curandero implements Entidad {

	private Bando bando;
	
	private final int VIDAINICIAL = 75;

	private final int CURACION = 15;
	
	private int vida = VIDAINICIAL;

	private int costo = 2;

	public int curacion = 15;
	
	private Posicion posicion;
	
	Tablero tablero = Tablero.getInstanciaTablero();
	
	public int getVida() {
		
		return this.vida;
	}
	
	public boolean puedoCurar(Entidad entidad) {
		return  (this.bando == entidad.getBando());
	}
	
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}
	public void curarEntidad(Curandero curandero) {
		reponerVida(CURACION);
	}
	public void curarEntidad(Entidad entidadACurar) {
		entidadACurar.reponerVida(CURACION);		
	}

	public void reponerVida(int curacion) {
		if ((this.vida += CURACION) > VIDAINICIAL){
			this.vida = VIDAINICIAL;
		}
	}


	public void mover(Direccion direccion) {
		tablero.mover(this, this.posicion, direccion.avanzar(this.posicion));
		this.posicion = direccion.avanzar(this.posicion);
	}

	@Override
	public Entidad agregar(Entidad otraEntidad) {
		throw new CasilleroOcupadoExcepcion();
	}

	@Override
	public Bando getBando() {
		return this.bando;
	}

	@Override
	public void atacarEnemigo() {
		throw new CuranderoNoPuedeAtacarExepcion();
	}

	@Override
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	@Override
	public int getCosto() {
		return this.costo;
	}

	@Override
	public void recibirPosicionYBando(Posicion posicion, Bando bandoJugador) {
		this.bando = bandoJugador;
		this.posicion = posicion;
	}
}
