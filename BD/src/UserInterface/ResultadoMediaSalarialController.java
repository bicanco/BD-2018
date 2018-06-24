package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

import backend.advancedQueries.SalarioPorEstado;
import javafx.collections.ObservableList;
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
    private TableView<SalarioPorEstado> mediasalarialTabela;
    @FXML
    private TableColumn<SalarioPorEstado, String> funcaoMediaSalarial;
    @FXML
    private TableColumn<SalarioPorEstado, String> quantMediaSalarial;
    @FXML
    private TableColumn<SalarioPorEstado, String> mediaMediaSalarial;
    
	private Stage mediasalarialStage;

    public Stage getAdicionarStage() {
        return mediasalarialStage;
    }

    public void setAdicionarStage(Stage adicionarStage, ObservableList<SalarioPorEstado> salario) {
        this.mediasalarialStage = adicionarStage;
        mediasalarialStage.setResizable(false);
        
        funcaoMediaSalarial.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        quantMediaSalarial.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        mediaMediaSalarial.setCellValueFactory(new PropertyValueFactory<>("mediaSalarial"));
       	mediasalarialTabela.setItems(salario);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
