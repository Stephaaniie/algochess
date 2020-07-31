package fiuba.algo3.algochess.models.entidades;

public abstract class Entidad extends Observable {   

    protected String casillero;

    protected String propietario;

    private int vida;

    private int costo;

    private int danio;

    public Entidad(String propietario, int vida, int costo) {
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

	public String getCasillero() {
		return casillero;
	}

	public void setCasillero(String casillero) {
		this.casillero = casillero;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
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