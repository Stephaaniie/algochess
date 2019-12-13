package fiuba.algo3.Modelado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.Modelado.Bandos.Aliado;
import fiuba.algo3.Modelado.Bandos.Enemigo;
import fiuba.algo3.Modelado.Buscador.RadarDeEntidades;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.Modelado.Jugador.Jugador;
import fiuba.algo3.Modelado.Tablero.Posicion;
import fiuba.algo3.Modelado.Tablero.Tablero;

public class TableroTest {
	@Test
	public void seCreaTableroSinProblema() {
		Tablero tablero = new Tablero();
		
		assertNotNull(tablero);
	}
	
	@Test 
	public void tableroCargaTodosSusCamposCorrectamente() {
		Tablero tablero = new Tablero();
		
		int tamanio  = tablero.getTamanioTablero();
		int casilleros = tablero.getCantidadCasilleros();
		int entidades  = tablero.getEntidadesEnTablero().size();
		
		assertEquals(tamanio,20);
		assertEquals(casilleros,0);
		assertEquals(entidades, 0);
	}
	
	@Test 
	public void posicionarEntidadesAliadasEnSuSector() {
		
		Aliado aliado = new Aliado();
				
		Posicion posicion = new Posicion( 0, 9);
		
		Jugador jugadores = new Jugador("Manuel",aliado, "Chary", aliado);		
		
		jugadores.agregarEntidad("jinete", posicion);
			
		Tablero tablero = new Tablero();
			
		Entidad entidad = jugadores.getEntidad(posicion);
			
		tablero.agregarEntidadEnCasillero(entidad,posicion);
		
		assertNotNull(entidad.getPosicion());
	}
	
	@Test
	public void eliminarDelTableroUnaEntidad() {
		
		Aliado aliado = new Aliado();
				
		boolean respuesta = false;
				
		Jugador jugador1 = new Jugador("Manuel",aliado, "Clotilde", aliado);		
		
		jugador1.agregarEntidad("jinete", new Posicion(20, 9));
		try {
			Tablero tablero = new Tablero();
			
			Entidad entidad = jugador1.getEntidad(new Posicion(7,9));
			
			tablero.agregarEntidadEnCasillero(entidad, new Posicion( 15, 9));
		
			jugador1.estadoDeEntidad(entidad);
			tablero.getEntidadEnPosicion(entidad.getPosicion());
		}catch( ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			respuesta = true;
		}
		
		assertEquals(respuesta,true);
	}
	
	@Test 
    public void utilizacionDelRadarDeEntidadesLaDistanciaMax() {
		
		RadarDeEntidades radar = new RadarDeEntidades(2,6);
		
		assertEquals(radar.getdistanciaMax(),6);
	}
	
	@Test 
    public void utilizacionDelRadarDeEntidadesLaDistanciaMin() {
		
		RadarDeEntidades radar = new RadarDeEntidades(2,6);
		
		assertEquals(radar.getdistanciaMin(),2);
	}
	
	@Test 
    public void utilizacionDelRadarDeEntidadesConUnaDistancia() {
		
		RadarDeEntidades radar = new RadarDeEntidades(2,6);
		
		assertEquals(radar.estaEnElRadar(2),true);
	}
	
	@Test 
    public void utilizacionDelRadarDeEntidadesConUnaDistanciaNoValida() {
		
		RadarDeEntidades radar = new RadarDeEntidades(2,6);
		
		assertEquals(radar.estaEnElRadar(9),false);
	}
	
	@Test
	public void verificarPosicionesAdyacente() {
				
		Posicion posicion = new Posicion(2,2);
		Posicion posicionAdyacente = new Posicion(2,3);
				
		assertEquals(posicion.esPosicionAdyacente(posicion, posicionAdyacente),true);
	}
	
	@Test
	public void verificarQueLaListaDeCasillerosAliadosSeCreanCorrectament() {
		
		Tablero tablero = new Tablero();
		
		assertNotNull(tablero.getSectorAliado());
	}
	
	@Test
	public void verificarQueLaListaDeCasillerosEnemigosSeCreanCorrectament() {
		
		Tablero tablero = new Tablero();
		
		assertNotNull(tablero.getSectorEnemigo());
	}
	
	@Test
	public void seCreaEnTableroCorrectamenteLosJugadores() {
		
		Aliado aliado   = new Aliado();
		Enemigo enemigo = new Enemigo();
		
		Tablero tablero = new Tablero();
		
		tablero.agergarJugadores("Juan", aliado, "Juanito", enemigo);
		
		assertEquals(tablero.getJugador().getNombre(),"Juan");
		assertEquals(tablero.getJugador().obtenerSiguienteJugador().getNombre(),"Juanito");
	}
	
	@Test
	public void agregarEntidadYDevolverEntidad() {
		
		Aliado aliado   = new Aliado();
		Enemigo enemigo = new Enemigo();
		
		Posicion posicion = new Posicion(2,2);
		
		Tablero tablero = new Tablero();
		
		tablero.agergarJugadores("Juan", aliado, "Juanito", enemigo);
		
		tablero.getJugador().agregarEntidad("soldado", posicion);
		
		Entidad entidad = tablero.getJugador().getEntidad(posicion);
		
		tablero.agregarEntidadEnCasillero(entidad, posicion);
				
		
		assertEquals(entidad, tablero.getEntidadEnPosicion(posicion));
	}
}
