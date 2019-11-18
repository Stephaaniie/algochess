package fiuba.algo3.AlgoChess;

public interface EntidadFija extends Ataque, Entidad {

	public void atacarEnemigo(Entidad entidadAtacada);

	public void recibirDanio(int danio);

}
