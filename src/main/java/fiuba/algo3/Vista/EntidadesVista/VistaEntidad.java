package fiuba.algo3.Vista.EntidadesVista;

import fiuba.algo3.Controlador.EntidadesControlador.FabricaDeControlador;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Vista.EntidadesAComprar.Sprite;
import fiuba.algo3.Vista.Ventana.Observer;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class VistaEntidad implements Observer{
	 
	private VistaDelTablero vistaDelTablero;
	 
	 private Entidad entidad;

	 private ImageView imagen;
	 
	 private Sprite sprite;

	 public VistaEntidad(Entidad entidad, VistaDelTablero vistaDelTablero, Sprite sprite) {
		 
		 this.sprite  = sprite;
	     this.entidad = entidad;
	     this.vistaDelTablero = vistaDelTablero;

	     imagen = new ImageView();
	     imagen.setImage(getImagen());
	     imagen.setFitWidth(getImagen().getWidth());
	     imagen.setFitHeight(getImagen().getHeight());

	     imagen.setOnMouseClicked(FabricaDeControlador.getInstancia(entidad, this, vistaDelTablero));

	     vistaDelTablero.agregarVistasEnMap(imagen, entidad.getPosicion().getFila(), entidad.getPosicion().getColumna());

	    }

	    public void setFrame(int fila, int columna) {
	        sprite.setActualFrame(fila, columna);
	    }

	    public Image getImagen() {
	        return SwingFXUtils.toFXImage(sprite.getFrameActual(), null);
	    }

	    public void update() {
	        if (entidad.getVida() <= 0) {
	            vistaDelTablero.remove(imagen);
	        } else {
	            imagen.setImage(getImagen());
	   	     	vistaDelTablero.agregarVistasEnMap(imagen, entidad.getPosicion().getFila(), entidad.getPosicion().getColumna());
	        }
	    }

	    public abstract void setFrameUp();

	    public abstract void setFrameDown();

	    public abstract void setFrameLeft();

	    public abstract void setFrameRight();

		public void change() {
			update();
		}

	
}
