package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {

	@Test
	public void seCreaTableroVacio() {
		Jugador jugador1 = new Jugador("pepe");
		Jugador jugador2 = new Jugador("jose");
		Tablero tablero = new Tablero(jugador1, jugador2);

		Assert.assertEquals(0, tablero.getCantidadEntidades());
	}
}
