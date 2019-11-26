package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.AlgoChess.distancia.EntidadesACiertaDistancia;
import fiuba.algo3.AlgoChess.entidades.Bando;
import fiuba.algo3.AlgoChess.entidades.Enemigo;
import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.EntidadInvalidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.NoHayCeldasAlrededorDeUnaDistanciaCortaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class DistanciaTest {
	
		@Test
		public void probarSiLaListaDeEntidadesEsIgualACeroPorQueNoHayEntidadesEnTablero() 
				throws NoHayCeldasAlrededorDeUnaDistanciaCortaExcepcion, ColocarUnidadEnSectorEnemigoExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion, CasilleroOcupadoExcepcion {
															
				Bando bandoO = new Enemigo();
				
				Entidad soldado1 = new Soldado(bandoO,6,6);
																				
				ArrayList<Entidad> listaAux = EntidadesACiertaDistancia.entidadesCerca(1, soldado1,2, 0);

				 assertEquals(0, listaAux.size());
		}
		
		@Test
		public void seAgreganEntidadesEnTableroYEltamanioDeLaListaCoinsideConLaDeLasEntidadesAgregadas() throws EntidadInvalidaExcepcion, CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
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
