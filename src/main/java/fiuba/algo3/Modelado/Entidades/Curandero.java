package fiuba.algo3.Modelado.Entidades;

import fiuba.algo3.Modelado.Bandos.Bando;
import fiuba.algo3.Modelado.Direccion.Direccion;
import fiuba.algo3.Modelado.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.Modelado.Excepciones.CuranderoNoPuedeAtacarExepcion;
import fiuba.algo3.Modelado.Tablero.Posicion;
import fiuba.algo3.Modelado.Tablero.Tablero;

public class Curandero implements Entidad {

	private Bando bando;
	
	private final int VIDAINICIAL = 75;

	private final int CURACION = 15;
	
	private int vida = VIDAINICIAL;

	private final int COSTO = 2;
	
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
		curandero.reponerVida(curandero.getCuracion());
	}
	private int getCuracion() {
		return this.CURACION;
	}

	public void curarEntidad(Entidad entidadACurar) {
		entidadACurar.reponerVida(getCuracion());		
	}

	public void reponerVida(int curacion) {
		if ((this.vida += curacion) > VIDAINICIAL){
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
		return this.COSTO;
	}

	@Override
	public void recibirPosicionYBando(Posicion posicion, Bando bandoJugador) {
		this.bando = bandoJugador;
		this.posicion = posicion;
	}
}
