package juego;

public interface EntidadMovil extends Ataque{
	
	public boolean aliadosCerca();
	
	public boolean enemigosCerca();
	
	public void reponerVida();
	
	public void restarVida(int danio);

	void atacarEnemigo();
}
