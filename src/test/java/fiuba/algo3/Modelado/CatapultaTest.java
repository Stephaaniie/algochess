package fiuba.algo3.Modelado;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.Modelado.Bandos.Aliado;
import fiuba.algo3.Modelado.Bandos.Enemigo;
import fiuba.algo3.Modelado.Direccion.Abajo;
import fiuba.algo3.Modelado.Direccion.Direccion;
import fiuba.algo3.Modelado.Entidades.Catapulta;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.Modelado.Excepciones.CatapultaNoSeMueveExcepcion;
import fiuba.algo3.Modelado.Jugador.Jugador;
import fiuba.algo3.Modelado.Tablero.Posicion;
import fiuba.algo3.Modelado.Tablero.Tablero;

public class CatapultaTest {
	@Test
	public void catapultaAtacadaPierdeVida() {
		Catapulta catapulta = new Catapulta();
		catapulta.recibirDanio(10);
		assertEquals(40, catapulta.getVida());
	}
    
    @Test 
    public void catapultaIntentaMoverse() {
    	boolean capturoError = false;
    	
    	Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();
		
		Jugador jugador = new Jugador("Camila",aliado, "SantiLocateli",enemigo);
		
		Posicion posicionVieja = new Posicion(15, 6);
		
		try {
			jugador.agregarEntidad("catapulta", posicionVieja);
			
			Tablero tablero = new Tablero();
			
			Entidad entidad = jugador.getEntidad(posicionVieja);
			
			tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
			
			Direccion direccion = new Abajo();
			
			entidad.mover(direccion);
		}catch(CatapultaNoSeMueveExcepcion e) {
			capturoError = true;
		}
		assertEquals(capturoError,true);
    }
    @Test
	public void agregarEntidad() {
		
		boolean respuesta = false;
		
		Enemigo enemigo = new Enemigo();
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", enemigo);
		
		Posicion posicion = new Posicion(16, 7);
		
		jugador.agregarEntidad("catapulta", posicion);
		
		Entidad entidad  = jugador.getEntidad(posicion);
		
		try {
			entidad.agregar(entidad);
		}catch(CasilleroOcupadoExcepcion e) {
			respuesta = true;
		}
		assertEquals( respuesta, true);
	}
    /*
    @Test
    public void implementarAtaqueMasivoDeCatapulta() {
    	Enemigo enemigo = new Enemigo();
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Mirtha",aliado, "Susana", enemigo);
		
		Posicion posicion = new Posicion(10, 8);
		
		Posicion posicion3 = new Posicion(10, 2);
		Posicion posicion5 = new Posicion(16, 8);
		Posicion posicion6 = new Posicion(16, 7);
		
		jugador.agregarEntidad("catapulta", posicion);
		jugador.agregarEntidad("soldado", posicion3);
		jugador.agregarEntidad("curandero", posicion5);
		jugador.agregarEntidad("jinete", posicion6);
    
		Tablero tablero = new Tablero();

		tablero.agregarEntidadEnCasillero(jugador.getEntidad(posicion),posicion);
		tablero.agregarEntidadEnCasillero(jugador.getEntidad(posicion3),posicion3);
		tablero.agregarEntidadEnCasillero(jugador.getEntidad(posicion5),posicion5);
		tablero.agregarEntidadEnCasillero(jugador.getEntidad(posicion6),posicion6);
		
		jugador.getEntidad(posicion).atacarEnemigo();

		assertEquals(jugador.getEntidad(posicion3).getVida(),100);
		assertEquals(jugador.getEntidad(posicion5).getVida(),75);
		assertEquals(jugador.getEntidad(posicion6).getVida(),100);
    }
    @Test
	public void verificarQueSeAtacaCorrectamenteConSuArma() {
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Agus",aliado,"Agus",enemigo);
		
		Posicion posicion  = new Posicion(5,6);
		Posicion posicion1 = new Posicion(15,5);
		
		jugador.agregarEntidad("catapulta", posicion);
		Entidad catapulta = jugador.getEntidad(posicion);
									
		jugador.obtenerSiguienteJugador().agregarEntidad("soldado", posicion1);
		Entidad soldado1  = jugador.obtenerSiguienteJugador().getEntidad(posicion1);

		Tablero tablero = new Tablero();			
			
		tablero.agregarEntidadEnCasillero(catapulta ,posicion);
		tablero.agregarEntidadEnCasillero(soldado1,posicion1);
		
		catapulta.atacarEnemigo();
		
		assertEquals(soldado1.getVida(),100);
	}
	*/
}
