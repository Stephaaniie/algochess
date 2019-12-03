package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Bandos.Enemigo;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class TableroTest {
	@Before
	@Test
	public void seCreaTableroSinProblema() {
		Tablero tablero = Tablero.getInstanciaTablero();
		
		assertNotNull(tablero);
	}
	
	@Test 
	public void tableroCargaTodosSusCamposCorrectamente() {
		Tablero tablero = Tablero.getInstanciaTablero();
		
		int tamanio  = tablero.tamanioTablero();
		int casilleros = tablero.cantidadCasilleros();
		int entidades  = tablero.getEntidadesEnTablero().size();
		
		assertEquals(tamanio,20);
		assertEquals(casilleros,0);
		assertEquals(entidades, 0);
	}
	@Test 
	public void noSePuedePonerEntidadEnemigaEnSectorAliado() {
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();
		
		boolean excepcion = false;
		
		Jugador jugador1 = new Jugador("Manuel",aliado);
		Jugador jugador2 = new Jugador("Carly",enemigo);
		
		try {
			jugador1.agregarEntidad("jinete", 20, 9);
			jugador2.agregarEntidad("soldado", 9, 10);
			
			Tablero tablero = Tablero.getInstanciaTablero();
			
			Entidad entidad = jugador1.getEntidad(new Posicion(7,9));
			Entidad entidad2 = jugador2.getEntidad(new Posicion(11,10));
			
			tablero.agregarEntidadEnCasillero(entidad, 20, 9);
			tablero.agregarEntidadEnCasillero(entidad2, 9, 10);
		}catch( ColocarUnidadEnSectorEnemigoExcepcion e){
			excepcion = true;
		}
		assertEquals(excepcion,true);

	}
	
	@Test 
	public void noSePuedePonerEntidadAliadaEnSectorEnemigo() {
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();
		
		boolean excepcion = false;
		
		Jugador jugador1 = new Jugador("Manuel",aliado);
		Jugador jugador2 = new Jugador("Carly",enemigo);
		
		try {
			jugador1.agregarEntidad("jinete", 0, 9);
			jugador2.agregarEntidad("soldado", 11, 10);
			
			Tablero tablero = Tablero.getInstanciaTablero();
			
			Entidad entidad = jugador1.getEntidad(new Posicion(7,9));
			Entidad entidad2 = jugador2.getEntidad(new Posicion(11,10));
			
			tablero.agregarEntidadEnCasillero(entidad, 20, 9);
			tablero.agregarEntidadEnCasillero(entidad2, 9, 10);
		}catch( ColocarUnidadEnSectorEnemigoExcepcion e){
			excepcion = true;
		}
		assertEquals(excepcion,true);
	}
	
	@Test 
	public void posicionarEntidadesAliadasEnSuSector() {
		
		Aliado aliado = new Aliado();
		
		boolean excepcion = false;
		
		Jugador jugador1 = new Jugador("Manuel",aliado);		
		try {
			jugador1.agregarEntidad("jinete", 0, 9);
			
			Tablero tablero = Tablero.getInstanciaTablero();
			
			Entidad entidad = jugador1.getEntidad(new Posicion(7,9));
			
			tablero.agregarEntidadEnCasillero(entidad, 0, 9);
		}catch( ColocarUnidadEnSectorEnemigoExcepcion e){
			excepcion = true;
		}
		assertEquals(excepcion,true);
	}
	
	@Test
	public void eliminarDelTableroUnaEntidad() {
		
		Aliado aliado = new Aliado();
				
		boolean respuesta = false;
				
		Jugador jugador1 = new Jugador("Manuel",aliado);		
		
		jugador1.agregarEntidad("jinete", 20, 9);
			
		Tablero tablero = Tablero.getInstanciaTablero();
			
		Entidad entidad = jugador1.getEntidad(new Posicion(7,9));
			
		tablero.agregarEntidadEnCasillero(entidad, 0, 9);
		try {
			jugador1.eliminarEntidad(entidad);
			tablero.getEntidadEnPosicion(entidad.getPosicion());
		}catch( ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		
		assertEquals(respuesta,true);
	}
	
	
}
