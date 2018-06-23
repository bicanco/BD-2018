package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML ResultadoFaixaPrecoController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoFaixaPrecoController {
	@FXML
    private TableView<Object> faixaprecoTabela;
    @FXML
    private TableColumn<Object, String> nomeFaixaPreco;
    @FXML
    private TableColumn<Object, String> cnpjFaixaPreco;
    @FXML
    private TableColumn<Object, String> faixaFaixaPreco;
    
    private Stage faixaprecoStage;

    public Stage getAdicionarStage() {
        return faixaprecoStage;
    }

    public void setAdicionarStage(Stage adicionarStage) {
        this.faixaprecoStage = adicionarStage;
        faixaprecoStage.setResizable(false);
        
        nomeFaixaPreco.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cnpjFaixaPreco.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        faixaFaixaPreco.setCellValueFactory(new PropertyValueFactory<>("faixa"));
       	//faixaprecoTabela.setItems(BuscaAvancada.faixaprecoView());
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
