package fiuba.algo3.Vista.Main;

import fiuba.algo3.Vista.Juego.VistaJuego;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
       
        primaryStage.setTitle("ALGO_CHESS");
        
        new VistaJuego(primaryStage);
        
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}