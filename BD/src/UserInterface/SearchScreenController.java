package UserInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import backend.advancedQueries.CustoCoquetel;
import backend.advancedQueries.FaixaPrecoFrequente;
import backend.advancedQueries.LotesLocacao;
import backend.advancedQueries.PagamentoFuncionario;
import backend.advancedQueries.ProximasFestFoods;
import backend.advancedQueries.SalarioPorEstado;
import backend.tables.CategoriaFornecimento;
import backend.tables.Funcionario;
import backend.tables.Locacao;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Modality;
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
    private JFXTextField minConvidadosBusca;
    @FXML
    private JFXButton buscaCustoCoquetel;
    
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
    	ObservableList<String> mes = 
        	    FXCollections.observableArrayList(
        	        "1", "2", "3", "4",
        	        "5", "6", "7", "8",
        	        "9", "10", "11", "12");
    	
    	List<String> list = new ArrayList<String>();
    	
    	for(int i = 2000; i <= 2020; i++){
    		list.add(Integer.toString(i));
    	}
    	
    	ObservableList<String> ano = FXCollections.observableArrayList(list);
    	
    	mesInicial.setItems(mes);
    	
    	mesFinal.setItems(mes);
    	
    	anoInicial.setItems(ano);
    	
    	anoFinal.setItems(ano);
    	
    	locacaoBusca.setItems(Locacao.getListaLocacao());
    	
    	funcionarioBusca.setItems(Funcionario.getListaFuncionario());
    	
    	estadoBusca.setItems(Funcionario.getListaEstado());
    	
    	categoriaBusca.setItems(CategoriaFornecimento.getListaCategoria());
    	
        myStage = Main.getMyStage();
    }    
    
    @FXML
    void openInsertionScreen(ActionEvent event) throws IOException{
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("InsertionScreen.fxml"));
    	
    	Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
        myStage.setResizable(false);
    }
    
    @FXML
    void openDeleteScreen(ActionEvent event) throws IOException{
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("DeleteScreen.fxml"));
    	
    	Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
        myStage.setResizable(false);
    }
    
    @FXML
    void openAlterScreen(ActionEvent event) throws IOException{
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("AlterScreen.fxml"));
    	
    	Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
        myStage.setResizable(false);
    }
    
    @FXML
    void openSearchScreen(ActionEvent event) throws IOException{
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("SearchScreen.fxml"));
    	
    	Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
        myStage.setResizable(false);
    }
    
    @FXML
    void openViewScreen(ActionEvent event) throws IOException{
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("ViewScreen.fxml"));
    	
    	Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
        myStage.setResizable(false);
    }
   
    void abrirErrorScreen(String msg) throws IOException{
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginController.class.getResource("ErrorScreen.fxml"));
        AnchorPane root = loader.load();

        Stage erroStage = new Stage();
        erroStage.setResizable(false);
        erroStage.setTitle("Error");
        erroStage.initModality(Modality.WINDOW_MODAL);
        erroStage.initOwner(Main.getMyStage());
        Scene scene = new Scene(root);
        erroStage.setScene(scene);
        ErrorScreenController controller = loader.getController();
        controller.setAdicionarStage(erroStage, msg);
        
        erroStage.showAndWait();
    }
    
    @FXML
    void buscarLotes(ActionEvent event) throws IOException{
    	if(locacaoBusca.getValue() == null){
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else{
    		ObservableList<LotesLocacao> lotes = LotesLocacao.tableView(Integer.parseInt(locacaoBusca.getValue().split("[ /]")[0]));
    		
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LoginController.class.getResource("ResultadoLotes.fxml"));
            AnchorPane root = loader.load();

            Stage lotesStage = new Stage();
            lotesStage.setResizable(false);
            lotesStage.setTitle("Resultado da Busca");
            lotesStage.initModality(Modality.WINDOW_MODAL);
            lotesStage.initOwner(Main.getMyStage());
            Scene scene = new Scene(root);
            lotesStage.setScene(scene);
            ResultadoLotesController controller = loader.getController();
            controller.setAdicionarStage(lotesStage, lotes);
            
            lotesStage.showAndWait();
    	}
    }
    
    @FXML
    void buscarCustoCoquetel(ActionEvent event) throws IOException{
    	if(!minConvidadosBusca.getText().matches("^[0-9]*$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Mínimo de Convidados - inteiro.");
    	} else{
    		ObservableList<CustoCoquetel> custo = CustoCoquetel.tableView(Integer.parseInt(minConvidadosBusca.getText()));
    		
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LoginController.class.getResource("ResultadoCustoCoquetel.fxml"));
            AnchorPane root = loader.load();

            Stage custoStage = new Stage();
            custoStage.setResizable(false);
            custoStage.setTitle("Resultado da Busca");
            custoStage.initModality(Modality.WINDOW_MODAL);
            custoStage.initOwner(Main.getMyStage());
            Scene scene = new Scene(root);
            custoStage.setScene(scene);
            ResultadoCustoCoquetelController controller = loader.getController();
            controller.setAdicionarStage(custoStage, custo);
            
            custoStage.showAndWait();
    	}
    }
    
    @FXML
    void buscarFolhaPagamento(ActionEvent event) throws IOException{
    	if(funcionarioBusca.getValue() == null || mesInicial.getValue() == null || anoInicial.getValue() == null || mesFinal.getValue() == null || anoFinal.getValue() == null){
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else{
    		String dataInicial = mesInicial.getValue() + "/" + anoInicial.getValue();
    		String dataFinal = mesFinal.getValue() + "/" + anoFinal.getValue();
    		ObservableList<PagamentoFuncionario> pagamento = PagamentoFuncionario.tableView(funcionarioBusca.getValue().split(" / ")[1], dataInicial, dataFinal);
    		
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LoginController.class.getResource("ResultadoFolhaPagamento.fxml"));
            AnchorPane root = loader.load();

            Stage pagamentoStage = new Stage();
            pagamentoStage.setResizable(false);
            pagamentoStage.setTitle("Resultado da Busca");
            pagamentoStage.initModality(Modality.WINDOW_MODAL);
            pagamentoStage.initOwner(Main.getMyStage());
            Scene scene = new Scene(root);
            pagamentoStage.setScene(scene);
            ResultadoFolhaPagamentoController controller = loader.getController();
            controller.setAdicionarStage(pagamentoStage, pagamento);
            
            pagamentoStage.showAndWait();
    	}
    }
    
    @FXML
    void buscarMediaSalarial(ActionEvent event) throws IOException{
    	if(estadoBusca.getValue() == null){
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else{
    		ObservableList<SalarioPorEstado> salario = SalarioPorEstado.tableView(estadoBusca.getValue());
    		
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LoginController.class.getResource("ResultadoMediaSalarial.fxml"));
            AnchorPane root = loader.load();

            Stage salarioStage = new Stage();
            salarioStage.setResizable(false);
            salarioStage.setTitle("Resultado da Busca");
            salarioStage.initModality(Modality.WINDOW_MODAL);
            salarioStage.initOwner(Main.getMyStage());
            Scene scene = new Scene(root);
            salarioStage.setScene(scene);
            ResultadoMediaSalarialController controller = loader.getController();
            controller.setAdicionarStage(salarioStage, salario);
            
            salarioStage.showAndWait();
    	}
    }
    
    @FXML
    void buscarFaixaPreco(ActionEvent event) throws IOException{
    	if(categoriaBusca.getValue() == null){
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else{
    		ObservableList<FaixaPrecoFrequente> faixapreco = FaixaPrecoFrequente.tableView(categoriaBusca.getValue());
    		
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LoginController.class.getResource("ResultadoFaixaPreco.fxml"));
            AnchorPane root = loader.load();

            Stage faixaprecoStage = new Stage();
            faixaprecoStage.setResizable(false);
            faixaprecoStage.setTitle("Resultado da Busca");
            faixaprecoStage.initModality(Modality.WINDOW_MODAL);
            faixaprecoStage.initOwner(Main.getMyStage());
            Scene scene = new Scene(root);
            faixaprecoStage.setScene(scene);
            ResultadoFaixaPrecoController controller = loader.getController();
            controller.setAdicionarStage(faixaprecoStage, faixapreco);
            
            faixaprecoStage.showAndWait();
    	}
    }
    
    @FXML
    void buscarProxFestFoods(ActionEvent event) throws IOException{
    	ObservableList<ProximasFestFoods> proxfest = ProximasFestFoods.tableView();
		
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginController.class.getResource("ResultadoProxFestFoods.fxml"));
        AnchorPane root = loader.load();

        Stage proxfestStage = new Stage();
        proxfestStage.setResizable(false);
        proxfestStage.setTitle("Resultado da Busca");
        proxfestStage.initModality(Modality.WINDOW_MODAL);
        proxfestStage.initOwner(Main.getMyStage());
        Scene scene = new Scene(root);
        proxfestStage.setScene(scene);
        ResultadoProxFestFoodsController controller = loader.getController();
        controller.setAdicionarStage(proxfestStage, proxfest);
        
        proxfestStage.showAndWait();
    }
}
