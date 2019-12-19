package fiuba.algo3.Vista.Juego;

import java.io.File;

import fiuba.algo3.Controlador.EmpezarJuego.BotonEmpezarJuego;
import fiuba.algo3.Modelado.Tablero.Tablero;
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
import javafx.scene.layout.VBox;

public class Menu extends Group{

	private static final String STYLE_PATH = "ChatStyle.css";

    public int heigth = 5;
    public int width = 5;

    private int tileHeigth = 132;
    private int tileWidth = 132;

    private Pane[][] panes;

    public Menu(Tablero tablero, VistaJuego manejador) {
    	
        this.getStylesheets().add(new File(STYLE_PATH).toString());
        
        GridPane table = new GridPane();
        panes = new Pane[width * tileWidth][heigth * tileHeigth];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < heigth; j++) {
                Pane v = new Pane();
                v.setMinHeight(tileHeigth);
                v.setMinWidth(tileWidth);
                panes[i][j] = v;
                table.add(v, i, j);
            }
        }

        table.setGridLinesVisible(false);
        table.setBackground(new Background(new BackgroundImage(new Image("Intro.png"),BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));

        CargarNombre opcionA = new CargarNombre(tablero.getJugador());
        CargarNombre opcionB = new CargarNombre(tablero.getJugador().obtenerSiguienteJugador());

        this.addView(table);
        this.addViewOnMap(new VBox(new BotonEmpezarJuego(manejador)), 2, 2);
        this.addViewOnMap(opcionA.getOpcion(), 2, 3);
        this.addViewOnMap(opcionB.getOpcion(), 2, 4);
    }

    public void addViewOnMap(Node view, int x, int y) {
        panes[x][y].getChildren().remove(view);
        panes[x][y].getChildren().add(view);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }
}
