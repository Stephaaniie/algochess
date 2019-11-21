package fiuba.algo3.AlgoChess;
import fiuba.algo3.AlgoChess.direccion.*;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Posicion;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.excepciones.MovimientoInvalidoExcepcion;
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
	public void soldadoAtacaACuranderoYLeRestaVida() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Soldado soldado = new Soldado("enemigo", 6, 7);
		Curandero curandero = new Curandero("aliado", 4, 9);
		soldado.atacarEnemigo(curandero);

		Assert.assertEquals(65, curandero.getVida());
	}

	@Test
	public void soldadoSeMueveParaArriba() throws MovimientoInvalidoExcepcion {
		Soldado soldado = new Soldado("enemigo", 6, 7);
		Posicion posicion = new Posicion(5, 7);
		Direccion direccion = new Arriba();
		soldado.mover(direccion);

		Assert.assertEquals(posicion, soldado.getPosicion());
	}

	@Test
	public void soldadoSeMueveParaAbajo() {
		Soldado soldado = new Soldado("enemigo", 6, 7);
		Posicion posicion = new Posicion(7, 7);
		Direccion direccion = new Abajo();
		soldado.mover(direccion);

		Assert.assertEquals(posicion, soldado.getPosicion());
	}

	@Test
	public void soldadoSeMueveParaLaIzquierda() {
		Soldado soldado = new Soldado("enemigo", 6, 7);
		Posicion posicion = new Posicion(6, 6);
		Direccion direccion = new Izquierda();
		soldado.mover(direccion);

		Assert.assertEquals(posicion, soldado.getPosicion());
	}

	@Test
	public void soldadoSeMueveParaLaDerecha() {
		Soldado soldado = new Soldado("enemigo", 6, 7);
		Posicion posicion = new Posicion(6, 8);
		Direccion direccion = new Derecha();
		soldado.mover(direccion);

		Assert.assertEquals(posicion, soldado.getPosicion());
	}
}