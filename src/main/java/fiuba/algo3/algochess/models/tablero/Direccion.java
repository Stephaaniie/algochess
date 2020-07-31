package fiuba.algo3.algochess.models.tablero;

public abstract class Direccion {

    public Posicion avanzar(Posicion posicion){
		return posicion;
    }
    
    public Posicion avanzarIzquierda(Posicion posicion) {
		return new Posicion(posicion.getX(), posicion.getY() - 1);
    }
    
    public Posicion avanzarDiagonalAI(Posicion posicion) {
		return new Posicion(posicion.getX() - 1,posicion.getY() - 1);
    }
    
    public Posicion avanzarDiagonalAD(Posicion posicion) {
        return new Posicion(posicion.getX() - 1,posicion.getY() + 1);
    }
    
    public Posicion avanzarDiagonalABI(Posicion posicion) {
		return new Posicion(posicion.getX() - 1,posicion.getY() - 1);
    }
    
    public Posicion avanzarDiagonalABD(Posicion posicion) {
		return new Posicion(posicion.getX() + 1,posicion.getY()-1);
    }
    
    public Posicion avanzarDerecha(Posicion posicion) {
		return new Posicion(posicion.getX() + 1,posicion.getY()+1);
    }
    
    public Posicion avanzarArriba(Posicion posicion) {
		return new Posicion(posicion.getX() - 1, posicion.getY());
    }
    
    public Posicion avanzarAbajo(Posicion posicion) {
        return new Posicion(posicion.getX() + 1, posicion.getY());
	}
}
