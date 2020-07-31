package fiuba.algo3.Modelado.Entidades;

import fiuba.algo3.Modelado.Armas.Arma;
import fiuba.algo3.Modelado.Bandos.Bando;
import fiuba.algo3.Modelado.Buscador.BuscadorDeEntidades;
import fiuba.algo3.Modelado.Direccion.Direccion;
import fiuba.algo3.Modelado.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.Modelado.Tablero.Posicion;
import fiuba.algo3.Modelado.Tablero.Tablero;

public class Jinete implements Entidad {
	
	private final int VIDAINICIAL = 100;
	private final int COSTO = 3;
	
	private final int DIS_MAX_CON_ALIADO = 5;
	private final int DIS_MAX_SIN_ALIADO = 2;
	
	private final int DIS_MIN_CON_ALIADO = 3;
	private final int DIS_MIN_SIN_ALIADO = 1;
	
	private final int DANIO_CUERPO     = 5;
	private final int DANIO_DISTANCIA = 15;
	
	private int vida = VIDAINICIAL;
	
	private Bando bando;
	
	private Posicion posicion;
	
	private Arma arcoYFlecha;
		
	Tablero tablero = Tablero.getInstanciaTablero();

	private BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());
	
	
	public BuscadorDeEntidades getBuscador() {
		return this.buscador;
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public Arma getArma() {
		return arcoYFlecha = new Arma(DIS_MIN_SIN_ALIADO,DIS_MAX_SIN_ALIADO,DIS_MIN_CON_ALIADO,DIS_MAX_CON_ALIADO);
	}
	
	@Override
	public void atacarEnemigo() {
		this.getArma().utilizarArma(this.getBuscador().buscadorDeEntidades() ,this , DANIO_DISTANCIA ,DANIO_CUERPO);
	}
	
	@Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}
	
	@Override
	public void reponerVida(int curacion) {
		if ((this.vida += curacion) > VIDAINICIAL) {
			this.vida = VIDAINICIAL;
		}
	}

	@Override
	public void mover(Direccion direccion) {
		tablero.mover(this, this.posicion, direccion.avanzar(this.posicion));
		this.posicion = direccion.avanzar(posicion);
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
	public int getVida() {
		return this.vida;
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
