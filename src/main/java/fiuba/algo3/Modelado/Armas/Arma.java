package fiuba.algo3.Modelado.Armas;

import java.util.List;

import fiuba.algo3.Modelado.Buscador.RadarDeEntidades;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.Jinete;

public class Arma {
		
	RadarDeEntidades radar;
	
	RadarDeEntidades radarOtraArma;
		
	public Arma(int rangoMin, int rangoMax) {
		asignarRadar(this.radar,rangoMin, rangoMax);
	}
	
	public Arma(int rangoMin, int rangoMax,int rangoMin1, int rangoMax1) {
		asignarRadar(this.radar,rangoMin, rangoMax);
		asignarRadar(this.radarOtraArma,rangoMin1, rangoMax1);
	}

	public void asignarRadar(RadarDeEntidades radar, int rangoMin, int rangoMax) {
		radar = new RadarDeEntidades(rangoMin, rangoMax);
	}
	public void utilizarEspada(List<Entidad> enemigos, int danio) {
		radar.filtrarAtacables(enemigos).stream().forEach(x -> x.recibirDanio(danio));
	}
	
	public void utilizarArma(List<Entidad> enemigos, Jinete jinete,int danio, int danio1) {
		if(jinete.getBuscador().tengoAliados(jinete.getBando(), jinete)) {
			utilizarArcoYFlecha(enemigos,danio);
		}else {
			utilizarEspada(enemigos,danio1);
		}
	}
	
	private void utilizarArcoYFlecha(List<Entidad> enemigos, int danio) {
		radarOtraArma.filtrarAtacables(enemigos).stream().forEach(x -> x.recibirDanio(danio));
	}
	
	public void utilizarArmaCatapulta(List<Entidad> enemigos,int danio) {
		enemigos.stream().forEach(x -> x.recibirDanio(danio));
	}
}
