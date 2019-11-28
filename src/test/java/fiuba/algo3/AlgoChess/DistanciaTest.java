package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fiuba.algo3.AlgoChess.distancia.BuscadorDeEntidades;
import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class DistanciaTest {
	
		@Test
		public void probarSiLaListaDeEntidadesEsIgualACeroPorQueNoHayEntidadesEnTablero() {						
				Tablero tablero = Tablero.getInstanciaTablero();
			
				BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());
																															
				List<Entidad> listaAux = buscador.buscadorDeEntidades();

				 assertEquals(0, listaAux.size());
		}
		
		@Test
		public void seAgreganEntidadesEnTableroYEltamanioDeLaListaCoinsideConLaDeLasEntidadesAgregadas() {
		/*	
				Bando bandoO = new Enemigo();
				Bando bandoA = new Aliado();
				
				Entidad soldado0 = FabricaEntidades.crearEntidad("Soldado",6,5, bandoO);
				Entidad soldado1 = FabricaEntidades.crearEntidad("Soldado",5,5, bandoA);
				Entidad soldado2 = FabricaEntidades.crearEntidad("Soldado",7,5, bandoA);
				Entidad soldado3 = FabricaEntidades.crearEntidad("Soldado",5,6, bandoA);
				Entidad soldado4 = FabricaEntidades.crearEntidad("Soldado",5,7, bandoA);

				Tablero tablero = Tablero.getInstanciaTablero();
				
				tablero.reset();
				
				tablero.agregarContenidoEnCasillero(soldado0, 6, 5);
				
				tablero.agregarContenidoEnCasillero(soldado1, 5, 5);
				
				tablero.agregarContenidoEnCasillero(soldado2, 7, 5);
				
				tablero.agregarContenidoEnCasillero(soldado3, 5, 6);
				
				tablero.agregarContenidoEnCasillero(soldado4, 5, 7);
								
				ArrayList<Entidad> listaAux = EntidadesACiertaDistancia.entidadesCerca(1, tablero, soldado2,2);
		
				assertEquals(4, listaAux.size());
		
		*/
		}

}
