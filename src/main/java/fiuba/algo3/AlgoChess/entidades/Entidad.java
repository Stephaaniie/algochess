package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.Ataques.Ataque;
import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.tablero.Posicion;

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
}
