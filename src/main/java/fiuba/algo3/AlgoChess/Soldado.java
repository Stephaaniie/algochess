package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.MovimientoInvalidoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.teclado.Direccion;

public class Soldado implements Entidad {
	private final int VIDAINICIAL = 100;
	private String bando = new String();
	private int danioACuerpo = 10;
	private int danioADistancia = 0;
	private int vida = VIDAINICIAL;
	private int costo = 1;
	private Posicion posicion;
	private Direccion direccion;

	public Soldado(String bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
		this.direccion = new Direccion();

	}

	public int getVida() {
		
		return this.vida;
	}

	@Override
	public void recibirDanio(int danio) {

		this.vida -= danio;
	}
	
	public int getCosto() {
		
		return this.costo;
	}

	@Override
	public void reponerVida(int curacion) throws CuranderoCuraHastaLaMaximaVidaExcepcion{

		if ((this.vida += curacion) > VIDAINICIAL){

			this.vida = VIDAINICIAL;
		}
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		entidadAtacada.recibirDanio(this.danioACuerpo);
	}

	@Override
	public void mover(String direccion) throws MovimientoInvalidoExcepcion {
		switch(direccion){
			case "arriba":
				this.posicion = this.direccion.arriba(this.posicion);
				break;
			case "abajo":
				this.posicion = this.direccion.abajo(this.posicion);
				break;
			case "izquierda":
				this.posicion = this.direccion.izquierda(this.posicion);
				break;
			case "derecha":
				this.posicion = this.direccion.derecha(this.posicion);
				break;
			default:
				throw new MovimientoInvalidoExcepcion();
		}
	}

    @Override
    public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion {
        throw new CasilleroOcupadoExcepcion();
    }

    public Posicion getPosicion() {
		return this.posicion;
	}

}
