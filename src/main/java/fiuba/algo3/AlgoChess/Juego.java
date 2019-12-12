package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Bandos.Enemigo;
import fiuba.algo3.AlgoChess.Jugador.Jugador;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class Juego {
	
	private Tablero tablero;
	
	private Jugador jugadorAliado;
	
	private Jugador jugadorEnemigo;

	private Bando aliado = new Aliado();
	
	private Bando enemigo = new Enemigo();
	
	private static Juego instanciaDeJuego = null;
	
	public Juego(String nomJugador1, String nomJugador2) {
		
		this.tablero = Tablero.getInstanciaTablero();
		
		this.jugadorEnemigo = new Jugador(nomJugador1, aliado, nomJugador2, enemigo);
		
		this.jugadorAliado = jugadorEnemigo.obtenerSiguienteJugador();
	}
	
	public static Juego getInstanciaJuego(String nomJugador1, String nomJugador2) {
		if(instanciaDeJuego == null) {
			instanciaDeJuego = new Juego(nomJugador1,nomJugador2);
		}
		return instanciaDeJuego;
	}
	
	
	public Jugador getJugadorEnemigo() {
		return this.jugadorEnemigo;
	}

	public Jugador getJugadorAliado() {
		return this.jugadorAliado;
	}

	public Tablero getTablero() {
		return this.tablero;
	}

}
