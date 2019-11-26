package fiuba.algo3.AlgoChess;
import fiuba.algo3.AlgoChess.direccion.*;
import fiuba.algo3.AlgoChess.entidades.*;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.excepciones.*;
import fiuba.algo3.AlgoChess.tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JineteTest {

	@Test
	public void jineteRecuperaVidaTest() throws CuranderoCuraHastaLaMaximaVidaExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Bando bando = new Aliado();
		Jinete jinete = new Jinete(bando, 1, 2);
		jinete.reponerVida(10);
		
		Assert.assertEquals(100, jinete.getVida());
	}
	
	@Test
	public void jineteAtacadoPierdeVidaTest() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Bando bando = new Enemigo();
		Jinete jinete = new Jinete(bando, 6, 8);
		jinete.recibirDanio(20);
		
		Assert.assertEquals(80, jinete.getVida());
	}


	@Test
	public void jineteAtacaAEntidadEnDistanciaCorta() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Bando bando1 = new Aliado();
		Bando bando2 = new Enemigo();
		Jinete jinete = new Jinete(bando1, 1, 2);
		Soldado soldado = new Soldado(bando2, 2, 2);

		jinete.atacarEnemigo(soldado);

		Assert.assertEquals(95, soldado.getVida());
	}

	@Test
	public void jineteAtacaAEntidadEnDistanciaMedia() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Bando bando1 = new Aliado();
		Bando bando2 = new Enemigo();
		Jinete jinete = new Jinete(bando1, 1, 2);
		Soldado soldado = new Soldado(bando2, 4, 2);

		jinete.atacarEnemigo(soldado);

		Assert.assertEquals(85, soldado.getVida());
	}
	
	@Test
	public void jineteSeMueveParaAbajo() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Aliado();
		Jinete jinete = new Jinete(bando, 3, 2);
		Posicion posicionNueva = new Posicion(4,2);

		Direccion direccion = new Abajo();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(jinete,3, 2);

		jinete.mover(direccion);

		assertEquals(jinete.getPosicion(), posicionNueva);
		assertEquals(jinete, tablero.getEntidadEnPosicion(posicionNueva));
		tablero.reset();
	}

	@Test
	public void jineteSeMueveParaArriba() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(1, 1);
		Jinete jinete = new Jinete(bando, 2, 1);

		Direccion direccion = new Arriba();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(jinete,2, 1);

		jinete.mover(direccion);

		assertEquals(jinete.getPosicion(), posicionNueva);
		assertEquals(jinete, tablero.getEntidadEnPosicion(posicionNueva));
		tablero.reset();
	}

	@Test
	public void jineteSeMueveParaLaDerecha() throws MovimientoInvalidoExcepcion, CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(2,2);
		Jinete jinete = new Jinete(bando, 2, 1);

		Direccion direccion = new Derecha();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(jinete,2, 1);

		jinete.mover(direccion);

		assertEquals(jinete.getPosicion(), posicionNueva);
		assertEquals(jinete, tablero.getEntidadEnPosicion(posicionNueva));
		tablero.reset();
	}

	@Test
	public void jineteSeMueveParaLaIzquierda() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Bando bando = new Aliado();
		Posicion posicionNueva = new Posicion(3, 1);
		Jinete jinete = new Jinete(bando, 3, 2);

		Direccion direccion = new Izquierda();

		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.agregarContenidoEnCasillero(jinete,3, 2);

		jinete.mover(direccion);

		assertEquals(jinete.getPosicion(), posicionNueva);
		assertEquals(jinete, tablero.getEntidadEnPosicion(posicionNueva));
		tablero.reset();
	}

	@Test
	public void jineteNoPuedeMoverseACasilleroOcupado() throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		boolean errorAtrapado = false;
		Posicion posicionEsperada = new Posicion(5, 5);
		Bando bando1 = new Aliado();
		Bando bando2 = new Aliado();
		Jinete jinete = new Jinete(bando1, 5,5);
		Catapulta catapulta = new Catapulta(bando2, 5,4);
		Tablero tablero = Tablero.getInstanciaTablero();
		Direccion direccion = new Izquierda();

		try{
			tablero.agregarContenidoEnCasillero(jinete, 5, 5);
			tablero.agregarContenidoEnCasillero(catapulta,5,4);
			jinete.mover(direccion);
		}catch(CasilleroOcupadoExcepcion e){
			errorAtrapado = true;
		}

		Assert.assertTrue(errorAtrapado);
		Assert.assertEquals(posicionEsperada, jinete.getPosicion());
		tablero.reset();
	}
}