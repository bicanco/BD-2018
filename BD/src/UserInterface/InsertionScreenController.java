package UserInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import backend.tables.Contratante;
import backend.tables.Empresa;
import backend.tables.FestFood;
import backend.tables.Fornecedora;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe de controle da Interface de Insercao.
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class InsertionScreenController implements Initializable {
	
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
    private JFXTextField cnpjEmpresa;
    @FXML
    private JFXTextField nomeEmpresa;
    @FXML
    private JFXTextField razaoEmpresa;
    @FXML
    private JFXTextField enderecoEmpresa;
    @FXML
    private JFXComboBox<String> tipoEmpresa;
    @FXML
    private JFXButton inserirEmpresa;
    
    @FXML
    private JFXComboBox<String> empresaContatos;
    @FXML
    private JFXTextField nomeContatos;
    @FXML
    private JFXTextField emailContatos;
    @FXML
    private JFXTextField telefoneContatos;
    @FXML
    private JFXButton inserirContatos;
    
    @FXML
    private JFXTextField nomeCatFornecimento;
    @FXML
    private JFXTextField descricaoCatFornecimento;
    @FXML
    private JFXButton inserirCatFornecimento;
    
    @FXML
    private JFXComboBox<String> fornecedoraCatFornecedora;
    @FXML
    private JFXComboBox<String> categoriaCatFornecedora;
    @FXML
    private JFXTextField precoCatFornecedora;
    @FXML
    private JFXButton inserirCatFornecedora;
    
    @FXML
    private JFXComboBox<String> contratanteFesta;
    @FXML
    private JFXTextField dataFesta;
    @FXML
    private JFXTextField nomeFesta;
    @FXML
    private JFXTextField horarioFesta;
    @FXML
    private JFXTextField duracaoFesta;
    @FXML
    private JFXComboBox<String> tipoFesta;
    @FXML
    private JFXButton inserirFesta;
    
    @FXML
    private JFXComboBox<String> festaFestFood;
    @FXML
    private JFXTextField precoFestFood;
    @FXML
    private JFXButton inserirFestFood;
    
    @FXML
    private JFXComboBox<String> festfoodIngresso;
    @FXML
    private JFXTextField codigoIngresso;
    @FXML
    private JFXTextField compradorIngresso;
    @FXML
    private JFXButton inserirIngresso;
    
    @FXML
    private JFXComboBox<String> festaCoquetel;
    @FXML
    private JFXComboBox<String> localCoquetel;
    @FXML
    private JFXButton inserirCoquetel;
    
    @FXML
    private JFXTextField nomeConvidado;
    @FXML
    private JFXTextField emailConvidado;
    @FXML
    private JFXTextField telefoneConvidado;
    @FXML
    private JFXButton inserirConvidado;
    
    @FXML
    private JFXComboBox<String> coquetelConvite;
    @FXML
    private JFXComboBox<String> convidadoConvite;
    @FXML
    private JFXButton inserirConvite;
    
    @FXML
    private JFXComboBox<String> coquetelBrinde;
    @FXML
    private JFXTextField nomeBrinde;
    @FXML
    private JFXTextField descricaoBrinde;
    @FXML
    private JFXButton inserirBrinde;
    
    @FXML
    private JFXComboBox<String> fornecedoraFornecimento;
    @FXML
    private JFXComboBox<String> coquetelFornecimento;
    @FXML
    private JFXTextField precoFornecimento;
    @FXML
    private JFXButton inserirFornecimento;
    
    @FXML
    private JFXComboBox<String> fornecedoraProdutos;
    @FXML
    private JFXComboBox<String> coquetelProdutos;
    @FXML
    private JFXTextField nomeProdutos;
    @FXML
    private JFXTextField quantidadeProdutos;
    @FXML
    private JFXButton inserirProdutos;
    
    @FXML
    private JFXTextField nomeLocal;
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
    private JFXButton inserirLocal;
    
    @FXML
    private JFXComboBox<String> festfoodLocacao;
    @FXML
    private JFXComboBox<String> localLocacao;
    @FXML
    private JFXButton inserirLocacao;
    
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
    private JFXButton inserirLote;
    
    @FXML
    private JFXTextField cpfFuncionario;
    @FXML
    private JFXTextField nomeFuncionario;
    @FXML
    private JFXTextField rgFuncionario;
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
    private JFXTextField funcaoFuncionario;
    @FXML
    private JFXButton inserirFuncionario;
    
    @FXML
    private JFXComboBox<String> coquetelContCoquetel;
    @FXML
    private JFXComboBox<String> funcionarioContCoquetel;
    @FXML
    private JFXTextField horastrabContCoquetel;
    @FXML
    private JFXButton inserirContCoquetel;
    
    @FXML
    private JFXComboBox<String> festfoodContFestFood;
    @FXML
    private JFXComboBox<String> segurancaContFestFood;
    @FXML
    private JFXTextField horastrabContFestFood;
    @FXML
    private JFXButton inserirContFestFood;

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
        
        ObservableList<String> tipoempresa = 
        	    FXCollections.observableArrayList(
        	        "Fornecedora",
        	        "Contratante",
        	        "Ambas");
        tipoEmpresa.setItems(tipoempresa);
        
        
        empresaContatos.setItems(Empresa.getListaEmpresa());
        
        fornecedoraCatFornecedora.setItems(Fornecedora.getListaFornecedora());
        
        contratanteFesta.setItems(Contratante.getListaContratante());
        
        ObservableList<String> tipofesta = 
        	    FXCollections.observableArrayList(
        	        "Fest Food",
        	        "Coquetel de Lançamento");
       
        tipoFesta.setItems(tipofesta);
        
        festaFestFood.setItems(FestFood.getListaFestFood());
        
        festfoodIngresso.setItems(FestFood.getListaFestFood());
        /*
        festaCoquetel.setItems(Festa.getListaCoquetel());
 
        localCoquetel.setItems(Local.getListaLocal());
        
        cidadeCoquetel.setItems(Local.getListaCidade());
        
        coquetelConvite.setItems(Festa.getListaCoquetel());
        
        convidadoConvite.setItems(Convidado.getListaConvidado);
        
        coquetelBrinde.setItems(Festa.getListaCoquetel());
        
        fornecedoraFornecimento.setItems(Empresa.getListaFornecedora());
        
        coquetelFornecimento.setItems(Festa.getListaCoquetel());
        
        fornecedoraProdutos.setItems(Empresa.getListaFornecedora());
        
        coquetelProdutos.setItems(Festa.getListaCoquetel());
        
        festfoodLocacao.setItems(Festa.getListaFestFood());
        
        localLocacao.setItems(Local.getListaLocal());
        
        cidadeLocacao.setItems(Local.getListaCidade());
        
        fornecedoraLote.setItems(Empresa.getListaFornecedora());
        
        locacaoLote.setItems(Local.getListaLocacao());
        
        coquetelContCoquetel.setItems(Festa.getListaCoquetel());
        
        funcionarioContCoquetel.setItems(Funcionario.getListaFuncionario());
        
        festfoodContFestFood.setItems(Festa.getListaFestFood());
        
        segurancaContFestFood.setItems(Funcionario.getListaSeguranca());
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
    
    @FXML
    void inserirEmpresa(ActionEvent event) throws IOException{
    	/*
    	Empresa e = new Empresa(cnpjEmpresa.getText(), nomeEmpresa.getText(), razaoEmpresa.getText(), enderecoEmpresa.getText(), tipoEmpresa.getValue());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		Empresa.inserir(e);
    		ou
    		e.inserir();
    		-- nesse caso exclusivamente, quando formos inserir as empresas devemos também inserí-la na tabela de contratante e/ou fornecedora;
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    
    @FXML
    void inserirContato(ActionEvent event) throws IOException{
    	/*
    	ContatoEmpresa c = new ContatoEmpresa(empresaContatos.getValue(), nomeContatos.getText(), emailContatos.getText(), telefoneContatos.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirCategoriaFornecimento(ActionEvent event) throws IOException{
    	/*
    	CategoriaFornecimento c = new CategoriaFornecimento(nomeCatFornecimento.getText(), descricaoCatFornecimento.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.inserir();
    	else
    		tratamento dos erros (telas);
    	*/
    }
    
    @FXML
    void inserirCategoriaFornecedora(ActionEvent event) throws IOException{
    	/*
    	CategoriaFornecedora c = new CategoriaFornecedora(fornecedoraCatFornecedora.getValue(), categoriaCatFornecedora.getValue(), precoCatFornecedora.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirFesta(ActionEvent event) throws IOException{
    	/*
    	Festa f = new Festa(contratanteFesta.getValue(), dataFesta.getText(), nomeFesta.getText(), horarioFesta.getText(), duracaoFesta.getText(), tipoFesta.getValue());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirFestFood(ActionEvent event) throws IOException{
    	/*
    	FestFood f = new Festa(festaFestFood.getValue(), precoFestFood.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirIngresso(ActionEvent event) throws IOException{
    	/*
    	Ingresso i = new Ingresso(festfoodIngresso.getValue(), codigoIngresso.getText(), compradorIngresso.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		i.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirCoquetel(ActionEvent event) throws IOException{
    	/*
    	Coquetel c = new Coquetel(festaCoquetel.getValue(), localCoquetel.getValue());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirConvidado(ActionEvent event) throws IOException{
    	/*
    	Convidado c = new Convidado(nomeConvidado.getText(), emailConvidado.getText(), telefoneConvidado.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirConvite(ActionEvent event) throws IOException{
    	/*
    	Convite c = new Convite(coquetelConvite.getValue(), convidadoConvite.getValue());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirBrinde(ActionEvent event) throws IOException{
    	/*
    	Brinde b = new Brinde(coquetelBrinde.getValue(), nomeBrinde.getText(), descricaoBrinde.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		b.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirFornecimentoCoquetel(ActionEvent event) throws IOException{
    	/*
    	FornecimentoCoquetel f = new FornecimentoCoquetel(fornecedoraFornecimento.getValue(), coquetelFornecimento.getValue(), precoFornecimento.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirProduto(ActionEvent event) throws IOException{
    	/*
    	Produtos p = new Produtos(fornecedoraProdutos.getValue(), coquetelProdutos.getValue(), nomeProdutos.getText(), quantidadeProdutos.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		p.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirLocal(ActionEvent event) throws IOException{
    	/*
    	Local l = new Local(nomeLocal.getText(), ruaLocal.getText(), numeroLocal.getText(), cidadeLocal.getText(), estadoLocal.getText(), capacidadeLocal.getText(), diariaLocal.getText(), aberturaLocal.getValue());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		l.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirLocacao(ActionEvent event) throws IOException{
    	/*
    	Locacao l = new Locacao(festfoodLocacao.getValue(), localLocacao.getValue());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		l.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirLote(ActionEvent event) throws IOException{
    	/*
    	Lote l = new Lote(fornecedoraLote.getValue(), locacaoLote.getValue(), numeroLote.getText(), precoLote.getText(), larguraLote.getText(), comprimentoLote.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		l.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirFuncionario(ActionEvent event) throws IOException{
    	/*
    	Funcionario f = new Funcionario(cpfFuncionario.getText(), nomeFuncionario.getText(), rgFuncionario.getText(), numeroFuncionario.getText(), ruaFuncionario.getText(), cidadeFuncionario.getText(), estadoFuncionario.getText(), emailFuncionario.getText(), telefoneFuncionario.getText(), celularFuncionario.getText(), valorFuncionario.getText(), funcaoFuncionario.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirContratoCoquetel(ActionEvent event) throws IOException{
    	/*
    	ContratoCoquetel cc = new ContratoCoquetel(coquetelContCoquetel.getValue(), funcionarioContCoquetel.getValue(), horastrabContCoquetel.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		cc.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void inserirContratoFestFood(ActionEvent event) throws IOException{
    	/*
    	ContratoFestFood cf = new ContratoFestFood(festfoodContFestFood.getValue(), segurancaContFestFood.getValue(), horastrabContFestFood.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		cf.inserir();
    	else
    		tratamento dos erros (telas);
   		*/
    }
}
