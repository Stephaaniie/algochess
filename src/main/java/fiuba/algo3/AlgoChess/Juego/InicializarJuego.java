package fiuba.algo3.AlgoChess.Juego;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Bandos.Enemigo;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class InicializarJuego {
	
	private Tablero tablero;
	
	private Jugador jugadorAliado;
	
	private Jugador jugadorEnemigo;
	
	private Bando bando1;
	
	private Bando bando2;
	
	public InicializarJuego() {
		this.setTablero(Tablero.getInstanciaTablero());
		this.setJugadorAliado(null);
		this.setJugadorEnemigo(null);
		bando1 = new Aliado();
		bando2 = new Enemigo();
	}
	
	public void inicializarJugadorAliado(String nombre) {
		this.setJugadorAliado(new Jugador(nombre,bando1));
	}
	
	public void inicializarJugadorEnemigo(String nombre) {
		this.setJugadorEnemigo(new Jugador(nombre,bando2));
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
