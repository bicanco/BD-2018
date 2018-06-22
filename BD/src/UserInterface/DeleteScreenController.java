package UserInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import backend.tables.Empresa;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.omg.CORBA.SystemException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe de controle da Interface de Remocao.
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class DeleteScreenController implements Initializable {
	
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
    private JFXButton removerEmpresa;
    
    @FXML
    private JFXTextField cnpjFornecedora;
    @FXML
    private JFXButton removerFornecedora;
    
    @FXML
    private JFXTextField cnpjContratante;
    @FXML
    private JFXButton removerContratante;
    
    @FXML
    private JFXTextField empresaContatos;
    @FXML
    private JFXTextField nomeContatos;
    @FXML
    private JFXTextField emailContatos;
    @FXML
    private JFXButton removerContatos;
    
    @FXML
    private JFXTextField nomeCatFornecimento;
    @FXML
    private JFXButton removerCatFornecimento;
    
    @FXML
    private JFXTextField fornecedoraCatFornecedora;
    @FXML
    private JFXTextField categoriaCatFornecedora;
    @FXML
    private JFXButton removerCatFornecedora;
    
    @FXML
    private JFXTextField contratanteFesta;
    @FXML
    private JFXTextField dataFesta;
    @FXML
    private JFXTextField nomeFesta;
    @FXML
    private JFXButton removerFesta;
    
    @FXML
    private JFXTextField festaFestFood;
    @FXML
    private JFXButton removerFestFood;
    
    @FXML
    private JFXTextField festfoodIngresso;
    @FXML
    private JFXTextField codigoIngresso;
    @FXML
    private JFXTextField compradorIngresso;
    @FXML
    private JFXButton removerIngresso;
    
    @FXML
    private JFXTextField festaCoquetel;
    @FXML
    private JFXTextField localCoquetel;
    @FXML
    private JFXTextField cidadeCoquetel;
    @FXML
    private JFXButton removerCoquetel;
    
    @FXML
    private JFXTextField nomeConvidado;
    @FXML
    private JFXTextField emailConvidado;
    @FXML
    private JFXButton removerConvidado;
    
    @FXML
    private JFXTextField coquetelConvite;
    @FXML
    private JFXTextField convidadoConvite;
    @FXML
    private JFXButton removerConvite;
    
    @FXML
    private JFXTextField coquetelBrinde;
    @FXML
    private JFXTextField nomeBrinde;
    @FXML
    private JFXButton removerBrinde;
    
    @FXML
    private JFXTextField fornecedoraFornecimento;
    @FXML
    private JFXTextField coquetelFornecimento;
    @FXML
    private JFXButton removerFornecimento;
    
    @FXML
    private JFXTextField fornecedoraProdutos;
    @FXML
    private JFXTextField coquetelProdutos;
    @FXML
    private JFXTextField nomeProdutos;
    @FXML
    private JFXButton removerProdutos;
    
    @FXML
    private JFXTextField nomeLocal;
    @FXML
    private JFXTextField cidadeLocal;
    @FXML
    private JFXTextField estadoLocal;
    @FXML
    private JFXButton removerLocal;
    
    @FXML
    private JFXTextField festfoodLocacao;
    @FXML
    private JFXTextField localLocacao;
    @FXML
    private JFXTextField cidadeLocacao;
    @FXML
    private JFXButton removerLocacao;
    
    @FXML
    private JFXTextField fornecedoraLote;
    @FXML
    private JFXTextField locacaoLote;
    @FXML
    private JFXTextField numeroLote;
    @FXML
    private JFXButton removerLote;
    
    @FXML
    private JFXTextField cpfFuncionario;
    @FXML
    private JFXTextField nomeFuncionario;
    @FXML
    private JFXTextField cidadeFuncionario;
    @FXML
    private JFXTextField estadoFuncionario;
    @FXML
    private JFXButton removerFuncionario;
    
    @FXML
    private JFXTextField coquetelContCoquetel;
    @FXML
    private JFXTextField funcionarioContCoquetel;
    @FXML
    private JFXButton removerContCoquetel;
    
    @FXML
    private JFXTextField festfoodContFestFood;
    @FXML
    private JFXTextField segurancaContFestFood;
    @FXML
    private JFXButton removerContFestFood;
    
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
    void removerEmpresa(ActionEvent event) throws IOException{
    	Empresa e = new Empresa(cnpjEmpresa.getText(), nomeEmpresa.getText(), null, null, null);
    	try {
			Empresa.deleteEmpresa(e);
		} catch (Exception e1) {
			System.out.println(e1);;
		}
    	/*
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		Empresa.remover(e);
    		ou
    		e.remover();

    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerFornecedora(ActionEvent event) throws IOException{
    	/*
    	Fornecedora f = new Fornecedora(cnpjFornecedora.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerContratante(ActionEvent event) throws IOException{
    	/*
    	Contratante c = new Contratante(cnpjContratante.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerContato(ActionEvent event) throws IOException{
    	/*
    	ContatoEmpresa c = new ContatoEmpresa(empresaContatos.getText(), nomeContatos.getText(), emailContatos.getText(), null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerCategoriaFornecimento(ActionEvent event) throws IOException{
    	/*
    	CategoriaFornecimento c = new CategoriaFornecimento(nomeCatFornecimento.getText(), null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.remover();
    	else
    		tratamento dos erros (telas);
    	*/
    }
    
    @FXML
    void removerCategoriaFornecedora(ActionEvent event) throws IOException{
    	/*
    	CategoriaFornecedora c = new CategoriaFornecedora(fornecedoraCatFornecedora.getText(), categoriaCatFornecedora.getText(), null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerFesta(ActionEvent event) throws IOException{
    	/*
    	Festa f = new Festa(contratanteFesta.getText(), dataFesta.getText(), nomeFesta.getText(), null, null, null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerFestFood(ActionEvent event) throws IOException{
    	/*
    	FestFood f = new Festa(festaFestFood.getText(), null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerIngresso(ActionEvent event) throws IOException{
    	/*
    	Ingresso i = new Ingresso(festfoodIngresso.getText(), codigoIngresso.getText(), compradorIngresso.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		i.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerCoquetel(ActionEvent event) throws IOException{
    	/*
    	Coquetel c = new Coquetel(festaCoquetel.getText(), localCoquetel.getText(), cidadeCoquetel.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerConvidado(ActionEvent event) throws IOException{
    	/*
    	Convidado c = new Convidado(nomeConvidado.getText(), emailConvidado.getText(), null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerConvite(ActionEvent event) throws IOException{
    	/*
    	Convite c = new Convite(coquetelConvite.getText(), convidadoConvite.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		c.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerBrinde(ActionEvent event) throws IOException{
    	/*
    	Brinde b = new Brinde(coquetelBrinde.getText(), nomeBrinde.getText(), null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		b.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerFornecimentoCoquetel(ActionEvent event) throws IOException{
    	/*
    	FornecimentoCoquetel f = new FornecimentoCoquetel(fornecedoraFornecimento.getText(), coquetelFornecimento.getText(), null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerProduto(ActionEvent event) throws IOException{
    	/*
    	Produtos p = new Produtos(fornecedoraProdutos.getText(), coquetelProdutos.getText(), nomeProdutos.getText(), null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		p.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerLocal(ActionEvent event) throws IOException{
    	/*
    	Local l = new Local(nomeLocal.getText(), null, null, cidadeLocal.getText(), estadoLocal.getText(), capacidadeLocal.getText(), null, null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		l.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerLocacao(ActionEvent event) throws IOException{
    	/*
    	Locacao l = new Locacao(festfoodLocacao.getText(), localLocacao.getText(), cidadeLocacao.getText());
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		l.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerLote(ActionEvent event) throws IOException{
    	/*
    	Lote l = new Lote(fornecedoraLote.getText(), locacaoLote.getText(), numeroLote.getText(), null, null, null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		l.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerFuncionario(ActionEvent event) throws IOException{
    	/*
    	Funcionario f = new Funcionario(cpfFuncionario.getText(), nomeFuncionario.getText(), null, null, null, cidadeFuncionario.getText(), estadoFuncionario.getText(), null, null, null, null, null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		f.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerContratoCoquetel(ActionEvent event) throws IOException{
    	/*
    	ContratoCoquetel cc = new ContratoCoquetel(coquetelContCoquetel.getText(), funcionarioContCoquetel.getText(), null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		cc.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
    
    @FXML
    void removerContratoFestFood(ActionEvent event) throws IOException{
    	/*
    	ContratoFestFood cf = new ContratoFestFood(festfoodContFestFood.getText(), segurancaContFestFood.getText(), null);
    	
    	if(verificação dos atributos para saber se estão conforme as especificações)
    		cf.remover();
    	else
    		tratamento dos erros (telas);
   		*/
    }
}

