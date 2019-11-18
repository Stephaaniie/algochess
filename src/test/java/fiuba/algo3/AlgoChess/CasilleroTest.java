package fiuba.algo3.AlgoChess;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;


public class CasilleroTest {
	
	@Test
	public void noSePuedeAgregarContenidoEnCasilleroOcupado() {
		boolean errorAtrapado = false;
		try {
			Posicion posicion = new Posicion(4,5);
			Casillero casillero = new Casillero(posicion);
			casillero.agregarContenido(40);
			casillero.agregarContenido(50);
			errorAtrapado = true;
		}catch(CasilleroOcupadoExcepcion excepcion) {
		}
		
		Assert.assertTrue(errorAtrapado);
	}
}
