package fiuba.algo3.Controlador.EntidadesHendler;

import fiuba.algo3.Controlador.EntidadesBotonParaComprar.EntidadCompra;
import fiuba.algo3.Modelado.Entidades.Curandero;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.Ventana.PosicionarEntidadesEnTablero;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarHandlerCurandero implements EventHandler<ActionEvent>{

	private Tablero tablero;
	
	private VistaDelTablero vista;

	private EntidadCompra entidadCompra;
	
	public ComprarHandlerCurandero(Tablero tablero, VistaDelTablero vista,EntidadCompra entidadCompra) {
		
		this.tablero = tablero;
		
		this.vista   = vista;
	
		this.entidadCompra = entidadCompra;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			Curandero curandero = new Curandero();
			tablero.getJugador().comprarEntidad(curandero);
			vista.setOnMousePressed(new PosicionarEntidadesEnTablero(entidadCompra,curandero,tablero,vista));
		}catch(RuntimeException e) {
			System.out.println("Lo sentimos, pero ya no contas con puntos suficientes para adquierir un soldado");
		}	
	}

}
