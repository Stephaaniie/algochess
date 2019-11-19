package fiuba.algo3.AlgoChess;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;

public class SectorTest {

    @Test
    public void noSePuedeAgregarEntidadEnSectorEnemigo(){
        boolean errorAtrapado = false;
        Sector enemigo = new Sector();
        Jugador jugador1 = new Jugador("pepe");
        Jugador jugador2 = new Jugador("maria");

        enemigo.agregarJugador(jugador1);
        try{
            Entidad entidad = new Catapulta(null);
            Posicion posicion = new Posicion(1,2);
            enemigo.agregarContenidoEnCasillero(jugador2, entidad, posicion);
        }catch(ColocarUnidadEnSectorEnemigoExcepcion | CasilleroOcupadoExcepcion e){
            errorAtrapado = true;
        }

        Assert.assertTrue(errorAtrapado);
    }
}
