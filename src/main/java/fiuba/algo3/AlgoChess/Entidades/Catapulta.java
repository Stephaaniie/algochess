package fiuba.algo3.AlgoChess.Entidades;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.AlgoChess.Armas.ArmaParaDistanciaLarga;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Buscador.BuscadorDeEntidades;
import fiuba.algo3.AlgoChess.Buscador.RadarDeEntidades;
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.CatapultaNoSeMueveExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.CuranderoNoCuraAunaEntidadFijaExcepcion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;
import fiuba.algo3.AlgoChess.Tablero.Tablero;

public class Catapulta implements Entidad, ArmaParaDistanciaLarga {
	private final int VIDA_INICIAL = 50;
	private final int COSTO = 5;
	
	private final int DANIO_DISTANCIA = 20;
	
	private final int DISTANCIA_MAX_ATAQUE = 20;
	private final int DISTANCIA_MIN_ATAQUE = 6;
	
	private Bando bando;
	
	private int vida = VIDA_INICIAL;
	private int costo = COSTO;
		
	private Posicion posicion;
	
	Tablero tablero = Tablero.getInstanciaTablero();
	
	private BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());
	public Catapulta(Bando bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
	}
	
	public boolean estaEnRango(Entidad entidad) {
		RadarDeEntidades distancia = new RadarDeEntidades(DISTANCIA_MIN_ATAQUE,DISTANCIA_MAX_ATAQUE);
		return (distancia.estaEnElRadar(this.getPosicion().calcularDistanciaCon(entidad.getPosicion().getFila(),entidad.getPosicion().getColumna())));
		
	}
	
	public List<Entidad> filtrarAtacables(List<Entidad> enemigos){
		List<Entidad> filtrados = new ArrayList<Entidad>();
		for(Entidad entidad : enemigos) {
			if(estaEnRango(entidad)) {
				filtrados.add(entidad);
			}
		}
		return filtrados;
	}
	
	@Override
	public void atacarEnemigo() {
		List<Entidad> enemigos = buscador.buscarEnemigos(this.bando);
		objetosASerLanzados(filtrarAtacables(enemigos),DANIO_DISTANCIA);
	}

    @Override
    public void mover(Direccion direccion) {
        throw new CatapultaNoSeMueveExcepcion("No se puede realizar dicha accion");
    }

    @Override
    public Entidad agregar(Entidad otraEntidad) {
        throw new CasilleroOcupadoExcepcion("No se puede realizar dicha accion");
    }

    @Override
    public Posicion getPosicion() {
        return this.posicion;
    }

    @Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}

	@Override
	public int getCosto() {
		return this.costo;
	}

	public int getVida() {
		return this.vida;
	}

	@Override
	public void reponerVida(int curacion) {
        new CuranderoNoCuraAunaEntidadFijaExcepcion("No se puede reponer vida");
	}

	@Override
	public Bando getBando() {
		return this.bando;
	}

	@Override
	public void objetosASerLanzados(List<Entidad> entidad, int danio) {
		for(Entidad entidadAux : entidad) {
			entidadAux.recibirDanio(danio);
		}
	}

}