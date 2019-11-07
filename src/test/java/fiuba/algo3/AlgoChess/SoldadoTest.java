package fiuba.algo3.AlgoChess;

import org.junit.Assert;
import org.junit.Test;

public class SoldadoTest {

	@Test
	public void soldadoRecuperadoSeLeSumaVidaTest() {
		Casillero casillero = new Casillero(1, 2);
		Soldado soldado = new Soldado("aliado", casillero);
		soldado.reponerVida(15);

		Assert.assertEquals(115, soldado.getVida());
	}

	@Test
	public void soldadoAtacadoPierdeVidaTest() {
		Casillero casillero = new Casillero(1, 2);
		Soldado soldado = new Soldado("aliado", casillero);

		soldado.restarVida(50);

		Assert.assertEquals(50, soldado.getVida());
	}

	@Test
	public void soldadoNoTieneEnemigosCercaTest() {
		Casillero casillero = new Casillero(3, 5);
		Soldado soldado = new Soldado("aliado", casillero);

		Assert.assertEquals(false, soldado.enemigosCerca());
	}

	@Test
	public void soldadoNoTieneAliadosCercaTest() {
		Casillero casillero = new Casillero(6, 7);
		Soldado soldado = new Soldado("enemigo", casillero);

		Assert.assertEquals(false, soldado.aliadosCerca());
	}

}
