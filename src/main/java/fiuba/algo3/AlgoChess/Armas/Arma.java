package fiuba.algo3.AlgoChess.Armas;

import java.util.List;

import fiuba.algo3.AlgoChess.Buscador.BuscadorDeEntidades;
import fiuba.algo3.AlgoChess.Buscador.RadarDeEntidades;
import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.Entidades.Jinete;

public class Arma {
	
	BuscadorDeEntidades buscador = new BuscadorDeEntidades();
	
	RadarDeEntidades radar;
	
	RadarDeEntidades radarOtraArma;
		
	public Arma(int rangoMin, int rangoMax) {
		this.radar = new RadarDeEntidades(rangoMin, rangoMax);
	}
	
	public Arma(int rangoMin, int rangoMax,int rangoMin1, int rangoMax1) {
		this.radarOtraArma = new RadarDeEntidades(rangoMin1, rangoMax1);
		this.radar = new RadarDeEntidades(rangoMin, rangoMax);
	}

	public void soldadoUtilizaEspada(List<Entidad> enemigos, int danio) {
		radar.filtrarAtacables(enemigos).stream().forEach(x -> x.recibirDanio(danio));
	}
	
	public void jineteAtaca(List<Entidad> enemigos, Jinete jinete,int danio, int danio1) {
		if(jinete.getBuscador().tengoAliados(jinete.getBando(), jinete)) {
			utilizarArcoYFlecha(enemigos,danio);
		}else {
			jineteUtilizaEspada(enemigos,danio1);
		}
	}
	
	public void jineteUtilizaEspada(List<Entidad> enemigos, int danio) {
		radar.filtrarAtacables(enemigos).stream().forEach(x -> x.recibirDanio(danio));
	}
	
	public void utilizarArcoYFlecha(List<Entidad> enemigos, int danio) {
		radarOtraArma.filtrarAtacables(enemigos).stream().forEach(x -> x.recibirDanio(danio));
	}
	
	public void objetosASerLanzados(List<Entidad> enemigos,int danio) {
		enemigos.stream().forEach(x -> x.recibirDanio(danio));
	}
}
