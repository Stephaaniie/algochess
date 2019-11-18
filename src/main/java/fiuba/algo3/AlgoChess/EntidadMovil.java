package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;

public interface EntidadMovil extends Ataque {

	public boolean aliadosCerca();

	public boolean enemigosCerca();

	public void reponerVida(int curacion) throws CuranderoCuraHastaLaMaximaVidaExcepcion;

	public void restarVida(int danio);

	
}
