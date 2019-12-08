package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.Jugador.Jugador;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class Juego {
	
	private Tablero tablero;
	
	private Jugador jugadorAliado;
	
	private Jugador jugadorEnemigo;

	public Juego() {
		this.setTablero(Tablero.getInstanciaTablero());
		this.setJugadorAliado(null);
		this.setJugadorEnemigo(null);
	}
	

	public Jugador getJugadorEnemigo() {
		return jugadorEnemigo;
	}

	public void setJugadorEnemigo(Jugador jugadorEnemigo) {
		this.jugadorEnemigo = jugadorEnemigo;
	}

	public Jugador getJugadorAliado() {
		return jugadorAliado;
	}

	public void setJugadorAliado(Jugador jugadorAliado) {
		this.jugadorAliado = jugadorAliado;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
}
