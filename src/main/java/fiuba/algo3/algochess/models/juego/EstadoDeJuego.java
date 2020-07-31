package fiuba.algo3.Modelado.Juego;

import fiuba.algo3.Modelado.Excepciones.NoPuedeRealizarAccionesTerminoElJuegoExcepcion;
import fiuba.algo3.Modelado.Jugador.Jugador;

public class EstadoDeJuego {
	
	private final String FIN_DE_JUEGO = "Hay ganador";
	
	private Jugador jugadorAliado;
	
	private Jugador jugadorEnemigo;
	
	private String  tipoDeEstado;
	
	private String  ganador;
	
	public EstadoDeJuego(Jugador jugadorALiado,Jugador jugadorEnemigo) {
		
		this.jugadorAliado  = jugadorALiado;
		this.jugadorEnemigo = jugadorEnemigo;
		this.tipoDeEstado   = "jugando";
	}
	
	private String getEstado() {
		return this.tipoDeEstado;
	}
	
	private String getGanador() {
		return this.ganador;
	}
	
	private void verificarSiHayGanador() {
		if (jugadorAliado.getCantidadDeEntidades() == 0) {
			this.ganador = jugadorAliado.getNombre();
		}else if (jugadorEnemigo.getCantidadDeEntidades() == 0) {
			this.ganador = jugadorEnemigo.getNombre();
		}
		this.tipoDeEstado = FIN_DE_JUEGO;
	}
	
	private void verificarEmpate() {
		if(jugadorAliado.getCantidadDeEntidades() == 0 & jugadorEnemigo.getCantidadDeEntidades() == 0) {
			this.tipoDeEstado = FIN_DE_JUEGO;
			this.ganador = "Empate";
		}
	}
	
	public void publicarGanador() {
		getGanador();
	}
	
	public void verificarEstadoDelJuego() {
		
		verificarSiHayGanador();
		
		verificarEmpate();
		
		if(this.getEstado() == FIN_DE_JUEGO) {
			publicarGanador();
			throw new NoPuedeRealizarAccionesTerminoElJuegoExcepcion();
		}
	}
}
