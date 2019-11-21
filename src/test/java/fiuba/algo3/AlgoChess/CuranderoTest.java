package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import fiuba.algo3.AlgoChess.direccion.*;
import fiuba.algo3.AlgoChess.entidades.*;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class CuranderoTest {

	@Test
	public void CuranderoSeCreaConElCostoCorrecto() {
		Bando bando = new Aliado();
		Curandero curandero = new Curandero(bando, 0, 1);

		assertEquals(2, curandero.getCosto());

	}

	@Test
	public void CuranderoSeCreaConLaVidaCorrecta() {
		Bando bando = new Aliado();
		Curandero curandero = new Curandero(bando, 0, 1);

		assertEquals(75, curandero.getVida());

	}

	@Test
	public void seCreaCuranderoConTodosSusAtributosCargados() {
		Bando bando = new Aliado();
		Curandero curandero = new Curandero(bando, 0, 1);

		assertNotEquals(null, curandero);
	}

	@Test
	public void curanderoCuraUnSoldadoAlDecrementarLaVida()
			throws CuranderoCuraHastaLaMaximaVidaExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Bando bando1 = new Aliado();
		Bando bando2 = new Aliado();
		Curandero curandero = new Curandero(bando1, 5, 5);

		Soldado soldado = new Soldado(bando2, 6, 7);

		soldado.recibirDanio(20);

		curandero.curarEntidad(soldado);

		assertEquals(95, soldado.getVida());
	}

	@Test
	public void curanderoCuraUnJineteDecrementarLaVida()
			throws CuranderoCuraHastaLaMaximaVidaExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Bando bando1 = new Aliado();
		Bando bando2 = new Aliado();
		Curandero curandero = new Curandero(bando1, 5, 5);

		Jinete jinete = new Jinete(bando2, 6, 7);

		jinete.recibirDanio(20);

		curandero.curarEntidad(jinete);

		assertEquals(95, jinete.getVida());
	}

	@Test
	public void curanderoIntentaCurarUnaCatapulta() {
		Bando bando1 = new Aliado();
		Bando bando2 = new Aliado();
		Curandero curandero = new Curandero(bando1, 5, 5);

		Catapulta catapulta = new Catapulta(bando2, 6, 7);

		catapulta.recibirDanio(20);

		try {
			curandero.curarEntidad(catapulta);

		} catch (CuranderoCuraHastaLaMaximaVidaExcepcion | ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {

			assertEquals(30, catapulta.getVida());
		}
	}

	@Test
	public void curanderoSeLeDecrementaLaVidaYSeAutoCura() {
		Bando bando = new Aliado();
		Curandero curandero = new Curandero(bando, 5, 5);

		curandero.recibirDanio(20);

		try {
			curandero.curarEntidad(curandero);
		} catch (CuranderoCuraHastaLaMaximaVidaExcepcion e) {
			e.printStackTrace();
		} catch (ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			e.printStackTrace();
		}
		assertEquals(75, curandero.getVida());
	}

	@Test
	public void curanderoSeMueveEnDireccionArriba() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(7, 8);

		Curandero curandero = new Curandero(bando, 8, 8);
		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(curandero,8, 8);

		Direccion direccion = new Arriba();

		curandero.mover(direccion);

		assertEquals(curandero.getPosicion(), posicionNueva);
		assertEquals(curandero, tablero.getEntidadEnPosicion(posicionNueva));
	}

	@Test
	public void curanderoSeMueveEnDireccionAbajo() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(6, 5);

		Curandero curandero = new Curandero(bando, 5, 5);

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(curandero,5, 5);

		Direccion direccion = new Abajo();

		curandero.mover(direccion);

		assertEquals(curandero.getPosicion(), posicionNueva);
		assertEquals(curandero, tablero.getEntidadEnPosicion(posicionNueva));
	}

	@Test
	public void curanderoSeMueveEnDireccionDerecha() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(5, 6);

		Curandero curandero = new Curandero(bando, 5, 5);

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(curandero,5, 5);

		Direccion direccion = new Derecha();

		curandero.mover(direccion);

		assertEquals(curandero.getPosicion(), posicionNueva);
		assertEquals(curandero, tablero.getEntidadEnPosicion(posicionNueva));
	}

	@Test
	public void curanderoSeMueveEnDireccionIzquierda() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(5, 4);

		Curandero curandero = new Curandero(bando, 5, 5);

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(curandero,5, 5);

		Direccion direccion = new Izquierda();

		curandero.mover(direccion);

		assertEquals(curandero.getPosicion(), posicionNueva);
		assertEquals(curandero, tablero.getEntidadEnPosicion(posicionNueva));
	}

	@Test
	public void jineteNoPuedeMoverseACasilleroOcupado() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		boolean errorAtrapado = false;
		Posicion posicionEsperada = new Posicion(6, 6);
		Bando bando1 = new Aliado();
		Bando bando2 = new Aliado();
		Curandero curandero = new Curandero(bando1, 6,6);
		Catapulta catapulta = new Catapulta(bando2, 6,5);
		Tablero tablero = Tablero.getInstanciaTablero();
		Direccion direccion = new Izquierda();

		try{
			tablero.agregarContenidoEnCasillero(curandero, 5, 5);
			tablero.agregarContenidoEnCasillero(catapulta,5,4);
			curandero.mover(direccion);
		}catch(CasilleroOcupadoExcepcion e){
			errorAtrapado = true;
		}

		Assert.assertTrue(errorAtrapado);
		Assert.assertEquals(posicionEsperada, curandero.getPosicion());
	}
}
