package fiuba.algo3.algochess.modelado;

public class SoldadoTest {
	/*@Test
	public void soldadoRecuperadoSeLeSumaVidaTest() {
		Soldado soldado = new Soldado();

		soldado.reponerVida(15);

		assertEquals(100, soldado.getVida());
	}

	@Test
	public void soldadoAtacadoPierdeVidaTest() {

		Soldado soldado = new Soldado();

		soldado.recibirDanio(50);

		assertEquals(50, soldado.getVida());
	}


	@Test
	public void soldadoSeMueveParaArriba() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(15, 7);
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new Arriba();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void soldadoSeMueveParaAbajo() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 7);
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new Abajo();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void soldadoSeMueveParaLaIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(16, 6);
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new Izquierda();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}

	@Test
	public void soldadoSeMueveParaLaDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(16, 8);
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new Derecha();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaArribaALaDerecha() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(15, 8);
		
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		
		Direccion direccion = new ArribaDerecha();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaAbajoALaIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 6);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new AbajoIzquierda();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaAbajoALaDerecha() {
	
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(17, 8);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void soldadoSeMueveParaArribaALaIzquierda() {
		
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja = new Posicion(16, 7);
		Posicion posicionNueva = new Posicion(15, 6);
		
		jugador.agregarEntidad("curandero", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad = jugador.getEntidad(posicionVieja);
		
		tablero.agregarEntidadEnCasillero(entidad, posicionVieja);
		
		Direccion direccion = new ArribaIzquierda();
		
		entidad.mover(direccion);
		
		assertTrue(posicionNueva.mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	

	@Test
	public void soldadoNoPuedeMoverseACasilleroOcupado() {		

		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Laura",aliado, "Berni", aliado);
		
		Posicion posicionVieja1 = new Posicion(17, 8);
		Posicion posicionVieja  = new Posicion(16, 7);
		Posicion posicionNueva  = new Posicion(17, 8);
		
		jugador.agregarEntidad("soldado", posicionVieja1);
		jugador.agregarEntidad("soldado", posicionVieja);
		
		Tablero tablero = new Tablero();
		
		Entidad entidad  = jugador.getEntidad(posicionVieja);
		Entidad entidad1 = jugador.getEntidad(posicionVieja1);
		
		tablero.agregarEntidadEnCasillero(entidad,posicionVieja);
		tablero.agregarEntidadEnCasillero(entidad1,posicionVieja1);

		Direccion direccion = new AbajoDerecha();
		
		entidad.mover(direccion);
		
		assertTrue(entidad1.getPosicion().mismaPosicion(posicionNueva, entidad.getPosicion()));
	}
	
	@Test
	public void agregarEntidad() {
		
		boolean respuesta = false;
		
		Enemigo enemigo = new Enemigo();
		Aliado aliado = new Aliado();
		
		Jugador jugador = new Jugador("Sofia",aliado, "Brenda", enemigo);
		
		Posicion posicion = new Posicion(16, 7);
		
		jugador.agregarEntidad("soldado", posicion);
		
		Entidad entidad  = jugador.getEntidad(posicion);
		
		try {
			entidad.agregar(entidad);
		}catch(CasilleroOcupadoExcepcion e) {
			respuesta = true;
		}
		assertEquals( respuesta, true);
	}
	
	 no puede realizar el ataque porque la entidad le llega como objeto nulo
	@Test
	public void verificarQueSeAtacaCorrectamenteConLaEspada() {
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();

		Jugador jugador = new Jugador("Agus",aliado,"Agus",enemigo);
		
		Posicion posicion  = new Posicion(9,6);
		Posicion posicion1 = new Posicion(10,5);
		
		jugador.agregarEntidad("soldado", posicion);
		Entidad soldado = jugador.getEntidad(posicion);
									
		jugador.obtenerSiguienteJugador().agregarEntidad("soldado", posicion1);
		Entidad soldado1  = jugador.obtenerSiguienteJugador().getEntidad(posicion1);

		Tablero tablero = new Tablero();			
			
		tablero.agregarEntidadEnCasillero(soldado ,posicion);
		tablero.agregarEntidadEnCasillero(soldado1,posicion1);
		
		soldado.atacarEnemigo();
		
		assertEquals(soldado1.getVida(),100);
	}
	*/
}
