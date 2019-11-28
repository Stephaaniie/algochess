package fiuba.algo3.AlgoChess;


import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.AlgoChess.entidades.Aliado;
import fiuba.algo3.AlgoChess.entidades.Bando;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Enemigo;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class CatapultaTest {

	@Test
	public void catapultaAtacadaPierdeVida() {
		Bando bando = new Aliado();
		Catapulta catapulta = new Catapulta(bando, 1,2);
		catapulta.recibirDanio(10);
		Assert.assertEquals(40, catapulta.getVida());
	}

	@Test
    public void catapultaAtacaAJineteYLeRestaVida() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Bando bando1 = new Aliado();
		Bando bando2 = new Enemigo();
	    Catapulta catapulta = new Catapulta(bando1,2,2);
	    Jinete jinete = new Jinete(bando2, 10, 11);

	    catapulta.atacarEnemigo();

	    Assert.assertEquals(100, jinete.getVida());
    }

    @Test
    public void catapultaAtacaASoldadoYLeRestaVida() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Bando bando1 = new Aliado();
		Bando bando2 = new Enemigo();
	    Catapulta catapulta = new Catapulta(bando1, 2, 2);
	    Soldado soldado = new Soldado(bando2, 10,10);

	    catapulta.atacarEnemigo();

	    Assert.assertEquals(100, soldado.getVida());
    }
}
