package fiuba.algo3.algochess.controller.entidades;

public abstract class Unidad extends Observable {    
    //protected Casilla casilla;
    //protected Jugador propietario;

    private double vida;
    private int costo;

    private double multiplicadorDeDanio;

    public Unidad(int vida, int costo) {
        this.multiplicadorDeDanio = 0;
        this.costo = costo;
        this.vida = vida;
    }

    public Unidad(int vida, int costo) {
        this.multiplicadorDeDanio = 0;
        this.costo = costo;
        this.vida = vida;
    }
}