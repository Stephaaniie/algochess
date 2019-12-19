package fiuba.algo3.Controlador.EntidadesHendler;

import fiuba.algo3.Controlador.EntidadesBotonParaComprar.EntidadCompra;
import fiuba.algo3.Modelado.Entidades.Jinete;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.Ventana.PosicionarEntidadesEnTablero;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComprarHandlerJinete implements EventHandler<ActionEvent>{

	private Tablero tablero;
	
	private VistaDelTablero vista;

	private EntidadCompra entidadCompra;

	public ComprarHandlerJinete(Tablero tablero, VistaDelTablero vista,EntidadCompra entidadCompra) {
		
		this.tablero = tablero;
		
		this.vista   = vista;
	
		this.entidadCompra = entidadCompra;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			Jinete jinete = new Jinete();
			tablero.getJugador().comprarEntidad(jinete);
			vista.setOnMousePressed(new PosicionarEntidadesEnTablero(entidadCompra,jinete,tablero,vista));
		}catch(RuntimeException e) {
			System.out.println("Lo sentimos, pero ya no contas con puntos suficientes para adquierir un Jinete");
		}	
	}

}
