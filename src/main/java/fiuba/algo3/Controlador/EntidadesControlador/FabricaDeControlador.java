package fiuba.algo3.Controlador.EntidadesControlador;

import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.Modelado.Entidades.Catapulta;
import fiuba.algo3.Modelado.Entidades.Curandero;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.Jinete;
import fiuba.algo3.Modelado.Entidades.Soldado;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class FabricaDeControlador {
	
	private static final Map<String,GeneradorDeControladores> controladores = new HashMap<String,GeneradorDeControladores>(Map.ofEntries(Map.entry(Soldado.class.getName(),SoldadoControlador::new),Map.entry(Jinete.class.getName(),JineteControlador::new),Map.entry(Catapulta.class.getName(),CatapultaControlador::new),Map.entry(Curandero.class.getName(),CuranderoControlador::new))); 
	
	@FunctionalInterface
	private interface GeneradorDeControladores{
		EntidadControladora getEntidadControladora(Entidad entidad, VistaEntidad vistaEntidad,VistaDelTablero vistaDelTablero);
	}
	
	public static EntidadControladora getInstancia(Entidad entidad, VistaEntidad vistaEntidad, VistaDelTablero vistaDelTablero) {
		return controladores.get(entidad.getClass().getName()).getEntidadControladora(entidad, vistaEntidad, vistaDelTablero);
	}
}

