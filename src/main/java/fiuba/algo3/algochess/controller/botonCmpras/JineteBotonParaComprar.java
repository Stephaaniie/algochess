package fiuba.algo3.Controlador.EntidadesBotonParaComprar;

import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.Jinete;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.EntidadesAComprar.VistaDeCompra;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class JineteBotonParaComprar extends EntidadCompra {

	public JineteBotonParaComprar(VistaDelTablero vistaDelTablero, Tablero tablero, VistaDeCompra vistaDeCompra) {
		super(vistaDelTablero, tablero, vistaDeCompra);
	}

	@Override
	protected Entidad comprarEntidad() {
		return new Jinete();
	}
}
