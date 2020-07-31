package fiuba.algo3.Controlador.EmpezarJuego;

import fiuba.algo3.Vista.Juego.VistaJuego;
import fiuba.algo3.Vista.Ventana.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EmpezarJuegoHendler extends Observable implements EventHandler<ActionEvent>{
	
	public EmpezarJuegoHendler( VistaJuego vista) {
		addObserver(vista);
	}


	@Override
	public void handle(ActionEvent click) {
		notificarObservers();
	}
	
}
