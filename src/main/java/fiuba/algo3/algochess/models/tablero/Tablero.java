package fiuba.algo3.algochess.models.tablero;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.algochess.models.entidades.Entidad;

public class Tablero {
    private static final int FILAS = 20;
    private static final int COLUMNAS = 20;

    private List<Casillero> casilleros;
    private List<Entidad> entidades;

    public Tablero() {
        entidades = new LinkedList<>();
        setCasillasVacias();
    }

    private void setCasillasVacias() {
        casilleros = new ArrayList<>();
        inicializarCasilleros(0, FILAS / 2);
        inicializarCasilleros(FILAS / 2, FILAS);
    }

	private void inicializarCasilleros(int i, int j) {
	}
    
}