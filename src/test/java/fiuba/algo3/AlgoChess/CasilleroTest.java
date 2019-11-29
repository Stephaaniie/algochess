package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.AlgoChess.entidades.Aliado;
import fiuba.algo3.AlgoChess.entidades.Bando;
import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.tablero.Casillero;
import fiuba.algo3.AlgoChess.tablero.Posicion;

public class CasilleroTest {
	
	@Test
	public void noSePuedeAgregarContenidoEnCasilleroOcupado() {
		
		Posicion posicion = new Posicion(1,2);
		
		Casillero casillero = new Casillero(posicion);
		
		Bando bando1 = new Aliado();
		Bando bando2 = new Aliado();
		
		Entidad jinete1 = new Jinete(bando1, 1 ,2);
		Entidad jinete2 = new Jinete(bando2, 1 ,2);
		
		casillero.agregarEntidad(jinete1);
		casillero.agregarEntidad(jinete2);
		assertTrue(posicion.mismaPosicion(jinete1.getPosicion(), jinete2.getPosicion()));
	}
	
}
