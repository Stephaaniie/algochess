package fiuba.algo3.AlgoChess.juego;

import java.util.List;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.excepciones.NoPuedeRealizarAccionesTerminoElJuegoExcepcion;

public class TurnoFinalizado extends TurnoEstado{
	
public List<Entidad> entidades;
	
	public ListCircular<Jugador> jugadores;
	
	public int indiceJugador1;
		
	TurnoFinalizado referenciAlTurno;
	
	public TurnoFinalizado(List<Entidad> entidades, ListCircular<Jugador> jugadores,TurnoEstado referenciAlTurno,int jugadorGanador) {
		super(entidades,jugadores,referenciAlTurno,jugadorGanador);
	}

	@Override
	public TurnoEstado turnoSiguiente() {
		throw new NoPuedeRealizarAccionesTerminoElJuegoExcepcion("Temino el juego");
	}
	
}
