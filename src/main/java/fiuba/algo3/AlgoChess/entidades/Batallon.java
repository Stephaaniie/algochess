package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CatapultaNoSeMueveExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Batallon implements Entidad{
    private List<Soldado> soldadosDelBatallon = new ArrayList<Soldado>();
    private int danio = 10;


    @Override
    public Posicion getPosicion() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
        return null;
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
        throw new CasilleroOcupadoExcepcion();
    }
}
