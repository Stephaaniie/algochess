package fiuba.algo3.AlgoChess;

public class Jugador {

	private int puntosActuales = 20;
	private boolean hayEntidad = false;
	private boolean puedeAdquirirEntidad = true;
	private int cantidadEntidades = 0;
	private String bando;
	private String nombre;
	
	public Jugador() {}
	
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

//	public boolean esPerdedor() {
//		if (cantidadEntidades == 0) {
//			return true;
//		}
//		return false;
//	}

//	public boolean tieneEntidades() {

//		return (hayEntidad);
//	}

	public void descontarPuntos(int numero) {

		if (puntosActuales <= 0) {
			this.puedeAdquirirEntidad = false;
			return;
		}

		hayEntidad = true;

		puntosActuales -= numero;
	}

//	public boolean puedeCargarMasEntidades() {
//		return (this.puedeAdquirirEntidad);
//	}

	public int cantidadDePuntosActual() {

		return puntosActuales;
	}
}
