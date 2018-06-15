package UserInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
    private JFXButton buscarEmpresa;
    
    @FXML
    private JFXTextField empresaContatos;
    @FXML
    private JFXTextField nomeContatos;
    @FXML
    private JFXTextField emailContatos;
    @FXML
    private JFXTextField telefoneContatos;
    @FXML
    private JFXButton buscarContatos;
    
    @FXML
    private JFXTextField nomeCatFornecimento;
    @FXML
    private JFXTextField descricaoCatFornecimento;
    @FXML
    private JFXButton buscarCatFornecimento;
    
    @FXML
    private JFXTextField fornecedoraCatFornecedora;
    @FXML
    private JFXTextField categoriaCatFornecedora;
    @FXML
    private JFXTextField precoCatFornecedora;
    @FXML
    private JFXButton buscarCatFornecedora;
    
    @FXML
    private JFXTextField contratanteFesta;
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
    private JFXButton buscarFesta;
    
    @FXML
    private JFXTextField festaFestFood;
    @FXML
    private JFXTextField precoFestFood;
    @FXML
    private JFXButton buscarFestFood;
    
    @FXML
    private JFXTextField festfoodIngresso;
    @FXML
    private JFXTextField codigoIngresso;
    @FXML
    private JFXTextField compradorIngresso;
    @FXML
    private JFXButton buscarIngresso;
    
    @FXML
    private JFXTextField festaCoquetel;
    @FXML
    private JFXTextField localCoquetel;
    @FXML
    private JFXTextField cidadeCoquetel;
    @FXML
    private JFXButton buscarCoquetel;
    
    @FXML
    private JFXTextField nomeConvidado;
    @FXML
    private JFXTextField emailConvidado;
    @FXML
    private JFXTextField telefoneConvidado;
    @FXML
    private JFXButton buscarConvidado;
    
    @FXML
    private JFXTextField coquetelConvite;
    @FXML
    private JFXTextField convidadoConvite;
    @FXML
    private JFXButton buscarConvite;
    
    @FXML
    private JFXTextField coquetelBrinde;
    @FXML
    private JFXTextField nomeBrinde;
    @FXML
    private JFXTextField descricaoBrinde;
    @FXML
    private JFXButton buscarBrinde;
    
    @FXML
    private JFXTextField fornecedoraFornecimento;
    @FXML
    private JFXTextField coquetelFornecimento;
    @FXML
    private JFXTextField precoFornecimento;
    @FXML
    private JFXButton buscarFornecimento;
    
    @FXML
    private JFXTextField fornecedoraProdutos;
    @FXML
    private JFXTextField coquetelProdutos;
    @FXML
    private JFXTextField nomeProdutos;
    @FXML
    private JFXTextField quantidadeProdutos;
    @FXML
    private JFXButton buscarProdutos;
    
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
    private JFXButton buscarLocal;
    
    @FXML
    private JFXTextField festfoodLocacao;
    @FXML
    private JFXTextField localLocacao;
    @FXML
    private JFXTextField cidadeLocacao;
    @FXML
    private JFXButton buscarLocacao;
    
    @FXML
    private JFXTextField fornecedoraLote;
    @FXML
    private JFXTextField locacaoLote;
    @FXML
    private JFXTextField numeroLote;
    @FXML
    private JFXTextField precoLote;
    @FXML
    private JFXTextField larguraLote;
    @FXML
    private JFXTextField comprimentoLote;
    @FXML
    private JFXButton buscarLote;
    
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
    private JFXButton buscarFuncionario;
    
    @FXML
    private JFXTextField coquetelContCoquetel;
    @FXML
    private JFXTextField funcionarioContCoquetel;
    @FXML
    private JFXTextField horastrabContCoquetel;
    @FXML
    private JFXButton buscarContCoquetel;
    
    @FXML
    private JFXTextField festfoodContFestFood;
    @FXML
    private JFXTextField segurancaContFestFood;
    @FXML
    private JFXTextField horastrabContFestFood;
    @FXML
    private JFXButton buscarContFestFood;
    
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
        
        ObservableList<String> tipofesta = 
        	    FXCollections.observableArrayList(
        	        "Fest Food",
        	        "Coquetel de Lançamento");
        tipoFesta.setItems(tipofesta);
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
    void buscarEmpresa(ActionEvent event) throws IOException{
    	/*
    	Empresa e = new Empresa(cnpjEmpresa.getText(), nomeEmpresa.getText(), razaoEmpresa.getText(), enderecoEmpresa.getText(), tipoEmpresa.getValue());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		Empresa.buscar(e);
    		ou
    		e.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    
    @FXML
    void buscarContato(ActionEvent event) throws IOException{
    	/*
    	ContatoEmpresa c = new ContatoEmpresa(empresaContatos.getText(), nomeContatos.getText(), emailContatos.getText(), telefoneContatos.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarCategoriaFornecimento(ActionEvent event) throws IOException{
    	/*
    	CategoriaFornecimento c = new CategoriaFornecimento(nomeCatFornecimento.getText(), descricaoCatFornecimento.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.buscar();
    	else
    		tratamento dos erros (telas);
    	*/
    }
    
    @FXML
    void buscarCategoriaFornecedora(ActionEvent event) throws IOException{
    	/*
    	CategoriaFornecedora c = new CategoriaFornecedora(fornecedoraCatFornecedora.getText(), categoriaCatFornecedora.getText(), precoCatFornecedora.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarFesta(ActionEvent event) throws IOException{
    	/*
    	Festa f = new Festa(contratanteFesta.getText(), dataFesta.getText(), nomeFesta.getText(), horarioFesta.getText(), duracaoFesta.getText(), tipoFesta.getValue());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarFestFood(ActionEvent event) throws IOException{
    	/*
    	FestFood f = new Festa(festaFestFood.getText(), precoFestFood.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarIngresso(ActionEvent event) throws IOException{
    	/*
    	Ingresso i = new Ingresso(festfoodIngresso.getText(), codigoIngresso.getText(), compradorIngresso.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		i.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarCoquetel(ActionEvent event) throws IOException{
    	/*
    	Coquetel c = new Coquetel(festaCoquetel.getText(), localCoquetel.getText(), cidadeCoquetel.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarConvidado(ActionEvent event) throws IOException{
    	/*
    	Convidado c = new Convidado(nomeConvidado.getText(), emailConvidado.getText(), telefoneConvidado.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarConvite(ActionEvent event) throws IOException{
    	/*
    	Convite c = new Convite(coquetelConvite.getText(), convidadoConvite.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarBrinde(ActionEvent event) throws IOException{
    	/*
    	Brinde b = new Brinde(coquetelBrinde.getText(), nomeBrinde.getText(), descricaoBrinde.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		b.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarFornecimentoCoquetel(ActionEvent event) throws IOException{
    	/*
    	FornecimentoCoquetel f = new FornecimentoCoquetel(fornecedoraFornecimento.getText(), coquetelFornecimento.getText(), precoFornecimento.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarProduto(ActionEvent event) throws IOException{
    	/*
    	Produtos p = new Produtos(fornecedoraProdutos.getText(), coquetelProdutos.getText(), nomeProdutos.getText(), quantidadeProdutos.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		p.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarLocal(ActionEvent event) throws IOException{
    	/*
    	Local l = new Local(nomeLocal.getText(), ruaLocal.getText(), numeroLocal.getText(), cidadeLocal.getText(), estadoLocal.getText(), capacidadeLocal.getText(), diariaLocal.getText(), aberturaLocal.getValue());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		l.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarLocacao(ActionEvent event) throws IOException{
    	/*
    	Locacao l = new Locacao(festfoodLocacao.getText(), localLocacao.getText(), cidadeLocacao.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		l.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarLote(ActionEvent event) throws IOException{
    	/*
    	Lote l = new Lote(fornecedoraLote.getText(), locacaoLote.getText(), numeroLote.getText(), precoLote.getText(), larguraLote.getText(), comprimentoLote.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		l.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarFuncionario(ActionEvent event) throws IOException{
    	/*
    	Funcionario f = new Funcionario(cpfFuncionario.getText(), nomeFuncionario.getText(), rgFuncionario.getText(), numeroFuncionario.getText(), ruaFuncionario.getText(), cidadeFuncionario.getText(), estadoFuncionario.getText(), emailFuncionario.getText(), telefoneFuncionario.getText(), celularFuncionario.getText(), valorFuncionario.getText(), funcaoFuncionario.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarContratoCoquetel(ActionEvent event) throws IOException{
    	/*
    	ContratoCoquetel cc = new ContratoCoquetel(coquetelContCoquetel.getText(), funcionarioContCoquetel.getText(), horastrabContCoquetel.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		cc.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void buscarContratoFestFood(ActionEvent event) throws IOException{
    	/*
    	ContratoFestFood cf = new ContratoFestFood(festfoodContFestFood.getText(), segurancaContFestFood.getText(), horastrabContFestFood.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		cf.buscar();
    	else
    		tratamento dos erros (telas);
   		*/
    }
}
