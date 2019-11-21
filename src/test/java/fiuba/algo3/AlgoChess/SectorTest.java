package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Entidad;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.tablero.Casillero;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Sector;
import org.junit.Assert;
import org.junit.Test;

public class SectorTest {
    /*@Test
    public void noSePuedeAgregarEntidadEnSectorEnemigo(){
        boolean errorAtrapado = false;
        Sector enemigo = new Sector();
        Jugador jugador1 = new Jugador("pepe");
        Jugador jugador2 = new Jugador("maria");

        enemigo.agregarJugador(jugador1);
        try{
            Entidad entidad = new Catapulta("aliado", 5, 4);
            Posicion posicion = new Posicion(1,2);
            enemigo.agregarContenidoEnCasillero(entidad, posicion);
        }catch(ColocarUnidadEnSectorEnemigoExcepcion | CasilleroOcupadoExcepcion e){
            errorAtrapado = true;
        }

        Assert.assertTrue(errorAtrapado);
    }*/
}
