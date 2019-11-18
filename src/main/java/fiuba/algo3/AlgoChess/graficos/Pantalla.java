package fiuba.algo3.AlgoChess.graficos;

public class Pantalla {
	private int ancho;
	
	private int alto;
	
	public int[] pixeles;
	
	public Pantalla(int ancho, int alto) {
		
		this.alto = alto;
		
		this.ancho = ancho;
		
		pixeles = new int[this.ancho * this.alto];
	}
	
	public void limpiarTablero() {
		
		for(int i = 0; i < pixeles.length; i++) {
			
			pixeles[i] = 0;
		}
	}
	
	public void mostrarTablero(int x, int y) {
		
		for(int i = 0; i < alto; i++) {
			
			int posicionY = (i + y);
			
			for(int j = 0; j < ancho; j++) {
				
				int posicionX = (j + x);
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
