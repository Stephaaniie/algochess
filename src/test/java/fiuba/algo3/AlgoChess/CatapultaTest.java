package fiuba.algo3.AlgoChess;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.AlgoChess.Entidades.Catapulta;
import fiuba.algo3.AlgoChess.Entidades.Jinete;
import fiuba.algo3.AlgoChess.Entidades.Soldado;

public class CatapultaTest {
	@Test
	public void catapultaAtacadaPierdeVida() {
		Catapulta catapulta = new Catapulta();
		catapulta.recibirDanio(10);
		Assert.assertEquals(40, catapulta.getVida());
	}

	@Test
    public void catapultaAtacaAJineteYLeRestaVida() {
	    Catapulta catapulta = new Catapulta();
	    Jinete jinete = new Jinete();

	    catapulta.atacarEnemigo();

	    Assert.assertEquals(100, jinete.getVida());
    }

    @Test
    public void catapultaAtacaASoldadoYLeRestaVida() {
	    Catapulta catapulta = new Catapulta();
	    Soldado soldado = new Soldado();

	    catapulta.atacarEnemigo();

	    Assert.assertEquals(100, soldado.getVida());
    }
}
