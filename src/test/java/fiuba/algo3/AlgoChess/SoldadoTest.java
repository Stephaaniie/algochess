package fiuba.algo3.AlgoChess;
import fiuba.algo3.AlgoChess.direccion.*;
import fiuba.algo3.AlgoChess.entidades.*;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.excepciones.*;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SoldadoTest {

	@Test
	public void soldadoRecuperadoSeLeSumaVidaTest()
			throws CuranderoCuraHastaLaMaximaVidaExcepcion {
		Bando bando = new Aliado();
		Soldado soldado = new Soldado(bando, 1, 2);
		soldado.reponerVida(15);

		Assert.assertEquals(100, soldado.getVida());
	}

	@Test
	public void soldadoAtacadoPierdeVidaTest() {
		Bando bando = new Aliado();
		Soldado soldado = new Soldado(bando, 1, 2);

		soldado.recibirDanio(50);

		Assert.assertEquals(50, soldado.getVida());
	}

	@Test
	public void soldadoAtacaACuranderoYLeRestaVida() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Bando bando1 = new Aliado();
		Bando bando2 = new Enemigo();
		Soldado soldado = new Soldado(bando2, 6, 7);
		Curandero curandero = new Curandero(bando1, 4, 9);
		soldado.atacarEnemigo(curandero);

		Assert.assertEquals(65, curandero.getVida());
	}

	@Test
	public void soldadoSeMueveParaArriba() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Aliado();
		Soldado soldado = new Soldado(bando, 6, 7);
		Posicion posicionNueva = new Posicion(5, 7);
		Direccion direccion = new Arriba();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(soldado,6, 7 );

		soldado.mover(direccion);

		assertEquals(soldado.getPosicion(), posicionNueva);
		assertEquals(soldado, tablero.getEntidadEnPosicion(posicionNueva));
	}

	@Test
	public void soldadoSeMueveParaAbajo() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Enemigo();
		Soldado soldado = new Soldado(bando, 6, 7);
		Posicion posicionNueva = new Posicion(7, 7);
		Direccion direccion = new Abajo();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(soldado,6, 7);

		soldado.mover(direccion);

		assertEquals(soldado.getPosicion(), posicionNueva);
		assertEquals(soldado, tablero.getEntidadEnPosicion(posicionNueva));
	}

	@Test
	public void soldadoSeMueveParaLaIzquierda() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Enemigo();
		Soldado soldado = new Soldado(bando, 6, 7);
		Posicion posicionNueva = new Posicion(6, 6);

		Direccion direccion = new Izquierda();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(soldado,6, 7);

		soldado.mover(direccion);

		assertEquals(soldado.getPosicion(), posicionNueva);
		assertEquals(soldado, tablero.getEntidadEnPosicion(posicionNueva));
	}

	@Test
	public void soldadoSeMueveParaLaDerecha() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Enemigo();
		Soldado soldado = new Soldado(bando, 6, 7);
		Posicion posicionNueva = new Posicion(6, 8);

		Direccion direccion = new Derecha();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(soldado,6,7 );

		soldado.mover(direccion);

		assertEquals(soldado.getPosicion(), posicionNueva);
		assertEquals(soldado, tablero.getEntidadEnPosicion(posicionNueva));
	}
}