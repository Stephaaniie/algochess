package fiuba.algo3.Modelado.Entidades;

import fiuba.algo3.Modelado.Armas.Ataque;
import fiuba.algo3.Modelado.Bandos.Bando;
import fiuba.algo3.Modelado.Direccion.Direccion;
import fiuba.algo3.Modelado.Tablero.Posicion;

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
