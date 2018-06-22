package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;

/**
 * FXML ResultadoFolhaPagamentoController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoFolhaPagamentoController {
	private Stage folhapagamentoStage;

    public Stage getAdicionarStage() {
        return folhapagamentoStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.folhapagamentoStage = adicionarStage;
        folhapagamentoStage.setResizable(false);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
