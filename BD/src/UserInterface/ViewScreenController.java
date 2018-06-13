package UserInterface;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import backend.tables.*;

/**
 * Classe de controle da Interface de Visualizacao.
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class ViewScreenController implements Initializable {
	
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
    private TableView<Empresa> empresaTabela;
    @FXML
    private TableColumn<Empresa, String> cnpjEmpresa;
    @FXML
    private TableColumn<Empresa, String> nomeEmpresa;
    @FXML
    private TableColumn<Empresa, String> razaoEmpresa;
    @FXML
    private TableColumn<Empresa, String> enderecoEmpresa;
    
    /**    
    @FXML
    private TableView<Contatos> contatosTabela;
    @FXML
    private TableColumn<Contatos, String> empresaContatos;
    @FXML
    private TableColumn<Contatos, String> emailContatos;
    @FXML
    private TableColumn<Contatos, String> nomeContatos;
    @FXML
    private TableColumn<Contatos, String> telefoneContatos;
    
    @FXML
    private TableView<Contratante> contratanteTabela;
    @FXML
    private TableColumn<Contratante, String> cnpjContratante;
    
    @FXML
    private TableView<Fornecedora> fornecedoraTabela;
    @FXML
    private TableColumn<Fornecedora, String> cnpjFornecedora;
    
    @FXML
    private TableView<CatFornecimento> catFornecimentoTabela;
    @FXML
    private TableColumn<CatFornecimento, String> nomeCatFornecimento;
    @FXML
    private TableColumn<CatFornecimento, String> descCatFornecimento;
    
    @FXML
    private TableView<CatFornecedora> catFornecedoraTabela;
    @FXML
    private TableColumn<CatFornecedora, String> fornecedoraCatFornecedora;
    @FXML
    private TableColumn<CatFornecedora, String> categoriaCatFornecedora;
    @FXML
    private TableColumn<CatFornecedora, String> precoCatFornecedora;
    
    @FXML
    private TableView<Festa> festaTabela;
    @FXML
    private TableColumn<Festa, String> idFesta;
    @FXML
    private TableColumn<Festa, String> nomeFesta;
    @FXML
    private TableColumn<Festa, String> contratanteFesta;
    @FXML
    private TableColumn<Festa, String> dataFesta;
    @FXML
    private TableColumn<Festa, String> horarioFesta;
    @FXML
    private TableColumn<Festa, String> duracaoFesta;
    
    @FXML
    private TableView<FestFood> festfoodTabela;
    @FXML
    private TableColumn<FestFood, String> festaFestFood;
    @FXML
    private TableColumn<FestFood, String> ingressoFestFood;
    
    @FXML
    private TableView<Ingresso> ingressoTabela;
    @FXML
    private TableColumn<Ingresso, String> festfoodIngresso;
    @FXML
    private TableColumn<Ingresso, String> numeroIngresso;
    @FXML
    private TableColumn<Ingresso, String> compradorIngresso;
    
    @FXML
    private TableView<Coquetel> coquetelTabela;
    @FXML
    private TableColumn<Coquetel, String> festaCoquetel;
    @FXML
    private TableColumn<Coquetel, String> localCoquetel;
    @FXML
    private TableColumn<Coquetel, String> cidadeCoquetel;
    @FXML
    private TableColumn<Coquetel, String> orcamentoCoquetel;
    
    @FXML
    private TableView<Convidado> convidadoTabela;
    @FXML
    private TableColumn<Convidado, String> emailConvidado;
    @FXML
    private TableColumn<Convidado, String> nomeConvidado;
    @FXML
    private TableColumn<Convidado, String> telefoneConvidado;
    
    @FXML
    private TableView<Convite> conviteTabela;
    @FXML
    private TableColumn<Convite, String> convidadoConvite;
    @FXML
    private TableColumn<Convite, String> coquetelConvite;
    
    @FXML
    private TableView<Brinde> brindeTabela;
    @FXML
    private TableColumn<Brinde, String> coquetelBrinde;
    @FXML
    private TableColumn<Brinde, String> nomeBrinde;
    @FXML
    private TableColumn<Brinde, String> descricaoBrinde;
    
    @FXML
    private TableView<FornecimentoCoquetel> fornCoquetelTabela;
    @FXML
    private TableColumn<FornecimentoCoquetel, String> fornecedoraFornCoquetel;
    @FXML
    private TableColumn<FornecimentoCoquetel, String> coquetelFornCoquetel;
    @FXML
    private TableColumn<FornecimentoCoquetel, String> precoFornCoquetel;
    
    @FXML
    private TableView<Produtos> produtosTabela;
    @FXML
    private TableColumn<Produtos, String> fornecedoraProdutos;
    @FXML
    private TableColumn<Produtos, String> coquetelProdutos;
    @FXML
    private TableColumn<Produtos, String> nomeProdutos;
    @FXML
    private TableColumn<Produtos, String> quantidadeProdutos;
    
    @FXML
    private TableView<Local> localTabela;
    @FXML
    private TableColumn<Local, String> nomeLocal;
    @FXML
    private TableColumn<Local, String> cidadeLocal;
    @FXML
    private TableColumn<Local, String> estadoLocal;
    @FXML
    private TableColumn<Local, String> numeroLocal;
    @FXML
    private TableColumn<Local, String> ruaLocal;
    @FXML
    private TableColumn<Local, String> capacidadeLocal;
    @FXML
    private TableColumn<Local, String> diariaLocal;
    @FXML
    private TableColumn<Local, String> aberturaLocal;
    
   	@FXML
    private TableView<Locacao> locacaoTabela;
    @FXML
    private TableColumn<Locacao, String> idLocacao;
    @FXML
    private TableColumn<Locacao, String> festfoodLocacao;
    @FXML
    private TableColumn<Locacao, String> localLocacao;
    @FXML
    private TableColumn<Locacao, String> cidadeLocacao;
    
    @FXML
    private TableView<Lote> loteTabela;
    @FXML
    private TableColumn<Lote, String> fornecedoraLote;
    @FXML
    private TableColumn<Lote, String> locacaoLote;
    @FXML
    private TableColumn<Lote, String> numeroLote;
    @FXML
    private TableColumn<Lote, String> precoLote;
    @FXML
    private TableColumn<Lote, String> larguraLote;
    @FXML
    private TableColumn<Lote, String> comprimentoLote;
    
    @FXML
    private TableView<Lote> loteTabela;
    @FXML
    private TableColumn<Lote, String> fornecedoraLote;
    @FXML
    private TableColumn<Lote, String> locacaoLote;
    @FXML
    private TableColumn<Lote, String> numeroLote;
    @FXML
    private TableColumn<Lote, String> precoLote;
    @FXML
    private TableColumn<Lote, String> larguraLote;
    @FXML
    private TableColumn<Lote, String> comprimentoLote;
    
    @FXML
    private TableView<Funcionario> funcionarioTabela;
    @FXML
    private TableColumn<Funcionario, String> cpfFuncionario;
    @FXML
    private TableColumn<Funcionario, String> nomeFuncionario;
    @FXML
    private TableColumn<Funcionario, String> rgFuncionario;
    @FXML
    private TableColumn<Funcionario, String> ruaFuncionario;
    @FXML
    private TableColumn<Funcionario, String> numeroFuncionario;
    @FXML
    private TableColumn<Funcionario, String> cidadeFuncionario;
    @FXML
    private TableColumn<Funcionario, String> estadoFuncionario;
    @FXML
    private TableColumn<Funcionario, String> emailFuncionario;
    @FXML
    private TableColumn<Funcionario, String> celularFuncionario;
    @FXML
    private TableColumn<Funcionario, String> telefoneFuncionario;
    @FXML
    private TableColumn<Funcionario, String> valorFuncionario;
    @FXML
    private TableColumn<Funcionario, String> funcaoFuncionario;
    
    @FXML
    private TableView<ContratoCoquetel> contCoquetelTabela;
    @FXML
    private TableColumn<ContratoCoquetel, String> coquetelContCoquetel;
    @FXML
    private TableColumn<ContratoCoquetel, String> funcionarioContCoquetel;
    @FXML
    private TableColumn<ContratoCoquetel, String> horastrabContCoquetel;
    @FXML
    private TableColumn<ContratoCoquetel, String> valorContCoquetel;
    
    @FXML
    private TableView<ContratoFestFood> contFestFoodTabela;
    @FXML
    private TableColumn<ContratoFestFood, String> festfoodContFestFood;
    @FXML
    private TableColumn<ContratoFestFood, String> segurancaContFestFood;
    @FXML
    private TableColumn<ContratoFestFood, String> horastrabContFestFood;
    @FXML
    private TableColumn<ContratoFestFood, String> valorContFestFood;
    **/
    
    private static Stage myStage;
    
    /**
     * Metodo que inicializa a classe de Controle, setando todos os argumentos de ambiente e as estruturas graficas da interface.
     * 
     * @param url - endereco de localizacao do arquivo fxml
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){      
    	cnpjEmpresa.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        nomeEmpresa.setCellValueFactory(new PropertyValueFactory<>("nome"));
        razaoEmpresa.setCellValueFactory(new PropertyValueFactory<>("razao"));
        enderecoEmpresa.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        empresaTabela.setItems(Empresa.tableView()); 
        
        /**
        empresaContatos.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        emailContatos.setCellValueFactory(new PropertyValueFactory<>("email"));
        razaoContatos.setCellValueFactory(new PropertyValueFactory<>("nome"));
        enderecoContatos.setCellValueFactory(new PropertyValueFactory<>("telefone"));
       	contatosTabela.setItems(Contatos.TableView());
       	
       	cnpjContratante.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
       	contratanteTabela.setItems(Contratante.TableView());
       	
       	cnpjContratante.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        fornecedoraTabela.setItems(Fornecedora.TableView());
        
        nomeCatFornecimento.setCellValueFactory(new PropertyValueFactory<>("nome"));
        descCatFornecimento.setCellValueFactory(new PropertyValueFactory<>("descricao"));
      	catFornecimentoTabela.setItems(CategoriaFornecimento.TableView());
      	
      	fornecedoraCatFornecedora.setCellValueFactory(new PropertyValueFactory<>("fornecedora"));
        categoriaCatFornecedora.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        precoCatFornecedora.setCellValueFactory(new PropertyValueFactory<>("preco"));
        catFornecedoraTabela.setItems(CategoriaFornecedora.TableView());
        
        idFesta.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeFesta.setCellValueFactory(new PropertyValueFactory<>("nome"));
        contratanteFesta.setCellValueFactory(new PropertyValueFactory<>("contratante"));
        dataFesta.setCellValueFactory(new PropertyValueFactory<>("data"));
        horarioFesta.setCellValueFactory(new PropertyValueFactory<>("horario"));
        duracaoFesta.setCellValueFactory(new PropertyValueFactory<>("duracao"));
       	festaTabela.setItems(Festa.TableView());
       	
       	festaFestFood.setCellValueFactory(new PropertyValueFactory<>("festa"));
        ingressoFestFood.setCellValueFactory(new PropertyValueFactory<>("ingresso"));
       	festfoodTabela.setItems(FestFood.TableView());
       	
       	festfoodIngresso.setCellValueFactory(new PropertyValueFactory<>("festfood"));
        numeroIngresso.setCellValueFactory(new PropertyValueFactory<>("numeoro"));
        compradorIngresso.setCellValueFactory(new PropertyValueFactory<>("comprador"));
       	ingressoTabela.setItems(Ingresso.TableView());
       	
       	festaCoquetel.setCellValueFactory(new PropertyValueFactory<>("festa"));
        localCoquetel.setCellValueFactory(new PropertyValueFactory<>("local"));
        cidadeCoquetel.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        orcamentoCoquetel.setCellValueFactory(new PropertyValueFactory<>("orcamento"));
        coquetelTabela.setItems(Coquetel.TableView());
 
        emailConvidado.setCellValueFactory(new PropertyValueFactory<>("email"));
        nomeConvidado.setCellValueFactory(new PropertyValueFactory<>("nome"));
        telefoneConvidado.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        convidadoTabela.setItems(Convidado.TableView());
        
        coquetelConvite.setCellValueFactory(new PropertyValueFactory<>("convidado"));
        convidadoConvite.setCellValueFactory(new PropertyValueFactory<>("convite"));
        conviteTabela.setItems(Convite.TableView());
        **/       
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
    void tupla(){}
   
}