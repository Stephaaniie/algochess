package fiuba.algo3.Controlador.EntidadesBotonParaComprar;

import fiuba.algo3.Modelado.Entidades.Curandero;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.EntidadesAComprar.VistaDeCompra;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class CuranderoBotonParaComprar extends EntidadCompra{

	public CuranderoBotonParaComprar(VistaDelTablero vistaDelTablero, Tablero tablero, VistaDeCompra vistaDeCompra) {
		super(vistaDelTablero, tablero, vistaDeCompra);
	}

	@Override
	protected Entidad comprarEntidad() {
		return new Curandero();
	}
}
