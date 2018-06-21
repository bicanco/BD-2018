package UserInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe de controle da Interface de Busca.
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class SearchScreenController implements Initializable {
	
    @FXML
    private JFXButton insert;
    
    @FXML
    private JFXButton alter;
    
    @FXML
    private JFXButton delete;
    
    @FXML
    private JFXButton search;
    
    @FXML
    private JFXButton view;
    
    @FXML
    private JFXComboBox<String> locacaoBusca;
    @FXML
    private JFXButton buscaLotes;
    
    @FXML
    private JFXComboBox<String> coquetelBusca;
    @FXML
    private JFXButton buscaOrcamento;
    
    @FXML
    private JFXComboBox<String> funcionarioBusca;
    @FXML
    private JFXComboBox<String> mesInicial;
    @FXML
    private JFXComboBox<String> anoInicial;
    @FXML
    private JFXComboBox<String> mesFinal;
    @FXML
    private JFXComboBox<String> anoFinal;
    @FXML
    private JFXButton buscaFolhaPagamento;
    
    @FXML
    private JFXComboBox<String> estadoBusca;
    @FXML
    private JFXButton buscaMediaSalarial;
    
    @FXML
    private JFXComboBox<String> categoriaBusca;
    @FXML
    private JFXButton buscaFaixaPreco;
    
    @FXML
    private JFXButton buscaProxFestFoods;
    
    private static Stage myStage;
    
    /**
     * Metodo que inicializa a classe de Controle, setando todos os argumentos de ambiente e as estruturas graficas da interface.
     * 
     * @param url - endereco de localizacao do arquivo fxml
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myStage = Main.getMyStage();
    }    
    
    @FXML
    void openInsertionScreen(ActionEvent event) throws IOException{
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("InsertionScreen.fxml"));
    	
    	Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
    }
    
    @FXML
    void openDeleteScreen(ActionEvent event) throws IOException{
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("DeleteScreen.fxml"));
    	
    	Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
    }
    
    @FXML
    void openAlterScreen(ActionEvent event) throws IOException{
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("AlterScreen.fxml"));
    	
    	Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
    }
    
    @FXML
    void openSearchScreen(ActionEvent event) throws IOException{
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("SearchScreen.fxml"));
    	
    	Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
    }
    
    @FXML
    void openViewScreen(ActionEvent event) throws IOException{
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("ViewScreen.fxml"));
    	
    	Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
    }
   
    @FXML
    void buscarLotes(ActionEvent event) throws IOException{

    }
    
    @FXML
    void buscarOrcamento(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void buscarFolhaPagamento(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void buscarMediaSalarial(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void buscarFaixaPreco(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void buscarProxFestFoods(ActionEvent event) throws IOException{
    	
    }
}
