package fiuba.algo3.algochess.modelado;

public class BuscadorTest {
	/*
	@Test
	public void probarSiLaListaDeEntidadesEsIgualACeroPorQueNoHayEntidadesEnTablero() {						
			
		Tablero tablero = new Tablero();
		
		BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());
																															
		List<Entidad> listaAux = buscador.buscadorDeEntidades();
		
		assertEquals(0, listaAux.size());
	}
	
	@Test 
	public void aniadoUnaEntidadAliadaYMuchasEnemigasParaQueDevuelvaUnaListaDeAliadosVacia() {	
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();
		
		Tablero tablero = new Tablero();
		
		Posicion posicion = new Posicion(2,2);
		Posicion posEnemigo1 = new Posicion(12,7);
		Posicion posEnemigo2 = new Posicion(14,13);
		Posicion posEnemigo3 = new Posicion(16,3);
		
		Jugador jugador = new Jugador("Pedro",aliado, "Sebastian", enemigo);
		
		jugador.agregarEntidad("soldado", posicion);
		jugador.obtenerSiguienteJugador().agregarEntidad("curandero", posEnemigo1);
		jugador.obtenerSiguienteJugador().agregarEntidad("jinete", posEnemigo2);
		jugador.obtenerSiguienteJugador().agregarEntidad("catapulta", posEnemigo3);

		Soldado soldadoAliado = (Soldado) jugador.getEntidad(posicion);
		Entidad curanderoEnemigo = jugador.obtenerSiguienteJugador().getEntidad(posEnemigo1);
		Entidad jineteEnemigo = jugador.obtenerSiguienteJugador().getEntidad(posEnemigo2);
		Entidad catapultaEnemigo = jugador.obtenerSiguienteJugador().getEntidad(posEnemigo3);
		
		tablero.agregarEntidadEnCasillero(soldadoAliado, posicion);
		tablero.agregarEntidadEnCasillero(curanderoEnemigo, posEnemigo1);
		tablero.agregarEntidadEnCasillero(jineteEnemigo, posEnemigo2);
		tablero.agregarEntidadEnCasillero(catapultaEnemigo, posEnemigo3);
																															
		List<Entidad> listaAux = soldadoAliado.getBuscador().buscarAliados(aliado);
		
		assertEquals(listaAux.size(),0);
	}
	
	@Test 
	public void aniadoUnaEntidadesAliadasDevuelvaUnaListaDeAliadosConCuatroEntidades() {	
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();
		
		Tablero tablero = new Tablero();
		
		Posicion posicion = new Posicion(2,2);
		
		Posicion posAliado1 = new Posicion(1,7);
		Posicion posAliado2 = new Posicion(4,13);
		Posicion posAliado3 = new Posicion(8,3);
		
		Jugador jugador = new Jugador("Pedro",aliado, "Sebastian", enemigo);
		
		jugador.agregarEntidad("soldado", posicion);
		jugador.agregarEntidad("curandero", posAliado1);
		jugador.agregarEntidad("jinete", posAliado2);
		jugador.agregarEntidad("catapulta", posAliado3);

		Soldado soldadoAliado = (Soldado) jugador.getEntidad(posicion);
		Entidad curanderoEnemigo = jugador.getEntidad(posAliado1);
		Entidad jineteEnemigo    = jugador.getEntidad(posAliado2);
		Entidad catapultaEnemigo = jugador.getEntidad(posAliado3);
		
		tablero.agregarEntidadEnCasillero(soldadoAliado, posicion);
		tablero.agregarEntidadEnCasillero(curanderoEnemigo, posAliado1);
		tablero.agregarEntidadEnCasillero(jineteEnemigo, posAliado2);
		tablero.agregarEntidadEnCasillero(catapultaEnemigo, posAliado3);
																				
		BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());
		List<Entidad> listaAux = buscador.buscadorDeEntidades();

		assertEquals(listaAux.size(),4);
	}
	
	@Test 
	public void aniadoUnaEntidadAliadaYMuchasEnemigasParaQueDevuelvaUnaListaDeEnemigosLlena() {	
		
		Aliado aliado = new Aliado();
		Enemigo enemigo = new Enemigo();
		
		Tablero tablero = new Tablero();
		
		Posicion posicion = new Posicion(2,2);
		Posicion posEnemigo1 = new Posicion(12,7);
		Posicion posEnemigo2 = new Posicion(14,13);
		Posicion posEnemigo3 = new Posicion(16,3);
		
		Jugador jugador = new Jugador("Pedro",aliado, "Sebastian", enemigo);
		
		jugador.agregarEntidad("soldado", posicion);
		jugador.obtenerSiguienteJugador().agregarEntidad("curandero", posEnemigo1);
		jugador.obtenerSiguienteJugador().agregarEntidad("jinete", posEnemigo2);
		jugador.obtenerSiguienteJugador().agregarEntidad("catapulta", posEnemigo3);

		Entidad soldadoAliado =  jugador.getEntidad(posicion);
		Entidad curanderoEnemigo = jugador.obtenerSiguienteJugador().getEntidad(posEnemigo1);
		Entidad jineteEnemigo = jugador.obtenerSiguienteJugador().getEntidad(posEnemigo2);
		Entidad catapultaEnemigo = jugador.obtenerSiguienteJugador().getEntidad(posEnemigo3);
		
		tablero.agregarEntidadEnCasillero(soldadoAliado, posicion);
		tablero.agregarEntidadEnCasillero(curanderoEnemigo, posEnemigo1);
		tablero.agregarEntidadEnCasillero(jineteEnemigo, posEnemigo2);
		tablero.agregarEntidadEnCasillero(catapultaEnemigo, posEnemigo3);
															
		BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());

		List<Entidad> listaAux = buscador.buscarEnemigos(aliado);
		
		assertEquals(listaAux.size(),4);
		//Como llegan como objetos nulos me devuelve los ingresados porque le bando que le queda registrado es null y es idstinto al que contiene
	}
	*/
}
