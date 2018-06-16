package UserInterface;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
       
    @FXML
    private TableView<ContatoEmpresa> contatosTabela;
    @FXML
    private TableColumn<ContatoEmpresa, String> empresaContatos;
    @FXML
    private TableColumn<ContatoEmpresa, String> emailContatos;
    @FXML
    private TableColumn<ContatoEmpresa, String> nomeContatos;
    @FXML
    private TableColumn<ContatoEmpresa, String> telefoneContatos;
    
    @FXML
    private TableView<Contratante> contratanteTabela;
    @FXML
    private TableColumn<Contratante, String> cnpjContratante;
    
    @FXML
    private TableView<Fornecedora> fornecedoraTabela;
    @FXML
    private TableColumn<Fornecedora, String> cnpjFornecedora;
    
    @FXML
    private TableView<CategoriaFornecimento> catFornecimentoTabela;
    @FXML
    private TableColumn<CategoriaFornecimento, String> nomeCatFornecimento;
    @FXML
    private TableColumn<CategoriaFornecimento, String> descCatFornecimento;
    
    @FXML
    private TableView<AtribuicaoCategoria> catFornecedoraTabela;
    @FXML
    private TableColumn<AtribuicaoCategoria, String> fornecedoraCatFornecedora;
    @FXML
    private TableColumn<AtribuicaoCategoria, String> categoriaCatFornecedora;
    @FXML
    private TableColumn<AtribuicaoCategoria, String> precoCatFornecedora;
    
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
    private TableColumn<Festa, String> tipoFesta;
    
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
    private TableView<ProdutosFornecidos> produtosTabela;
    @FXML
    private TableColumn<ProdutosFornecidos, String> fornecedoraProdutos;
    @FXML
    private TableColumn<ProdutosFornecidos, String> coquetelProdutos;
    @FXML
    private TableColumn<ProdutosFornecidos, String> nomeProdutos;
    @FXML
    private TableColumn<ProdutosFornecidos, String> quantidadeProdutos;
    
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
 
        empresaContatos.setCellValueFactory(new PropertyValueFactory<>("empresa"));
        emailContatos.setCellValueFactory(new PropertyValueFactory<>("email"));
        nomeContatos.setCellValueFactory(new PropertyValueFactory<>("nome"));
        telefoneContatos.setCellValueFactory(new PropertyValueFactory<>("telefone"));
       	contatosTabela.setItems(ContatoEmpresa.tableView());
       	
       	cnpjContratante.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
       	contratanteTabela.setItems(Contratante.tableView());
       	
       	cnpjFornecedora.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
        fornecedoraTabela.setItems(Fornecedora.tableView());
        
        nomeCatFornecimento.setCellValueFactory(new PropertyValueFactory<>("nome"));
        descCatFornecimento.setCellValueFactory(new PropertyValueFactory<>("descricao"));
      	catFornecimentoTabela.setItems(CategoriaFornecimento.tableView());
      	
      	fornecedoraCatFornecedora.setCellValueFactory(new PropertyValueFactory<>("fornecedora"));
        categoriaCatFornecedora.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        precoCatFornecedora.setCellValueFactory(new PropertyValueFactory<>("preco"));
        catFornecedoraTabela.setItems(AtribuicaoCategoria.tableView());
        
        
        idFesta.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeFesta.setCellValueFactory(new PropertyValueFactory<>("nome"));
        contratanteFesta.setCellValueFactory(new PropertyValueFactory<>("contratante"));
        dataFesta.setCellValueFactory(new PropertyValueFactory<>("data"));
        horarioFesta.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));
        duracaoFesta.setCellValueFactory(new PropertyValueFactory<>("duracao"));
        tipoFesta.setCellValueFactory(new PropertyValueFactory<>("tipoFesta"));
       	festaTabela.setItems(Festa.tableView());
       	
       	festaFestFood.setCellValueFactory(new PropertyValueFactory<>("festa"));
        ingressoFestFood.setCellValueFactory(new PropertyValueFactory<>("precoIngresso"));
       	festfoodTabela.setItems(FestFood.tableView());
       	
       	festfoodIngresso.setCellValueFactory(new PropertyValueFactory<>("festFood"));
        numeroIngresso.setCellValueFactory(new PropertyValueFactory<>("numero"));
        compradorIngresso.setCellValueFactory(new PropertyValueFactory<>("cpfComprador"));
       	ingressoTabela.setItems(Ingresso.tableView());
       	
       	festaCoquetel.setCellValueFactory(new PropertyValueFactory<>("festa"));
        localCoquetel.setCellValueFactory(new PropertyValueFactory<>("local"));
        cidadeCoquetel.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        orcamentoCoquetel.setCellValueFactory(new PropertyValueFactory<>("orcamento"));
        coquetelTabela.setItems(Coquetel.tableView());
 
        emailConvidado.setCellValueFactory(new PropertyValueFactory<>("email"));
        nomeConvidado.setCellValueFactory(new PropertyValueFactory<>("nome"));
        telefoneConvidado.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        convidadoTabela.setItems(Convidado.tableView());
        
        coquetelConvite.setCellValueFactory(new PropertyValueFactory<>("convidado"));
        convidadoConvite.setCellValueFactory(new PropertyValueFactory<>("convite"));
        conviteTabela.setItems(Convite.tableView());
        
        coquetelBrinde.setCellValueFactory(new PropertyValueFactory<>("coquetel"));
        nomeBrinde.setCellValueFactory(new PropertyValueFactory<>("nome"));
        descricaoBrinde.setCellValueFactory(new PropertyValueFactory<>("descricao"));
       	brindeTabela.setItems(Brinde.tableView());
       	
       	fornecedoraFornCoquetel.setCellValueFactory(new PropertyValueFactory<>("fornecedora"));
        coquetelFornCoquetel.setCellValueFactory(new PropertyValueFactory<>("coquetel"));
        precoFornCoquetel.setCellValueFactory(new PropertyValueFactory<>("nome"));
       	fornCoquetelTabela.setItems(FornecimentoCoquetel.tableView());
       	
       	fornecedoraProdutos.setCellValueFactory(new PropertyValueFactory<>("fornecedora"));
        coquetelProdutos.setCellValueFactory(new PropertyValueFactory<>("coquetel"));
        nomeProdutos.setCellValueFactory(new PropertyValueFactory<>("nome"));
        quantidadeProdutos.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        produtosTabela.setItems(ProdutosFornecidos.tableView());
        
        nomeLocal.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cidadeLocal.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        estadoLocal.setCellValueFactory(new PropertyValueFactory<>("estado"));
        numeroLocal.setCellValueFactory(new PropertyValueFactory<>("rua"));
        ruaLocal.setCellValueFactory(new PropertyValueFactory<>("numero"));
        capacidadeLocal.setCellValueFactory(new PropertyValueFactory<>("maxFrequentadores"));
        diariaLocal.setCellValueFactory(new PropertyValueFactory<>("diariaLocacao"));
        aberturaLocal.setCellValueFactory(new PropertyValueFactory<>("possuiAbertura"));
        localTabela.setItems(Local.tableView());
        
        idLocacao.setCellValueFactory(new PropertyValueFactory<>("id"));
        festfoodLocacao.setCellValueFactory(new PropertyValueFactory<>("festfood"));
        localLocacao.setCellValueFactory(new PropertyValueFactory<>("nomeLocal"));
        cidadeLocacao.setCellValueFactory(new PropertyValueFactory<>("cidadeLocal"));
        locacaoTabela.setItems(Locacao.tableView());
        
        fornecedoraLote.setCellValueFactory(new PropertyValueFactory<>("fornecedora"));
        locacaoLote.setCellValueFactory(new PropertyValueFactory<>("locacao"));
        numeroLote.setCellValueFactory(new PropertyValueFactory<>("numero"));
        precoLote.setCellValueFactory(new PropertyValueFactory<>("preco"));
        larguraLote.setCellValueFactory(new PropertyValueFactory<>("largura"));
        comprimentoLote.setCellValueFactory(new PropertyValueFactory<>("comprimento"));
        loteTabela.setItems(Lote.tableView());
        
        /*
        cpfFuncionario.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        nomeFuncionario.setCellValueFactory(new PropertyValueFactory<>("nome"));
        rgFuncionario.setCellValueFactory(new PropertyValueFactory<>("rg"));
        numeroFuncionario.setCellValueFactory(new PropertyValueFactory<>("numero"));
        ruaFuncionario.setCellValueFactory(new PropertyValueFactory<>("rua"));
        cidadeFuncionario.setCellValueFactory(new PropertyValueFactory<>("cidade"));
        estadoFuncionario.setCellValueFactory(new PropertyValueFactory<>("estado"));
        emailFuncionario.setCellValueFactory(new PropertyValueFactory<>("email"));
        celularFuncionario.setCellValueFactory(new PropertyValueFactory<>("celular"));
        telefoneFuncionario.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        valorFuncionario.setCellValueFactory(new PropertyValueFactory<>("valor"));
        funcaoFuncionario.setCellValueFactory(new PropertyValueFactory<>("funcao"));
        funcionarioTabela.setItems(Funcionario.tableView());
        
        coquetelContCoquetel.setCellValueFactory(new PropertyValueFactory<>("coquetel"));
        funcionarioContCoquetel.setCellValueFactory(new PropertyValueFactory<>("funcionario"));
        horastrabContCoquetel.setCellValueFactory(new PropertyValueFactory<>("horastrabalhadas"));
        valorContCoquetel.setCellValueFactory(new PropertyValueFactory<>("valor"));
        contCoquetelTabela.setItems(ContratoCoquetel.tableView());
        
        festfoodContFestFood.setCellValueFactory(new PropertyValueFactory<>("festfood"));
        segurancaContFestFood.setCellValueFactory(new PropertyValueFactory<>("seguranca"));
        horastrabContFestFood.setCellValueFactory(new PropertyValueFactory<>("horastrabalhadas"));
        valorContFestFood.setCellValueFactory(new PropertyValueFactory<>("valor"));
        contFestFoodTabela.setItems(ContratoFestFood.tableView());
        */
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
   
}