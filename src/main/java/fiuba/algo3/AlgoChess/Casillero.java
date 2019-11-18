package fiuba.algo3.AlgoChess;

public class Casillero {
	
	private Entidad contenido = null; //aca iria el objeto nulo pero falta hacerlo
	
	public agregarContenido(Entidad contenido) {
		if(contenido == null) {
			this.contenido = contenido;
		}else throw new CasilleroOcupadoExcepcion(); 
	}
}
