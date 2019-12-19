package fiuba.algo3.Modelado.Jugador;

import fiuba.algo3.Modelado.Bandos.Bando;

public class TurnoSiguiente {
	
	private static TurnoSiguiente instanciaDeTurnoSiguiente = null;
	
	private Jugador jugador;
		
	private Bando bandoJugadorActual;
	
	private TurnoSiguiente() {
		this.jugador = null;
	}
	public static TurnoSiguiente getInstancia() {
		if(instanciaDeTurnoSiguiente == null) {
			instanciaDeTurnoSiguiente = new TurnoSiguiente();
		}
		return instanciaDeTurnoSiguiente;
	}
	
	public void cambiarDespuesDeComprarEntidades(Jugador jugador) {
		if(jugador.getPuntos() <= 0) {
			cambiadorDeTurno(jugador,jugador.obtenerSiguienteJugador());
		}
	}
	
	public void cambiarTurno() {
		Jugador jugadorAux = jugador;
		jugador = jugador.obtenerSiguienteJugador();
		jugador.setOtroJUgador(jugadorAux);
		this.setBandoJugadorActual(jugador.getBando());
	}
	
	public void cambiadorDeTurno(Jugador jugador1, Jugador jugador2) { 
		Jugador jugador = jugador1;
		jugador1 = jugador2;
		jugador2 = jugador;
		this.setBandoJugadorActual(jugador1.getBando());
	}

	public Bando getBandoJugadorActual() {
		return bandoJugadorActual;
	}

	public void setBandoJugadorActual(Bando bandoJugadorActual) {
		this.bandoJugadorActual = bandoJugadorActual;
	}

	public Jugador getJugadorActual() {
		return jugador;
	}

	
}
