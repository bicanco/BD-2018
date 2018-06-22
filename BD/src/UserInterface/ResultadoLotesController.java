package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;

/**
 * FXML ResultadoLotesController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoLotesController {
	private Stage lotesStage;

    public Stage getAdicionarStage() {
        return lotesStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.lotesStage = adicionarStage;
        lotesStage.setResizable(false);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
