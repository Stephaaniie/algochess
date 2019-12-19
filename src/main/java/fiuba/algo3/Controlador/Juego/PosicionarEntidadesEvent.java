package fiuba.algo3.Controlador.Juego;

import org.w3c.dom.events.MouseEvent;

import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.ObjetoNull;
import fiuba.algo3.Modelado.Excepciones.CasilleroOcupadoExcepcion;
import fiuba.algo3.Modelado.Excepciones.ColocarEntidadEnSectorEnemigoExcepcion;
import fiuba.algo3.Modelado.Jugador.TurnoSiguiente;
import fiuba.algo3.Modelado.Tablero.Posicion;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.EntidadesAComprar.VistaDeCompra;
import fiuba.algo3.Vista.EntidadesVista.ColeccionVistaAliados;
import fiuba.algo3.Vista.EntidadesVista.ColeccionVistaEnemigos;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class PosicionarEntidadesEvent {
	
	private Entidad entidad;
	
	private Tablero tablero;
	
	private VistaDelTablero vistaDelTablero;
	
	private VistaDeCompra vistaDeCompra;
	
	public PosicionarEntidadesEvent(Entidad entidad, Tablero tablero, VistaDelTablero vistaDelTablero, VistaDeCompra vistaDeCompra) {
		
		this.entidad = entidad;
		
		this.tablero = tablero;
		
		this.vistaDeCompra = vistaDeCompra;
		
		this.vistaDelTablero = vistaDelTablero;
	}
	
	public void handle(MouseEvent click) {
		
		double clickFila = click.getClientX();
		double clickColumna = click.getClientY();
		
		int fila = (int) clickFila/ vistaDelTablero.getTileAncho();
		int columna = (int) clickColumna/vistaDelTablero.getTileAlto();
		
		try {
			if(!entidad.equals(null)) {
				tablero.agregarEntidadEnCasillero(entidad, new Posicion(fila,columna));
				vistaDelTablero.resetearCasilleros();
				vistaDeCompra.setDisable(false);
				vistaDelTablero.setDisable(true);
				
				if(TurnoSiguiente.getInstancia().getBandoJugadorActual().equals(tablero.getJugador().getBando())) {
					ColeccionVistaAliados.getInstancia(entidad, vistaDelTablero);
				}else {
					ColeccionVistaEnemigos.getInstancia(entidad, vistaDelTablero);
				}
				entidad = new ObjetoNull();
			}
			
		}catch(ColocarEntidadEnSectorEnemigoExcepcion e) {
			
		}catch(CasilleroOcupadoExcepcion n) {
			
		}
			
	}

}
