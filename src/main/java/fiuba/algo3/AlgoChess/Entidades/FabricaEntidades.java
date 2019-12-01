package fiuba.algo3.AlgoChess.Entidades;

import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Excepciones.EntidadInvalidaExcepcion;
import fiuba.algo3.AlgoChess.Excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class FabricaEntidades {

    public Entidad crearEntidad(String tipoEntidad, int fila, int columna, Bando bando) throws EntidadInvalidaExcepcion, ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
        if(tipoEntidad.equalsIgnoreCase("Soldado")){
            return new Soldado(bando, fila, columna);
        }else if(tipoEntidad.equalsIgnoreCase("Jinete")){
            return new Jinete(bando, fila, columna);
        }else if(tipoEntidad.equalsIgnoreCase("Catapulta")){
            return new Catapulta(bando, fila, columna);
        }else if(tipoEntidad.equalsIgnoreCase("Curandero")){
            return new Curandero(bando, fila, columna);
        }else{
            throw new EntidadInvalidaExcepcion();
        }
    }
}
