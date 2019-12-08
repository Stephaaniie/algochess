package fiuba.algo3.AlgoChess.Entidades;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.AlgoChess.Armas.ArmaParaCuerpoACuerpo;
import fiuba.algo3.AlgoChess.Armas.ArmaParaDistanciaMedia;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Buscador.BuscadorDeEntidades;
import fiuba.algo3.AlgoChess.Buscador.RadarDeEntidades;
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class Jinete implements Entidad, ArmaParaCuerpoACuerpo, ArmaParaDistanciaMedia {
	
	private final int VIDAINICIAL = 100;
	private final int COSTO = 3;
	
	private final int DIS_MAX_CON_ALIADO = 5;
	private final int DIS_MAX_SIN_ALIADO = 2;
	
	private final int DIS_MIN_CON_ALIADO = 3;
	private final int DIS_MIN_SIN_ALIADO = 1;
	
	private final int DANIO_CUERPO     = 5;
	private final int DANIO_DISTANCIA = 15;
	
	private int vida = VIDAINICIAL;
	
	private Bando bando;
	
	private Posicion posicion;
	
	Tablero tablero = Tablero.getInstanciaTablero();
	
	private BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());
	
	public boolean estaEnRangoSinAliado(Entidad entidad) {
		RadarDeEntidades distancia = new RadarDeEntidades(DIS_MIN_SIN_ALIADO,DIS_MAX_SIN_ALIADO);
		return (distancia.estaEnElRadar(this.getPosicion().calcularDistanciaCon(entidad.getPosicion().getFila(),entidad.getPosicion().getColumna())));
		
	}
	
	public boolean estaEnRangoConAliado(Entidad entidad) {
		RadarDeEntidades distancia = new RadarDeEntidades(DIS_MIN_CON_ALIADO,DIS_MAX_CON_ALIADO);
		return (distancia.estaEnElRadar(this.getPosicion().calcularDistanciaCon(entidad.getPosicion().getFila(),entidad.getPosicion().getColumna())));
		
	}
	
	public boolean tengoAliados() {
		List<Entidad> aliados = buscador.buscarAliados(this.bando);
		return aliados.size() != 0;
	}
	
	public List<Entidad> filtrarAtacables(List<Entidad> enemigos){
		List<Entidad> filtrados = new ArrayList<Entidad>();
		for(Entidad entidad : enemigos) {
			if(tengoAliados() & estaEnRangoConAliado(entidad)) {
				filtrados.add(entidad);
			}else if(!tengoAliados() & estaEnRangoSinAliado(entidad)){
				filtrados.add(entidad);
			}
		}
		return filtrados;
	}
    
	public void modoDeAtaque(List<Entidad> enemigos){
		if(!tengoAliados()) {
			espada(enemigos,DANIO_CUERPO);
		}else {
			arcoYFlecha(enemigos,DANIO_DISTANCIA);
		}
	}
	
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	@Override
	public void atacarEnemigo() {
		List<Entidad> enemigos = buscador.buscarEnemigos(this.bando);
		modoDeAtaque(filtrarAtacables(enemigos));
	}
	
	@Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}
	
	@Override
	public void reponerVida(int curacion) {
		if ((this.vida += curacion) > VIDAINICIAL) {
			this.vida = VIDAINICIAL;
		}
	}

	@Override
	public void mover(Direccion direccion) {
		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.mover(this, this.posicion, direccion.avanzar(this.posicion));
		this.posicion = direccion.avanzar(this.posicion);
	}

    @Override
    public Entidad agregar(Entidad otraEntidad) {
        throw new CasilleroOcupadoExcepcion();
    }

	@Override
	public void arcoYFlecha(List<Entidad> entidad,int DANIO_DISTANCIA) {
		for(Entidad entidadAux : entidad) {
			entidadAux.recibirDanio(DANIO_DISTANCIA);
		}
	}

	@Override
	public void espada(List<Entidad> entidad, int DANIO_CUERPO) {
		for(Entidad entidadAux : entidad) {
			entidadAux.recibirDanio(DANIO_CUERPO);
		}
	}

	@Override
	public Bando getBando() {
		return this.bando;
	}
	@Override
	public int getVida() {
		return this.vida;
	}

	@Override
	public int getCosto() {
		return this.COSTO;
	}

	@Override
	public void recibirPosicionYBando(Posicion posicion, Bando bandoJugador) {
		this.bando = bandoJugador;
		this.posicion = posicion;
	}
}
