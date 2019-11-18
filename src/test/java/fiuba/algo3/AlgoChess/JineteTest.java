package fiuba.algo3.AlgoChess;
import org.junit.Test;
import org.junit.Assert;

public class JineteTest {

	@Test
	public void jineteRecuperaVidaTest()  {
		//throws CuranderoCuraHastaLaMaximaVidaExcepcion
		//Casillero casillero = new Casillero(3,1);
		//Jinete jinete = new Jinete("aliado", casillero);
		//jinete.reponerVida(10);
		
		//assertEquals(100, jinete.getVida());
	}
	
	@Test
	public void jineteAtacadoPierdeVidaTest() {
		Posicion posicion = new Posicion(6,8);
		Casillero casillero = new Casillero(posicion);
		Jinete jinete = new Jinete();
		jinete.recibirDanio(20);
		Assert.assertEquals(80, jinete.getVida());
	}
	
	@Test
	public void jineteNoTieneEnemigosCercaTest() {
		//Casillero casillero = new Casillero(8,1);
		//Jinete jinete = new Jinete("aliado", casillero);
		
		//assertEquals(false, jinete.enemigosCerca());
	}
}