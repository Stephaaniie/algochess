package fiuba.algo3.AlgoChess;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import fiuba.algo3.AlgoChess.Buscador.BuscadorDeEntidades;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Tablero.Tablero;


public class BuscadorTest {
		@Before
		@Test
		public void probarSiLaListaDeEntidadesEsIgualACeroPorQueNoHayEntidadesEnTablero() {						
				
			Tablero tablero = Tablero.getInstanciaTablero();
			
			BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());
																															
			List<Entidad> listaAux = buscador.buscadorDeEntidades();

			assertEquals(0, listaAux.size());
		}
}
