package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;

public class ObjetoNull implements Entidad {

	public ObjetoNull(Object objetoNull ) {
		
		objetoNull = null;	
	}
	
	public void restarVida(int danio)throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		
		new ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion("La entidad no existe y no puede recibir dicho daño");
		
	}

}
