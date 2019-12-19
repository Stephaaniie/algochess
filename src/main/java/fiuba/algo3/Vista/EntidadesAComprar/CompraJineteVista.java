package fiuba.algo3.Vista.EntidadesAComprar;

import fiuba.algo3.Controlador.EntidadesBotonParaComprar.EntidadCompra;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class CompraJineteVista extends CompraEntidadVista{

	private final static String JINETE_ALIADO = "src/main/Imagenes/jinete.png";
	
	private final static String JINETE_ENEMIGO = "src/main/Imagenes/jinete1.png";
	
	public CompraJineteVista(EntidadCompra comprarEntidad, VistaDelTablero vistaDeTablero) {
		super(comprarEntidad, vistaDeTablero, new Sprite(JINETE_ALIADO, 0, 0, 27, 19, 50, 50), new Sprite(JINETE_ENEMIGO, 0, 0, 27, 19, 50, 50));
	}

	
}

	