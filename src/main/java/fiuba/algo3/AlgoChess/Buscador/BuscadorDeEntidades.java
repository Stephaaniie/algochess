package fiuba.algo3.AlgoChess.Buscador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Tablero.Casillero;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class BuscadorDeEntidades {

	private  Map<Posicion,Casillero> casilleros;
	
	public Tablero tablero =  new Tablero();
	
	public BuscadorDeEntidades() {
		
		this.casilleros = tablero.getMap();
	}
	
	public List <Entidad> buscadorDeEntidades(){
		List<Entidad> entidades = new ArrayList<Entidad>();
		casilleros.entrySet().stream().forEach(x -> entidades.add(x.getValue().getEntidad()));
		return entidades;
	}
	
	public List <Entidad> buscarEnemigos(Bando bandoOpuesto){
		List<Entidad> entidades = buscadorDeEntidades();
		List<Entidad> enemigos = new ArrayList<Entidad>();
		entidades.stream().filter(x -> x.getBando() != bandoOpuesto).forEach(x -> enemigos.add(x.agregar(x)));
		return enemigos;
	}
	
	public boolean tengoAliados(Bando bando,Entidad entidad) {
		boolean respuesta = false;
		List<Entidad> entidades = buscadorDeEntidades();
		List<Entidad> aliados = new ArrayList<Entidad>();
		entidades.stream().filter(x -> x.getBando() == bando).forEach(x -> aliados.add(x.agregar(x)));
		for(Entidad entidad1 : aliados) {
			if (entidad.getPosicion().esPosicionAdyacente(entidad1.getPosicion(), entidad.getPosicion())) {
				respuesta = true;
			}
		}
		return respuesta;
	}
}
