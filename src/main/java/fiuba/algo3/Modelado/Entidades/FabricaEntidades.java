package fiuba.algo3.Modelado.Entidades;

import fiuba.algo3.Modelado.Excepciones.EntidadInvalidaExcepcion;

public class FabricaEntidades {

    public Entidad crearEntidad(String tipoEntidad) {
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
