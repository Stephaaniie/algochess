package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Bandos.Enemigo;
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
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Jugador.Jugador;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class JineteTest {
	@Test 
	public void jineteconBando() {
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Violeta", aliado);
		
		Posicion posicion = new Posicion(16, 7);
		
		jugador.agregarEntidad("curandero", posicion);
				
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
	public void jineteSeMueveParaAbajo() {
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();
		
		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(16, 6);
		
		jugador.agregarEntidad("jinete", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new Abajo();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
		
	}

	@Test
	public void jineteSeMueveParaArriba() {
		
		Aliado aliado = new Aliado();
		
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(14, 6);
		
		jugador.agregarEntidad("jinete", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new Arriba();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));

	}

	@Test
	public void jineteSeMueveParaLaDerecha() {
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(15, 7);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new Derecha();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void jineteSeMueveParaLaIzquierda() {
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();
		
		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(15, 5);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new Izquierda();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	@Test
	public void soldadoSeMueveParaArribaALaDerecha() {

		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(14, 7);
		
		jugador.agregarEntidad("jinete", posicionVieja);
		
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
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(16, 5);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new AbajoIzquierda();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaAbajoALaDerecha() {

		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(16, 7);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaArribaALaIzquierda() {

		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(14, 5);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new ArribaIzquierda();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void jineteNoPuedeMoverseACasilleroOcupado() {
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja1 = new Posicion(17, 8);
		Posicion posicionVieja  = new Posicion(16, 7);
		Posicion posicionNueva  = new Posicion(17, 8);
		
		jugador.agregarEntidad("jinete", posicionVieja1);
		jugador.agregarEntidad("jinete", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
		Entidad entidad  = jugador.getEntidad(posicionVieja);
		Entidad entidad1 = jugador.getEntidad(posicionVieja1);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		tablero.agregarEntidadEnCasillero(entidad1,posicionVieja1);

		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);
		
		assertTrue(entidad1.getPosicion().mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void agregarEntidad() {
		
		boolean respuesta = false;
		
		Enemigo enemigo = new Enemigo();
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", enemigo);
		
		Posicion posicion = new Posicion(16, 7);
		
		jugador.agregarEntidad("curandero", posicion);
		
		Entidad entidad  = jugador.getEntidad(posicion);
		
		try {
			entidad.agregar(entidad);
		}catch(CasilleroOcupadoExcepcion e) {
			respuesta = true;
		}
		assertEquals( respuesta, true);
	}
}