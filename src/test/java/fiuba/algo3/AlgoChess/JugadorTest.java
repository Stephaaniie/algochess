package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.*;
import fiuba.algo3.AlgoChess.excepciones.*;
import fiuba.algo3.AlgoChess.tablero.Casillero;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {
		
		@Test
		public void puntosIncialesCorrectosTest() {
		    Bando bando = new Aliado();
			Jugador nuevoJugador = new Jugador("pedro", bando);
			
			Assert.assertEquals(20,nuevoJugador.cantidadPuntos());
		}
			
		@Test
		public void descontarUnPuntoPorAdquirirSoldado() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion, CantidadDePuntosInsuficientesExcepcion {
            Bando bando = new Aliado();
            Entidad soldado = new Soldado(bando, 3,2);

            Jugador nuevoJugador = new Jugador("pedro", bando);

            nuevoJugador.descontarPuntos(soldado.getCosto());

            Assert.assertEquals(19,nuevoJugador.cantidadPuntos());
		}
			
		@Test
		public void descontarTresPuntoPorAdquirirJinete() throws CantidadDePuntosInsuficientesExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
            Bando bando = new Aliado();
            Entidad jinete = new Jinete(bando, 3,2);

            Jugador nuevoJugador = new Jugador("pedro", bando);

            nuevoJugador.descontarPuntos(jinete.getCosto());

            Assert.assertEquals(17,nuevoJugador.cantidadPuntos());
		}
		
		@Test
		public void descontarDosPuntosPorAdquirirCurandero() throws CantidadDePuntosInsuficientesExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
            Bando bando = new Aliado();
            Entidad curandero = new Curandero(bando, 3,2);

            Jugador nuevoJugador = new Jugador("pedro", bando);

            nuevoJugador.descontarPuntos(curandero.getCosto());

            Assert.assertEquals(18,nuevoJugador.cantidadPuntos());
		}
			
		@Test 
		public void descontarCincoPuntosPorAdquirirCatapulta() throws CantidadDePuntosInsuficientesExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
			Bando bando = new Aliado();
			Entidad catapulta = new Catapulta(bando, 3,2);
								
			Jugador nuevoJugador = new Jugador("pedro", bando);
				
			nuevoJugador.descontarPuntos(catapulta.getCosto());
				
			Assert.assertEquals(15,nuevoJugador.cantidadPuntos());
		}
}
