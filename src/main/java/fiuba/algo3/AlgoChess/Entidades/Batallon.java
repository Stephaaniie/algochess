package fiuba.algo3.AlgoChess.Entidades;

import java.util.List;

import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;

public class Batallon implements Entidad{
    private List<Soldado> soldadosDelBatallon;
    private Bando bando;
    private Posicion posicionCentral;
    
    public Batallon(List<Soldado> batallon,Bando bando) {
    	this.soldadosDelBatallon = batallon;
    	this.bando = bando;
    }
    @Override
    public Posicion getPosicion() {
        return posicionCentral;
    }

    @Override
    public void recibirDanio(int danio) {
        for(Soldado soldado : this.soldadosDelBatallon){
            soldado.recibirDanio(danio);
        }
    }

    @Override
    public void reponerVida(int curacion) {
        for(Soldado soldado : this.soldadosDelBatallon){
            soldado.reponerVida(curacion);
        }
    }

    @Override
    public void mover(Direccion direccion) {
    	for(Soldado soldado : this.soldadosDelBatallon){
    		soldado.mover(direccion);
    	}
    }

    @Override
    public Entidad agregar(Entidad otraEntidad) {
        throw new CasilleroOcupadoExcepcion("No se puede realizar dicha accion");
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
		for(Soldado soldado : this.soldadosDelBatallon) {
			soldado.atacarEnemigo();
		}
	}

	@Override
	public int getVida() {
		return 0;
	}
}
