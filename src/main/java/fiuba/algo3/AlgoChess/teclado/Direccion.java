package fiuba.algo3.AlgoChess.teclado;

import fiuba.algo3.AlgoChess.Posicion;

public class Direccion {
		
	private Direccion inversa;
	private int x;
	private int y;

    private static Direccion arriba;
    private static Direccion abajo;
    private static Direccion derecha;
    private static Direccion izquierda;

    static {
        arriba    = new Direccion(0,1);
        abajo     = new Direccion(0,-1);
        derecha   = new Direccion(1,0);
        izquierda = new Direccion(-1,0);

        arriba.setDireccionInversa(abajo);
        abajo.setDireccionInversa(arriba);
        derecha.setDireccionInversa(izquierda);
        izquierda.setDireccionInversa(derecha);
    }
    
    Direccion(int x, int y) {
    	
    	this.x = x;
    	
    	this.y = y;
    }
    
    public Direccion inversa() {
        return this.inversa;
    }
    private void setDireccionInversa(Direccion inversa) {
		
    	this.inversa = inversa;
	}

	public static Direccion abajo() {
        return abajo();
    }

    public static Direccion arriba() {
        return arriba();
    }

    public static Direccion derecha() {
        return derecha();
    }
    
    public static Direccion izquierda() {
    	return izquierda();
    }
    public Posicion siguiente(Posicion posicion) {
    	
        int siguienteX = posicion.getX() + 1;
        int siguienteY = posicion.getY() + 1;

        return new Posicion(siguienteX, siguienteY);
    }
    public Posicion anterior(Posicion posicion) {
    	
        int siguienteX = posicion.getX() - 1;
        int siguienteY = posicion.getY() - 1;

        return new Posicion(siguienteX, siguienteY);
    }
}