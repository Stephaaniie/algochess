package fiuba.algo3.AlgoChess.entidades;

import java.util.ArrayList;

import fiuba.algo3.AlgoChess.Ataques.ArmaParaCuerpoACuerpo;
import fiuba.algo3.AlgoChess.Ataques.ArmaParaDistanciaMedia;
import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.distancia.EntidadesACiertaDistancia;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ColocarUnidadEnSectorEnemigoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Jinete implements Entidad, ArmaParaCuerpoACuerpo, ArmaParaDistanciaMedia {
	private final static int ALIADOS  = 1;
	private final static int ENEMIGOS = 2;
	private final int VIDAINICIAL = 100;
	private final int ATAQUECONALIADO = 5;
	private final int ATAQUESINALIADO = 2;
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
        throw new CasilleroOcupadoExcepcion("No se puede realizar dicha acción");
    }


    public Posicion getPosicion() {
		return this.posicion;
	}

	@Override
	public void arcoYFlecha() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		ArrayList<Entidad> listaAux = EntidadesACiertaDistancia.entidadesCerca(ENEMIGOS,this,ATAQUECONALIADO);
		for(Entidad entidadAux : listaAux) {
			atacarEnemigo(entidadAux);
		}
		
	}

	@Override
	public void espada() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		ArrayList<Entidad> listaAux = EntidadesACiertaDistancia.entidadesCerca(ENEMIGOS,this,ATAQUESINALIADO);
		for(Entidad entidadAux : listaAux) {
			atacarEnemigo(entidadAux);
		}
		
	}
	
	public void modoDeAtaque() throws ObjetoNuloNoPuedeRealizarNingunaAccionExcepcion {
		
		ArrayList<Entidad> listaAux = EntidadesACiertaDistancia.entidadesADistanciaContigua(this);

		if(listaAux.size() != 0) {
			arcoYFlecha();
		}else {
			espada();
		}
	}

}
