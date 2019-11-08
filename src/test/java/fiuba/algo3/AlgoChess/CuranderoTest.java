package fiuba.algo3.AlgoChess;
import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;

public class CuranderoTest {

	@Test
	public void seCreaCuranderoConTodosSusAtributosCargados() {

		Casillero casillero = new Casillero(5, 2);

		Curandero curandero = new Curandero("aliado", casillero);

		Assert.assertNotEquals(null, curandero);
	}

	@Test
	public void seCuraUnSoldadoAlDecrementarLaVida() 
			throws CuranderoCuraHastaLaMaximaVidaExcepcion{

		Casillero casillero = new Casillero(5, 2);

		Casillero casilleroConjunto = new Casillero(5, 3);

		Curandero curandero = new Curandero("aliado", casillero);

		Soldado soldado = new Soldado("aliado", casilleroConjunto);

		soldado.restarVida(20);

		curandero.curarEntidad(soldado);

		Assert.assertEquals(95, soldado.getVida());
	}
	
	@Test
	public void seCuraAUnJineteCuandoSeLeDecrementaLaVida()
		throws CuranderoCuraHastaLaMaximaVidaExcepcion{

		Casillero casillero = new Casillero(5, 2);

		Casillero casilleroConjunto = new Casillero(5, 3);

		Curandero curandero = new Curandero("aliado", casillero);

		Jinete jinete = new Jinete("aliado", casilleroConjunto);

		jinete.restarVida(30);

		curandero.curarEntidad(jinete);

		Assert.assertEquals(85, jinete.getVida());
	}
	
	@Test
	public void seCuraUnCuranderoASiMismo() 
		throws CuranderoCuraHastaLaMaximaVidaExcepcion {

		Casillero casillero = new Casillero(5, 2);

		Curandero curandero = new Curandero("aliado", casillero);

		curandero.recibirDanio(25);
		
		curandero.reponerVida(curandero.curacion);

		Assert.assertEquals(65, curandero.getVida());
	}

}
