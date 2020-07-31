package fiuba.algo3.algochess.models;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.algochess.models.bandos.Bando;
import fiuba.algo3.algochess.models.entidades.Entidad;
import fiuba.algo3.algochess.models.entidades.FabricaDeEntidades;

public class Jugador {
    
    private final int  PUNTOS_INICIALES = 20;
	
	private int puntosActuales = PUNTOS_INICIALES;
	
	private String nombre;
	
	private FabricaDeEntidades fabrica = new FabricaDeEntidades();
	
	private List<Entidad> entidades;
	
	private Bando bando;
	
	private Jugador otroJugador;
		
	public Jugador(String nombre, Bando bando, Jugador otroJugador) {
		asignarAtributosDelJugador(nombre, bando);
		this.otroJugador = otroJugador;
	}
	
	public Jugador(String nombre, Bando bando, String nombre1, Bando bando1) {
		asignarAtributosDelJugador(nombre, bando);
		this.otroJugador = new Jugador(nombre1, bando1, this);
	}
	private void asignarAtributosDelJugador(String nombre, Bando bando) {
		this.nombre = nombre;
		this.bando = bando;
		this.entidades  = new ArrayList<Entidad>();
	}

	public Jugador obtenerSiguienteJugador() {
		return this.otroJugador;
	}

	public void agregarEntidad(Entidad entidad) {
        entidades.add(entidad);
        entidad.setPropietario(this);
	}
	
}