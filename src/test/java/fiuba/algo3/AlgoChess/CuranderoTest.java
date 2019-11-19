package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class CuranderoTest {

	@Test
	public void seCreaCuranderoConTodosSusAtributosCargados() {
		
		int fila = 0;
		
		int columna = 1;
		
		Curandero curandero = new Curandero("aliado", fila, columna);
		
		assertNotEquals(null, curandero);	
	}
	
	@Test
	public void curanderoCuraUnSoldadoAlDecrementarLaVida() 
		throws CuranderoCuraHastaLaMaximaVidaExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion { 
		
		Curandero curandero = new Curandero("aliado", 5, 5);
		
		Soldado soldado = new Soldado("aliado",6,7);
		
		soldado.recibirDanio(20);
		
		curandero.curarEntidad(soldado);
		
		assertEquals(95,soldado.getVida());
	}
	
	@Test	
	public void curanderoCuraUnJineteDecrementarLaVida() 
		throws CuranderoCuraHastaLaMaximaVidaExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion { 
		
		Curandero curandero = new Curandero("aliado", 5, 5);
		
		Jinete jinete = new Jinete("aliado",6,7);
		
		jinete.recibirDanio(20);
		
		curandero.curarEntidad(jinete);
		
		assertEquals(95,jinete.getVida());
	}
	
	@Test
	public void curanderoIntentaCurarUnaCatapulta() { 
			
		Curandero curandero = new Curandero("aliado", 5, 5);
		
		Catapulta catapulta = new Catapulta("aliado",6,7);		
		
		catapulta.recibirDanio(20);
		
		try{
			curandero.curarEntidad(catapulta);

        }catch( CuranderoCuraHastaLaMaximaVidaExcepcion | ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e){
        	
        	assertEquals(30,catapulta.getVida());
        }
	}
	
	@Test 
	public void curanderoSeLeDecrementaLaVidaYSeAutoCura() {
		
		Curandero curandero = new Curandero("aliado", 5, 5);
		
		curandero.recibirDanio(20);
		
		try {
			curandero.curarEntidad(curandero);
		} catch (CuranderoCuraHastaLaMaximaVidaExcepcion e) {
			e.printStackTrace();
		} catch (ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion e) {
			e.printStackTrace();
		}
    	assertEquals(75,curandero.getVida());
	}

}
