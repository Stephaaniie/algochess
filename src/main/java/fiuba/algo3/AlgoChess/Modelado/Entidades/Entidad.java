package fiuba.algo3.AlgoChess.Entidades;

import fiuba.algo3.AlgoChess.Armas.Ataque;
import fiuba.algo3.AlgoChess.Bandos.Bando;
import fiuba.algo3.AlgoChess.Direccion.Direccion;
import fiuba.algo3.AlgoChess.Tablero.Posicion;

public interface Entidad extends Ataque {

	public Posicion getPosicion();
	
	public Bando getBando();

	public void recibirDanio(int danio);

	public void reponerVida(int curacion);

	public void atacarEnemigo();

	public void mover(Direccion direccion);

	public Entidad agregar(Entidad otraEntidad);

	public int getCosto();

	public int getVida();

	public void recibirPosicionYBando(Posicion posicion, Bando bandoJugador);
}
