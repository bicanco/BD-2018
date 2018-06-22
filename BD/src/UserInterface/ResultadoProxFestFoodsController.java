package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.stage.Stage;

/**
 * FXML ResultadoProxFestFoodsController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoProxFestFoodsController {
	private Stage proxfestfoodStage;

    public Stage getAdicionarStage() {
        return proxfestfoodStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.proxfestfoodStage = adicionarStage;
        proxfestfoodStage.setResizable(false);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
