package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;

public class JineteTest {

	@Test
	public void jineteRecuperaVidaTest() throws CuranderoCuraHastaLaMaximaVidaExcepcion {
		Casillero casillero = new Casillero(3,1);
		Jinete jinete = new Jinete("aliado", casillero);
		jinete.reponerVida(10);
		
		assertEquals(100, jinete.getVida());
	}
	
	@Test
	public void jineteAtacadoPierdeVidaTest() {
		Casillero casillero = new Casillero(6,8);
		Jinete jinete = new Jinete("aliado", casillero);
		jinete.recibirDanio(20);
		
		assertEquals(80, jinete.getVida());
	}
	
	@Test
	public void jineteNoTieneEnemigosCercaTest() {
		Casillero casillero = new Casillero(8,1);
		Jinete jinete = new Jinete("aliado", casillero);
		
		assertEquals(false, jinete.enemigosCerca());
	}
}