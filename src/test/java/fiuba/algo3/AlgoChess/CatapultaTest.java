package fiuba.algo3.AlgoChess;


import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import org.junit.Assert;
import org.junit.Test;

public class CatapultaTest {

	@Test
	public void catapultaAtacadaPierdeVida() {

		Catapulta catapulta = new Catapulta("aliado", 1,2);
		catapulta.recibirDanio(10);
		Assert.assertEquals(40, catapulta.getVida());
	}

	@Test
    public void catapultaAtacaASoldadoYLeRestaVida() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
	    Catapulta catapulta = new Catapulta("aliado",2,2);
	    Jinete jinete = new Jinete("enemigo", 10, 11);

	    catapulta.atacarEnemigo(jinete);

	    Assert.assertEquals(80, jinete.getVida());
    }
}
