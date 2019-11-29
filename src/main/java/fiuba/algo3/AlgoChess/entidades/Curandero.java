package fiuba.algo3.AlgoChess.entidades;
import fiuba.algo3.AlgoChess.direccion.Direccion;
import fiuba.algo3.AlgoChess.distancia.BuscadorDeEntidades;
import fiuba.algo3.AlgoChess.excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.AlgoChess.excepciones.CuranderoNoPuedeAtacar;
import fiuba.algo3.AlgoChess.tablero.Posicion;
import fiuba.algo3.AlgoChess.tablero.Tablero;

public class Curandero implements Entidad {

	private Bando bando;
	
	private final int VIDAINICIAL = 75;

	private final int CURACION = 15;
	
	private int vida = VIDAINICIAL;

	private int costo = 2;

	public int curacion = 15;
	
	private Posicion posicion;
	
	Tablero tablero = Tablero.getInstanciaTablero();
	
	private BuscadorDeEntidades buscador = new BuscadorDeEntidades(tablero.getMap());


	public Curandero(Bando bando, int fila, int columna) {
		this.bando = bando;
		this.posicion = new Posicion(fila, columna);

	}

	public int getVida() {
		
		return this.vida;
	}
	
	public boolean puedoCurar(Entidad entidad) {
		return  (this.bando == entidad.getBando());
	}
	
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}
	public void curarEntidad(Curandero curandero) {
		reponerVida(CURACION);
	}
	public void curarEntidad(Entidad entidadACurar) {
		entidadACurar.reponerVida(CURACION);		
	}

	public void reponerVida(int curacion) {
		if ((this.vida += CURACION) > VIDAINICIAL){
			this.vida = VIDAINICIAL;
		}
	}


	public void mover(Direccion direccion) {
		tablero.mover(this, this.posicion, direccion.avanzar(this.posicion));
		this.posicion = direccion.avanzar(this.posicion);
	}

	@Override
	public Entidad agregar(Entidad otraEntidad) throws CasilleroOcupadoExcepcion {
		throw new CasilleroOcupadoExcepcion("No se puede realizar dicha acción");
	}

	@Override
	public Bando getBando() {
		return this.bando;
	}

	@Override
	public void atacarEnemigo() {
		new CuranderoNoPuedeAtacar("Curandero no puede atacar solo realiza curaciones");
	}

	@Override
	public Posicion getPosicion() {
		return this.posicion;
	}
	
	@Override
	public int getCosto() {
		return this.costo;
	}
}
