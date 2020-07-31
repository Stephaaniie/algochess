package fiuba.algo3.Modelado;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class JineteTest {
	/*
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
		
		Tablero tablero = new Tablero();
		
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
		
		Tablero tablero = new Tablero();
		
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
		
		jugador.agregarEntidad("jinete", posicionVieja);
		
		Tablero tablero = new Tablero();
		
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
		
		jugador.agregarEntidad("jinete", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new Izquierda();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	@Test
	public void jineteSeMueveParaArribaALaDerecha() {

		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(14, 7);
		
		jugador.agregarEntidad("jinete", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new ArribaDerecha();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void jineteSeMueveParaAbajoALaIzquierda() {

		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(16, 5);
		
		jugador.agregarEntidad("jinete", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new AbajoIzquierda();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void jineteSeMueveParaAbajoALaDerecha() {

		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(16, 7);
		
		jugador.agregarEntidad("jinete", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void jineteSeMueveParaArribaALaIzquierda() {

		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(14, 5);
		
		jugador.agregarEntidad("jinete", posicionVieja);
		
		Tablero tablero = new Tablero();
		
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
		
		Tablero tablero = new Tablero();
		
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
		
		jugador.agregarEntidad("jinete", posicion);
		
		Entidad entidad  = jugador.getEntidad(posicion);
		
		try {
			entidad.agregar(entidad);
		}catch(CasilleroOcupadoExcepcion e) {
			respuesta = true;
		}
		assertEquals( respuesta, true);
	}
	
	@Test
	public void jineteCreaASuBuscadorCorrectamente() {
		
		Jinete jinete = new Jinete();
		
		assertNotNull(jinete.getBuscador());
	}
	
	@Test
	public void jineteCreaSuArmaCorrectamente() {
		Jinete jinete = new Jinete();
				
		assertNotNull(jinete.getArma());
	}
	/* no puede realizar el ataque porque la entidad le llega como objeto nulo
	@Test 
	public void posicionarUnEnemigoYVerificarQueLoAtacaConEspada() {
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Cami",aliado, "Agus",enemigo);
		
		Posicion posicion  = new Posicion(9,5);
		Posicion posicion1 = new Posicion(11,5);
		
		jugador.agregarEntidad("jinete", posicion);
		Entidad jinete = jugador.getEntidad(posicion);			
			
		jugador.obtenerSiguienteJugador().agregarEntidad("soldado", posicion1);
		Entidad soldado  = jugador.obtenerSiguienteJugador().getEntidad(posicion1);

		Tablero tablero = new Tablero();			
			
		tablero.agregarEntidadEnCasillero(jinete ,posicion);
		tablero.agregarEntidadEnCasillero(soldado,posicion1);
		
		jinete.atacarEnemigo();
		
		assertEquals(soldado.getVida(),80);
	}
	
	@Test 
	public void posicionarUnEnemigoYVerificarQueLoAtacaConArcoYfrecha() {
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Cami",aliado, "Agus",enemigo);
		
		Posicion posicion  = new Posicion(9,5);
		Posicion posicion1 = new Posicion(8,4);
		Posicion posicion2 = new Posicion(11,5);
		
		jugador.agregarEntidad("jinete", posicion);
		jugador.agregarEntidad("soldado", posicion1);

		Entidad jinete  = jugador.getEntidad(posicion);
		Entidad soldadoAliado = jugador.getEntidad(posicion1);
			
		jugador.obtenerSiguienteJugador().agregarEntidad("soldado", posicion2);
		Entidad soldado  = jugador.obtenerSiguienteJugador().getEntidad(posicion2);

		Tablero tablero = new Tablero();			
			
		tablero.agregarEntidadEnCasillero(jinete ,posicion);
		tablero.agregarEntidadEnCasillero(soldadoAliado, posicion1);
		tablero.agregarEntidadEnCasillero(soldado,posicion1);
		
		jinete.atacarEnemigo();
		
		assertEquals(soldado.getVida(),80);
	}
	*/
}