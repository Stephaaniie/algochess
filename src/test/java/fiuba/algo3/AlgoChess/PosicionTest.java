package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.AlgoChess.Tablero.Posicion;


public class PosicionTest {
	@Before
	@Test 
	public void seLeAsignaCorrectamenteLaFila() {
		Posicion posicion = new Posicion(1,8);
		assertEquals(1,posicion.getFila());
	}
	
	@Test
	public void seLeAsignaCorrectamenteLaColumna() {
		Posicion posicion = new Posicion(1,8);
		assertEquals(8,posicion.getColumna());
	}
	
	@Test
	public void seCreaUnaPosicionNueva() {
		Posicion posicion = new Posicion(5,5);
		assertNotEquals(null,posicion);
	}
	
	@Test
	public void laDistanciaEntreUnaPosicionYOtraEsCero() {
		Posicion posicion = new Posicion(0,0);
		Posicion posicion1 = new Posicion(0,0);
		assertEquals(0,posicion.distanciaEntrePosiciones(posicion1));
	}
	
	@Test
	public void laDistanciaEntreUnaPosicionYOtraEsDos() {
		Posicion posicion = new Posicion(2,2);
		Posicion posicion1 = new Posicion(4,2);
		assertEquals(2,posicion.distanciaEntrePosiciones(posicion1));
	}

	@Test
	public void dosPosicionesConMismaFilaYColumnaSonIguales(){
		Posicion posicion1 = new Posicion(1,2);
		Posicion posicion2 = new Posicion(1,2);
		assertTrue(posicion1.mismaPosicion(posicion1,posicion2));
	}
	
	@Test
	public void crearPosicionIncorporandoleElementos() {
		Posicion posicion1 = new Posicion(5,5);
		Posicion posicion = new Posicion(9,20);	
		assertFalse(posicion.mismaPosicion(posicion, posicion1));
	}
}
