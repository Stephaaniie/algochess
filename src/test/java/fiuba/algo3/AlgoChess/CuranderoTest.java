package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
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
import fiuba.algo3.AlgoChess.Entidades.Catapulta;
import fiuba.algo3.AlgoChess.Entidades.Curandero;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.Jinete;
import fiuba.algo3.AlgoChess.Entidades.Soldado;
import fiuba.algo3.AlgoChess.Excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.CuranderoNoPuedeAtacarExepcion;
import fiuba.algo3.AlgoChess.Excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.Jugador.Jugador;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;



public class CuranderoTest {
	@Before
	@Test
	public void curanderoSeCreaConElCostoCorrecto() {
		Curandero curandero = new Curandero();

		assertEquals(2, curandero.getCosto());

	}
	
	@Test
	public void curanderoRecibeElBandoDelJugadorQueLoAdquiere() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", aliado);
		
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
		} catch (CuranderoCuraHastaLaMaximaVidaExcepcion | ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			assertEquals(30, catapulta.getVida());
		}
	}

	@Test
	public void curanderoSeLeDecrementaLaVidaYSeAutoCura() {
		Curandero curandero = new Curandero();
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
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(18, 8);
		Posicion posicionNueva = new Posicion(17, 8);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
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
		
		Tablero tablero =  new Tablero(20);
		
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
		
		Tablero tablero = new Tablero(20);
		
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
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
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
		
		Jugador jugador = new Jugador("Charli",aliado ,"Carlos", aliado);
		
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
		
		Jugador jugador = new Jugador("Laura",aliado, "Sofia", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 6);
		
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
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 8);
		
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
		
		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli", aliado);
		
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
	public void curanderoNoPuedeMoverseACasilleroOcupado() {		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", aliado);
		
		Posicion posicionVieja1 = new Posicion(17, 8);
		Posicion posicionVieja  = new Posicion(16, 7);
		Posicion posicionNueva  = new Posicion(17, 8);
		
		jugador.agregarEntidad("curandero", posicionVieja1);
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero(20);
		
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
}
