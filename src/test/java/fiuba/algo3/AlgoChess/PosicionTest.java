package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class PosicionTest {
	
	@Test 
	public void seLeAsignaCorrectamenteLaPosiconX() {
		
		Posicion posicion = new Posicion(1,8);
		
		assertEquals(1,posicion.getX());
	}
	
	@Test
	public void seLeAsignaCorrectamenteLPosicionY() {
		
		Posicion posicion = new Posicion(1,8);
		
		assertEquals(8,posicion.getY());
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
	
}
