package fiuba.algo3.AlgoChess;

import org.junit.Test;

import static org.junit.Assert.*;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;

public class SoldadoTest {

	@Test
	public void soldadoRecuperadoSeLeSumaVidaTest() throws CuranderoCuraHastaLaMaximaVidaExcepcion {
		Casillero casillero = new Casillero(1, 2);
		Soldado soldado = new Soldado("aliado", casillero);
		soldado.reponerVida(15);

		assertEquals(100, soldado.getVida());
	}

	@Test
	public void soldadoAtacadoPierdeVidaTest() {
		Casillero casillero = new Casillero(1, 2);
		Soldado soldado = new Soldado("aliado", casillero);

		soldado.restarVida(50);

		assertEquals(50, soldado.getVida());
	}

	@Test
	public void soldadoNoTieneEnemigosCercaTest() {
		Casillero casillero = new Casillero(3, 5);
		Soldado soldado = new Soldado("aliado", casillero);

		assertEquals(false, soldado.enemigosCerca());
	}

	@Test
	public void soldadoNoTieneAliadosCercaTest() {
		Casillero casillero = new Casillero(6, 7);
		Soldado soldado = new Soldado("enemigo", casillero);

		assertEquals(false, soldado.aliadosCerca());
	}

}
