package fiuba.algo3.Modelado.Entidades;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.Modelado.Armas.Arma;
import fiuba.algo3.Modelado.Bandos.Bando;
import fiuba.algo3.Modelado.Buscador.BuscadorDeEntidades;
import fiuba.algo3.Modelado.Direccion.Direccion;
import fiuba.algo3.Modelado.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.Modelado.Tablero.Posicion;
import fiuba.algo3.Modelado.Tablero.Tablero;

public class Soldado implements Entidad {

	private final int DISTANCIA_MAX_ATAQUE  = 2;
	
	private final int DISTANCIA_MIN_ATAQUE = 1;
	
	private final int DANIO_CUERPO   = 10;
		
	private final int VIDAINICIAL = 100;
	
	private final int COSTO = 1;
	
	private Bando bando;
	
	private int vida = VIDAINICIAL;
	
	private Posicion posicion;
	
	private Arma espada;
	
	public Tablero tablero = Tablero.getInstanciaTablero();
	
	private List<Soldado> soldadosParaBatallon = new ArrayList<Soldado>();
	
	private BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());
	
	
	public BuscadorDeEntidades getBuscador() {
		return this.buscador;
	}
	
	public  List<Soldado> getListaBatallon(){
		return this.soldadosParaBatallon;
	}
	

	public void formarListaDeSoldados(Soldado soldado) {
		this.soldadosParaBatallon.add(soldado);
	}
	

	public void enlistarSoldadoParaBatallon(List<Soldado> soldados) {
		soldados.stream().filter(x -> x.getPosicion().esPosicionAdyacente(getPosicion(), this.getPosicion())== true).forEach(x -> soldadosParaBatallon.add(x));			
	}
	
	@Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}

	@Override
	public int getCosto() {
		return this.COSTO;
	}

	@Override
	public void reponerVida(int curacion) {
		if ((this.vida += curacion) > VIDAINICIAL){
			this.vida = VIDAINICIAL;
		}
	}

	@Override
	public void mover(Direccion direccion) {
		this.tablero.mover(this, this.posicion, direccion.avanzar(this.posicion));
		this.posicion = direccion.avanzar(this.posicion);
	}

    @Override
    public Entidad agregar(Entidad otraEntidad) {
        throw new CasilleroOcupadoExcepcion();
    }

    public Posicion getPosicion() {
		return this.posicion;
	}

	@Override
	public Bando getBando() {
		return this.bando;
	}

	@Override
	public void atacarEnemigo() {
		espada = new Arma(DISTANCIA_MIN_ATAQUE,DISTANCIA_MAX_ATAQUE);
		espada.soldadoUtilizaEspada(this.getBuscador().buscadorDeEntidades(), DANIO_CUERPO);
	}

	@Override
	public void recibirPosicionYBando(Posicion posicion, Bando bandoJugador) {
		this.bando = bandoJugador;
		this.posicion = posicion;
	}

	@Override
	public int getVida() {
		return this.vida;
	}
}
