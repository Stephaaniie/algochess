package fiuba.algo3.AlgoChess;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.AlgoChess.entidades.Bando;
import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.entidades.FabricaEntidades;
import fiuba.algo3.AlgoChess.excepciones.CantidadDePuntosInsuficientesExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.EntidadInvalidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Jugador {

	private int puntosActuales = 20;
	private int cantidadEntidades = 0;
	private String nombre;
	private FabricaEntidades fabrica = new FabricaEntidades();
	private List<Entidad> entidades = new ArrayList<Entidad>();
	private Bando bandoJugador;

	public Jugador(String nombre, Bando bando) {
		this.nombre = nombre;
		this.bandoJugador = bando;
	}

	public void agregarEntidad(String tipoEntidad, int fila, int columna) throws EntidadInvalidaExcepcion, ColocarUnidadEnSectorEnemigoExcepcion, CasilleroOcupadoExcepcion, CantidadDePuntosInsuficientesExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Entidad entidad = fabrica.crearEntidad(tipoEntidad, fila, columna, bandoJugador);
		try {
			descontarPuntos(entidad.getCosto());
			Tablero tablero = Tablero.getInstanciaTablero();
			tablero.agregarEntidadEnCasillero(entidad, fila, columna);
			entidades.add(entidad);
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
	
	public int getCantidadDeEntidades() {
		return this.cantidadEntidades;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	
}