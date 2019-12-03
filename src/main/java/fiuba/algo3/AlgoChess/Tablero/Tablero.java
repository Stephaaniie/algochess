package fiuba.algo3.AlgoChess.Tablero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.Buscador.RadarDeEntidades;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.ObjetoNull;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.ColocarUnidadEnSectorEnemigoExcepcion;

public class Tablero {
	
	private final static int TAMANIO_TABLERO = 20;
	
	private static Tablero instanciaTablero = null;
	
	private RadarDeEntidades esSectorAliado;
	
	private RadarDeEntidades esSectorEnemigo;
			
	private List <Entidad> entidadesEnTablero;

	private List <Casillero> sectorAliado;
	
	private List <Casillero> sectorEnemigo;
		
	private Map<Posicion,Casillero> tablero;
	
	private Tablero(int tamanio) {
		this.esSectorAliado  = new RadarDeEntidades(0,(tamanio -1)/2);
		this.esSectorEnemigo = new RadarDeEntidades(tamanio/2, tamanio-1);
		this.tablero  = new HashMap<Posicion,Casillero>();
		this.entidadesEnTablero = new ArrayList<Entidad>();
		this.sectorAliado = new ArrayList<Casillero>();
		this.sectorEnemigo = new ArrayList<Casillero>();
	}

	public static Tablero getInstanciaTablero(){
		if(instanciaTablero == null) {
			instanciaTablero = new Tablero(TAMANIO_TABLERO);
		}
		return instanciaTablero;
	}

	public void mover(Entidad entidad, Posicion posicionAnterior, Posicion posicionNueva){
		
		try{
			agregarEntidadEnCasillero(entidad, posicionNueva.getFila(), posicionNueva.getColumna());
		}catch(CasilleroOcupadoExcepcion e){
			throw new CasilleroOcupadoExcepcion("El casillero esta ocupado");
		} catch (ColocarUnidadEnSectorEnemigoExcepcion n) {
			throw new ColocarUnidadEnSectorEnemigoExcepcion("El sector es el del enemigo");
		}
		quitarEntidadDeCasillero(posicionAnterior,entidad);
	}

	public Posicion crearPosicion(int fila, int columna) {
		return new Posicion(fila,columna);
	}
	
	public void agregarEntidadSectorAliado(int fila, int columna, Entidad entidad){
		if(this.esSectorAliado.estaEnElRadar(fila,columna)) {
			this.tablero.put(crearPosicion(fila,columna), agregarEntidadEnCasillero(entidad,fila,columna));
			sectorAliado.add(agregarEntidadEnCasillero(entidad,fila,columna));
		}
	}
	
	public void agregarEntidadSectorEnemigo(int fila, int columna, Entidad entidad){
		if(this.esSectorEnemigo.estaEnElRadar(fila, columna)) {
			this.tablero.put(crearPosicion(fila,columna),agregarEntidadEnCasillero(entidad,fila,columna));
			sectorEnemigo.add(agregarEntidadEnCasillero(entidad,fila,columna));
		}
	}
	
	
	public Casillero agregarEntidadEnCasillero(Entidad entidad, int fila, int columna) {
		entidadesEnTablero.add(entidad);
		Casillero casillero = new Casillero(crearPosicion(fila,columna));
		casillero.agregarEntidad(entidad);
		return casillero;
	}
	
	public void quitarEntidadDeCasillero(Posicion posicionAnterior,Entidad entidad) {
		getEntidadesEnTablero().remove(entidad);
		this.tablero.entrySet().stream().filter(x -> x.getKey() == posicionAnterior).forEach(x -> this.tablero.remove(x.getKey()));
	}
	
	public Map<Posicion,Casillero> getMap(){
		return this.tablero;
	}
	
	public List <Casillero> getSectorEnemigo(){
		return this.sectorEnemigo;
	}

	public List <Casillero> getSectorAliado(){
		return this.sectorAliado;
	}
	
	public List<Entidad> getEntidadesEnTablero(){
		return this.entidadesEnTablero;
	}

	public Entidad getEntidadEnPosicion(Posicion posicionNueva) {
		Entidad entidadEncontrada = new ObjetoNull();
		this.entidadesEnTablero.stream().filter(x -> x.getPosicion() == posicionNueva).forEach(x -> entidadEncontrada.agregar(x));
		return entidadEncontrada;
	}

	public Jugador agergarJugador() {
		
		return null;
	}
}