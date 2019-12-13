package fiuba.algo3.Modelado.Buscador;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fiuba.algo3.Modelado.Bandos.Bando;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Tablero.Casillero;
import fiuba.algo3.Modelado.Tablero.Posicion;

public class BuscadorDeEntidades {

	private  Map<Posicion,Casillero> casilleros;
		
	public BuscadorDeEntidades(Map<Posicion,Casillero> casilleros) {
		
		this.casilleros = casilleros;
	}
	
	public List <Entidad> buscadorDeEntidades(){
		List<Entidad> entidades = new ArrayList<Entidad>();
		casilleros.entrySet().stream().forEach(x -> entidades.add(x.getValue().getEntidad()));
		return entidades;
	}
	
	public List <Entidad> buscarEnemigos(Bando bandoOpuesto){
		List<Entidad> entidades = buscadorDeEntidades();
		List<Entidad> enemigos = new ArrayList<Entidad>();
		entidades.stream().filter(x -> x.getBando() != bandoOpuesto).forEach(x -> enemigos.add(x));
		return enemigos;
	}
	
	public List<Entidad> buscarAliados(Bando bando) {
		List<Entidad> entidades = buscadorDeEntidades();
		List<Entidad> aliados = new ArrayList<Entidad>();
		entidades.stream().filter(x -> x.getBando() == bando).forEach(x -> aliados.add(x));
		return aliados;
	}
	
	public boolean tengoAliados(Bando bando,Entidad entidad) {
		boolean respuesta = false;
		List<Entidad> aliados = buscarAliados(bando);
		for(Entidad entidad1 : aliados) {
			if (entidad.getPosicion().esPosicionAdyacente(entidad1.getPosicion(), entidad.getPosicion())) {
				respuesta = true;
			}
		}
		return respuesta;
	}
}
