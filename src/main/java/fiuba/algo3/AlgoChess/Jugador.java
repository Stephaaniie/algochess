package fiuba.algo3.AlgoChess;

public class Jugador {

	private int puntosActuales = 20;
	private boolean hayEntidad = false;
	private boolean puedeAdquirirEntidad = true;
	private int cantidadEntidades = 0;
	private String bando;
	private String nombre;
		
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public void descontarPuntos(int numero) {

		if (puntosActuales <= 0) {
			this.puedeAdquirirEntidad = false;
			return;
		}

		hayEntidad = true;

		puntosActuales -= numero;
	}

}
