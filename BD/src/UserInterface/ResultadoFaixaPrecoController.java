package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;

/**
 * FXML ResultadoFaixaPrecoController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoFaixaPrecoController {
    private Stage faixaprecoStage;

    public Stage getAdicionarStage() {
        return faixaprecoStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.faixaprecoStage = adicionarStage;
        faixaprecoStage.setResizable(false);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
