package fiuba.algo3.Modelado;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fiuba.algo3.Modelado.Buscador.BuscadorDeEntidades;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Tablero.Tablero;

public class BuscadorTest {
	
	@Test
	public void probarSiLaListaDeEntidadesEsIgualACeroPorQueNoHayEntidadesEnTablero() {						
			
		Tablero tablero = new Tablero();
		
		BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());
																															
		List<Entidad> listaAux = buscador.buscadorDeEntidades();
		
		assertEquals(0, listaAux.size());
	}
	
	@Test 
	public void aniadoUnaEntidadAliadaYMuchasEnemigasParaQueDevuelvaUnaListaDeEnemigos() {		
		

	}
}
