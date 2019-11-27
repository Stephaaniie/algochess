package fiuba.algo3.AlgoChess.tablero;

public class Posicion{
	private int fila;

	private int columna;
	
	public Posicion(int fila, int columna) {
		this.fila = fila;
		this.columna = columna;
	}

	public int getFila() {
		return this.fila;
	}

	public int getColumna() {
		return this.columna;
	}
	
	public void setFila(int fila) {
		this.fila = fila; 
	}
	
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public int distanciaEntrePosiciones(Posicion posicion) {
		return posicion.calcularDistanciaCon(this.fila,this.columna);
		
	}
	
	public int distanciaFila(int filaOriginal, int filaResta) {
		return filaOriginal - filaResta;
	}
	
	public int distanciaColumna(int colOriginal, int colResta) {
		return colOriginal - colResta;
	}
	
	public int calcularDistanciaCon(int fila, int columna) {
		return (int) Math.sqrt(Math.pow(distanciaFila(fila,this.fila), 2) + Math.pow(distanciaColumna(columna,this.columna), 2));

	}

}