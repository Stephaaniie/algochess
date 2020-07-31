package fiuba.algo3.algochess.models.tablero;

import static java.lang.Math.sqrt;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Posicion extends Direccion{

    private int x;

    private int y;

    public Posicion(int x, int y) {
        this.x = x;

        this.y = y;
    }

    public int getX() {
        return x; 
    }

    public int getY() {
        return y; 
    }

    public int distanciaAPosicion(Posicion posicion) {
        return posicion.distanciaAXeY(x, y);
    }

    private int distanciaAXeY(int x, int y) {
        int distanciaEnX = abs(this.x - x);
        int distanciaEnY = abs(this.y - y);
        return (int) sqrt(pow(distanciaEnX, 2) + pow(distanciaEnY, 2));
    }   

    public boolean isEquals(Posicion posicion) {
        return posicion.poseeXeY(x, y);
    }

    private boolean poseeXeY(int x, int y) {
        return this.x == x && this.y == y;
    }
}
