package fiuba.algo3.Algochess.EntidadesVista;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.EntidadesControlador.JineteControlador;
import fiuba.algo3.AlgoChess.Ventana.VistaDelTablero;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CuranderoVista{
	
	private VistaDelTablero tablero;
	
	private Entidad entidad;
		
	private ImageView imagen;
	
	public CuranderoVista(VistaDelTablero tablero,Entidad entidad) {
		this.tablero = tablero;
		this.entidad = entidad;
		imagen       = new ImageView();
		imagen.setScaleX(1.2);
		imagen.setScaleY(1.2);
		imagen.setFitHeight(38);
		imagen.setFitWidth(48);
		imagen.setImage(getImage());
		tablero.agregarVistasEnMap(imagen, entidad.getPosicion().getFila(),entidad.getPosicion().getColumna());
		imagen.setOnMouseClicked(new JineteControlador(entidad,tablero));
	}

	private Image getImage() {
		try {
			BufferedImage bff = ImageIO.read(new File("src/main/Sprites/curandero.png"));
			BufferedImage sub = bff.getSubimage(4 * 32, 0, 32, 32);
			Image imagen = SwingFXUtils.toFXImage(sub, null);
			return imagen;
		}catch(IOException e) {
			System.out.println("Error de apertura de archivos");
		}
		return new Image("curandero.png");
	}
	
	public void cambio() {
		tablero.agregarVistasEnMap(imagen, entidad.getPosicion().getFila(), entidad.getPosicion().getColumna());
	}
}

