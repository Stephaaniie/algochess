package fiuba.algo3.Vista.EntidadesVista;

import java.util.HashMap;
import java.util.Map;

import fiuba.algo3.Modelado.Entidades.Catapulta;
import fiuba.algo3.Modelado.Entidades.Curandero;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Entidades.Jinete;
import fiuba.algo3.Modelado.Entidades.Soldado;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class ColeccionVistaAliados {
	
	@FunctionalInterface
    private interface ProveedorDeVistas {
        VistaEntidad getVistaEntidad(Entidad entidad, VistaDelTablero vistaDelTablero);
    }

    private static final Map<String, ProveedorDeVistas> entidades = new HashMap<String, ProveedorDeVistas>(Map.ofEntries(Map.entry(Soldado.class.getName(), VistaSoldadoEnemigo::new),Map.entry(Catapulta.class.getName(), VistaCatapultaEnemiga::new),Map.entry(Curandero.class.getName(), VistaCuranderoEnemigo::new),Map.entry(Jinete.class.getName(), VistaJineteEnemigo::new)));

    public static VistaEntidad getInstancia(Entidad entidad, VistaDelTablero vistaDelTablero) {
        return entidades.get(entidad.getClass().getName()).getVistaEntidad(entidad, vistaDelTablero);
    }
}
