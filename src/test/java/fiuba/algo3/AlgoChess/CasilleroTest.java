package fiuba.algo3.AlgoChess;

import org.junit.Test;

import static org.junit.Assert.*;

public class CasilleroTest {

	@Test
	public void casilleroSeCreaConFilaYColumnaCorrectas() {
		Casillero casillero = new Casillero(1, 20);

		assertEquals(1, casillero.fila());
		assertEquals(20, casillero.columna());
	}
/*
	@Test
	public void noSePuedeAgregarContenidoEnCasilleroOcupado() {
		boolean errorAtrapado = false;
		try {
			Casillero casillero = new Casillero(4, 5);
			//casillero.agregarContenido(40);
			//casillero.agregarContenido(50);
		} catch (CasilleroOcupadoExcepcion excepcion) {
			errorAtrapado = true;
		}

		assertTrue(errorAtrapado);
	}
	*/
}
