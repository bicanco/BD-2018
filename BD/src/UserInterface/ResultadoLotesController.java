package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

import backend.advancedQueries.LotesLocacao;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML ResultadoLotesController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoLotesController {
	@FXML
    private TableView<LotesLocacao> lotesTabela;
    @FXML
    private TableColumn<LotesLocacao, String> numeroLote;
    @FXML
    private TableColumn<LotesLocacao, String> precoLote;
    @FXML
    private TableColumn<LotesLocacao, String> larguraLote;
    @FXML
    private TableColumn<LotesLocacao, String> comprimentoLote;
    @FXML
    private TableColumn<LotesLocacao, String> nomefornLote;
    @FXML
    private TableColumn<LotesLocacao, String> cnpjfornLote;
    
	private Stage lotesStage;

    public Stage getAdicionarStage() {
        return lotesStage;
    }

    public void setAdicionarStage(Stage adicionarStage, ObservableList<LotesLocacao> lotes) {
        this.lotesStage = adicionarStage;
        lotesStage.setResizable(false);
        
        numeroLote.setCellValueFactory(new PropertyValueFactory<>("numero"));
        precoLote.setCellValueFactory(new PropertyValueFactory<>("preco"));
        larguraLote.setCellValueFactory(new PropertyValueFactory<>("largura"));
        comprimentoLote.setCellValueFactory(new PropertyValueFactory<>("comprimento"));
        nomefornLote.setCellValueFactory(new PropertyValueFactory<>("nomeFantasia"));
        cnpjfornLote.setCellValueFactory(new PropertyValueFactory<>("fornecedora"));
       	lotesTabela.setItems(lotes);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
