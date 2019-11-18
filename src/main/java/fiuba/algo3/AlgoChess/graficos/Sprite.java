package fiuba.algo3.AlgoChess.graficos;

public class Sprite {
	
	private final int tamanio;
	
	private int x;
	
	private int y;
	
	private final HojaDeSpriteSheet hoja;
	
	public int[] pixeles;
	
	public Sprite (final int tamanio, final int columna, final int fila, final HojaDeSpriteSheet hoja) {
		
		this.x = (columna * tamanio);
		
		this.y = (fila * tamanio);
		
		this.hoja = hoja;
		
		this.tamanio = tamanio;
		
		pixeles = new int[this.tamanio * this.tamanio];
	
		for(int i = 0; i < tamanio; i ++) {
			
			for( int j = 0; j < tamanio; j++) {
				
				pixeles[j + i * tamanio] = hoja.pixeles[(j + this.x) + (i + this.y) * hoja.getAncho()];
			}
			
		}
	
	}
}
