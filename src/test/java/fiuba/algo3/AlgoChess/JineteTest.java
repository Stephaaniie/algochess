package fiuba.algo3.AlgoChess;
import org.junit.Assert;
import org.junit.Test;

public class JineteTest {

	@Test
	public void jineteRecuperaVidaTest()  {
		throws CuranderoCuraHastaLaMaximaVidaExcepcion
		Posicion posicion = new Posicion(6,9);
		Jinete jinete = new Jinete("aliado", posicion);
		jinete.reponerVida(10);
		
		assertEquals(100, jinete.getVida());
	}
	
	@Test
	public void jineteAtacadoPierdeVidaTest() {
		Posicion posicion = new Posicion(6,8);
		Jinete jinete = new Jinete("enemigo", posicion);
		jinete.recibirDanio(20);
		
		Assert.assertEquals(80, jinete.getVida());
	}
	
	@Test
	public void jineteNoTieneEnemigosCercaTest() {
		Posicion posicion = new Posicion(8,1);
		Jinete jinete = new Jinete("aliado", posicion);
		
		assertEquals(false, jinete.enemigosCerca());
	}
	
	@Test
	public void jineteSeMueveAOtraPosicion(){
		Posicion posicion = new Posicion(3,2);
		Posicion posicionNueva = new Posicion(4,2);
		Jinete jinete = new Jinete("aliado", posicion);
		jinete.mover(posicionNueva);
		
		Assert.assertEquals(posicionNueva, jinete.getPosicion);
	}
}