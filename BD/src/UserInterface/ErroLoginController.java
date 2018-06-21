package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML ErroLoginController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ErroLoginController implements Initializable {
    /**
     * Initializes the controller class.
     */
    private Stage erroStage;

    public Stage getAdicionarStage() {
        return erroStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.erroStage = adicionarStage;
        erroStage.setResizable(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
