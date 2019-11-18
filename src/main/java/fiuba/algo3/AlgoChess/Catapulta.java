package fiuba.algo3.AlgoChess;

public class Catapulta implements EntidadFija {

	private String bando = new String();
	private int vida = 50;
	private int costo = 5;
	private int danioADistancia = 20;
/*
	public Catapulta(String bando, Casillero casillero) {
		this.bando = bando;
		this.posicion = casillero;
	}

*/	@Override
	public void atacarEnemigo(Entidad entidadAtacada) {
		
	}

	@Override
	public void recibirDanio(int danio) {
		this.vida -= danio;
	}

	public int getCosto() {
		
		return this.costo;
	}

	public int getVida() {
		return this.vida;
	}

	@Override
	public void atacarEnemigo(EntidadMovil ofensivo) {
		
	}

	@Override
	public void atacarEnemigo() {
		// TODO Auto-generated method stub
		
	}
	
}
