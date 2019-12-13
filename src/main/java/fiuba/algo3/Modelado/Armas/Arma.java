package fiuba.algo3.Modelado.Armas;

import java.util.List;

import fiuba.algo3.Modelado.Buscador.RadarDeEntidades;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.Jinete;

public class Arma {
		
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
	
	public void utilizarArma(List<Entidad> enemigos, Jinete jinete,int danio, int danio1) {
		if(jinete.getBuscador().tengoAliados(jinete.getBando(), jinete)) {
			utilizarArcoYFlecha(enemigos,danio);
		}else {
			jineteUtilizaEspada(enemigos,danio1);
		}
	}
	
	private void jineteUtilizaEspada(List<Entidad> enemigos, int danio) {
		radar.filtrarAtacables(enemigos).stream().forEach(x -> x.recibirDanio(danio));
	}
	
	private void utilizarArcoYFlecha(List<Entidad> enemigos, int danio) {
		radarOtraArma.filtrarAtacables(enemigos).stream().forEach(x -> x.recibirDanio(danio));
	}
	
	public void utilizarArmaCatapulta(List<Entidad> enemigos,int danio) {
		enemigos.stream().forEach(x -> x.recibirDanio(danio));
	}
}
