package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Bandos.Enemigo;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.Jugador.Jugador;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class TableroTest {
	@Test
	public void seCreaTableroSinProblema() {
		Tablero tablero = new Tablero(20);
		
		assertNotNull(tablero);
	}
	
	@Test 
	public void tableroCargaTodosSusCamposCorrectamente() {
		Tablero tablero = new Tablero(20);
		
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
		Jugador jugadores = new Jugador("Carly",enemigo,"Manuel",aliado);
		
		try {
			jugadores.agregarEntidad("jinete", new Posicion(20, 9));
			jugadores.agregarEntidad("soldado", new Posicion(9, 10));
			
			Tablero tablero = new Tablero(20);
			
			Entidad entidad  =  jugadores.getEntidad(new Posicion(7,9));
			Entidad entidad2 = jugadores.getEntidad(new Posicion(11,10));
			
			tablero.agregarEntidadEnCasillero(entidad, new Posicion( 20, 9));
			tablero.agregarEntidadEnCasillero(entidad2, new Posicion( 9, 10));
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
		
		Jugador jugadores = new Jugador("Manuel", aliado, "Carly",enemigo);
		
		try {
			jugadores.agregarEntidad("jinete", new Posicion(0, 9));
			jugadores.agregarEntidad("soldado", new Posicion(11, 10));
			
			Tablero tablero = new Tablero(20);
			
			Entidad entidad = jugadores.getEntidad(new Posicion(7,9));
			Entidad entidad2 = jugadores.getEntidad(new Posicion(11,10));
			
			tablero.agregarEntidadEnCasillero(entidad,new Posicion( 20, 9));
			tablero.agregarEntidadEnCasillero(entidad2,new Posicion( 9, 10));
		}catch( ColocarUnidadEnSectorEnemigoExcepcion e){
			excepcion = true;
		}
		assertEquals(excepcion,true);
	}
	
	@Test 
	public void posicionarEntidadesAliadasEnSuSector() {
		
		Aliado aliado = new Aliado();
		
		boolean excepcion = false;
		
		Jugador jugadores = new Jugador("Manuel",aliado, "Chary", aliado);		
		try {
			jugadores.agregarEntidad("jinete",new Posicion( 0, 9));
			
			Tablero tablero = new Tablero(20);
			
			Entidad entidad = jugadores.getEntidad(new Posicion(7,9));
			
			tablero.agregarEntidadEnCasillero(entidad, new Posicion(0, 9));
		}catch( ColocarUnidadEnSectorEnemigoExcepcion e){
			excepcion = true;
		}
		assertEquals(excepcion,true);
	}
	
	@Test
	public void eliminarDelTableroUnaEntidad() {
		
		Aliado aliado = new Aliado();
				
		boolean respuesta = false;
				
		Jugador jugador1 = new Jugador("Manuel",aliado, "Clotilde", aliado);		
		
		jugador1.agregarEntidad("jinete", new Posicion(20, 9));
		try {
			Tablero tablero = new Tablero(20);
			
			Entidad entidad = jugador1.getEntidad(new Posicion(7,9));
			
			tablero.agregarEntidadEnCasillero(entidad, new Posicion( 15, 9));
		
			jugador1.eliminarEntidad(entidad);
			tablero.getEntidadEnPosicion(entidad.getPosicion());
		}catch( ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		
		assertEquals(respuesta,true);
	}
	
	
}
