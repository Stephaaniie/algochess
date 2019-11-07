package fiuba.algo3.AlgoChess;

import org.junit.Assert;
import org.junit.Test;


public class TableroTest {

	@Test
	public void seCreaTableroVacio() {
		Jugador jugador1 = new Jugador("pepe");
		Jugador jugador2 = new Jugador("Matias");

		Tablero nuevoTablero = new Tablero(jugador1, jugador2);

		Assert.assertEquals(0, nuevoTablero.getCantidadEntidades());
	}
/*
	@Test
	public void agregoUnContenidoYTableroNoEstaVacio() {
		Jugador jugador1 = new Jugador("pepe");
		Jugador jugador2 = new Jugador("Matias");

		Tablero nuevoTablero = new Tablero(jugador1, jugador2);

		nuevoTablero.agregarContenidoEnCasillero(jugador2, 40, 1, 1);

		Assert.assertEquals(1, nuevoTablero.getCantidadEntidades());
	}
	*/
}
