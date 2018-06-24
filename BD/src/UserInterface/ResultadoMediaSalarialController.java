package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML ResultadoMediaSalarialController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoMediaSalarialController {
	@FXML
    private TableView<Object> mediasalarialTabela;
    @FXML
    private TableColumn<Object, String> funcaoMediaSalarial;
    @FXML
    private TableColumn<Object, String> quantMediaSalarial;
    @FXML
    private TableColumn<Object, String> mediaMediaSalarial;
    
	private Stage mediasalarialStage;

    public Stage getAdicionarStage() {
        return mediasalarialStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.mediasalarialStage = adicionarStage;
        mediasalarialStage.setResizable(false);
        
        funcaoMediaSalarial.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        quantMediaSalarial.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        mediaMediaSalarial.setCellValueFactory(new PropertyValueFactory<>("mediaSalarial"));
       	//mediasalarialTabela.setItems(SalarioPorEstado.tableView(estado));
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
