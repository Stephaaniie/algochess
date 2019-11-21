package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CuranderoCuraHastaLaMaximaVidaExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Soldado implements Entidad {
	private final int VIDAINICIAL = 100;
	private String bando = new String();
	private int danioACuerpo = 10;
	private int danioADistancia = 0;
	private int vida = VIDAINICIAL;
	private int costo = 1;
	private Posicion posicion;

	public Soldado(String bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
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
	public void mover(Direccion direccion) {
		Tablero tablero = Tablero.getInstanciaTablero();
		tablero.quitarEntidadDePosicion(this.posicion);
		this.posicion = direccion.avanzar(this.posicion);
		tablero.agregarContenidoEnCasillero(this, this.posicion.getFila(), this.posicion.getColumna());
	}

    @Override
    public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion {
        throw new CasilleroOcupadoExcepcion();
    }

    public Posicion getPosicion() {
		return this.posicion;
	}

}
