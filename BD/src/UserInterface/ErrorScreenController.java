package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ErrorScreenController {
	
	@FXML
	private Label errorMessage;
	
	@FXML
	private AnchorPane ancPane;
	
	@FXML
	private ImageView image;   
	
	/**
     * Initializes the controller class.
     */
    private Stage erroStage;

    public Stage getAdicionarStage() {
        return erroStage;
    }

    public void setAdicionarStage(Stage adicionarStage, String error) {
        this.erroStage = adicionarStage;
        erroStage.setResizable(false);
        errorMessage.setText(error);  
        
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}
