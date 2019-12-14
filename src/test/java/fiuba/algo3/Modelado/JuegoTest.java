package fiuba.algo3.Modelado;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import fiuba.algo3.Modelado.Juego.Juego;

public class JuegoTest {

	@Test
	public void probarQueSeCreaCorrectamenteElJugadorYDevuelveUnJugadorEnemigo() {
		
		Juego juego = new Juego("Dori", "Nemo");
		
		assertNotNull(Juego.getJugadorAliado());
	}
	
	@Test
	public void probarQueSeCreaCorrectamenteElJugadorYDevuelveUnJugadorAliado() {
		
		Juego juego = new Juego("Messi", "Maradona");
		
		assertNotNull(Juego.getJugadorEnemigo());
	}
	
	@Test
	public void devuelveElTableroDelJuego() {
		
		Juego juego = new Juego("Tomas", "Diego");
		
		assertNotNull(juego.getTablero());
	}
	
	@Test
	public void seCreaJuegoYDevuelveUnaInstancia() {
		
		Juego juego = new Juego("Claudia", "Valeria");
		
		assertNotNull(Juego.getInstanciaJuego("Claudia", "Valeria"));
	}
	
	@Test 
	public void 
}
