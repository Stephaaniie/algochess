package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Bando;
import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.entidades.FabricaEntidades;
import fiuba.algo3.AlgoChess.excepciones.*;
import fiuba.algo3.AlgoChess.tablero.Casillero;
import fiuba.algo3.AlgoChess.tablero.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

	private int puntosActuales = 20;
	private int cantidadEntidades = 0;
	private String nombre;
	private FabricaEntidades fabrica = new FabricaEntidades();
	private List entidades = new ArrayList<Entidad>();
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
			tablero.agregarContenidoEnCasillero(entidad, fila, columna);
			entidades.add(entidad);
		} catch (CasilleroOcupadoExcepcion e) {
			throw new CasilleroOcupadoExcepcion("El casillero esta ocupado");
		} catch (ColocarUnidadEnSectorEnemigoExcepcion e) {
			throw new ColocarUnidadEnSectorEnemigoExcepcion("El sector es el del enemigo");
		}catch(CantidadDePuntosInsuficientesExcepcion e){
			throw new CantidadDePuntosInsuficientesExcepcion();
		}
	}

	public void descontarPuntos(int numero) throws CantidadDePuntosInsuficientesExcepcion {
		if (puntosActuales <= 0) {
			throw new CantidadDePuntosInsuficientesExcepcion();
		}
		puntosActuales -= numero;
	}

	public int cantidadPuntos(){
		return puntosActuales;
	}
}