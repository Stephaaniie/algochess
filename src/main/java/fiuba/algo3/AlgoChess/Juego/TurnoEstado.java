package fiuba.algo3.AlgoChess.Juego;

import java.util.List;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.Entidades.Entidad;

public abstract class TurnoEstado {
	
	public List<Entidad> entidades;
	
	public ListCircular<Jugador> jugadores;
	
	public int indiceJugador1;
	
	public int indiceJugador2;
	
	TurnoEstado referenciAlTurno;
	
	public TurnoEstado(List<Entidad> entidades, ListCircular<Jugador> jugadores,TurnoEstado referenciAlTurno,int indiceJugador1) {
		this.entidades = entidades;
		this.jugadores = jugadores;
		this.indiceJugador1 = indiceJugador1;
		this.referenciAlTurno = referenciAlTurno;
	}
	
	
	public abstract TurnoEstado turnoSiguiente();
	
	public TurnoEstado acualizarRonda() {
		if (this.entidades.size() == 0){
			return new TurnoFinalizado(this.entidades, this.jugadores,this.referenciAlTurno,this.indiceJugador1);
		}else{
			return turnoSiguiente();
		}
	}

	public Jugador turnoDe() {
		Jugador jugador = this.jugadores.getElementos(indiceJugador1);
		this.indiceJugador1 = this.indiceJugador1 + 1;
		return jugador;
	}

	 
}
