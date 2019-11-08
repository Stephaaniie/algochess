package juegoTest;

import juego.Casillero;
import juego.Catapulta;
import org.junit.Assert;
import org.junit.Test;


public class CatapultaTest {	
	
	@Test
	public void catapultaAtacadaPierdeVida() {
		
		Casillero casillero = new Casillero(2 , 3);
		
		Catapulta catapulta = new Catapulta("aliado", casillero);
		
		catapulta.restarVida(10);
		
		Assert.assertEquals(40, catapulta.getVida());
	}
	
	
}
