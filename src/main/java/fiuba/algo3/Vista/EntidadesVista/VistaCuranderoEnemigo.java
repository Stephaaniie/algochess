package fiuba.algo3.Vista.EntidadesVista;

import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesAComprar.Sprite;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class VistaCuranderoEnemigo extends VistaEntidad {
		
	private final static String CURANDERO_ENEMIGO = "src/main/Imagenes/curandero1.png";
	
	public VistaCuranderoEnemigo(Entidad entidad, VistaDelTablero vistaDelTablero) {
		super(entidad, vistaDelTablero, new Sprite(CURANDERO_ENEMIGO));
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
