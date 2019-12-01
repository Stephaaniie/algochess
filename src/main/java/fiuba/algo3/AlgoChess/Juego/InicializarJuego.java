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
		this.tablero = Tablero.getInstanciaTablero();
		this.jugadorAliado = null;
		this.jugadorEnemigo = null;
		bando1 = new Aliado();
		bando2 = new Enemigo();
	}
	
	public void inicializarJugadorAliado(String nombre) {
		this.jugadorAliado = new Jugador(nombre,bando1);
	}
	
	public void inicializarJugadorEnemigo(String nombre) {
		this.jugadorEnemigo = new Jugador(nombre,bando2);
	}
}
