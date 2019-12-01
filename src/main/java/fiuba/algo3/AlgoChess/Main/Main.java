package fiuba.algo3.AlgoChess.Main;

import java.util.concurrent.TimeUnit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application
{

    public void start(Stage theStage)
    {
        theStage.setTitle( "¡AlgoChess!" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        final double WIDTH = 48; 
        final double HEIGHT = 48; 

        final double CANVAS_WIDTH = 300;
        final double CANVAS_HEIGHT = 300;

        Canvas canvas = new Canvas( CANVAS_WIDTH, CANVAS_HEIGHT ); // Create new canvas
        root.getChildren().add( canvas );

        final GraphicsContext gc = canvas.getGraphicsContext2D();

        final Image monster = new Image( "src/main/Sprites/soldado.png" );

        new AnimationTimer() //use AnimationTimer to continue the game loop
        {
            double frame_number = 0;
            double x = 0;
            double y = 0;
            public void handle(long currentNanoTime)
            {
                if(frame_number == 4)
                {
                    frame_number = 0;
                } else {
                    frame_number += 1;
                }

                y = frame_number * HEIGHT;

                gc.setFill( Color.BLACK );
                gc.fillRect(0,0, CANVAS_WIDTH, CANVAS_HEIGHT);

                // Set delay before changing to next image
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch(InterruptedException e) {}

                // Draw next image
                gc.drawImage(monster, x, y, WIDTH, HEIGHT, CANVAS_WIDTH/2 - WIDTH/2, CANVAS_HEIGHT/2 - HEIGHT/2, WIDTH, HEIGHT);
            }
        }.start();

        theStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}