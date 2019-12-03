package fiuba.algo3.AlgoChess;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.FabricaEntidades;
import fiuba.algo3.AlgoChess.Entidades.ObjetoNull;
import fiuba.algo3.AlgoChess.Excepciones.CantidadDePuntosInsuficientesExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class Jugador {

	private int puntosActuales = 20;
	
	private String nombre;
	
	private FabricaEntidades fabrica = new FabricaEntidades();
	
	private List<Entidad> entidades;
	
	private Bando bandoJugador;
	
	private Aliado aliado = new Aliado();
	
	public Jugador(String nombre, Bando bando) {
		this.nombre = nombre;
		this.bandoJugador = bando;
		this.entidades  = new ArrayList<Entidad>();
	}

	public void agregarEntidad(String tipoEntidad, int fila, int columna) {
		Entidad entidad = fabrica.crearEntidad(tipoEntidad, fila, columna, this.bandoJugador);
		
		try {
			descontarPuntos(entidad.getCosto());
			Tablero tablero = Tablero.getInstanciaTablero();
			tablero.agregarEntidadEnCasillero(entidad, fila, columna);
			if(this.bandoJugador == aliado) {
				tablero.agregarEntidadSectorAliado(fila, columna, entidad);
			}else {
				tablero.agregarEntidadSectorEnemigo(fila, columna, entidad);
			}
			this.entidades.add(entidad);
			entidad.recibirPosicionYBando(fila,columna,this.bandoJugador);
		} catch (CasilleroOcupadoExcepcion e) {
			throw new CasilleroOcupadoExcepcion("El casillero esta ocupado");
		} catch (ColocarUnidadEnSectorEnemigoExcepcion e) {
			throw new ColocarUnidadEnSectorEnemigoExcepcion("El sector es el del enemigo");
		}catch(CantidadDePuntosInsuficientesExcepcion e){
			throw new CantidadDePuntosInsuficientesExcepcion();
		}
	}

	public void descontarPuntos(int numero) {
		if (puntosActuales <= 0) {
			throw new CantidadDePuntosInsuficientesExcepcion();
		}
		puntosActuales -= numero;
	}

	public int cantidadPuntos(){
		return puntosActuales;
	}
	
	public int getPuntos() {
		return this.puntosActuales;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Entidad getEntidad(Posicion posicion) {
		Entidad entidadAux = new ObjetoNull();
		for(Entidad entidad : this.entidades) {
			if(entidad.getPosicion().mismaPosicion(posicion, entidad.getPosicion())) {
				entidadAux =  entidad;
			}
		}
		return entidadAux;
	}
	
	public List<Entidad> getListDeEntidades(){
		return this.entidades;
	}
	
	public int getCantidadDeEntidades() {
		return this.getListDeEntidades().size();
	}
	
	public void eliminarEntidad(Entidad entidad) {
		this.entidades.remove(entidad);
	}

	public void comprarEntidad(Entidad catapulta) {		
	}

}