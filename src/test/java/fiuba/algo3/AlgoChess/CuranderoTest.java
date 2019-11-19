package fiuba.algo3.AlgoChess;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.MovimientoInvalidoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class CuranderoTest {

	@Test 
	public void CuranderoSeCreaConElCostoCorrecto() {
		
		Curandero curandero = new Curandero("aliado", 0, 1);
		
		assertEquals(2,curandero.getCosto());

	}
	
	@Test 
	public void CuranderoSeCreaConLaVidaCorrecta() {
		
		Curandero curandero = new Curandero("aliado", 0, 1);
		
		assertEquals(75,curandero.getVida());

	}

	@Test
	public void seCreaCuranderoConTodosSusAtributosCargados() {
		
		Curandero curandero = new Curandero("aliado", 0, 1);
		
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

	@Test
	public void curanderoSeMueveEnDireccionArriba() throws MovimientoInvalidoExcepcion {
		
		Posicion posicionNueva = new Posicion(4,5);
		
		Curandero curandero = new Curandero("aliado", 5, 5);
		
		curandero.mover("arriba");
		
		assertEquals(curandero.posicion,posicionNueva);
	}
	
	@Test
	public void curanderoSeMueveEnDireccionAbajo() throws MovimientoInvalidoExcepcion {
		
		Posicion posicionNueva = new Posicion(6,5);
		
		Curandero curandero = new Curandero("aliado", 5, 5);
		
		curandero.mover("abajo");
		
		assertEquals(curandero.posicion,posicionNueva);
	}
	
	@Test
	public void curanderoSeMueveEnDireccionDerecha() throws MovimientoInvalidoExcepcion {
		
		Posicion posicionNueva = new Posicion(5,6);
		
		Curandero curandero = new Curandero("aliado", 5, 5);
		
		curandero.mover("derecha");
		
		assertEquals(curandero.posicion,posicionNueva);
	}
	
	@Test
	public void curanderoSeMueveEnDireccionIzquierda() throws MovimientoInvalidoExcepcion {
		
		Posicion posicionNueva = new Posicion(5,4);
		
		Curandero curandero = new Curandero("aliado", 5, 5);
		
		curandero.mover("izquierda");
		
		assertEquals(curandero.posicion,posicionNueva);
	}
	
	@Test
	public void curanderoNoSeMueveEnDireccionInvalida(){
		
		Curandero curandero = new Curandero("aliado", 1, 1);
		
		boolean errorAtrapado = false;

		try{
			curandero.mover("diagonal");
		}catch(MovimientoInvalidoExcepcion e){
			errorAtrapado = true;
		}
		Assert.assertTrue(errorAtrapado);
	}
	
}
