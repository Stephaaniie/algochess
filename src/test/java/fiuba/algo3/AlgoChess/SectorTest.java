package fiuba.algo3.AlgoChess;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import fiuba.algo3.AlgoChess.Tablero.Sector;


public class SectorTest {
	
    @Test
    public void seCreaCorrectamenteElSector(){
    	Sector sector = new Sector(4,5);
    	assertNotEquals(null, sector);
    }
}
