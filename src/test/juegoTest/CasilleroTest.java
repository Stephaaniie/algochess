package juegoTest;

import org.junit.Test;

import excepciones.CasilleroOcupadoExcepcion;

import org.junit.Assert;
import juego.Casillero;

public class CasilleroTest {
	
	
	@Test
	public void casilleroSeCreaConFilaYColumnaCorrectas() {
		Casillero casillero = new Casillero(1,20);
		
		Assert.assertEquals(1, casillero.fila());
		Assert.assertEquals(20, casillero.columna());
	}
	
	@Test
	public void noSePuedeAgregarContenidoEnCasilleroOcupado() {
		boolean errorAtrapado = false;
		try {
			Casillero casillero = new Casillero(4,5);
			casillero.agregarContenido(40);
			casillero.agregarContenido(50);
		}catch(CasilleroOcupadoExcepcion excepcion) {
			errorAtrapado = true;
		}
		
		Assert.assertTrue(errorAtrapado);
	}
}
