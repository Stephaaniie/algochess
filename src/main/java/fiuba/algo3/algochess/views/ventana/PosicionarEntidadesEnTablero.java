package fiuba.algo3.Vista.Ventana;

import fiuba.algo3.Controlador.EntidadesBotonParaComprar.EntidadCompra;
import fiuba.algo3.Modelado.Entidades.Catapulta;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.Jinete;
import fiuba.algo3.Modelado.Entidades.Soldado;
import fiuba.algo3.Modelado.Tablero.Posicion;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.EntidadesAComprar.CompraCatapultaVista;
import fiuba.algo3.Vista.EntidadesAComprar.CompraCuranderoVista;
import fiuba.algo3.Vista.EntidadesAComprar.CompraJineteVista;
import fiuba.algo3.Vista.EntidadesAComprar.CompraSoldadoVista;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

public class PosicionarEntidadesEnTablero implements EventHandler<MouseEvent>{
	
	private Entidad entidad;
	
	private Tablero tablero;
	
	private VistaDelTablero vista;
	
	private EntidadCompra entidadComprada;
	
	public PosicionarEntidadesEnTablero(EntidadCompra entidadComprada,Entidad entidad, Tablero tablero, VistaDelTablero vista) {
		
		this.entidad = entidad;
		
		this.tablero = tablero;
		
		this.vista   = vista;
		
		this.entidadComprada = entidadComprada;
	}
	
	public void handle(MouseEvent click) {
		
		int fila = (int) click.getX()/48;
		int columna= (int) click.getY()/38;
		
		try {
			tablero.agregarEntidadEnCasillero(entidad, new Posicion(fila,columna));
			if(entidad.getClass() == Soldado.class) {
				new CompraSoldadoVista(entidadComprada, vista);
			}else if(entidad.getClass() == Jinete.class) {
				new CompraJineteVista(entidadComprada, vista);
			}else if(entidad.getClass() == Catapulta.class) {
				new CompraCatapultaVista(entidadComprada, vista);
			}else {
				new CompraCuranderoVista(entidadComprada, vista);
			}
		}catch(RuntimeException e) {
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setContentText("Este sector no es el correspondiente");
			alerta.showAndWait();
		}
	}
}
