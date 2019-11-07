package fiuba.algo3.AlgoChess;
import fiuba.algo3.AlgoChess.excepciones.*;

public interface EntidadCuradora {

	public void curarEntidad(EntidadMovil entidadACurar)  throws CuranderoCuraHastaLaMaximaVidaExcepcion;

}
