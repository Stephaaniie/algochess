package fiuba.algo3.algochess.models.administradorVenta;

import fiuba.algo3.algochess.models.Jugador;
import fiuba.algo3.algochess.models.entidades.Entidad;

public class AdmDeCompra {

    protected Jugador propietario;

    AdmDeCompra(Jugador propietario) {
        this.propietario = propietario;
    }

    public void comprarEntidad(Entidad entidad, Billetera billetera) {
        billetera.pagar(entidad.getCosto());
        propietario.agregarEntidad(entidad);
    }
}