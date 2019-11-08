package fiuba.algo3.AlgoChess;

public class Direccion {
		
	private Direccion inversa;
	private int X;
	private int Y;

    private static Direccion norte;
    private static Direccion sur;
    private static Direccion este;
    private static Direccion oeste;

    static {
        norte = new Direccion(0,1);
        sur   = new Direccion(0,-1);
        este  = new Direccion(1,0);
        oeste = new Direccion(-1,0);

        norte.setDireccionInversa(sur);
        sur.setDireccionInversa(norte);
        este.setDireccionInversa(oeste);
        oeste.setDireccionInversa(este);
    }
    
    Direccion(int x, int y) {
    	
    	this.X = x;
    	
    	this.Y = y;
    }
    
    public Direccion inversa() {
        return this.inversa;
    }
    private void setDireccionInversa(Direccion inversa) {
		
    	this.inversa = inversa;
	}

	public static Direccion sur() {
        return sur();
    }

    public static Direccion norte() {
        return norte();
    }

    public static Direccion este() {
        return este();
    }
    
    public static Direccion oeste() {
    	return oeste();
    }
    public Posicion siguiente(Posicion posicion) {
    	
        int siguienteX = posicion.getX() + 1;
        int siguienteY = posicion.getY() + 1;

        return new Posicion(siguienteX, siguienteY);
    }
}