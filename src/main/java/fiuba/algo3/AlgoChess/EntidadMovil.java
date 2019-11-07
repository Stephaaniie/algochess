package fiuba.algo3.AlgoChess;

public interface EntidadMovil extends Ataque {

	public boolean aliadosCerca();

	public boolean enemigosCerca();

	public void reponerVida(int curacion);

	public void restarVida(int danio);

	void atacarEnemigo();
}
