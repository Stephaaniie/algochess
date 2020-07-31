package fiuba.algo3.Controlador.EntidadesBotonParaComprar;

import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Jugador.TurnoSiguiente;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.EntidadesAComprar.VistaDeCompra;
import fiuba.algo3.Vista.Ventana.PosicionarEntidadesEnTablero;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class EntidadCompra implements EventHandler<ActionEvent> {

	protected VistaDelTablero vistaDelTablero;
	
	protected Tablero tablero;
	
	protected VistaDeCompra vistaDeCompra;
	
	protected abstract Entidad comprarEntidad();
	
	public EntidadCompra(VistaDelTablero vistaDelTablero,Tablero tablero, VistaDeCompra vistaDeCompra) {
		
		this.vistaDelTablero = vistaDelTablero;
		
		this.tablero = tablero;
	
		this.vistaDeCompra = vistaDeCompra;
	}
	
	@Override
	public void handle(ActionEvent event) {
		try {
			Entidad entidad = comprarEntidad();
			TurnoSiguiente.getInstancia().getJugadorActual().comprarEntidad(entidad);
			vistaDeCompra.setDisable(true);
			vistaDelTablero.setDisable(false);
			vistaDelTablero.marcarCasilleroDelJugadorActual();
			vistaDelTablero.setOnMousePressed(new PosicionarEntidadesEnTablero(this, entidad,tablero,vistaDelTablero));
		}catch(RuntimeException e) {
			
		}
	}
	
	
}
