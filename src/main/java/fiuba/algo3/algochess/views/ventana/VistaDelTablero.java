package fiuba.algo3.Vista.Ventana;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.Controlador.MoverControlador.MoverAbajoControlador;
import fiuba.algo3.Controlador.MoverControlador.MoverAbajoDerechaControlador;
import fiuba.algo3.Controlador.MoverControlador.MoverAbajoIzquierdaControlador;
import fiuba.algo3.Controlador.MoverControlador.MoverArribaControlador;
import fiuba.algo3.Controlador.MoverControlador.MoverArribaDerechaControlador;
import fiuba.algo3.Controlador.MoverControlador.MoverArribaIzquierdaControlador;
import fiuba.algo3.Controlador.MoverControlador.MoverDerechaControlador;
import fiuba.algo3.Controlador.MoverControlador.MoverIzquierdaControlador;
import fiuba.algo3.Modelado.Entidades.Entidad;
import fiuba.algo3.Modelado.Jugador.TurnoSiguiente;
import fiuba.algo3.Modelado.Tablero.Tablero;
import fiuba.algo3.Vista.EntidadesVista.VistaEntidad;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class VistaDelTablero extends Group {

	private Tablero tablero;
	private GridPane table;
	
	private int ancho;
    private int alto;
    
    private int tamanioCeldaH = 32;
    private int tamanioCeldaA = 32;
    
    private Pane[][] panes;
 
    public VistaDelTablero(Tablero tablero) {
    	
    	this.table = new GridPane();
    	
    	this.tablero = tablero;
    	this.ancho = tablero.getTamanioTablero();
    	this.alto  = tablero.getTamanioTablero();
    	
    	panes = new Pane[ancho*tamanioCeldaA][alto*tamanioCeldaH];
    	
    	for(int i = 0; i < alto; i++) {
    		for(int j = 0; j < ancho; j++) {
    			Pane aux = new Pane();
    			aux.setMinHeight(tamanioCeldaH);
    			aux.setMaxWidth(tamanioCeldaA);
    			aux.setStyle("-fx-background-color: #CCCCFF");
    			panes[i][j] = aux;
    			table.add(aux, i, j);
    		}
    	}
    	table.setVgap(0);
    	table.setHgap(0);
    	table.setGridLinesVisible(true);
    	table.setBackground(new Background(new BackgroundImage(new Image("color.png"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
    	this.añadirVista(table);
    }

	private void añadirVista(Node vista) {
		this.getChildren().add(vista);
	}
    
    public void agregarVistasEnMap(Node vista,int fila, int columna) {
    	panes[fila][columna].getChildren().remove(vista);
    	panes[fila][columna].getChildren().add(vista);
    }
    
    public void remove(Node vista) {
    	for (int i = 0; i < ancho; i++) {
    		for (int j = 0; j < alto; j++) {
                try {
                    panes[i][j].getChildren().remove(vista);
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void actualizarVista(Node vista, int fila, int columna) {
    	remove(vista);
    	agregarVistasEnMap(vista,fila,columna);
    }

    public boolean paneEstaVacio(Pane pane) {
    	return pane.getChildren().isEmpty();
    }
    
    public List<Pane> panesADirigirseEnTablero(Entidad entidad, VistaEntidad vistaEntidad){
    	
    	List<Pane> panesMover = new ArrayList<Pane>();
    	
    	try {
    		if(paneEstaVacio(paneArriba(entidad))) {
    			
    			paneArriba(entidad).setOnMouseClicked(new MoverArribaControlador(entidad, vistaEntidad));
        		panesMover.add(paneArriba(entidad));
    		}
    	}catch (RuntimeException e) {}
    	try {
    		if(paneEstaVacio(paneAbajo(entidad))) {
    	    	
    			paneAbajo(entidad).setOnMouseClicked(new MoverAbajoControlador(entidad, vistaEntidad));
        		panesMover.add(paneAbajo(entidad));
    		}
       	}catch (RuntimeException e) {}
    	try {
    		if(paneEstaVacio(paneDerecha(entidad))) {
    			paneDerecha(entidad).setOnMouseClicked(new MoverDerechaControlador(entidad, vistaEntidad));
    			panesMover.add(paneDerecha(entidad));
    		}
    	}catch (RuntimeException e) {}
    	
    	try {
    		if(paneEstaVacio(paneIzquierda(entidad))) {
    			paneIzquierda(entidad).setOnMouseClicked(new MoverIzquierdaControlador(entidad, vistaEntidad));
    			panesMover.add(paneIzquierda(entidad));
    		}
    	}catch (RuntimeException e) {}    	
    	try {
    		if(paneEstaVacio(paneDerechaArriba(entidad))) {
    			
    			paneDerechaArriba(entidad).setOnMouseClicked(new MoverArribaDerechaControlador(entidad, vistaEntidad));
        		panesMover.add(paneDerechaArriba(entidad));
    		}
    	}catch (RuntimeException e) {}
    	
    	try {
    		if(paneEstaVacio(paneIzquierdaArriba(entidad))) {
    			
        		paneIzquierdaArriba(entidad).setOnMouseClicked(new MoverArribaIzquierdaControlador(entidad, vistaEntidad));
        		panesMover.add(paneIzquierdaArriba(entidad));

    		}
    	}catch (RuntimeException e) {}
    	
    	try {
    		if(paneEstaVacio(paneDerechaAbajo(entidad))) {
    			paneDerechaAbajo(entidad).setOnMouseClicked(new MoverAbajoDerechaControlador(entidad, vistaEntidad));
        		panesMover.add(paneDerechaAbajo(entidad));
    		}
    	}catch (RuntimeException e) {}
    	try {
    		if(paneEstaVacio(paneIzquierdaAbajo(entidad))) {
    			paneIzquierdaAbajo(entidad).setOnMouseClicked(new MoverAbajoIzquierdaControlador(entidad, vistaEntidad));
        		panesMover.add(paneIzquierdaAbajo(entidad));
    		}
    	}catch (RuntimeException e) {}
		
    	return panesMover;
    }

	public Pane paneArriba(Entidad entidad) {
		return panes[entidad.getPosicion().getFila()-1][entidad.getPosicion().getColumna()];
	}
    
	public Pane paneAbajo(Entidad entidad) {
		return panes[entidad.getPosicion().getFila()+1][entidad.getPosicion().getColumna()];
	}
	
	public Pane paneDerecha(Entidad entidad) {
		return panes[entidad.getPosicion().getFila()][entidad.getPosicion().getColumna()+1];
	}
	
	public Pane paneDerechaArriba(Entidad entidad) {
		return panes[entidad.getPosicion().getFila()-1][entidad.getPosicion().getColumna()+1];
	}
	
	public Pane paneDerechaAbajo(Entidad entidad) {
		return panes[entidad.getPosicion().getFila()+1][entidad.getPosicion().getColumna()+1];
	}
	
	public Pane paneIzquierda(Entidad entidad) {
		return panes[entidad.getPosicion().getFila()][entidad.getPosicion().getColumna()-1];
	}
	
	public Pane paneIzquierdaArriba(Entidad entidad) {
		return panes[entidad.getPosicion().getFila()-1][entidad.getPosicion().getColumna()-1];
	}
	
	public Pane paneIzquierdaAbajo(Entidad entidad) {
		return panes[entidad.getPosicion().getFila()+1][entidad.getPosicion().getColumna()-1];
	}
	
	public Pane paneActual(Entidad entidad) {
        panes[entidad.getPosicion().getFila()][entidad.getPosicion().getColumna()].setStyle("-fx-background-color: #FF99FF");
        return panes[entidad.getPosicion().getFila()][entidad.getPosicion().getColumna()];
    }

	public int getTileAncho() {
		return this.tamanioCeldaA;
	}

	public int getTileAlto() {
		return this.tamanioCeldaH;
	}

	public void resetearCasilleros() {
		int columna = 10;
	    int limite = 20;

	    if(tablero.getJugador() == TurnoSiguiente.getInstancia().getJugadorActual()) {
	    	columna = 0;
	        limite = 10;
	    }
	    for(int i = 0; i < ancho; i++) {
	    	for(int j = columna; j < limite; j++) {
	    		panes[i][j].setStyle("-fx-background-color: rgba(255,255,255,0)");
	        }
	    }
	}

	public void marcarCasilleroDelJugadorActual() {
		int columna = 0;
	    int limite = 10;

	    if(tablero.getJugador() == TurnoSiguiente.getInstancia().getJugadorActual()) {
	    	columna = 10;
	        limite = 20;
	    }
	    for(int i = 0; i < ancho; i++) {
	    	for(int j = columna; j < limite; j++) {
	        	panes[i][j].setStyle("-fx-background-color: rgba(70,222,32,0.43)");
	        }
	    }
	}

}