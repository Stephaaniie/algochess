package fiuba.algo3.Vista.EntidadesVista;

import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesAComprar.Sprite;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class VistaSoldadoAliado extends VistaEntidad{
	
	private final static String SOLDADO_ALIADO = "src/main/Imagenes/soldado.png";	

	public VistaSoldadoAliado(Entidad entidad, VistaDelTablero vistaDelTablero, Sprite sprite) {
		super(entidad, vistaDelTablero, new Sprite(SOLDADO_ALIADO));
	}

	@Override
	public void setFrameUp() {		
		this.setFrame(0, 0);
	}

	@Override
	public void setFrameDown() {	
		this.setFrame(1, 1);
	}

	@Override
	public void setFrameLeft() {	
		this.setFrame(2, 2);
	}

	@Override
	public void setFrameRight() {
		this.setFrame(3, 3);
	}
}
