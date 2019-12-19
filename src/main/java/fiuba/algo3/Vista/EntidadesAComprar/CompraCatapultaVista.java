package fiuba.algo3.Vista.EntidadesAComprar;

import fiuba.algo3.Controlador.EntidadesBotonParaComprar.EntidadCompra;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class CompraCatapultaVista extends CompraEntidadVista{

	private final static String CATAPULTA_ALIADO = "src/main/Imagenes/catapulta.png";
	
	private final static String CATAPULTA_ENEMIGO = "src/main/Imagenes/catapulta1.png";
	
	public CompraCatapultaVista(EntidadCompra comprarEntidad, VistaDelTablero vistaDeTablero) {
		super(comprarEntidad, vistaDeTablero, new Sprite(CATAPULTA_ALIADO, 0, 0, 27, 19, 50, 50), new Sprite(CATAPULTA_ENEMIGO, 0, 0, 27, 19, 50, 50));
	}
}																		