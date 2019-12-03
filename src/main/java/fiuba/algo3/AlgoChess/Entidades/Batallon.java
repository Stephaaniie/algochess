package fiuba.algo3.AlgoChess.Entidades;

import java.util.List;

import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;

public class Batallon implements Entidad{
	
    private List<Soldado> soldadosDelBatallon;
    
    private Bando bando;
    
    private Posicion posicion;
    
    public Batallon(List<Soldado> batallon) {
    	this.soldadosDelBatallon = batallon;
    	soldadosDelBatallon.stream().forEach(x -> this.bando = x.getBando());
    }
    
    public List<Soldado> getBatallon() {
    	return this.soldadosDelBatallon;
    }
    @Override
    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    public void recibirDanio(int danio) {
    	soldadosDelBatallon.stream().forEach(x -> x.recibirDanio(danio));
    }

    @Override
    public void reponerVida(int curacion) {
    	soldadosDelBatallon.stream().forEach(x -> x.reponerVida(curacion));
    }

    @Override
    public void mover(Direccion direccion) {
    	soldadosDelBatallon.stream().forEach(x -> x.mover(direccion));
    }

    @Override
    public Entidad agregar(Entidad otraEntidad) {
        throw new CasilleroOcupadoExcepcion();
    }

    @Override
    public int getCosto() {
        return 0;
    }

	@Override
	public Bando getBando() {
		return this.bando;
	}

	@Override
	public void atacarEnemigo() {
    	soldadosDelBatallon.stream().forEach(x -> x.atacarEnemigo());
	}

	@Override
	public int getVida() {
		int vida = 0;
		for(Soldado soldado : soldadosDelBatallon) {
			vida = soldado.getVida();
		}
		return vida;
	}
	@Override
	public void recibirPosicionYBando(int fila, int columna, Bando bandoJugador) {
		this.bando = bandoJugador;
		this.posicion = new Posicion(fila,columna);
	}
}
