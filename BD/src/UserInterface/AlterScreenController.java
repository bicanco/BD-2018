package UserInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
import backend.tables.*;

/**
 * Classe de controle da Interface de Alteracao.
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class AlterScreenController implements Initializable {
	
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
    private JFXComboBox<String> cnpjEmpresa;
    @FXML
    private JFXTextField nomeEmpresa;
    @FXML
    private JFXTextField enderecoEmpresa;
    @FXML
    private JFXButton alterarEmpresa;
    
    @FXML
    private JFXComboBox<String> emailContatos;
    @FXML
    private JFXTextField telefoneContatos;
    @FXML
    private JFXButton alterarContatos;
    
    @FXML
    private JFXComboBox<String> nomeCatFornecimento;
    @FXML
    private JFXTextField descricaoCatFornecimento;
    @FXML
    private JFXButton alterarCatFornecimento;
    
    @FXML
    private JFXComboBox<String> fornecedoraCatFornecedora;
    @FXML
    private JFXComboBox<String> categoriaCatFornecedora;
    @FXML
    private JFXTextField precoCatFornecedora;
    @FXML
    private JFXButton alterarCatFornecedora;
    
    @FXML
    private JFXComboBox<Number> idFesta;
    @FXML
    private JFXTextField dataFesta;
    @FXML
    private JFXTextField nomeFesta;
    @FXML
    private JFXTextField horarioFesta;
    @FXML
    private JFXTextField duracaoFesta;
    @FXML
    private JFXButton alterarFesta;
    
    @FXML
    private JFXComboBox<String> festaFestFood;
    @FXML
    private JFXTextField precoFestFood;
    @FXML
    private JFXButton alterarFestFood;
    
    @FXML
    private JFXComboBox<String> festaCoquetel;
    @FXML
    private JFXComboBox<String> localCoquetel;
    @FXML
    private JFXButton alterarCoquetel;
    
    @FXML
    private JFXComboBox<String> emailConvidado;
    @FXML
    private JFXTextField telefoneConvidado;
    @FXML
    private JFXButton alterarConvidado;
    
    @FXML
    private JFXComboBox<String> coquetelBrinde;
    @FXML
    private JFXTextField nomeBrinde;
    @FXML
    private JFXTextField descricaoBrinde;
    @FXML
    private JFXButton alterarBrinde;
    
    @FXML
    private JFXComboBox<String> fornecedoraFornecimento;
    @FXML
    private JFXComboBox<String> coquetelFornecimento;
    @FXML
    private JFXTextField precoFornecimento;
    @FXML
    private JFXButton alterarFornecimento;
    
    @FXML
    private JFXComboBox<String> fornecedoraProdutos;
    @FXML
    private JFXComboBox<String> coquetelProdutos;
    @FXML
    private JFXTextField nomeProdutos;
    @FXML
    private JFXTextField quantidadeProdutos;
    @FXML
    private JFXButton alterarProdutos;
    
    @FXML
    private JFXComboBox<String> nomeLocal;
    @FXML
    private JFXTextField ruaLocal;
    @FXML
    private JFXTextField numeroLocal;
    @FXML
    private JFXTextField cidadeLocal;
    @FXML
    private JFXTextField estadoLocal;
    @FXML
    private JFXTextField capacidadeLocal;
    @FXML
    private JFXTextField diariaLocal;
    @FXML
    private JFXCheckBox aberturaLocal;
    @FXML
    private JFXButton alterarLocal;
    
    @FXML
    private JFXComboBox<Number> idLocacao;
    @FXML
    private JFXComboBox<String> localLocacao;
    @FXML
    private JFXButton alterarLocacao;
    
    @FXML
    private JFXComboBox<String> fornecedoraLote;
    @FXML
    private JFXComboBox<String> locacaoLote;
    @FXML
    private JFXTextField numeroLote;
    @FXML
    private JFXTextField precoLote;
    @FXML
    private JFXTextField larguraLote;
    @FXML
    private JFXTextField comprimentoLote;
    @FXML
    private JFXButton alterarLote;
    
    @FXML
    private JFXComboBox<String> cpfFuncionario;
    @FXML
    private JFXTextField ruaFuncionario;
    @FXML
    private JFXTextField numeroFuncionario;
    @FXML
    private JFXTextField cidadeFuncionario;
    @FXML
    private JFXTextField estadoFuncionario;
    @FXML
    private JFXTextField emailFuncionario;
    @FXML
    private JFXTextField telefoneFuncionario;
    @FXML
    private JFXTextField celularFuncionario;
    @FXML
    private JFXTextField valorFuncionario;
    @FXML
    private JFXButton alterarFuncionario;
    
    @FXML
    private JFXComboBox<String> coquetelContCoquetel;
    @FXML
    private JFXComboBox<String> funcionarioContCoquetel;
    @FXML
    private JFXTextField horastrabContCoquetel;
    @FXML
    private JFXButton alterarContCoquetel;
    
    @FXML
    private JFXComboBox<String> festfoodContFestFood;
    @FXML
    private JFXComboBox<String> segurancaContFestFood;
    @FXML
    private JFXTextField horastrabContFestFood;
    @FXML
    private JFXButton alterarContFestFood;
    
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
        
        cnpjEmpresa.setItems(Empresa.getListaEmpresa());
        
        emailContatos.setItems(ContatoEmpresa.getListaEmail());
        
        nomeCatFornecimento.setItems(CategoriaFornecimento.getListaCategoria());
        
        fornecedoraCatFornecedora.setItems(Fornecedora.getListaFornecedora());
        
        categoriaCatFornecedora.setItems(CategoriaFornecimento.getListaCategoria());
        
        idFesta.setItems(Festa.getListaFesta());
        
        festaFestFood.setItems(FestFood.getListaFestFood());
        
        festaCoquetel.setItems(Coquetel.getListaCoquetel());
 
        localCoquetel.setItems(Local.getListaLocal());
        
        emailConvidado.setItems(Convidado.getListaConvidado());
        
        coquetelBrinde.setItems(Coquetel.getListaCoquetel());
        
        fornecedoraFornecimento.setItems(Fornecedora.getListaFornecedora());
        
        coquetelFornecimento.setItems(Coquetel.getListaCoquetel());
        
        fornecedoraProdutos.setItems(Fornecedora.getListaFornecedora());
        
        coquetelProdutos.setItems(Coquetel.getListaCoquetel());
        
        nomeLocal.setItems(Local.getListaNome());
        
        idLocacao.setItems(Locacao.getListaId());
        
        localLocacao.setItems(Local.getListaLocal());
        
        fornecedoraLote.setItems(Fornecedora.getListaFornecedora());
        
        locacaoLote.setItems(Locacao.getListaLocacao());
        
        cpfFuncionario.setItems(Funcionario.getListaCpf());
        
        coquetelContCoquetel.setItems(Coquetel.getListaCoquetel());
        
        funcionarioContCoquetel.setItems(Funcionario.getListaFuncionario());
        
        festfoodContFestFood.setItems(FestFood.getListaFestFood());
        
        segurancaContFestFood.setItems(Funcionario.getListaSeguranca());
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
    void alterarEmpresa(ActionEvent event) throws IOException{
    	
    }
    
    
    @FXML
    void alterarContato(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarCategoriaFornecimento(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarCategoriaFornecedora(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarFesta(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarFestFood(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarIngresso(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarCoquetel(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarConvidado(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarConvite(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarBrinde(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarFornecimentoCoquetel(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarProduto(ActionEvent event) throws IOException{

    }
    
    @FXML
    void alterarLocal(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarLocacao(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarLote(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarFuncionario(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarContratoCoquetel(ActionEvent event) throws IOException{
    	
    }
    
    @FXML
    void alterarContratoFestFood(ActionEvent event) throws IOException{
    	
    }
}
