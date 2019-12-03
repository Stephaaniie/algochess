package fiuba.algo3.AlgoChess;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.AlgoChess.Bandos.Aliado;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Entidades.Catapulta;
import fiuba.algo3.AlgoChess.Entidades.Curandero;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.Jinete;
import fiuba.algo3.AlgoChess.Entidades.Soldado;

public class JugadorTest {
		
		@Test
		public void puntosIncialesCorrectosTest() {
		    Bando bando = new Aliado();
			Jugador nuevoJugador = new Jugador("pedro", bando);
			
			Assert.assertEquals(20,nuevoJugador.cantidadPuntos());
		}
			
		@Test
		public void descontarUnPuntoPorAdquirirSoldado() {
            Bando bando = new Aliado();
            Entidad soldado = new Soldado();

            Jugador nuevoJugador = new Jugador("pedro", bando);

            nuevoJugador.descontarPuntos(soldado.getCosto());

            Assert.assertEquals(19,nuevoJugador.cantidadPuntos());
		}
			
		@Test
		public void descontarTresPuntoPorAdquirirJinete() {
            Bando bando = new Aliado();
            Entidad jinete = new Jinete();

            Jugador nuevoJugador = new Jugador("pedro", bando);

            nuevoJugador.descontarPuntos(jinete.getCosto());

            Assert.assertEquals(17,nuevoJugador.cantidadPuntos());
		}
		
		@Test
		public void descontarDosPuntosPorAdquirirCurandero() {
            Bando bando = new Aliado();
            Entidad curandero = new Curandero();

            Jugador nuevoJugador = new Jugador("pedro", bando);

            nuevoJugador.descontarPuntos(curandero.getCosto());

            Assert.assertEquals(18,nuevoJugador.cantidadPuntos());
		}
			
		@Test 
		public void descontarCincoPuntosPorAdquirirCatapulta() {
			Bando bando = new Aliado();
			Entidad catapulta = new Catapulta();
								
			Jugador nuevoJugador = new Jugador("pedro", bando);
				
			nuevoJugador.descontarPuntos(catapulta.getCosto());
				
			Assert.assertEquals(15,nuevoJugador.cantidadPuntos());
		}
}
