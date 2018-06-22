package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;

/**
 * FXML ResultadoMediaSalarialController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoMediaSalarialController {
	private Stage mediasalarialStage;

    public Stage getAdicionarStage() {
        return mediasalarialStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.mediasalarialStage = adicionarStage;
        mediasalarialStage.setResizable(false);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
