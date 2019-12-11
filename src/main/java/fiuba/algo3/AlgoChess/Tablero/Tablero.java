package fiuba.algo3.AlgoChess.Tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Buscador.RadarDeEntidades;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.ObjetoNull;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.ColocarEntidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.Jugador.Jugador;

public class Tablero {
	
	private final static int TAMANIO_TABLERO = 20;
	
	private static Tablero instanciaTablero = null;
	
	private RadarDeEntidades radarDeAliados;
	
	private RadarDeEntidades radarDeEnemigos;
			
	private List <Entidad> entidadesDeCasilleros;

	private List <Casillero> casillerosAliado;
	
	private List <Casillero> casillerosEnemigo;
		
	private Map<Posicion,Casillero> casilleros;
	
	public Tablero(int tamanio) {
		
		this.radarDeAliados        = new RadarDeEntidades(0,(tamanio -1)/2);
		this.radarDeEnemigos       = new RadarDeEntidades(tamanio/2, tamanio-1);
		this.casilleros            = new HashMap<Posicion,Casillero>();
		this.entidadesDeCasilleros = new ArrayList<Entidad>();
		this.casillerosAliado      = new ArrayList<Casillero>();
		this.casillerosEnemigo     = new ArrayList<Casillero>();
	}

	public static Tablero getInstanciaTablero(){
		if(instanciaTablero == null) {
			instanciaTablero = new Tablero(TAMANIO_TABLERO);
		}
		return instanciaTablero;
	}

	public void mover(Entidad entidad, Posicion posicionAnterior, Posicion posicionNueva){	
		try{
			Casillero casillero = new Casillero(posicionNueva);
			agregarEntidad(entidad, posicionNueva,casillero);
		}catch(CasilleroOcupadoExcepcion e){
			e.printStackTrace();
		} catch (ColocarEntidadEnSectorEnemigoExcepcion n) {
			n.printStackTrace();
		}
		quitarEntidadDeCasillero(posicionAnterior,entidad);
	}
	
	private void agregarEntidad(Entidad entidad, Posicion posicion,Casillero casillero) {
		this.radarDeAliados.posicionarEntidad(posicion, casillero, entidad, this, entidad.getBando());
		this.radarDeEnemigos.posicionarEntidad(posicion, casillero, entidad, this, entidad.getBando());
	}
	
	public void agregarEntidadSectorEnemigo(Posicion posicion, Entidad entidad){
		if(this.radarDeEnemigos.estaEnElRadar(posicion)) {
			this.casilleros.put(posicion, agregarEntidadEnCasillero(entidad, posicion));
			casillerosEnemigo.add(agregarEntidadEnCasillero(entidad, posicion));
		}
	}
	
	public Casillero agregarEntidadEnCasillero(Entidad entidad,Posicion posicion) {
		entidadesDeCasilleros.add(entidad);
		Casillero casillero = new Casillero(posicion);
		agregarEntidad(entidad, posicion, casillero);
		return casillero;
	}

	public void agregarCasillero(Casillero casillero, Posicion posicionNueva) {
		this.casilleros.put(posicionNueva, casillero);
	}
	
	public void quitarEntidadDeCasillero(Posicion posicionAnterior,Entidad entidad) {
		getEntidadesEnTablero().remove(entidad);
		this.casilleros.entrySet().stream().filter(x -> x.getKey() == posicionAnterior).forEach(x -> this.casilleros.remove(x.getKey()));
	}
	

	public Entidad getEntidadEnPosicion(Posicion posicionNueva) {
		Entidad entidadEncontrada = new ObjetoNull();
		this.entidadesDeCasilleros.stream().filter(x -> x.getPosicion() == posicionNueva).forEach(x -> entidadEncontrada.agregar(x));
		return entidadEncontrada;
	}

	public Jugador agergarJugador(String nombre, Bando bando, String nombre1, Bando bando1) {
		return new Jugador(nombre, bando, nombre1, bando1);
	}
	
	public int tamanioTablero() {
		return Tablero.TAMANIO_TABLERO;
	}
	
	public int cantidadCasilleros() {
		return this.casillerosAliado.size() + this.casillerosEnemigo.size();
	}
	
	public Map<Posicion,Casillero> getMap(){
		return this.casilleros;
	}
	
	public List <Casillero> getSectorEnemigo(){
		return this.casillerosEnemigo;
	}

	public List <Casillero> getSectorAliado(){
		return this.casillerosAliado;
	}
	
	public List<Entidad> getEntidadesEnTablero(){
		return this.entidadesDeCasilleros;
	}
}