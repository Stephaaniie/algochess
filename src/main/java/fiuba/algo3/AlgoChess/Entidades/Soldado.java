package fiuba.algo3.AlgoChess.Entidades;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.AlgoChess.Armas.ArmaParaCuerpoACuerpo;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Buscador.BuscadorDeEntidades;
import fiuba.algo3.AlgoChess.Buscador.RadarDeEntidades;
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class Soldado implements Entidad, ArmaParaCuerpoACuerpo {

	private final int DISTANCIA_MAX_ATAQUE  = 2;
	
	private final int DISTANCIA_MIN_ATAQUE = 1;
	
	private final int DANIO_CUERPO   = 10;
	
	private final int MAX_CANT_BATALLON = 3;
	
	private final int VIDAINICIAL = 100;
	
	private Bando bando;
	
	private int vida = VIDAINICIAL;
	
	private int costo = 1;
	
	private Posicion posicion;
	
	public Tablero tablero = Tablero.getInstanciaTablero();
	
	private BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());

	private List<Soldado> soldadosParaBatallon = new ArrayList<Soldado>();
			
	public Soldado(Bando bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
	}

	public int getVida() {
		return this.vida;
	}
	
	public boolean estaEnRango(Entidad entidad) {
		RadarDeEntidades distancia = new RadarDeEntidades(DISTANCIA_MIN_ATAQUE,DISTANCIA_MAX_ATAQUE);
		return (distancia.estaEnElRadar(this.getPosicion().calcularDistanciaCon(entidad.getPosicion().getFila(),entidad.getPosicion().getColumna())));
		
	}
	
	public List<Entidad> filtrarAtacables(List<Entidad> enemigos){
		List<Entidad> filtrados = new ArrayList<Entidad>();
		enemigos.stream().filter(x -> estaEnRango(x) == true).forEach(x -> filtrados.add(x));
		return filtrados;
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
		return this.costo;
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
        throw new CasilleroOcupadoExcepcion("NO se pude realizar dicha acción");
    }

    public Posicion getPosicion() {
		return this.posicion;
	}

	@Override
	public void espada(List<Entidad> entidad, int danio) {
		entidad.stream().forEach(x -> x.recibirDanio(danio));
	}

	@Override
	public Bando getBando() {
		return this.bando;
	}

	@Override
	public void atacarEnemigo() {
		List<Entidad> enemigos = buscador.buscarEnemigos(this.bando);
		espada(filtrarAtacables(enemigos),DANIO_CUERPO);
	}

}
