package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	@Test
	public void batallonSeCreaCorrectamente() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(14, 7);
		Posicion posicion2 = new Posicion(15, 7);		
		Posicion posicion3 = new Posicion(16, 7);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(14, 7);
		Posicion posicion2 = new Posicion(15, 7);		
		Posicion posicion3 = new Posicion(16, 7);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(14, 7);
		Posicion posicion2 = new Posicion(15, 7);		
		Posicion posicion3 = new Posicion(16, 7);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(14, 7);
		Posicion posicion2 = new Posicion(15, 7);		
		Posicion posicion3 = new Posicion(16, 7);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(13, 7);
		Posicion posicion2 = new Posicion(18, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(12, 7);
		Posicion posicionNueva2 = new Posicion(17, 7);		
		Posicion posicionNueva3 = new Posicion(14, 7);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(13, 7);
		Posicion posicion2 = new Posicion(18, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(12, 8);
		Posicion posicionNueva2 = new Posicion(17, 8);		
		Posicion posicionNueva3 = new Posicion(14, 8);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(13, 7);
		Posicion posicion2 = new Posicion(18, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(12, 6);
		Posicion posicionNueva2 = new Posicion(17, 6);		
		Posicion posicionNueva3 = new Posicion(14, 6);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(13, 7);
		Posicion posicion2 = new Posicion(18, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(14, 7);
		Posicion posicionNueva2 = new Posicion(19, 7);		
		Posicion posicionNueva3 = new Posicion(16, 7);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(16, 9);
		Posicion posicion2 = new Posicion(15, 5);		
		Posicion posicion3 = new Posicion(19, 9);
		Posicion posicionNueva1 = new Posicion(17, 10);
		Posicion posicionNueva2 = new Posicion(16, 6);		
		Posicion posicionNueva3 = new Posicion(20, 10);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(15, 1);
		Posicion posicion2 = new Posicion(18, 6);		
		Posicion posicion3 = new Posicion(17, 5);
		Posicion posicionNueva1 = new Posicion(16, 0);
		Posicion posicionNueva2 = new Posicion(19, 5);		
		Posicion posicionNueva3 = new Posicion(18, 4);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(13, 7);
		Posicion posicion2 = new Posicion(18, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(13, 8);
		Posicion posicionNueva2 = new Posicion(18, 8);		
		Posicion posicionNueva3 = new Posicion(15, 8);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Tomas",aliado, "Berni", aliado);
		
		Posicion posicion1 = new Posicion(13, 7);
		Posicion posicion2 = new Posicion(18, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		Posicion posicionNueva1 = new Posicion(13, 6);
		Posicion posicionNueva2 = new Posicion(18, 6);		
		Posicion posicionNueva3 = new Posicion(15, 6);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
		
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
		
		Jugador jugador = new Jugador("Candela",aliado,"Agus", aliado);
		
		Posicion posicion1 = new Posicion(13, 7);
		Posicion posicion2 = new Posicion(18, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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
		
		Jugador jugador = new Jugador("Candela",aliado, "Zeynep", aliado);
		
		Posicion posicion1 = new Posicion(10, 7);
		Posicion posicion2 = new Posicion(18, 7);		
		Posicion posicion3 = new Posicion(15, 7);
		
		jugador.agregarEntidad("soldado", posicion1);
		jugador.agregarEntidad("soldado", posicion2);
		jugador.agregarEntidad("soldado", posicion3);
				
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

