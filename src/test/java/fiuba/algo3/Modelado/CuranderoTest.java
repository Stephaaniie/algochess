package fiuba.algo3.Modelado;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CuranderoTest {
	/*@Before
	@Test
	public void curanderoSeCreaConElCostoCorrecto() {
		Curandero curandero = new Curandero();

		assertEquals(2, curandero.getCosto());
	}
	
	@Test
	public void curanderoRecibeElBandoDelJugadorQueLoAdquiere() {
		
		Enemigo enemigo = new Enemigo();
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", enemigo);
		
		Posicion posicion = new Posicion(16, 7);
		
		jugador.agregarEntidad("curandero", posicion);
				
		Entidad entidad = jugador.getEntidad(posicion);
						
		assertTrue(entidad.getBando() == aliado);
	}
	
	@Test
	public void curanderoSeCreaConLaVidaCorrecta() {
		Curandero curandero = new Curandero();

		assertEquals(75, curandero.getVida());

	}

	@Test
	public void seCreaCuranderoConTodosSusAtributosCargados() {
		Curandero curandero = new Curandero();

		assertNotEquals(null, curandero);
	}

	@Test
	public void curanderoCuraUnSoldadoAlDecrementarLaVida() {
		Curandero curandero = new Curandero();
		Soldado soldado = new Soldado();
		soldado.recibirDanio(20);
		curandero.curarEntidad(soldado);

		assertEquals(95, soldado.getVida());
	}

	@Test
	public void curanderoCuraUnJineteDecrementarLaVida() {
		Curandero curandero = new Curandero();
		Jinete jinete = new Jinete();
		jinete.recibirDanio(20);
		curandero.curarEntidad(jinete);

		assertEquals(95, jinete.getVida());
	}

	@Test
	public void curanderoIntentaCurarUnaCatapulta() {
		Curandero curandero = new Curandero();
		Catapulta catapulta = new Catapulta();
		catapulta.recibirDanio(20);
		try {
			curandero.curarEntidad(catapulta);
		} catch (CuranderoNoPuedeRealizarCuracionExcepcion e) {
			assertEquals(30, catapulta.getVida());
		}
	}

	@Test
	public void curanderoSeLeDecrementaLaVidaYSeAutoCura() {
		Curandero curandero = new Curandero();
		curandero.recibirDanio(20);

		try {
			curandero.curarEntidad(curandero);
		} catch (ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			e.printStackTrace();
		}
		assertEquals(70, curandero.getVida());
	}

	@Test
	public void curanderoSeMueveEnDireccionArriba() {
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(18, 8);
		Posicion posicionNueva = new Posicion(17, 8);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new Arriba();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void curanderoSeMueveEnDireccionAbajo() {
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 7);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero =  new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new Abajo();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void curanderoSeMueveEnDireccionDerecha() {
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(16, 8);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new Derecha();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void curanderoSeMueveEnDireccionIzquierda() {
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(16, 6);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new Izquierda();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	@Test
	public void curanderoSeMueveParaArribaALaDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Charli",aliado ,"Carlos", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(15, 8);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new ArribaDerecha();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void curanderooSeMueveParaAbajoALaIzquierda() {
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Sofia", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 6);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new AbajoIzquierda();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void curanderoSeMueveParaAbajoALaDerecha() {
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 8);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void curanderoSeMueveParaArribaALaIzquierda() {
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli", aliado);
		
		Posicion posicionVieja = new Posicion(15, 6);
		Posicion posicionNueva = new Posicion(14, 5);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new ArribaIzquierda();
		
		entidad.mover(direccion);

		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));			
	}

	@Test
	public void curanderoNoPuedeMoverseACasilleroOcupado() {		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", aliado);
		
		Posicion posicionVieja1 = new Posicion(17, 8);
		Posicion posicionVieja  = new Posicion(16, 7);
		Posicion posicionNueva  = new Posicion(17, 8);
		
		jugador.agregarEntidad("curandero", posicionVieja1);
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad  = jugador.getEntidad(posicionVieja);
		Entidad entidad1 = jugador.getEntidad(posicionVieja1);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);

		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);
		
		assertTrue(entidad1.getPosicion().mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test 
	public void curanderoCuraAsusAliados() {
				
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Fernando", aliado);
		
		Posicion posicionVieja1 = new Posicion(17, 8);
		Posicion posicionVieja  = new Posicion(16, 7);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		jugador.agregarEntidad("curandero", posicionVieja1);

		Entidad entidad  = jugador.getEntidad(posicionVieja);
		Entidad entidad1 = jugador.getEntidad(posicionVieja1);

		assertTrue(((Curandero) entidad).puedoCurar(entidad1));

	}

	@Test
	public void curanderoIntentaAtacarEnemigo() {
		
		boolean atrapaError = false;
		
		try {
			Curandero curandero = new Curandero();
			curandero.atacarEnemigo();
		}catch(CuranderoNoPuedeAtacarExepcion e) {
			atrapaError = true;
		}
		assertEquals(atrapaError,true);
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
	
	@Test
	public void curanderoNoPuedeVolverACurarsePorqueTieneMaximaVida() {
		Curandero curandero = new Curandero();
		
		curandero.curarEntidad(curandero);
		
		assertEquals(curandero.getVida(),75);
	}
	
	@Test
	public void curanderoSoloCuraALosDeSuBando() {
		Curandero curandero = new Curandero();
		
		Soldado soldado = new Soldado();
		
		assertTrue(curandero.puedoCurar(soldado));
	}*/
}
