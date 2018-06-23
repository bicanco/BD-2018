package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

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
    private TableView<Object> folhapagTabela;
    @FXML
    private TableColumn<Object, String> nomeFolhaPag;
    @FXML
    private TableColumn<Object, String> dataFolhaPag;
    @FXML
    private TableColumn<Object, String> contratanteFolhaPag;
    @FXML
    private TableColumn<Object, String> tipoFolhaPag;
    @FXML
    private TableColumn<Object, String> valorpagoFolhaPag;
    
	private Stage folhapagamentoStage;

    public Stage getAdicionarStage() {
        return folhapagamentoStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.folhapagamentoStage = adicionarStage;
        folhapagamentoStage.setResizable(false);
        
        nomeFolhaPag.setCellValueFactory(new PropertyValueFactory<>("nome"));
        dataFolhaPag.setCellValueFactory(new PropertyValueFactory<>("data"));
        contratanteFolhaPag.setCellValueFactory(new PropertyValueFactory<>("contratante"));
        tipoFolhaPag.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        valorpagoFolhaPag.setCellValueFactory(new PropertyValueFactory<>("valorpago"));
       	//folhapagTabela.setItems(BuscaAvancada.folhapagView());
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
