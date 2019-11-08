package fiuba.algo3.AlgoChess;

import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorTest {

	@Test
	public void SeCreaJugadorSinEntidadesTest() {

		Jugador nuevoJugador = new Jugador("pedro");

		assertEquals(false, nuevoJugador.tieneEntidades());
	}

	@Test
	public void PuntosIncialesCorrectosTest() {

		Jugador nuevoJugador = new Jugador("pedro");

		assertEquals(20, nuevoJugador.cantidadDePuntosActual());
	}

	@Test
	public void DescontarUnPuntoPorAdquirirSoldadoTest() {

		Casillero casillero = new Casillero(1, 2);

		Soldado soldado = new Soldado("aliado", casillero);

		Jugador nuevoJugador = new Jugador("pedro");

		nuevoJugador.descontarPuntos(soldado.getCosto());

		assertEquals(19, nuevoJugador.cantidadDePuntosActual());
	}

	@Test
	public void DescontarTresPuntoPorAdquirirJineteTest() {

		Casillero casillero = new Casillero(9, 9);

		Jinete jinete = new Jinete("aliado", casillero);

		Jugador nuevoJuego = new Jugador("pedro");

		nuevoJuego.descontarPuntos(jinete.getCosto());

		assertEquals(17, nuevoJuego.cantidadDePuntosActual());
	}

	@Test
	public void DescontarDosPuntosPorAdquirirCuranderoTest() {
		Casillero casillero = new Casillero(5, 2);

		Curandero curandero = new Curandero("aliado", casillero);

		Jugador nuevoJugador = new Jugador("pedro");

		nuevoJugador.descontarPuntos(curandero.getCosto());

		assertEquals(18, nuevoJugador.cantidadDePuntosActual());
	}

	@Test
	public void DescontarCincoPuntosPorAdquirirCatapultaTest() {
		Casillero casillero = new Casillero(3, 2);

		Catapulta catapulta = new Catapulta("aliado", casillero);

		Jugador nuevoJugador = new Jugador("pedro");

		nuevoJugador.descontarPuntos(catapulta.getCosto());

		assertEquals(15, nuevoJugador.cantidadDePuntosActual());
	}

	@Test
	public void SeCreaJugadorYAdquiereEntidadYDevuelveTrueTest() {

		Casillero casillero = new Casillero(3, 2);

		Catapulta catapulta = new Catapulta("aliado", casillero);

		Jugador nuevoJugador = new Jugador("pedro");

		nuevoJugador.descontarPuntos(catapulta.getCosto());

		assertEquals(true, nuevoJugador.tieneEntidades());
	}

	@Test
	public void jugadorSinEntidadesEsPerdedor() {
		Jugador nuevoJugador = new Jugador("pedro");

		assertEquals(true, nuevoJugador.esPerdedor());
	}

	@Test
	public void jugadorSinPuntosNoPuedeCrearMasEntidadesTest() {

		Casillero casillero = new Casillero(1, 2);

		Soldado soldado = new Soldado("aliado", casillero);

		Catapulta catapulta = new Catapulta("aliado", casillero);

		Jugador nuevoJugador = new Jugador("pedro");

		nuevoJugador.descontarPuntos(catapulta.getCosto());

		nuevoJugador.descontarPuntos(catapulta.getCosto());

		nuevoJugador.descontarPuntos(catapulta.getCosto());

		nuevoJugador.descontarPuntos(catapulta.getCosto());

		nuevoJugador.descontarPuntos(soldado.getCosto());

		assertEquals(false, nuevoJugador.puedeCargarMasEntidades());
	}
}
