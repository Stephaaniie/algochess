package fiuba.algo3.AlgoChess.ventana.botones;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
public class BotonEmpezar extends Button {

    public BotonEmpezar(HBox hbox){
        super();
        this.setText("COMENZAR");
        this.setPrefSize(250,150);
        this.setStyle("-fx-font: 30 arial; -fx-base: #000000; -fx-border-color: #6d1fa8; -fx-text-fill: #f4ef15");
    }
}