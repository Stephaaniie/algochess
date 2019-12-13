package fiuba.algo3.Modelado.Tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiuba.algo3.Modelado.Bandos.Bando;
import fiuba.algo3.Modelado.Buscador.RadarDeEntidades;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.ObjetoNull;
import fiuba.algo3.Modelado.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.Modelado.Excepciones.ColocarEntidadEnSectorEnemigoExcepcion;
import fiuba.algo3.Modelado.Jugador.Jugador;

public class Tablero {
	
	private final int TAMANIO_TABLERO = 20;
	
	private static Tablero instanciaTablero = null;
	
	private Jugador jugador;
	
	private RadarDeEntidades radarDeAliados;
	
	private RadarDeEntidades radarDeEnemigos;
			
	private List <Entidad> entidadesDeCasilleros;

	private List <Casillero> casillerosAliado;
	
	private List <Casillero> casillerosEnemigo;
		
	private Map<Posicion,Casillero> casilleros;
	
	public Tablero() {
		
		this.radarDeAliados        = new RadarDeEntidades(0,(TAMANIO_TABLERO -1));
		this.radarDeEnemigos       = new RadarDeEntidades(TAMANIO_TABLERO/2, TAMANIO_TABLERO-1);
		this.casilleros            = new HashMap<Posicion,Casillero>();
		this.entidadesDeCasilleros = new ArrayList<Entidad>();
		this.casillerosAliado      = new ArrayList<Casillero>();
		this.casillerosEnemigo     = new ArrayList<Casillero>();
	}

	public static Tablero getInstanciaTablero(){
		if(instanciaTablero == null) {
			instanciaTablero = new Tablero();
		}
		return instanciaTablero;
	}

	public void mover(Entidad entidad, Posicion posicionAnterior, Posicion posicionNueva){	
		try{
			Casillero casillero = new Casillero(posicionNueva);
			agregarEntidad(entidad, posicionNueva,casillero);
		}catch(CasilleroOcupadoExcepcion e){
		} catch (ColocarEntidadEnSectorEnemigoExcepcion n) {
		}
		quitarEntidadDeCasillero(posicionAnterior,entidad);
	}
	
	private void agregarEntidad(Entidad entidad, Posicion posicion,Casillero casillero) {
		this.radarDeAliados.posicionarEntidad(posicion, casillero, entidad, this, entidad.getBando());
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
	

	public Entidad getEntidadEnPosicion(Posicion posicion) {
		Entidad entidadEncontrada = new ObjetoNull();
		for(Entidad entidad : entidadesDeCasilleros) {
			if(entidad.getPosicion().mismaPosicion(posicion, entidad.getPosicion())) {
				entidadEncontrada = entidad;
			}
		}
		return entidadEncontrada;
	}

	public Jugador agergarJugadores(String nombre, Bando bando, String nombre1, Bando bando1) {
		return this.jugador = new Jugador(nombre, bando, nombre1, bando1);
	}
	
	public Jugador getJugador() {
		return this.jugador;
	}
	
	public int getTamanioTablero() {
		return this.TAMANIO_TABLERO;
	}
	
	public int getCantidadCasilleros() {
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