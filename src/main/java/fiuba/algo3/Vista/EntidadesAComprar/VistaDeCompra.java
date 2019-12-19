package fiuba.algo3.Vista.EntidadesAComprar;

import fiuba.algo3.Controlador.EntidadesBotonParaComprar.EntidadCompra;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class VistaDeCompra extends VBox{

	public VistaDeCompra(EntidadCompra comprarEntidad, VistaDelTablero vistaDelTablero) {
		this.setWidth(320);
	
		addVista(new CompraSoldadoVista(comprarEntidad, vistaDelTablero));
	
		addVista(new CompraJineteVista(comprarEntidad,vistaDelTablero));
	
		addVista(new CompraCatapultaVista(comprarEntidad, vistaDelTablero));
	
		addVista(new CompraCuranderoVista(comprarEntidad, vistaDelTablero));
	}

	private void addVista(Node vista) {
		this.getChildren().remove(vista);
		this.getChildren().add(vista);
	}

}
