package fiuba.algo3.Modelado;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fiuba.algo3.Modelado.Buscador.BuscadorDeEntidades;
import fiuba.algo3.Modelado.Entidades.Entidad;

public class BuscadorTest {
	
	@Test
	public void probarSiLaListaDeEntidadesEsIgualACeroPorQueNoHayEntidadesEnTablero() {						
			
		BuscadorDeEntidades buscador = new BuscadorDeEntidades();
																															
		List<Entidad> listaAux = buscador.buscadorDeEntidades();
		
		assertEquals(0, listaAux.size());
	}
}
