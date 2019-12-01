package fiuba.algo3.AlgoChess.Ventana;

import java.util.ArrayList;
import java.util.List;

import fiuba.algo3.AlgoChess.Entidades.Entidad;
import fiuba.algo3.AlgoChess.MoverControlador.MoverAbajoControlador;
import fiuba.algo3.AlgoChess.MoverControlador.MoverAbajoDerechaControlador;
import fiuba.algo3.AlgoChess.MoverControlador.MoverAbajoIzquierdaControlador;
import fiuba.algo3.AlgoChess.MoverControlador.MoverArribaControlador;
import fiuba.algo3.AlgoChess.MoverControlador.MoverArribaDerechaControlador;
import fiuba.algo3.AlgoChess.MoverControlador.MoverArribaIzquierdaControlador;
import fiuba.algo3.AlgoChess.MoverControlador.MoverDerechaControlador;
import fiuba.algo3.AlgoChess.MoverControlador.MoverIzquierdaControlador;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class VistaDelTablero extends Group {

	public int ancho = 20;
    public int alto = 20;
    
    private int tamanioCeldaH = 32;
    private int tamanioCeldaA = 32;
    
    private GridPane tablero;
    private Pane[][] panes;
 
    public VistaDelTablero() {
    	GridPane tablero = new GridPane();
    	panes = new Pane[ancho*tamanioCeldaA][alto*tamanioCeldaH];
    	
    	for(int i = 0; i < alto; i++) {
    		for(int j = 0; j < ancho; j++) {
    			Pane aux = new Pane();
    			aux.setMinHeight(tamanioCeldaH);
    			aux.setMaxWidth(tamanioCeldaA);
    			aux.setStyle("-fx-background-color: #CCCCFF");
    			panes[i][j] = aux;
    			tablero.add(aux, i, j);
    		}
    	}
    	tablero.setVgap(1);
    	tablero.setHgap(1);
    	tablero.setStyle("-fx-background-color: #FFCCCC");
    	this.añadirVista(tablero);
    }

    private void añadirVista(Node vista) {
		this.getChildren().add(vista);
	}
    
    public void agregarVistasEnMap(Node vista,int fila, int columna) {
    	for(int i = 0; i < ancho; i++) {
    		for(int j = 0; j < alto; j++) {
    			try {
    				panes[i][j].getChildren().remove(vista);
    			}catch(Exception e) {
    				
    			}
    		}
    		panes[fila][columna].getChildren().add(0,vista);
    	}
    }
    
    public void actualizarvista(Node vista) {
    	getChildren().remove(vista);
    	getChildren().add(vista);
    }

    public List<Pane> panesAdyacentesEnTablero(Entidad entidad){
    	List<Pane> paneAdyacente = new ArrayList<Pane>();
    	try {
    		panes[entidad.getPosicion().getFila()][entidad.getPosicion().getColumna()+1].setOnMouseClicked(new MoverDerechaControlador(entidad));
    		paneAdyacente.add(panes[entidad.getPosicion().getFila()][entidad.getPosicion().getColumna()+1]);
    	}catch (ArrayIndexOutOfBoundsException e) {}
    	
    	try {
    		panes[entidad.getPosicion().getFila()][entidad.getPosicion().getColumna()-1].setOnMouseClicked(new MoverIzquierdaControlador(entidad));
    		paneAdyacente.add(panes[entidad.getPosicion().getFila()][entidad.getPosicion().getColumna()-1]);
    	}catch (ArrayIndexOutOfBoundsException e) {}
    	
    	try {
    		panes[entidad.getPosicion().getFila()-1][entidad.getPosicion().getColumna()].setOnMouseClicked(new MoverArribaControlador(entidad));
    		paneAdyacente.add(panes[entidad.getPosicion().getFila()-1][entidad.getPosicion().getColumna()]);
    	}catch (ArrayIndexOutOfBoundsException e) {}
    	
    	try {
    		panes[entidad.getPosicion().getFila()+1][entidad.getPosicion().getColumna()].setOnMouseClicked(new MoverAbajoControlador(entidad));
    		paneAdyacente.add(panes[entidad.getPosicion().getFila()+1][entidad.getPosicion().getColumna()]);
    	}catch (ArrayIndexOutOfBoundsException e) {}
    	
    	try {
    		panes[entidad.getPosicion().getFila()-1][entidad.getPosicion().getColumna()+1].setOnMouseClicked(new MoverArribaDerechaControlador(entidad));
    		paneAdyacente.add(panes[entidad.getPosicion().getFila()-1][entidad.getPosicion().getColumna()+1]);
    	}catch (ArrayIndexOutOfBoundsException e) {}
    	
    	try {
    		panes[entidad.getPosicion().getFila()-1][entidad.getPosicion().getColumna()-1].setOnMouseClicked(new MoverArribaIzquierdaControlador(entidad));
    		paneAdyacente.add(panes[entidad.getPosicion().getFila()-1][entidad.getPosicion().getColumna()-1]);
    	}catch (ArrayIndexOutOfBoundsException e) {}
    	
    	try {
    		panes[entidad.getPosicion().getFila()+1][entidad.getPosicion().getColumna()+1].setOnMouseClicked(new MoverAbajoDerechaControlador(entidad));
    		paneAdyacente.add(panes[entidad.getPosicion().getFila()+1][entidad.getPosicion().getColumna()+1]);
    	}catch (ArrayIndexOutOfBoundsException e) {}
    	
    	try {
    		panes[entidad.getPosicion().getFila()+1][entidad.getPosicion().getColumna()-1].setOnMouseClicked(new MoverAbajoIzquierdaControlador(entidad));
    		paneAdyacente.add(panes[entidad.getPosicion().getFila()+1][entidad.getPosicion().getColumna()-11]);
    	}catch (ArrayIndexOutOfBoundsException e) {}
		return paneAdyacente;
    }
    
	public Pane paneActual(Entidad entidad) {
        panes[entidad.getPosicion().getFila()][entidad.getPosicion().getColumna()].setStyle("-fx-background-color: #FF99FF");
        return panes[entidad.getPosicion().getFila()][entidad.getPosicion().getColumna()];
    }

}