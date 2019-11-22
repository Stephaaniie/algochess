package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.AlgoChess.distancia.DistanciaCorta;
import fiuba.algo3.AlgoChess.entidades.Aliado;
import fiuba.algo3.AlgoChess.entidades.Bando;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.NoHayCeldasAlrededorDeUnaDistanciaCortaExcepcion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class DistanciaTest {
	
		@Test
		public void probarSiCalculaBienLaDistanciaCorta() 
				throws NoHayCeldasAlrededorDeUnaDistanciaCortaExcepcion, CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
			
			boolean noSePuedeCalcular = false;
			try {
				Bando bando = new Aliado();
				Soldado soldado = new Soldado(bando,6,7);
				Tablero tablero = Tablero.getInstanciaTablero();
				tablero.agregarContenidoEnCasillero(soldado,6,7);
				DistanciaCorta distancia = new DistanciaCorta(soldado.getPosicion());
				distancia.calcularDistanciaCorta();
				
			}catch (NoHayCeldasAlrededorDeUnaDistanciaCortaExcepcion excepciones){
				
				noSePuedeCalcular =  true;
			}
			assertTrue(noSePuedeCalcular);
		}
}
