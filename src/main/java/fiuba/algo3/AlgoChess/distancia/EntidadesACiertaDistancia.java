package fiuba.algo3.AlgoChess.distancia;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class EntidadesACiertaDistancia {
	
	private final static int ALIADOS  = 1;
	
	private final static int ENEMIGOS = 2;
			
	private static Tablero tablero = Tablero.getInstanciaTablero();
	
	private static List<Entidad> EntidadesACiertaDistancia = new ArrayList<Entidad>();
	
public static List<Entidad> calcularDistancia(Entidad entidad, int distanciaDeseada, int distanciaMin) 
		throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
			return EntidadesACiertaDistancia;		
		/*
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
		return EntidadesACiertaDistancia;*/
	}
	
	public static List <Entidad> entidadesCerca(int tipoDeLista,Entidad entidad, int distanciaDeseada,int distanciaMin) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion{
		/*
		List<Entidad> listaAux = calcularDistancia(entidad, distanciaDeseada, distanciaMin);
		//aca se deberia comparar con bandos.
		for(Entidad entidadAux : listaAux){
			if(tipoDeLista == ALIADOS) {
				EntidadesACiertaDistancia.add(entidadAux);
			}else if(tipoDeLista == ENEMIGOS){
				EntidadesACiertaDistancia.add(entidadAux);
			}
		}*/
		return EntidadesACiertaDistancia;
	}
	
	public static List <Entidad> buscarEnemigos(Entidad entidad){
		return EntidadesACiertaDistancia;
		
		//List<Entidad> listaAux = calcularDistancia(entidad, distanciaDeseada, distanciaMin);

	}
	
	public static List <Entidad> entidadesADistanciaContigua(Entidad entidad) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		return EntidadesACiertaDistancia;
		
		 //ArrayList<Entidad> listaAux = new ArrayList<Entidad>();
		 
		
		//return EntidadesACiertaDistancia;		
	}
}
