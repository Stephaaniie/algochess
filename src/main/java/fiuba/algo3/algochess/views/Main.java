package fiuba.algo3.Vista.Main;

import fiuba.algo3.Vista.Juego.VistaJuego;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        theStage.setTitle("AlgoChess");
        
        ReproductorMusica reproductor = new ReproductorMusica();
        reproductor.reproducirMusica();

        new AlgoChessView(theStage);

        theStage.show();
    }
}