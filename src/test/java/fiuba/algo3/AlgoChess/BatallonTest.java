package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Direccion.Abajo;
import fiuba.algo3.AlgoChess.Direccion.AbajoDerecha;
import fiuba.algo3.AlgoChess.Direccion.AbajoIzquierda;
import fiuba.algo3.AlgoChess.Direccion.Arriba;
import fiuba.algo3.AlgoChess.Direccion.ArribaDerecha;
import fiuba.algo3.AlgoChess.Direccion.ArribaIzquierda;
import fiuba.algo3.AlgoChess.Direccion.Derecha;
import fiuba.algo3.AlgoChess.Direccion.Izquierda;
import fiuba.algo3.AlgoChess.Entidades.Batallon;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.Soldado;
import fiuba.algo3.AlgoChess.Tablero.Posicion;

public class BatallonTest {
	@Before
	@Test
	public void batallonSeCreaCorrectamente() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(4, 7);
		Posicion posicion2 = new Posicion(5, 7);		
		Posicion posicion3 = new Posicion(6, 7);
		
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion1);
		Entidad entidad3 = jugador.getEntidad(posicion1);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
	
		assertEquals(aliado,batallon.getBando());
	}
	
	@Test
	public void batallonRecibeBandoDelJugador() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(4, 7);
		Posicion posicion2 = new Posicion(5, 7);		
		Posicion posicion3 = new Posicion(6, 7);
		
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion1);
		Entidad entidad3 = jugador.getEntidad(posicion1);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
														
		assertEquals(entidad1.getBando(),batallon.getBando());
	}
	@Test
	public void batallonRecibeBienElnumeroDeSoldadosEnlistados() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(4, 7);
		Posicion posicion2 = new Posicion(5, 7);		
		Posicion posicion3 = new Posicion(6, 7);
		
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion1);
		Entidad entidad3 = jugador.getEntidad(posicion1);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		assertTrue(batallon.getBatallon().size() == 3);
	}
	
	@Test
	public void lasPosicionesDeLosSoldadosLLeganBien() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(4, 7);
		Posicion posicion2 = new Posicion(5, 7);		
		Posicion posicion3 = new Posicion(6, 7);
		
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
														
		assertTrue(batallon.getBatallon().get(0).getPosicion().mismaPosicion(posicion1, batallon.getBatallon().get(0).getPosicion()));
		assertTrue(batallon.getBatallon().get(1).getPosicion().mismaPosicion(posicion2, batallon.getBatallon().get(1).getPosicion()));
		assertTrue(batallon.getBatallon().get(2).getPosicion().mismaPosicion(posicion3, batallon.getBatallon().get(2).getPosicion()));

	}
	@Test
	public void verificarQueTodosLosIntegrantesDelBatallonSeMuevenUnaPosicionArriba() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(3, 7);
		Posicion posicion2 = new Posicion(8, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(2, 7);
		Posicion posicionNueva2 = new Posicion(7, 7);		
		Posicion posicionNueva3 = new Posicion(14, 7);
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		Arriba direccion = new Arriba();
		
		batallon.mover(direccion);
		
		assertEquals(posicionNueva1.getFila(),entidad1.getPosicion().getFila());
		assertEquals(posicionNueva2.getFila(),entidad2.getPosicion().getFila());
		assertEquals(posicionNueva3.getFila(),entidad3.getPosicion().getFila());

	}
	
	@Test
	public void verificarQueTodosLosIntegrantesDelBatallonSeMuevenUnaPosicionArribaDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(3, 7);
		Posicion posicion2 = new Posicion(8, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(2, 8);
		Posicion posicionNueva2 = new Posicion(7, 8);		
		Posicion posicionNueva3 = new Posicion(14, 8);
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		ArribaDerecha direccion = new ArribaDerecha();
		
		batallon.mover(direccion);
		
		assertTrue(posicionNueva1.getPosicion().mismaPosicion(entidad1.getPosicion(), posicionNueva1));
		assertTrue(posicionNueva2.getPosicion().mismaPosicion(entidad2.getPosicion(), posicionNueva2));
		assertTrue(posicionNueva3.getPosicion().mismaPosicion(entidad3.getPosicion(), posicionNueva3));
	}
	
	@Test
	public void verificarQueTodosLosIntegrantesDelBatallonSeMuevenUnaPosicionArribaIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(3, 7);
		Posicion posicion2 = new Posicion(8, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(2, 6);
		Posicion posicionNueva2 = new Posicion(7, 6);		
		Posicion posicionNueva3 = new Posicion(14, 6);
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		ArribaIzquierda direccion = new ArribaIzquierda();
		
		batallon.mover(direccion);
		
		assertTrue(posicionNueva1.getPosicion().mismaPosicion(entidad1.getPosicion(), posicionNueva1));
		assertTrue(posicionNueva2.getPosicion().mismaPosicion(entidad2.getPosicion(), posicionNueva2));
		assertTrue(posicionNueva3.getPosicion().mismaPosicion(entidad3.getPosicion(), posicionNueva3));
	}
	
	@Test
	public void verificarQueTodosLosIntegrantesDelBatallonSeMuevenUnaPosicionAbajo() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(3, 7);
		Posicion posicion2 = new Posicion(8, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(4, 7);
		Posicion posicionNueva2 = new Posicion(9, 7);		
		Posicion posicionNueva3 = new Posicion(16, 7);
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		Abajo direccion = new Abajo();
		
		batallon.mover(direccion);
		
		assertEquals(posicionNueva1.getFila(),entidad1.getPosicion().getFila());
		assertEquals(posicionNueva2.getFila(),entidad2.getPosicion().getFila());
		assertEquals(posicionNueva3.getFila(),entidad3.getPosicion().getFila());

	}
	
	@Test
	public void verificarQueTodosLosIntegrantesDelBatallonSeMuevenUnaPosicionAbajoDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(6, 9);
		Posicion posicion2 = new Posicion(15, 5);		
		Posicion posicion3 = new Posicion(19, 10);
		Posicion posicionNueva1 = new Posicion(7, 10);
		Posicion posicionNueva2 = new Posicion(16, 6);		
		Posicion posicionNueva3 = new Posicion(20, 11);
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		AbajoDerecha direccion = new AbajoDerecha();
		
		batallon.mover(direccion);
		
		assertTrue(posicionNueva1.getPosicion().mismaPosicion(entidad1.getPosicion(), posicionNueva1));
		assertTrue(posicionNueva2.getPosicion().mismaPosicion(entidad2.getPosicion(), posicionNueva2));
		assertTrue(posicionNueva3.getPosicion().mismaPosicion(entidad3.getPosicion(), posicionNueva3));
	}
	
	@Test
	public void verificarQueTodosLosIntegrantesDelBatallonSeMuevenUnaPosicionAbajoIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(15, 17);
		Posicion posicion2 = new Posicion(18, 6);		
		Posicion posicion3 = new Posicion(0, 1);
		Posicion posicionNueva1 = new Posicion(16, 16);
		Posicion posicionNueva2 = new Posicion(19, 5);		
		Posicion posicionNueva3 = new Posicion(1, 0);
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		AbajoIzquierda direccion = new AbajoIzquierda();
		
		batallon.mover(direccion);
		
		assertTrue(posicionNueva1.getPosicion().mismaPosicion(entidad1.getPosicion(), posicionNueva1));
		assertTrue(posicionNueva2.getPosicion().mismaPosicion(entidad2.getPosicion(), posicionNueva2));
		assertTrue(posicionNueva3.getPosicion().mismaPosicion(entidad3.getPosicion(), posicionNueva3));
	}
	
	@Test
	public void verificarQueTodosLosIntegrantesDelBatallonSeMuevenUnaPosicionDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(3, 7);
		Posicion posicion2 = new Posicion(8, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(3, 8);
		Posicion posicionNueva2 = new Posicion(8, 8);		
		Posicion posicionNueva3 = new Posicion(15, 8);
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		Derecha direccion = new Derecha();
		
		batallon.mover(direccion);
		
		assertEquals(posicionNueva1.getFila(),entidad1.getPosicion().getFila());
		assertEquals(posicionNueva2.getFila(),entidad2.getPosicion().getFila());
		assertEquals(posicionNueva3.getFila(),entidad3.getPosicion().getFila());

	}
	
	@Test
	public void verificarQueTodosLosIntegrantesDelBatallonSeMuevenUnaPosicionIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicion1 = new Posicion(3, 7);
		Posicion posicion2 = new Posicion(8, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(3, 6);
		Posicion posicionNueva2 = new Posicion(8, 6);		
		Posicion posicionNueva3 = new Posicion(15, 6);
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		Izquierda direccion = new Izquierda();
		
		batallon.mover(direccion);
		
		assertEquals(posicionNueva1.getFila(),entidad1.getPosicion().getFila());
		assertEquals(posicionNueva2.getFila(),entidad2.getPosicion().getFila());
		assertEquals(posicionNueva3.getFila(),entidad3.getPosicion().getFila());

	}
	
	@Test
	public void verificarQueElCostoQueDevuelveEsCero() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Candela",aliado);
		
		Posicion posicion1 = new Posicion(3, 7);
		Posicion posicion2 = new Posicion(8, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		assertTrue(batallon.getCosto() == 0);
	}
	
	@Test
	public void verificarQueLaVidaQueDevuelveEsSinAtaque() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Candela",aliado);
		
		Posicion posicion1 = new Posicion(3, 7);
		Posicion posicion2 = new Posicion(8, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		
		jugador.agregarEntidad("soldado", posicion1.getFila(), posicion1.getColumna());
		jugador.agregarEntidad("soldado", posicion2.getFila(), posicion2.getColumna());
		jugador.agregarEntidad("soldado", posicion3.getFila(), posicion3.getColumna());
				
		Entidad entidad1 = jugador.getEntidad(posicion1);
		Entidad entidad2 = jugador.getEntidad(posicion2);
		Entidad entidad3 = jugador.getEntidad(posicion3);

		Soldado soldadoAux = new Soldado();
		
		soldadoAux.formarListaDeSoldados((Soldado) entidad1);
		soldadoAux.formarListaDeSoldados((Soldado) entidad2);
		soldadoAux.formarListaDeSoldados((Soldado) entidad3);
		
		Batallon batallon = new Batallon(soldadoAux.getListaBatallon());
		
		assertTrue(batallon.getVida() == 100);
	}
	
}

