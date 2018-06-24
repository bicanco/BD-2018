package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

import backend.advancedQueries.PagamentoFuncionario;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML ResultadoFolhaPagamentoController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoFolhaPagamentoController {
	@FXML
    private TableView<PagamentoFuncionario> folhapagTabela;
    @FXML
    private TableColumn<PagamentoFuncionario, String> nomeFolhaPag;
    @FXML
    private TableColumn<PagamentoFuncionario, String> dataFolhaPag;
    @FXML
    private TableColumn<PagamentoFuncionario, String> contratanteFolhaPag;
    @FXML
    private TableColumn<PagamentoFuncionario, String> tipoFolhaPag;
    @FXML
    private TableColumn<PagamentoFuncionario, String> valorpagoFolhaPag;
    
	private Stage folhapagamentoStage;

    public Stage getAdicionarStage() {
        return folhapagamentoStage;
    }

    public void setAdicionarStage(Stage adicionarStage, ObservableList<PagamentoFuncionario> folhapag) {
        this.folhapagamentoStage = adicionarStage;
        folhapagamentoStage.setResizable(false);
        
        nomeFolhaPag.setCellValueFactory(new PropertyValueFactory<>("nome"));
        dataFolhaPag.setCellValueFactory(new PropertyValueFactory<>("data"));
        contratanteFolhaPag.setCellValueFactory(new PropertyValueFactory<>("contratante"));
        tipoFolhaPag.setCellValueFactory(new PropertyValueFactory<>("tipoFesta"));
        valorpagoFolhaPag.setCellValueFactory(new PropertyValueFactory<>("valorpago"));
        folhapagTabela.setItems(folhapag);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
