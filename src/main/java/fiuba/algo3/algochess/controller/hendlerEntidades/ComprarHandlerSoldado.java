package fiuba.algo3.Controlador.EntidadesHendler;

import fiuba.algo3.Controlador.EntidadesBotonParaComprar.EntidadCompra;
import fiuba.algo3.Modelado.Entidades.Soldado;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.Ventana.PosicionarEntidadesEnTablero;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarHandlerSoldado implements EventHandler<ActionEvent>{

	private Tablero tablero;
	
	private VistaDelTablero vista;
	
	private EntidadCompra entidadCompra;
	
	public ComprarHandlerSoldado(Tablero tablero, VistaDelTablero vista,EntidadCompra entidadCompra) {
	
		this.tablero = tablero;
		
		this.vista   = vista;
		
		this.entidadCompra = entidadCompra;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			Soldado soldado = new Soldado();
			tablero.getJugador().comprarEntidad(soldado);
			vista.setOnMousePressed(new PosicionarEntidadesEnTablero(entidadCompra,soldado,tablero,vista));
		}catch(RuntimeException e) {
			System.out.println("Lo sentimos, pero ya no contas con puntos suficientes para adquierir un soldado");
		}	
	}

}
