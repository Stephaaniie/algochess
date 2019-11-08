package juegoTest;

import static org.junit.Assert.*;
import juego.Casillero;
import juego.Curandero;
import juego.Soldado;
import org.junit.Assert;
import org.junit.Test;

public class CuranderoTest {

	@Test
	public void seCreaCuranderoConTodosSusAtributosCargados() {
		
		Casillero casillero = new Casillero(5,2);
		
		Curandero curandero = new Curandero("aliado", casillero);
		
		Assert.assertNotEquals(null, curandero);	
	}
	
	@Test
	public void seCuraUnSoldadoAlDecrementarLaVida() {
		
		Casillero casillero = new Casillero(5,2);
		
		Casillero casilleroConjunto = new Casillero(5,3);
		
		Curandero curandero = new Curandero("aliado", casillero);
		
		Soldado soldado = new Soldado("oponente", casilleroConjunto);
		
		soldado.restarVida(20);
		
		curandero.curarEntidad(soldado);
		
		Assert.assertEquals(95,soldado.getVida());
	}

}
