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
	public void jineteSeMueveAOtraPosicion(){
		Posicion posicionNueva = new Posicion(4,2);
		Jinete jinete = new Jinete("aliado", 3, 2);
		jinete.mover(posicionNueva);
		
		Assert.assertEquals(posicionNueva, jinete.getPosicion());
	}
}