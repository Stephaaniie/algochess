package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Posicion;
import fiuba.algo3.AlgoChess.tablero.Casillero;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;

public class CasilleroTest {
	
	@Test
	public void noSePuedeAgregarContenidoEnCasilleroOcupado() {
		boolean errorAtrapado = false;
		try {
			Posicion posicion = new Posicion(1,2);
			Casillero casillero = new Casillero(posicion);
			Entidad jinete1 = new Jinete("aliado", 2 ,1);
			Entidad jinete2 = new Jinete("aliado", 1 , 2);
			casillero.agregarContenido(jinete1);
			casillero.agregarContenido(jinete2);
		}catch(CasilleroOcupadoExcepcion excepcion) {
			errorAtrapado = true;
		}
		Assert.assertTrue(errorAtrapado);
	}
	
}
