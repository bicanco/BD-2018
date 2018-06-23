package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;

/**
 * FXML ResultadoOrcamentoController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoOrcamentoController {
	private Stage orcamentoStage;

    public Stage getAdicionarStage() {
        return orcamentoStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.orcamentoStage = adicionarStage;
        orcamentoStage.setResizable(false);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
