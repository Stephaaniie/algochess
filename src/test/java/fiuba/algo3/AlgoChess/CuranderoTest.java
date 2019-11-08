package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;

public class CuranderoTest {

	@Test
	public void seCreaCuranderoConTodosSusAtributosCargados() {
		
		Casillero casillero = new Casillero(5,2);
		
		Curandero curandero = new Curandero("aliado", casillero);
		
		assertNotEquals(null, curandero);	
	}
	
	@Test
	public void seCuraUnSoldadoAlDecrementarLaVida() throws CuranderoCuraHastaLaMaximaVidaExcepcion {
		
		Casillero casillero = new Casillero(5,2);
		
		Casillero casilleroConjunto = new Casillero(5,3);
		
		Curandero curandero = new Curandero("aliado", casillero);
		
		Soldado soldado = new Soldado("oponente", casilleroConjunto);
		
		soldado.restarVida(20);
		
		curandero.curarEntidad(soldado);
		
		assertEquals(95,soldado.getVida());
	}

}
