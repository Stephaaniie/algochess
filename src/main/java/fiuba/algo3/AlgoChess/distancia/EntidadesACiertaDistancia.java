package fiuba.algo3.AlgoChess.distancia;

import java.util.ArrayList;

import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class EntidadesACiertaDistancia {
	
	private final static int ALIADOS  = 1;
	
	private final static int ENEMIGOS = 2;
			
	private static Tablero tablero = Tablero.getInstanciaTablero();
	
	private static ArrayList<Entidad> EntidadesACiertaDistancia = new ArrayList<Entidad>();
	
public static ArrayList<Entidad> calcularDistancia(Entidad entidad, int distanciaDeseada, int distanciaMin) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {		
		
		Posicion posicionMax = new Posicion(entidad.getPosicion().fila + distanciaDeseada,entidad.getPosicion().columna + distanciaDeseada);
		Posicion posicionMin = new Posicion(entidad.getPosicion().fila - distanciaDeseada,entidad.getPosicion().columna - distanciaDeseada);

		for(int i = posicionMax.fila; i <= posicionMin.fila; i--) {
			if(i > tablero.getCantidadDeFila() | i < distanciaMin) continue;
			for(int j = posicionMin.columna; j <= posicionMax.columna; j++) {
				if((i > tablero.getCantidadDeColumnas() | i < distanciaMin) | 
					(entidad.getPosicion().fila == i & entidad.getPosicion().columna == j)) continue;
				
				Posicion posicionAux = new Posicion(i,j);
				
				if(posicionAux.distanciaEntrePosiciones(entidad.getPosicion()) <= distanciaDeseada){
					EntidadesACiertaDistancia.add(tablero.getEntidadEnPosicion(posicionAux));
				}
			}
		}
		return EntidadesACiertaDistancia;
	}
	
	public static  ArrayList <Entidad> entidadesCerca(int tipoDeLista,Entidad entidad, int distanciaDeseada,int distanciaMin) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion{
		
		ArrayList<Entidad> listaAux = calcularDistancia(entidad, distanciaDeseada, distanciaMin);
		//aca se deberia comparar con bandos.
		for(Entidad entidadAux : listaAux){
			if(tipoDeLista == ALIADOS) {
				EntidadesACiertaDistancia.add(entidadAux);
			}else if(tipoDeLista == ENEMIGOS){
				EntidadesACiertaDistancia.add(entidadAux);
			}
		}
		return EntidadesACiertaDistancia;
	}
	
	public static ArrayList <Entidad> entidadesADistanciaContigua(Entidad entidad) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		
		 ArrayList<Entidad> listaAux = new ArrayList<Entidad>();
		 
		
		return EntidadesACiertaDistancia;		
	}
}
