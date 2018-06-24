package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

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
    private TableView<Object> lotesTabela;
    @FXML
    private TableColumn<Object, String> numeroLote;
    @FXML
    private TableColumn<Object, String> precoLote;
    @FXML
    private TableColumn<Object, String> larguraLote;
    @FXML
    private TableColumn<Object, String> comprimentoLote;
    @FXML
    private TableColumn<Object, String> nomefornLote;
    @FXML
    private TableColumn<Object, String> cnpjfornLote;
    
	private Stage lotesStage;

    public Stage getAdicionarStage() {
        return lotesStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.lotesStage = adicionarStage;
        lotesStage.setResizable(false);
        
        numeroLote.setCellValueFactory(new PropertyValueFactory<>("numero"));
        precoLote.setCellValueFactory(new PropertyValueFactory<>("preco"));
        larguraLote.setCellValueFactory(new PropertyValueFactory<>("largura"));
        comprimentoLote.setCellValueFactory(new PropertyValueFactory<>("comprimento"));
        nomefornLote.setCellValueFactory(new PropertyValueFactory<>("nomeFantasia"));
        cnpjfornLote.setCellValueFactory(new PropertyValueFactory<>("fornecedora"));
       	//lotesTabela.setItems(LotesLocacao.tableView(locacao));
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
