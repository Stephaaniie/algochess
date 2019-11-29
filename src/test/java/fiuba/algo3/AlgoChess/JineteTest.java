package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.AlgoChess.direccion.Abajo;
import fiuba.algo3.AlgoChess.direccion.Arriba;
import fiuba.algo3.AlgoChess.direccion.Derecha;
import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.direccion.Izquierda;
import fiuba.algo3.AlgoChess.entidades.Aliado;
import fiuba.algo3.AlgoChess.entidades.Bando;
import fiuba.algo3.AlgoChess.entidades.Enemigo;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class JineteTest {
	@Before
	@Test
	public void jineteRecuperaVidaTest() {
		Bando bando = new Aliado();
		Jinete jinete = new Jinete(bando, 1, 2);
		jinete.reponerVida(10);
		
		assertEquals(100, jinete.getVida());
	}
	
	@Test
	public void jineteAtacadoPierdeVidaTest() {
		Bando bando = new Enemigo();
		Jinete jinete = new Jinete(bando, 6, 8);
		jinete.recibirDanio(20);
		
		assertEquals(80, jinete.getVida());
	}


	@Test
	public void jineteAtacaAEntidadEnDistanciaCorta() {
		Bando bando1 = new Aliado();
		Bando bando2 = new Enemigo();
		Jinete jinete = new Jinete(bando1, 1, 2);
		Soldado soldado = new Soldado(bando2, 2, 2);

		jinete.atacarEnemigo();

		assertEquals(100, soldado.getVida());
	}

	@Test
	public void jineteAtacaAEntidadEnDistanciaMedia() {
		Bando bando1 = new Aliado();
		Bando bando2 = new Enemigo();
		Jinete jinete = new Jinete(bando1, 1, 2);
		Soldado soldado = new Soldado(bando2, 4, 2);

		jinete.atacarEnemigo();

		assertEquals(100, soldado.getVida());
	}
	
	@Test
	public void jineteSeMueveParaAbajo() {
		Bando bando = new Aliado();
		Jinete jinete = new Jinete(bando, 3, 2);
		Posicion posicionNueva = new Posicion(4,2);

		Direccion direccion = new Abajo();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(jinete,3, 2);

		jinete.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, jinete.getPosicion()));
	}

	@Test
	public void jineteSeMueveParaArriba() {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(1, 1);
		Jinete jinete = new Jinete(bando, 2, 1);

		Direccion direccion = new Arriba();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(jinete,2, 1);

		jinete.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, jinete.getPosicion()));

	}

	@Test
	public void jineteSeMueveParaLaDerecha() {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(2,2);
		Jinete jinete = new Jinete(bando, 2, 1);

		Direccion direccion = new Derecha();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(jinete,2, 1);

		jinete.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, jinete.getPosicion()));

	}

	@Test
	public void jineteSeMueveParaLaIzquierda() {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(3, 1);
		Jinete jinete = new Jinete(bando, 3, 2);

		Direccion direccion = new Izquierda();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarEntidadEnCasillero(jinete,3, 2);

		jinete.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, jinete.getPosicion()));
	}

	@Test
	public void jineteNoPuedeMoverseACasilleroOcupado() {
		Posicion posicionEsperada = new Posicion(5, 5);
		
		Bando bando1 = new Aliado();
		
		Jinete jinete = new Jinete(bando1, 5,5);
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Direccion direccion = new Izquierda();
		
		tablero.agregarEntidadEnCasillero(jinete, 5, 5);
		
		jinete.mover(direccion);

		assertFalse(jinete.getPosicion().mismaPosicion(posicionEsperada, jinete.getPosicion()));
	}
}