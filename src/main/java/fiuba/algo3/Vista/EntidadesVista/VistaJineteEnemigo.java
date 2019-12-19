package fiuba.algo3.Vista.EntidadesVista;

import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesAComprar.Sprite;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;

public class VistaJineteEnemigo  extends VistaEntidad {
	
	private final static String JINETE_ENEMIGO = "src/main/Imagenes/jinete1.png";
	
	public VistaJineteEnemigo(Entidad entidad, VistaDelTablero vistaDelTablero) {
		super(entidad, vistaDelTablero, new Sprite(JINETE_ENEMIGO));
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
