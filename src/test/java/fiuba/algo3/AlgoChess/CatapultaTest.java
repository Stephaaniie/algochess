package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Bandos.Enemigo;
import fiuba.algo3.AlgoChess.Direccion.Abajo;
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Entidades.Catapulta;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.Jinete;
import fiuba.algo3.AlgoChess.Entidades.Soldado;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.CatapultaNoSeMueveExcepcion;
import fiuba.algo3.AlgoChess.Jugador.Jugador;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class CatapultaTest {
	@Test
	public void catapultaAtacadaPierdeVida() {
		Catapulta catapulta = new Catapulta();
		catapulta.recibirDanio(10);
		assertEquals(40, catapulta.getVida());
	}

	@Test
    public void catapultaAtacaAJineteYLeRestaVida() {
	    Catapulta catapulta = new Catapulta();
	    Jinete jinete = new Jinete();

	    catapulta.atacarEnemigo();

	    assertEquals(100, jinete.getVida());
    }

    @Test
    public void catapultaAtacaASoldadoYLeRestaVida() {
	    Catapulta catapulta = new Catapulta();
	    Soldado soldado = new Soldado();

	    catapulta.atacarEnemigo();

	    assertEquals(100, soldado.getVida());
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
			
			Tablero tablero = new Tablero(20);
			
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
}
