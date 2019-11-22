package fiuba.algo3.AlgoChess.distancia;

import java.util.ArrayList;

import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.tablero.Casillero;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class DistanciaMedia {
	
	
	private final int DIS_MIN = 3;
	
	private final int DIS_MAX = 5;
	
	private ArrayList<Entidad> EntidadesACiertaDistancia = new ArrayList<Entidad>();
	
	private Posicion posicion;
	
	public DistanciaMedia(Posicion posicion){
		
		this.posicion = posicion;
	}
	
	public ArrayList <Entidad> calcularDistanciaCorta() {
		
		Tablero tablero = Tablero.getInstanciaTablero();
		
		Casillero casillero_aux = new Casillero(posicion);
		
		for(int i = 0; i < tablero.getCantidadDeFila(); i++) {
			
			for(int j = 0; j < tablero.getCantidadDeColumnas(); j++) {
				
				casillero_aux = tablero.sectorGlobal.getCasilleroDelSector(posicion);
				
				if( casillero_aux.getPosicionDeCasillero().distanciaEntrePosiciones(posicion) >= DIS_MIN ||
						casillero_aux.getPosicionDeCasillero().distanciaEntrePosiciones(posicion) <= DIS_MAX) {
				
					EntidadesACiertaDistancia.add(casillero_aux.getContenido());
				}
			}
		}
		return EntidadesACiertaDistancia;
	}
}
