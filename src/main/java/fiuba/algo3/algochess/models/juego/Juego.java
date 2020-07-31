package fiuba.algo3.Modelado.Juego;

import fiuba.algo3.Modelado.Bandos.Aliado;
import fiuba.algo3.Modelado.Bandos.Bando;
import fiuba.algo3.Modelado.Bandos.Enemigo;
import fiuba.algo3.Modelado.Jugador.Jugador;
import fiuba.algo3.Modelado.Tablero.Tablero;

public class Juego {
	
	private Tablero tablero;
	
	private static Jugador jugadorAliado;
	
	private static Jugador jugadorEnemigo;

	private Bando aliado = new Aliado();
	
	private Bando enemigo = new Enemigo();
	
	private static Juego instanciaDeJuego = null;
	
	private static EstadoDeJuego estadoDeJuego;
	
	public Juego(String nomJugador1, String nomJugador2) {
		
		this.tablero = Tablero.getInstanciaTablero();
		
		jugadorEnemigo = new Jugador(nomJugador1, aliado, nomJugador2, enemigo);

		estadoDeJuego = new EstadoDeJuego(getJugadorEnemigo(),getJugadorAliado());

		jugadorAliado = jugadorEnemigo.obtenerSiguienteJugador();
	}
	
	public static Juego getInstanciaJuego(String nomJugador1, String nomJugador2) {
		if(instanciaDeJuego == null) {
			instanciaDeJuego = new Juego(nomJugador1,nomJugador2);
		}
		return instanciaDeJuego;
	}
	
	
	public static Jugador getJugadorEnemigo() {
		return jugadorEnemigo;
	}

	public static Jugador getJugadorAliado() {
		return jugadorAliado;
	}

	public Tablero getTablero() {
		return this.tablero;
	}
	
	public void actualizarEstado() {
		estadoDeJuego.verificarEstadoDelJuego();
	}
}
