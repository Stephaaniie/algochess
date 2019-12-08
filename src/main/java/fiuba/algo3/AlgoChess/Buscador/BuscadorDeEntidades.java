package fiuba.algo3.AlgoChess.Buscador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Tablero.Casillero;
import fiuba.algo3.AlgoChess.Tablero.Posicion;

public class BuscadorDeEntidades {

	private  Map<Posicion,Casillero> tablero;
	
	public BuscadorDeEntidades(Map<Posicion,Casillero> tablero) {
		this.tablero = tablero;
	}
	public List<Posicion> buscadorDePosiciones(){
	 	List<Posicion> posiciones = new ArrayList<Posicion>();
		tablero.entrySet().stream().forEach(x -> posiciones.add(x.getKey()));
		return posiciones;
	}
	
	public List <Entidad> buscadorDeEntidades(){
		List<Entidad> entidades = new ArrayList<Entidad>();
		tablero.entrySet().stream().forEach(x -> entidades.add(x.getValue().getEntidad()));
		return entidades;
	}
	
	public List <Entidad> buscarEnemigos(Bando bandoOpuesto){
		List<Entidad> entidades = buscadorDeEntidades();
		List<Entidad> enemigos = new ArrayList<Entidad>();
		entidades.stream().filter(x -> x.getBando() != bandoOpuesto).forEach(x -> enemigos.add(x.agregar(x)));
		return enemigos;
	}
	
	public List <Entidad> buscarAliados(Bando bansoAliado){
		List<Entidad> entidades = buscadorDeEntidades();
		List<Entidad> aliados = new ArrayList<Entidad>();
		entidades.stream().filter(x -> x.getBando() == bansoAliado).forEach(x -> aliados.add(x.agregar(x)));
		return aliados;	
	}
	
}
