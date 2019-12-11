package fiuba.algo3.AlgoChess.Armas;

import java.util.List;

import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Buscador.BuscadorDeEntidades;
import fiuba.algo3.AlgoChess.Buscador.RadarDeEntidades;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.Jinete;

public class Armas {
	
	BuscadorDeEntidades buscador = new BuscadorDeEntidades();
	
	RadarDeEntidades radar;
	
	RadarDeEntidades radarOtraArma;
	
	List<Entidad> enemigos;
	
	public Armas(int rangoMin, int rangoMax,Bando bando) {
		asignarRadarYListaDeEnemigos(rangoMin,rangoMax,bando);
	}
	
	public Armas(int rangoMin, int rangoMax,int rangoMin1, int rangoMax1,Bando bando) {
		this.radarOtraArma = new RadarDeEntidades(rangoMin1, rangoMax1);
		asignarRadarYListaDeEnemigos(rangoMin,rangoMax,bando);
	}
	
	private void asignarRadarYListaDeEnemigos(int rangoMin, int rangoMax, Bando bando) {
		this.radar = new RadarDeEntidades(rangoMin, rangoMax);
		this.enemigos = buscador.buscarEnemigos(bando);
	}
	public void soldadoUtilizaEspada(int danio) {
		radar.filtrarAtacables(this.enemigos).stream().forEach(x -> x.recibirDanio(danio));
	}
	
	public void jineteAtaca(Jinete jinete,int danio, int danio1) {
		if(jinete.getBuscador().tengoAliados(jinete.getBando(), jinete)) {
			utilizarArcoYFlecha(this.enemigos,danio);
		}else {
			jineteUtilizaEspada(this.enemigos,danio1);
		}
	}
	
	public void jineteUtilizaEspada(List<Entidad> enemigos, int danio) {
		radar.filtrarAtacables(enemigos).stream().forEach(x -> x.recibirDanio(danio));
	}
	
	public void utilizarArcoYFlecha(List<Entidad> enemigos, int danio) {
		radarOtraArma.filtrarAtacables(enemigos).stream().forEach(x -> x.recibirDanio(danio));
	}
	
	public void objetosASerLanzados(int danio) {
		this.enemigos.stream().forEach(x -> x.recibirDanio(danio));
	}
}
