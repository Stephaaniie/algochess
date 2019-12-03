package fiuba.algo3.AlgoChess.Entidades;

import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Excepciones.EntidadInvalidaExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class FabricaEntidades {

    public Entidad crearEntidad(String tipoEntidad, int fila, int columna, Bando bando) throws EntidadInvalidaExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
        if(tipoEntidad.equalsIgnoreCase("Soldado")){
            return new Soldado();
        }else if(tipoEntidad.equalsIgnoreCase("Jinete")){
            return new Jinete();
        }else if(tipoEntidad.equalsIgnoreCase("Catapulta")){
            return new Catapulta();
        }else if(tipoEntidad.equalsIgnoreCase("Curandero")){
            return new Curandero();
        }else{
            throw new EntidadInvalidaExcepcion();
        }
    }
}
