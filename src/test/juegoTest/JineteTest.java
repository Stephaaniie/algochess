package juegoTest;

import org.junit.Assert;
import org.junit.Test;
import juego.Casillero;
import juego.Jinete;

public class JineteTest {

	@Test
	public void jineteRecuperaVidaTest() {
		Casillero casillero = new Casillero(3,1);
		Jinete jinete = new Jinete("aliado", casillero);
		jinete.reponerVida();
		
		Assert.assertEquals(115, jinete.getVida());
	}
	
	@Test
	public void jineteAtacadoPierdeVidaTest() {
		Casillero casillero = new Casillero(6,8);
		Jinete jinete = new Jinete("aliado", casillero);
		jinete.restarVida(20);
		
		Assert.assertEquals(95, jinete.getVida());
	}
	
	@Test
	public void jineteNoTieneEnemigosCercaTest() {
		Casillero casillero = new Casillero(8,1);
		Jinete jinete = new Jinete("aliado", casillero);
		
		Assert.assertEquals(false, jinete.enemigosCerca());
	}
}