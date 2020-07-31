package fiuba.algo3.Vista.EntidadesAComprar;

import fiuba.algo3.Controlador.EntidadesBotonParaComprar.EntidadCompra;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class CompraCuranderoVista extends CompraEntidadVista{

	private final static String CURANDERO_ALIADO = "src/main/Imagenes/curandero.png";
	
	private final static String CURANDERO_ENEMIGO = "src/main/Imagenes/curandero1.png";
	
	public CompraCuranderoVista(EntidadCompra comprarEntidad, VistaDelTablero vistaDeTablero) {
		super(comprarEntidad, vistaDeTablero, new Sprite(CURANDERO_ALIADO, 0, 0, 27, 19, 50, 50), new Sprite(CURANDERO_ENEMIGO, 0, 0, 27, 19, 50, 50));
	}
}

