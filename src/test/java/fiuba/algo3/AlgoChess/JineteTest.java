package fiuba.algo3.AlgoChess;

import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

	@Test
	public void jineteRecuperaVidaTest() {
		Casillero casillero = new Casillero(3, 1);
		Jinete jinete = new Jinete("aliado", casillero);
		jinete.reponerVida(15);

		Assert.assertEquals(115, jinete.getVida());
	}

	@Test
	public void jineteAtacadoPierdeVidaTest() {
		Casillero casillero = new Casillero(6, 8);
		Jinete jinete = new Jinete("aliado", casillero);
		jinete.restarVida(20);

		Assert.assertEquals(80, jinete.getVida());
	}

	@Test
	public void jineteNoTieneEnemigosCercaTest() {
		Casillero casillero = new Casillero(8, 1);
		Jinete jinete = new Jinete("aliado", casillero);

		Assert.assertEquals(false, jinete.enemigosCerca());
	}
}