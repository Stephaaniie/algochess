package fiuba.algo3.AlgoChess.entidades;

public class RadarDeEntidades {
	
	private int distanciaMin;
	
	private int distanciaMax;
	
	public RadarDeEntidades(int distanciaMin, int distanciaMax) {
		this.distanciaMin = distanciaMin;
		this.distanciaMax = distanciaMax;
	}
	
	public boolean estaEnElRadar(int distancia) {
		return distancia >= distanciaMin & distancia <= distanciaMax;
	}
	
	public boolean estaEnElRadar(int disMin, int disMax) {
		return disMin >= distanciaMin & disMax <= distanciaMax;
	}
	
	public int getdistanciaMin() {
		return this.distanciaMin;
	}
	
	public int getdistanciaMax() {
		return this.distanciaMax;
	}
}
