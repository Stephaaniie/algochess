package fiuba.algo3.AlgoChess.Juego;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Bandos.Enemigo;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class Juego {
	
	private Tablero tablero;
	
	private Jugador jugadorAliado;
	
	private Jugador jugadorEnemigo;
	
	private Bando bando1;
	
	private Bando bando2;
	
	public Juego() {
		this.setTablero(Tablero.getInstanciaTablero());
		this.setJugadorAliado(null);
		this.setJugadorEnemigo(null);
		bando1 = new Aliado();
		bando2 = new Enemigo();
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
