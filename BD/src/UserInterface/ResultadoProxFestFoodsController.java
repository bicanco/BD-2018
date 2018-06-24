package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML ResultadoProxFestFoodsController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoProxFestFoodsController {
	@FXML
    private TableView<Object> proxfestfoodsTabela;
    @FXML
    private TableColumn<Object, String> nomeProxFestFoods;
    @FXML
    private TableColumn<Object, String> dataProxFestFoods;
    @FXML
    private TableColumn<Object, String> contratanteProxFestFoods;
    @FXML
    private TableColumn<Object, String> totalLotesProxFestFoods;
    @FXML
    private TableColumn<Object, String> lotesVendProxFestFoods;
    @FXML
    private TableColumn<Object, String> ingVendProxFestFoods;
    
	private Stage proxfestfoodStage;

    public Stage getAdicionarStage() {
        return proxfestfoodStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.proxfestfoodStage = adicionarStage;
        proxfestfoodStage.setResizable(false);
        
        nomeProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("nome"));
        dataProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("data"));
        contratanteProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("contratante"));
        totalLotesProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("totalLotes"));
        lotesVendProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("lotesVendidos"));
        ingVendProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("ingressosVendidos"));
       	//proxFestFoodsTabela.setItems(ProximasFestFoods.tableView());
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
