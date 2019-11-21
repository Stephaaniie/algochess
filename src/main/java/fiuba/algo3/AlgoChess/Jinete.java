package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.MovimientoInvalidoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.teclado.Direccion;

public class Jinete implements Entidad {
	private final int VIDAINICIAL = 100;
	private String bando = new String();
	private int danioACuerpo = 5;
	private int danioADistancia = 15;
	private int vida = VIDAINICIAL;
	private int costo = 3;
	private Posicion posicion;
	private Direccion direccion = new Direccion();

	public Jinete(String bando, int fila, int columna) {
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

	public int getCosto() {
		
		return this.costo;
	}

	@Override
	public void mover(String direccion) throws MovimientoInvalidoExcepcion {
		switch (direccion){
			case "arriba":
				this.posicion = this.direccion.arriba(this.posicion);
				break;
			case "abajo":
				this.posicion = this.direccion.abajo(this.posicion);
				break;
			case "derecha":
				this.posicion = this.direccion.derecha(this.posicion);
				break;
			case "izquierda":
				this.posicion = this.direccion.izquierda(this.posicion);
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
