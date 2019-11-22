package fiuba.algo3.AlgoChess.entidades;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CatapultaNoSeMueveExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;

public class Batallon implements Entidad{
    private List<Soldado> soldadosDelBatallon = new ArrayList<Soldado>();
    private int danio = 10;
    //private Bando bando;
    private Posicion posicionCentral;


    @Override
    public Posicion getPosicion() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
        return posicionCentral;
    }

    @Override
    public void recibirDanio(int danio) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
        for(Soldado soldado : soldadosDelBatallon){
            soldado.recibirDanio(danio);
        }
    }

    @Override
    public void reponerVida(int curacion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion, CuranderoCuraHastaLaMaximaVidaExcepcion {
        for(Soldado soldado : soldadosDelBatallon){
            soldado.reponerVida(curacion);
        }
    }

    @Override
    public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
        entidadAtacada.recibirDanio(this.danio);
    }

    @Override
    public void mover(Direccion direccion) throws CatapultaNoSeMueveExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {

    }

    @Override
    public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion {
        throw new CasilleroOcupadoExcepcion("No se puede realizar dicha accion");
    }
}
