package fiuba.algo3.Modelado.Jugador;

public class TurnoSiguiente {
	
	private static TurnoSiguiente instanciaDeTurnoSiguiente = null;
	
	public TurnoSiguiente getInstancia() {
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
	
	public void cambiadorDeTurno(Jugador jugadorA, Jugador jugadorE) {
		Jugador jugador = jugadorA;
		jugadorA = jugadorE;
		jugadorE = jugador;
	}
	
	
}
