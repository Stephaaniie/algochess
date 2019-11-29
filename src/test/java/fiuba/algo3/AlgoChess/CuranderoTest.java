package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.AlgoChess.direccion.Abajo;
import fiuba.algo3.AlgoChess.direccion.AbajoDerecha;
import fiuba.algo3.AlgoChess.direccion.AbajoIzquierda;
import fiuba.algo3.AlgoChess.direccion.Arriba;
import fiuba.algo3.AlgoChess.direccion.ArribaDerecha;
import fiuba.algo3.AlgoChess.direccion.ArribaIzquierda;
import fiuba.algo3.AlgoChess.direccion.Derecha;
import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.direccion.Izquierda;
import fiuba.algo3.AlgoChess.entidades.Aliado;
import fiuba.algo3.AlgoChess.entidades.Bando;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Enemigo;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class CuranderoTest {
	@Before
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
	public void curanderoCuraUnSoldadoAlDecrementarLaVida() {
		Bando bando1 = new Aliado();
		Bando bando2 = new Aliado();
		Curandero curandero = new Curandero(bando1, 5, 5);

		Soldado soldado = new Soldado(bando2, 6, 7);

		soldado.recibirDanio(20);

		curandero.curarEntidad(soldado);

		assertEquals(95, soldado.getVida());
	}

	@Test
	public void curanderoCuraUnJineteDecrementarLaVida() {
		Bando bando1 = new Aliado();
		Bando bando2 = new Aliado();
		Curandero curandero = new Curandero(bando1, 5, 5);

		Jinete jinete = new Jinete(bando2, 5, 6);

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
		assertEquals(70, curandero.getVida());
	}

	@Test
	public void curanderoSeMueveEnDireccionArriba() {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(7, 8);

		Curandero curandero = new Curandero(bando, 8, 8);
		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(curandero,8, 8);

		Direccion direccion = new Arriba();

		curandero.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, curandero.getPosicion()));
	}

	@Test
	public void curanderoSeMueveEnDireccionAbajo() {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(6, 5);

		Curandero curandero = new Curandero(bando, 5, 5);

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(curandero,5, 5);

		Direccion direccion = new Abajo();

		curandero.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, curandero.getPosicion()));
	}

	@Test
	public void curanderoSeMueveEnDireccionDerecha() {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(5, 6);

		Curandero curandero = new Curandero(bando, 5, 5);

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(curandero,5, 5);

		Direccion direccion = new Derecha();

		curandero.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, curandero.getPosicion()));
	}

	@Test
	public void curanderoSeMueveEnDireccionIzquierda() {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(10, 9);

		Curandero curandero = new Curandero(bando, 10, 10);

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(curandero,10, 10);

		Direccion direccion = new Izquierda();

		curandero.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, curandero.getPosicion()));
	}
	@Test
	public void soldadoSeMueveParaArribaALaDerecha() {
		Bando bando = new Enemigo();
		Soldado soldado = new Soldado(bando, 6, 7);
		Posicion posicionNueva = new Posicion(5, 8);

		Direccion direccion = new ArribaDerecha();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(soldado,6,7 );

		soldado.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, soldado.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaAbajoALaIzquierda() {
		Bando bando = new Enemigo();
		Soldado soldado = new Soldado(bando, 6, 7);
		Posicion posicionNueva = new Posicion(7, 6);

		Direccion direccion = new AbajoIzquierda();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(soldado,6,7 );

		soldado.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, soldado.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaAbajoALaDerecha() {
		Bando bando = new Enemigo();
		Soldado soldado = new Soldado(bando, 6, 7);
		Posicion posicionNueva = new Posicion(7, 8);

		Direccion direccion = new AbajoDerecha();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(soldado,6,7 );

		soldado.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, soldado.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaArribaALaIzquierda() {
		Bando bando = new Enemigo();
		Soldado soldado = new Soldado(bando, 6, 7);
		Posicion posicionNueva = new Posicion(5,6);

		Direccion direccion = new ArribaIzquierda();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(soldado,6,7 );

		soldado.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, soldado.getPosicion()));
	}

	@Test
	public void curanderoNoPuedeMoverseACasilleroOcupado() {		
		Bando bando1 = new Aliado();
		Bando bando2 = new Aliado();
		
		Curandero curandero = new Curandero(bando1, 6,6);
		Catapulta catapulta = new Catapulta(bando2, 6,5);
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Direccion direccion = new Izquierda();

		tablero.agregarEntidadEnCasillero(curandero, 6, 6);
		tablero.agregarEntidadEnCasillero(catapulta,6,5);
		curandero.mover(direccion);

		assertTrue(curandero.getPosicion().mismaPosicion(catapulta.getPosicion(), curandero.getPosicion()));
	}
}
