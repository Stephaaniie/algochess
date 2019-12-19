package fiuba.algo3.Vista.EntidadesAComprar;

import fiuba.algo3.Controlador.EntidadesBotonParaComprar.EntidadCompra;
import fiuba.algo3.Vista.Ventana.VistaDelTablero;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public abstract class CompraEntidadVista extends Button{

	private static final int BOTON_ANCHO = 320;
	
	private static final int BOTON_ALTO  = 100;
	
	private EntidadCompra entidadComprada;
	
	private VistaDelTablero vistaDeTablero;
	
	private Sprite spriteAliado;

	private Sprite spriteEnemigo;
	
	public CompraEntidadVista(EntidadCompra comprarEntidad,VistaDelTablero vistaDeTablero, Sprite spriteAliado, Sprite spriteEnemigo) {
		
		this.setEntidadComprada(comprarEntidad);
		this.setVistaDeTablero(vistaDeTablero);
		
		this.setSpriteAliado(spriteAliado);
		this.setSpriteEnemigo(spriteEnemigo);
		
		this.setMinSize(BOTON_ANCHO, BOTON_ALTO);
		this.setMaxSize(BOTON_ANCHO, BOTON_ALTO);
		
		HBox hBox = new HBox();
		
		hBox.getChildren().add(getVistaDeImagen(getImagen(spriteAliado)));
		hBox.getChildren().add(getVistaDeImagen(getImagen(spriteEnemigo)));
				
		this.setGraphic(hBox);
		this.setOnAction(comprarEntidad);
	}

	private Image getImagen(Sprite sprite) {
		return SwingFXUtils.toFXImage(sprite.getFrameActual(), null);
	}
	
	private ImageView getVistaDeImagen(Image imagen) {
		ImageView imageView = new ImageView(imagen);
		imageView.setFitWidth(imagen.getWidth());
		imageView.setFitHeight(imagen.getHeight());
		return imageView;
	}

	public EntidadCompra getEntidadComprada() {
		return entidadComprada;
	}

	public void setEntidadComprada(EntidadCompra entidadComprada) {
		this.entidadComprada = entidadComprada;
	}

	public VistaDelTablero getVistaDeTablero() {
		return vistaDeTablero;
	}

	private void setVistaDeTablero(VistaDelTablero vistaDeTablero) {
		this.vistaDeTablero = vistaDeTablero;
	}

	public Sprite getSpriteAliado() {
		return spriteAliado;
	}
	
	public Sprite getSpriteEnemigo() {
		return spriteEnemigo;
	}
	private void setSpriteAliado(Sprite spriteAliado) {
		this.spriteAliado = spriteAliado;
	}

	private void setSpriteEnemigo(Sprite spriteEnemigo) {
		this.spriteEnemigo = spriteEnemigo;
	}
	
}
