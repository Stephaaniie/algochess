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
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Direccion.Izquierda;
import fiuba.algo3.AlgoChess.Entidades.Curandero;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.Soldado;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class SoldadoTest {
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
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(15, 7);
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new Arriba();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void soldadoSeMueveParaAbajo() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 7);
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new Abajo();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void soldadoSeMueveParaLaIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(16, 6);
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new Izquierda();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void soldadoSeMueveParaLaDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(16, 8);
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new Derecha();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaArribaALaDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(15, 8);
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new ArribaDerecha();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaAbajoALaIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 6);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new AbajoIzquierda();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaAbajoALaDerecha() {
	
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 8);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaArribaALaIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(15, 6);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new ArribaIzquierda();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	

	@Test
	public void soldadoNoPuedeMoverseACasilleroOcupado() {		

		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja1 = new Posicion(17, 8);
		Posicion posicionVieja  = new Posicion(16, 7);
		Posicion posicionNueva  = new Posicion(17, 8);
		
		jugador.agregarEntidad("soldado", posicionVieja1);
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad  = jugador.getEntidad(posicionVieja);
		Entidad entidad1 = jugador.getEntidad(posicionVieja1);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		tablero.agregarEntidadEnCasillero(entidad1,posicionVieja1);

		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);
		
		assertTrue(entidad1.getPosicion().mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
}