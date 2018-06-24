package UserInterface;

import java.net.URL;
import java.util.ResourceBundle;

import backend.advancedQueries.CustoCoquetel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML ResultadoCustoCoquetelController class
 *
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ResultadoCustoCoquetelController {
	@FXML
    private TableView<CustoCoquetel> custoTabela;
    @FXML
    private TableColumn<CustoCoquetel, String> nomeCusto;
    @FXML
    private TableColumn<CustoCoquetel, String> contratanteCusto;
    @FXML
    private TableColumn<CustoCoquetel, String> dataCusto;
    @FXML
    private TableColumn<CustoCoquetel, String> convidadosCusto;
    @FXML
    private TableColumn<CustoCoquetel, String> orcamentoCusto;
    
	private Stage custoStage;

    public Stage getAdicionarStage() {
        return custoStage;
    }

    public void setAdicionarStage(Stage adicionarStage, ObservableList<CustoCoquetel> custo) {
        this.custoStage = adicionarStage;
        custoStage.setResizable(false);
        
        nomeCusto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        contratanteCusto.setCellValueFactory(new PropertyValueFactory<>("contratante"));
        dataCusto.setCellValueFactory(new PropertyValueFactory<>("data"));
        convidadosCusto.setCellValueFactory(new PropertyValueFactory<>("convidados"));
        orcamentoCusto.setCellValueFactory(new PropertyValueFactory<>("orcamento"));
        custoTabela.setItems(custo);
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
