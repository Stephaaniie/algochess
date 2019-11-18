package fiuba.algo3.AlgoChess;

public interface EntidadMovil extends Ataque, Entidad {

	public boolean aliadosCerca();

	public boolean enemigosCerca();


	public void recibirDanio(int danio);


}
