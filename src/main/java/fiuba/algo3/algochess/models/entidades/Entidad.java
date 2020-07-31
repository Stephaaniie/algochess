package fiuba.algo3.algochess.models.entidades;

import fiuba.algo3.algochess.models.Jugador;
import fiuba.algo3.algochess.models.tablero.Casillero;

public abstract class Entidad extends Observable {   

    protected Casillero casillero;

    protected Jugador propietario;

    private int vida;

    private int costo;

    private int danio;

    public Entidad(Jugador propietario, int vida, int costo) {
        this.danio = 0;
        this.propietario = propietario;
        this.costo = costo;
        this.vida = vida;
    }

    public Entidad(int vida, int costo) {
        this.danio = 0;
        this.costo = costo;
        this.vida = vida;
    }

	public Casillero getCasillero() {
		return casillero;
	}

	public void setCasillero(Casillero casillero) {
		this.casillero = casillero;
	}

	public Jugador getPropietario() {
		return propietario;
	}

	public void setPropietario(Jugador propietario) {
		this.propietario = propietario;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getDanio() {
		return danio;
	}

	public void setDanio(int danio) {
		this.danio = danio;
    }
}