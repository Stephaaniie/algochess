package fiuba.algo3.AlgoChess.Entidades;

import fiuba.algo3.AlgoChess.Armas.Armas;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.CatapultaNoSeMueveExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.CuranderoNoCuraAunaEntidadFijaExcepcion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class Catapulta implements Entidad{
	private final int VIDA_INICIAL = 50;
	private final int COSTO = 5;
	
	private final int DANIO_DISTANCIA = 20;
	
	private final int DISTANCIA_MAX_ATAQUE = 20;
	private final int DISTANCIA_MIN_ATAQUE = 6;
	
	private Bando bando;
	
	private int vida = VIDA_INICIAL;
	
	private int costo = COSTO;
		
	private Posicion posicion;
	
	private Armas objetosALanzar;
	
	public Tablero tablero = Tablero.getInstanciaTablero();	
	
	
	@Override
	public void atacarEnemigo() {
		objetosALanzar = new Armas(DISTANCIA_MIN_ATAQUE,DISTANCIA_MAX_ATAQUE,this.getBando());
		objetosALanzar.objetosASerLanzados(DANIO_DISTANCIA);
	}

    @Override
    public void mover(Direccion direccion) {
        throw new CatapultaNoSeMueveExcepcion();
    }

    @Override
    public Entidad agregar(Entidad otraEntidad) {
        throw new CasilleroOcupadoExcepcion();
    }

    @Override
    public Posicion getPosicion() {
        return this.posicion;
    }

    @Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}

	@Override
	public int getCosto() {
		return this.costo;
	}

	public int getVida() {
		return this.vida;
	}

	@Override
	public void reponerVida(int curacion) {
        new CuranderoNoCuraAunaEntidadFijaExcepcion();
	}

	@Override
	public Bando getBando() {
		return this.bando;
	}

	@Override
	public void recibirPosicionYBando(Posicion posicion, Bando bandoJugador) {
		this.bando = bandoJugador;
		this.posicion = posicion;
	}
	
}