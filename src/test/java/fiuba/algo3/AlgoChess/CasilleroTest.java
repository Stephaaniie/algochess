package fiuba.algo3.AlgoChess;

import org.junit.Test;

import org.junit.Assert;


public class CasilleroTest {
	
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
