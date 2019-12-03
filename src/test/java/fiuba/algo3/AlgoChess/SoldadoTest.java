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
import fiuba.algo3.AlgoChess.Entidades.Curandero;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.Soldado;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class SoldadoTest {
	@Before
	@Test
	public void soldadoRecuperadoSeLeSumaVidaTest() {
		Soldado soldado = new Soldado();

		soldado.reponerVida(15);

		assertEquals(100, soldado.getVida());
	}

	@Test
	public void soldadoAtacadoPierdeVidaTest() {

		Soldado soldado = new Soldado();

		soldado.recibirDanio(50);

		assertEquals(50, soldado.getVida());
	}

	@Test
	public void soldadoAtacaACuranderoYLeRestaVida() {

		Soldado soldado = new Soldado();
		
		Curandero curandero = new Curandero();
		
		soldado.atacarEnemigo();
		
		assertEquals(75, curandero.getVida());
	}

	@Test
	public void soldadoSeMueveParaArriba() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicionVieja = new Posicion(6, 7);
		Posicion posicionNueva = new Posicion(5, 7);
		
		jugador.agregarEntidad("soldado", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new Arriba();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void soldadoSeMueveParaAbajo() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado);
		
		Posicion posicionVieja = new Posicion(6, 7);
		Posicion posicionNueva = new Posicion(7, 7);
		
		jugador.agregarEntidad("soldado", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new Abajo();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void soldadoSeMueveParaLaIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado);
		
		Posicion posicionVieja = new Posicion(6, 7);
		Posicion posicionNueva = new Posicion(6, 6);
		
		jugador.agregarEntidad("soldado", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new Izquierda();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void soldadoSeMueveParaLaDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado);
		
		Posicion posicionVieja = new Posicion(6, 7);
		Posicion posicionNueva = new Posicion(6, 8);
		
		jugador.agregarEntidad("soldado", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new Derecha();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaArribaALaDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado);
		
		Posicion posicionVieja = new Posicion(6, 7);
		Posicion posicionNueva = new Posicion(5, 8);
		
		jugador.agregarEntidad("soldado", posicionVieja.getFila(), posicionVieja.getColumna());
		
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
		
		Jugador jugador = new Jugador("Tomas",aliado);
		
		Posicion posicionVieja = new Posicion(6, 7);
		Posicion posicionNueva = new Posicion(7, 6);
		
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
		
		Jugador jugador = new Jugador("Laura",aliado);
		
		Posicion posicionVieja = new Posicion(6, 7);
		Posicion posicionNueva = new Posicion(7, 8);
		
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
		
		Jugador jugador = new Jugador("Laura",aliado);
		
		Posicion posicionVieja = new Posicion(6, 7);
		Posicion posicionNueva = new Posicion(5, 6);
		
		jugador.agregarEntidad("curandero", posicionVieja.getFila(), posicionVieja.getColumna());
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,6, 7);
		
		Direccion direccion = new ArribaIzquierda();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	

	@Test
	public void soldadoNoPuedeMoverseACasilleroOcupado() {		

		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado);
		
		Posicion posicionVieja1 = new Posicion(7, 8);
		Posicion posicionVieja  = new Posicion(6, 7);
		Posicion posicionNueva  = new Posicion(7, 8);
		
		jugador.agregarEntidad("soldado", posicionVieja1.getFila(), posicionVieja1.getColumna());
		jugador.agregarEntidad("soldado", posicionVieja.getFila(), posicionVieja.getColumna());
		
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