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
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Direccion.Izquierda;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.Jinete;
import fiuba.algo3.AlgoChess.Entidades.Soldado;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class JineteTest {
	@Before
	@Test 
	public void jineteconBando() {
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado);
		
		Posicion posicion = new Posicion(6, 7);
		
		jugador.agregarEntidad("curandero", posicion.getFila(), posicion.getColumna());
				
		Entidad entidad = jugador.getEntidad(posicion);
						
		assertTrue(entidad.getBando() == aliado);
		
	}
	@Test
	public void jineteRecuperaVidaTest() {

		Jinete jinete = new Jinete();
		jinete.reponerVida(10);
		
		assertEquals(100, jinete.getVida());
	}
	
	@Test
	public void jineteAtacadoPierdeVidaTest() {

		Jinete jinete = new Jinete();
		jinete.recibirDanio(20);
		
		assertEquals(80, jinete.getVida());
	}
	
	@Test
	public void noSePuedeAgregarEntidadYLanzaExcepcion() {

		boolean entroEnExcepcion = false;
		Jinete jinete = new Jinete();
		Jinete jinete1 = new Jinete();
		try {
			jinete.agregar(jinete1);
		}catch(Exception e){
			entroEnExcepcion =true;
		}
		
		assertTrue(entroEnExcepcion);
	}
	
	@Test
	public void jineteAtacaAEntidadEnDistanciaCorta() {

		Jinete jinete = new Jinete();
		Soldado soldado = new Soldado();

		jinete.atacarEnemigo();

		assertEquals(100, soldado.getVida());
	}

	@Test
	public void jineteAtacaAEntidadEnDistanciaMedia() {
		
		Jinete jinete = new Jinete();
		Soldado soldado = new Soldado();

		jinete.atacarEnemigo();

		assertEquals(100, soldado.getVida());
	}
	
	@Test
	public void jineteSeMueveParaAbajo() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Camila",aliado);
		
		Posicion posicionVieja = new Posicion(5, 6);
		Posicion posicionNueva = new Posicion(6, 6);
		
		jugador.agregarEntidad("jinete", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new Abajo();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
		
	}

	@Test
	public void jineteSeMueveParaArriba() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Camila",aliado);
		
		Posicion posicionVieja = new Posicion(5, 6);
		Posicion posicionNueva = new Posicion(4, 6);
		
		jugador.agregarEntidad("jinete", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new Arriba();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));

	}

	@Test
	public void jineteSeMueveParaLaDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Camila",aliado);
		
		Posicion posicionVieja = new Posicion(5, 6);
		Posicion posicionNueva = new Posicion(5, 7);
		
		jugador.agregarEntidad("curandero", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new Derecha();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void jineteSeMueveParaLaIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Camila",aliado);
		
		Posicion posicionVieja = new Posicion(5, 6);
		Posicion posicionNueva = new Posicion(5, 5);
		
		jugador.agregarEntidad("curandero", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new Izquierda();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	@Test
	public void soldadoSeMueveParaArribaALaDerecha() {

		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Camila",aliado);
		
		Posicion posicionVieja = new Posicion(5, 6);
		Posicion posicionNueva = new Posicion(4, 7);
		
		jugador.agregarEntidad("jinete", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new ArribaDerecha();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaAbajoALaIzquierda() {

		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Camila",aliado);
		
		Posicion posicionVieja = new Posicion(5, 6);
		Posicion posicionNueva = new Posicion(6, 5);
		
		jugador.agregarEntidad("curandero", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new AbajoIzquierda();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaAbajoALaDerecha() {

		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Camila",aliado);
		
		Posicion posicionVieja = new Posicion(5, 6);
		Posicion posicionNueva = new Posicion(6, 7);
		
		jugador.agregarEntidad("curandero", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaArribaALaIzquierda() {

		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Camila",aliado);
		
		Posicion posicionVieja = new Posicion(5, 6);
		Posicion posicionNueva = new Posicion(4, 5);
		
		jugador.agregarEntidad("curandero", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new ArribaIzquierda();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void jineteNoPuedeMoverseACasilleroOcupado() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado);
		
		Posicion posicionVieja1 = new Posicion(7, 8);
		Posicion posicionVieja  = new Posicion(6, 7);
		Posicion posicionNueva  = new Posicion(7, 8);
		
		jugador.agregarEntidad("jinete", posicionVieja1.getFila(), posicionVieja1.getColumna());
		jugador.agregarEntidad("jinete", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad  = jugador.getEntidad(posicionVieja);
		Entidad entidad1 = jugador.getEntidad(posicionVieja1);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		tablero.agregarEntidadEnCasillero(entidad1,7, 8);

		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);
		
		assertTrue(entidad1.getPosicion().mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
}