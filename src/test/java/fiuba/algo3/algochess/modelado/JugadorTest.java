package fiuba.algo3.algochess.modelado;

public class JugadorTest {
	
/*		@Test
		public void seCreaUnJugadorConNombre() {
			Bando bando = new Aliado();
			Bando bando2 = new Enemigo();

			Jugador nuevoJugador = new Jugador("pedro", bando, "Izac", bando2);
			
			assertEquals(nuevoJugador.getNombre(),"pedro");
		}
		
		@Test
		public void seCreaUnJugadorConNombreYDevuelveLosDosNombresDeJugador1YJugador2() {
			Bando bando = new Aliado();
			Bando bando2 = new Enemigo();

			Jugador nuevoJugador = new Jugador("Stephanie", bando, "Izac", bando2);
			
			assertEquals(nuevoJugador.getNombre(),"Stephanie");
			assertEquals(nuevoJugador.getNombreOtroJugador(),"Izac");
		}
		
		@Test
		public void seCreanLosDosJugadoresConLOsPuntosInicialesCorrectamente() {
			Bando bando = new Aliado();
			Bando bando2 = new Enemigo();

			Jugador nuevoJugador = new Jugador("Stephanie", bando, "Izac", bando2);
			
			assertEquals(nuevoJugador.getPuntos(),20);
			assertEquals(nuevoJugador.obtenerSiguienteJugador().getPuntos(),20);
		}
		
		@Test
		public void seCreaCorrectamenteELJugadorDos() {
			
			Bando bando = new Aliado();
			Bando bando2 = new Enemigo();

			Jugador nuevoJugador = new Jugador("pedro", bando, "Izac", bando2);
			
			assertEquals(nuevoJugador.obtenerSiguienteJugador().getNombre(),"Izac");
		}
		
		@Test
		public void puntosIncialesCorrectosTest() {
		    Bando bando = new Aliado();
			Bando bandoop = new Enemigo();

			Jugador nuevoJugador = new Jugador("pedro", bando, "Izac", bandoop);
			
			assertEquals(20,nuevoJugador.cantidadPuntos());
		}
			
		@Test
		public void descontarUnPuntoPorAdquirirSoldado() {
            Bando bando = new Aliado();
			Bando bandoop = new Enemigo();

            Entidad soldado = new Soldado();

			Jugador nuevoJugador = new Jugador("pedro", bando, "Izac", bandoop);

            nuevoJugador.descontarPuntos(soldado.getCosto());

            Assert.assertEquals(19,nuevoJugador.cantidadPuntos());
		}
			
		@Test
		public void descontarTresPuntoPorAdquirirJinete() {
            Bando bando = new Aliado();
			Bando bandoop = new Enemigo();

            Entidad jinete = new Jinete();

			Jugador nuevoJugador = new Jugador("pedro", bando, "Izac", bandoop);

            nuevoJugador.descontarPuntos(jinete.getCosto());

            Assert.assertEquals(17,nuevoJugador.cantidadPuntos());
		}
		
		@Test
		public void descontarDosPuntosPorAdquirirCurandero() {
            Bando bando = new Aliado();
			Bando bandoop = new Enemigo();

            Entidad curandero = new Curandero();

			Jugador nuevoJugador = new Jugador("pedro", bando, "Izac", bandoop);

            nuevoJugador.descontarPuntos(curandero.getCosto());

            Assert.assertEquals(18,nuevoJugador.cantidadPuntos());
		}
			
		@Test 
		public void descontarCincoPuntosPorAdquirirCatapulta() {
			Bando bando = new Aliado();
			Bando bandoop = new Enemigo();
			Entidad catapulta = new Catapulta();
								
			Jugador nuevoJugador = new Jugador("pedro", bando, "Izac", bandoop);
				
			nuevoJugador.descontarPuntos(catapulta.getCosto());
				
			Assert.assertEquals(15,nuevoJugador.cantidadPuntos());
		}
		
		@Test 
		public void jugadorNoPuedeAdquierirMasENtidadesPorQueSeQuedaSinPuntos() {
			
			Bando bando = new Aliado();
			Bando bandoop = new Enemigo();
											
			Posicion posicion = new Posicion(12,5);
			Posicion posicion1 = new Posicion(13,5);
			Posicion posicion2 = new Posicion(14,5);
			Posicion posicion3 = new Posicion(15,5);
			Posicion posicion4 = new Posicion(16,5);
			Posicion posicion5 = new Posicion(17,5);
			Posicion posicion6 = new Posicion(18,5);

			Jugador nuevoJugador = new Jugador("pedro", bando, "Izac", bandoop);
								
			nuevoJugador.agregarEntidad("Catapulta", posicion);
			nuevoJugador.agregarEntidad("Catapulta", posicion1);
			nuevoJugador.agregarEntidad("Catapulta", posicion2);
			nuevoJugador.agregarEntidad("Catapulta", posicion3);
			nuevoJugador.agregarEntidad("Catapulta", posicion4);
			nuevoJugador.agregarEntidad("Catapulta", posicion5);
			nuevoJugador.agregarEntidad("Catapulta", posicion6);

			assertEquals(nuevoJugador.getCantidadDeEntidades(), 4);
		}
		@Test
		public void jugadorAdquiereUnaEntidadQueNoExisteCapturaLaExcepcion() {
			
			boolean excepcionAtrapada = false;
			
			Bando bando = new Aliado();
			Bando bandoop = new Enemigo();
			
			Posicion posicion = new Posicion(12,5);

			Jugador nuevoJugador = new Jugador("pedro", bando, "Izac", bandoop);
			try {
				nuevoJugador.agregarEntidad("Catapulte", posicion);

			}catch(EntidadInvalidaExcepcion e) {
				excepcionAtrapada = true;
			}
			
			assertTrue(excepcionAtrapada);
		}
		*/
}
