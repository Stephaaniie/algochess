package fiuba.algo3.AlgoChess;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

	@Test
	public void jineteRecuperaVidaTest() throws CuranderoCuraHastaLaMaximaVidaExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Jinete jinete = new Jinete("aliado", 1, 2);
		jinete.reponerVida(10);
		
		Assert.assertEquals(100, jinete.getVida());
	}
	
	@Test
	public void jineteAtacadoPierdeVidaTest() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Jinete jinete = new Jinete("enemigo", 6, 8);
		jinete.recibirDanio(20);
		
		Assert.assertEquals(80, jinete.getVida());
	}
	
	@Test
	public void jineteNoTieneEnemigosCercaTest() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Jinete jinete = new Jinete("aliado", 1, 8);
		
		Assert.assertEquals(false, jinete.enemigosCerca());
	}

	@Test
	public void jineteAtacaAEntidadEnDistanciaCorta() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Jinete jinete = new Jinete("aliado", 1, 2);
		Soldado soldado = new Soldado("enemigo", 2, 2);

		jinete.atacarEnemigo(soldado);

		Assert.assertEquals(95, soldado.getVida());
	}

	@Test
	public void jineteAtacaAEntidadEnDistanciaMedia() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Jinete jinete = new Jinete("aliado", 1, 2);
		Soldado soldado = new Soldado("enemigo", 4, 2);

		jinete.atacarEnemigo(soldado);

		Assert.assertEquals(85, soldado.getVida());
	}
	
	@Test
	public void jineteSeMueveParaAbajo(){
		Posicion posicionNueva = new Posicion(4,2);
		Jinete jinete = new Jinete("aliado", 3, 2);
		jinete.mover(posicionNueva);
		
		Assert.assertEquals(posicionNueva, jinete.getPosicion());
	}

	@Test
	public void jineteSeMueveParaArriba(){
		Posicion posicionNueva = new Posicion(1, 1);
		Jinete jinete = new Jinete("aliado", 2, 1);
		jinete.mover(posicionNueva);

		Assert.assertEquals(posicionNueva, jinete.getPosicion());
	}

	@Test
	public void jineteSeMueveParaLaDerecha(){
		Posicion posicionNueva = new Posicion(2,2);
		Jinete jinete = new Jinete("aliado", 2, 1);
		jinete.mover(posicionNueva);

		Assert.assertEquals(posicionNueva, jinete.getPosicion());
	}

	@Test
	public void jineteSeMueveParaLaIzquierda(){
		Posicion posicionNueva = new Posicion(2, 1);
		Jinete jinete = new Jinete("aliado", 2, 2);
		jinete.mover(posicionNueva);

		Assert.assertEquals(posicionNueva, jinete.getPosicion());
	}
}