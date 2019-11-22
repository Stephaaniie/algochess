package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Jinete implements Entidad {
	private final int VIDAINICIAL = 100;
	private Bando bando;
	private int danioACuerpo = 5;
	private int danioADistancia = 15;
	private int vida = VIDAINICIAL;
	private int costo = 3;
	private Posicion posicion;

	public Jinete(Bando bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);
	}

	@Override
	public void recibirDanio(int danio) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		this.vida -= danio;
		
	}

	@Override
	public void atacarEnemigo(Entidad entidadAtacada) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		Posicion posicionEnemigo = entidadAtacada.getPosicion();
		int distancia = this.posicion.distanciaEntrePosiciones(posicionEnemigo);
		if(distancia == 1 || distancia == 2){
			entidadAtacada.recibirDanio(this.danioACuerpo);
		}else if(distancia == 3 || distancia == 4 || distancia == 5){
			entidadAtacada.recibirDanio(this.danioADistancia);
		}
	}

	@Override
	public void reponerVida(int curacion) throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		if ((this.vida += curacion) > VIDAINICIAL) {
			this.vida = VIDAINICIAL;
		}
	}

	public int getVida() {
		
		return this.vida;
	}

	@Override
	public int getCosto() {
		return this.costo;
	}

	@Override
	public void mover(Direccion direccion) throws CasilleroOcupadoExcepcion, ColocarUnidadEnSectorEnemigoExcepcion {
		Tablero tablero = Tablero.getInstanciaTablero();
		if(tablero.mover(this, this.posicion, direccion.avanzar(this.posicion)) == 0){
			this.posicion = direccion.avanzar(this.posicion);
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
