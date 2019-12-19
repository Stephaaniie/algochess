package fiuba.algo3.Vista.EntidadesAComprar;

import fiuba.algo3.Controlador.EntidadesBotonParaComprar.EntidadCompra;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class CompraSoldadoVista extends CompraEntidadVista{
	
	private final static String SOLDADO_ALIADO = "src/main/Imagenes/soldado.png";
	
	private final static String SOLDADO_ENEMIGO = "src/main/Imagenes/soldado1.png";
	
	public CompraSoldadoVista(EntidadCompra comprarEntidad, VistaDelTablero vistaDeTablero) {
		super(comprarEntidad, vistaDeTablero, new Sprite(SOLDADO_ALIADO,0, 0, 27, 19, 50, 50), new Sprite(SOLDADO_ENEMIGO, 0, 0, 27, 19, 50, 50));
	}
}

	