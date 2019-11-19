package fiuba.algo3.AlgoChess;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;

public class SoldadoTest {

	@Test
	public void soldadoRecuperadoSeLeSumaVidaTest()
			throws CuranderoCuraHastaLaMaximaVidaExcepcion {
		Soldado soldado = new Soldado("aliado", 1, 2);
		soldado.reponerVida(15);

		Assert.assertEquals(100, soldado.getVida());
	}

	@Test
	public void soldadoAtacadoPierdeVidaTest() {
		Soldado soldado = new Soldado("aliado", 1, 2);

		soldado.recibirDanio(50);

		Assert.assertEquals(50, soldado.getVida());
	}

	@Test
	public void soldadoNoTieneEnemigosCercaTest() {
		Soldado soldado = new Soldado("aliado", 3, 5);

		Assert.assertFalse(soldado.enemigosCerca());
	}

	@Test
	public void soldadoNoTieneAliadosCercaTest() {
		Soldado soldado = new Soldado("enemigo", 6, 7);

		Assert.assertFalse(soldado.aliadosCerca());
	}

	@Test
	public void soldadoAtacaACuranderoYLeRestaVida() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Soldado soldado = new Soldado("enemigo", 6, 7);
		Curandero curandero = new Curandero("aliado", 4, 9);
		soldado.atacarEnemigo(curandero);

		Assert.assertEquals(65, curandero.getVida());
	}

	@Test
	public void soldadoSeMueveParaArriba(){
		Soldado soldado = new Soldado("enemigo", 6, 7);
		Posicion posicion = new Posicion(5, 7);
		soldado.mover("arriba");

		Assert.assertEquals(posicion, soldado.getPosicion());
	}

	@Test
	public void soldadoSeMueveParaAbajo(){
		Soldado soldado = new Soldado("enemigo", 6, 7);
		Posicion posicion = new Posicion(7, 7);
		soldado.mover("abajo");

		Assert.assertEquals(posicion, soldado.getPosicion());
	}

	@Test
	public void soldadoSeMueveParaLaIzquierda(){
		Soldado soldado = new Soldado("enemigo", 6, 7);
		Posicion posicion = new Posicion(6, 6);
		soldado.mover("izquierda");

		Assert.assertEquals(posicion, soldado.getPosicion());
	}

	@Test
	public void soldadoSeMueveParaLaDerecha(){
		Soldado soldado = new Soldado("enemigo", 6, 7);
		Posicion posicion = new Posicion(6, 8);
		soldado.mover("derecha");

		Assert.assertEquals(posicion, soldado.getPosicion());
	}
}