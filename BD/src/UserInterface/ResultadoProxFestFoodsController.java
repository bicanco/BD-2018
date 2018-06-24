package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

import backend.advancedQueries.ProximasFestFoods;
import javafx.collections.ObservableList;
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
    private TableView<ProximasFestFoods> proxfestfoodsTabela;
    @FXML
    private TableColumn<ProximasFestFoods, String> nomeProxFestFoods;
    @FXML
    private TableColumn<ProximasFestFoods, String> dataProxFestFoods;
    @FXML
    private TableColumn<ProximasFestFoods, String> contratanteProxFestFoods;
    @FXML
    private TableColumn<ProximasFestFoods, String> totalLotesProxFestFoods;
    @FXML
    private TableColumn<ProximasFestFoods, String> lotesVendProxFestFoods;
    @FXML
    private TableColumn<ProximasFestFoods, String> ingVendProxFestFoods;
    
	private Stage proxfestfoodStage;

    public Stage getAdicionarStage() {
        return proxfestfoodStage;
    }

    public void setAdicionarStage(Stage adicionarStage, ObservableList<ProximasFestFoods> proxfest) {
        this.proxfestfoodStage = adicionarStage;
        proxfestfoodStage.setResizable(false);
        
        nomeProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("nome"));
        dataProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("data"));
        contratanteProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("contratante"));
        totalLotesProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("totalLotes"));
        lotesVendProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("lotesVendidos"));
        ingVendProxFestFoods.setCellValueFactory(new PropertyValueFactory<>("ingressosVendidos"));
       	proxfestfoodsTabela.setItems(proxfest);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
