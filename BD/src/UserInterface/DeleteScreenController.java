package UserInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import backend.tables.AtribuicaoCategoria;
import backend.tables.Brinde;
import backend.tables.CategoriaFornecimento;
import backend.tables.ContatoEmpresa;
import backend.tables.Contratante;
import backend.tables.ContratoCoquetel;
import backend.tables.ContratoFestFood;
import backend.tables.Convidado;
import backend.tables.Convite;
import backend.tables.Coquetel;
import backend.tables.Empresa;
import backend.tables.FestFood;
import backend.tables.Festa;
import backend.tables.Fornecedora;
import backend.tables.FornecimentoCoquetel;
import backend.tables.Funcionario;
import backend.tables.Ingresso;
import backend.tables.Locacao;
import backend.tables.Local;
import backend.tables.Lote;
import backend.tables.ProdutosFornecidos;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Modality;
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
    
    void abrirSuccessScreen(String msg) throws IOException{
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginController.class.getResource("ErrorScreen.fxml"));
        AnchorPane root = loader.load();

        Stage erroStage = new Stage();
        erroStage.setResizable(false);
        erroStage.setTitle("Success");
        erroStage.initModality(Modality.WINDOW_MODAL);
        erroStage.initOwner(Main.getMyStage());
        Scene scene = new Scene(root);
        erroStage.setScene(scene);
        ErrorScreenController controller = loader.getController();
        controller.setAdicionarStage(erroStage, msg);
        
        erroStage.showAndWait();
    }
    
    @FXML
    void removerEmpresa(ActionEvent event) throws IOException{
    	Empresa e = new Empresa(cnpjEmpresa.getText(), nomeEmpresa.getText(), null, null, null);
    	try {
			Empresa.deleteEmpresa(e);
			abrirSuccessScreen("Remoção realizada com sucesso");
		} catch (Exception e1) {
			abrirErrorScreen(e1.getMessage());
		}
    }
    
    @FXML
    void removerFornecedora(ActionEvent event) throws IOException{
    	Fornecedora f = new Fornecedora(cnpjFornecedora.getText());
    	try {
			Fornecedora.deleteFornecedora(f);
			abrirSuccessScreen("Remoção realizada com sucesso");
		} catch (Exception e) {
			abrirErrorScreen(e.getMessage());
		}
    }
    
    @FXML
    void removerContratante(ActionEvent event) throws IOException{
    		Contratante c = new Contratante(cnpjContratante.getText());
    		try {
				Contratante.deleteContratante(c);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    }
    
    @FXML
    void removerContato(ActionEvent event) throws IOException{
    	ContatoEmpresa c = new ContatoEmpresa(empresaContatos.getText(), emailContatos.getText(),  nomeContatos.getText(), null);
    	try {
			ContatoEmpresa.deleteContatoEmpresa(c);
			abrirSuccessScreen("Remoção realizada com sucesso");
		} catch (Exception e) {
			abrirErrorScreen(e.getMessage());
		}
    }
    
    @FXML
    void removerCategoriaFornecimento(ActionEvent event) throws IOException{
    	CategoriaFornecimento c = new CategoriaFornecimento(nomeCatFornecimento.getText(), null);
    	try {
			CategoriaFornecimento.deleteCategoriaFornecimento(c);
			abrirSuccessScreen("Remoção realizada com sucesso");
		} catch (Exception e) {
			abrirErrorScreen(e.getMessage());
		}
    }
    
    @FXML
    void removerCategoriaFornecedora(ActionEvent event) throws IOException{
    	AtribuicaoCategoria a = new AtribuicaoCategoria(fornecedoraCatFornecedora.getText(), categoriaCatFornecedora.getText(), null);
    	try {
			AtribuicaoCategoria.deleteAtribuicaoCategoria(a);
			abrirSuccessScreen("Remoção realizada com sucesso");
		} catch (Exception e) {
			abrirErrorScreen(e.getMessage());
		}
    }
    
    @FXML
    void removerFesta(ActionEvent event) throws IOException{
    	Festa f = new Festa(0,contratanteFesta.getText(), dataFesta.getText(), nomeFesta.getText(), null, null, null);
    	try {
			Festa.deleteFesta(f);
			abrirSuccessScreen("Remoção realizada com sucesso");
		} catch (Exception e) {
			abrirErrorScreen(e.getMessage());
		}
    }
    
    @FXML
    void removerFestFood(ActionEvent event) throws IOException{
    	if(!festaFestFood.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Festa - inteiro.");
	    } else{
	    	FestFood f = new FestFood(Integer.parseInt(festaFestFood.getText()), 0);
	    	try {
				FestFood.deleteFestFood(f);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
	    }
    }
    
    @FXML
    void removerIngresso(ActionEvent event) throws IOException{
    	if(!festfoodIngresso.getText().matches("^[0-9]*$") || !codigoIngresso.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Fest Food e Código  - inteiro.");
	    } else{
	    	Ingresso i = new Ingresso(Integer.parseInt(festfoodIngresso.getText()), Integer.parseInt(codigoIngresso.getText()), compradorIngresso.getText());
	    	try {
				Ingresso.deleteIngresso(i);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
	    }
    }
    
    @FXML
    void removerCoquetel(ActionEvent event) throws IOException{
    	if(!festaCoquetel.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Festa - inteiro.");
	    } else{	
	    	Coquetel c = new Coquetel(Integer.parseInt(festaCoquetel.getText()), 0 , localCoquetel.getText(), cidadeCoquetel.getText());
	    	try {
				Coquetel.deleteCoquetel(c);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
	    }
    }
    
    @FXML
    void removerConvidado(ActionEvent event) throws IOException{
    	Convidado c = new Convidado(emailConvidado.getText(),nomeConvidado.getText(), null);
    	try {
			Convidado.deleteConvidado(c);
			abrirSuccessScreen("Remoção realizada com sucesso");
		} catch (Exception e) {
			abrirErrorScreen(e.getMessage());
		}
    }
    
    @FXML
    void removerConvite(ActionEvent event) throws IOException{
    	if(!coquetelConvite.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Coquetel - inteiro.");
	    } else{	
	    	Convite c = new Convite(convidadoConvite.getText(),Integer.parseInt(coquetelConvite.getText()));
	    	try {
				Convite.deleteConvite(c);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
	    }
    }
    
    @FXML
    void removerBrinde(ActionEvent event) throws IOException{
    	if(!coquetelBrinde.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Coquetel - inteiro.");
	    } else{	
    		Brinde b = new Brinde(Integer.parseInt(coquetelBrinde.getText()), nomeBrinde.getText(), null);
	    	try {
				Brinde.deleteBrinde(b);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
	    }
    }
    
    @FXML
    void removerFornecimentoCoquetel(ActionEvent event) throws IOException{
    	if(!coquetelFornecimento.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Coquetel - inteiro.");
	    } else{
	    	FornecimentoCoquetel f = new FornecimentoCoquetel(fornecedoraFornecimento.getText(), Integer.parseInt(coquetelFornecimento.getText()), 0);
	    	try {
				FornecimentoCoquetel.deleteFornecimentoCoquetel(f);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
	    }
    }
    
    @FXML
    void removerProduto(ActionEvent event) throws IOException{
    	if(!coquetelProdutos.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Coquetel - inteiro.");
	    } else{
	    	ProdutosFornecidos p = new ProdutosFornecidos(fornecedoraProdutos.getText(), Integer.parseInt(coquetelProdutos.getText()), nomeProdutos.getText(), 0);
	    	try {
				ProdutosFornecidos.deleteProdutosFornecidos(p);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
	    }
    }
    
    @FXML
    void removerLocal(ActionEvent event) throws IOException{
    	Local l = new Local(nomeLocal.getText(), cidadeLocal.getText(), estadoLocal.getText(),null, 0, 0, null, 0);
    	try {
			Local.deleteLocal(l);
			abrirSuccessScreen("Remoção realizada com sucesso");
		} catch (Exception e) {
			abrirErrorScreen(e.getMessage());
		}
    }
    
    @FXML
    void removerLocacao(ActionEvent event) throws IOException{
    	if(!festfoodLocacao.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Fest Food - inteiro.");
	    } else{
	    	Locacao l = new Locacao(0,Integer.parseInt(festfoodLocacao.getText()), localLocacao.getText(), cidadeLocacao.getText());
	    	try {
				Locacao.deleteLocacao(l);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
	    }
    }
    
    @FXML
    void removerLote(ActionEvent event) throws IOException{
    	if(!locacaoLote.getText().matches("^[0-9]*$") || !numeroLote.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("Os seguintes campos aceitam somente valores numéricos: Locação e Número - inteiro.");
	    } else{
    		Lote l = new Lote(Integer.parseInt(locacaoLote.getText()),Integer.parseInt(numeroLote.getText()),fornecedoraLote.getText(), 0, 0, 0);
	    	try {
				Lote.deleteLote(l);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void removerFuncionario(ActionEvent event) throws IOException{
    	Funcionario f = new Funcionario(cpfFuncionario.getText(), null, estadoFuncionario.getText(), nomeFuncionario.getText(), cidadeFuncionario.getText(), null, 0, null, null, null, 0, null);
    	try {
			Funcionario.deleteFuncionario(f);
			abrirSuccessScreen("Remoção realizada com sucesso");
		} catch (Exception e) {
			abrirErrorScreen(e.getMessage());
		}
    }
    
    @FXML
    void removerContratoCoquetel(ActionEvent event) throws IOException{
    	if(!coquetelContCoquetel.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Coquetel - inteiro.");
	    } else{
	    	ContratoCoquetel cc = new ContratoCoquetel(Integer.parseInt(coquetelContCoquetel.getText()), funcionarioContCoquetel.getText(), 0, 0);
	    	try {
				ContratoCoquetel.deleteContratoCoquetel(cc);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
	    }
    }
    
    @FXML
    void removerContratoFestFood(ActionEvent event) throws IOException{
	    if(!festfoodContFestFood.getText().matches("^[0-9]*$")){
	    	abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Fest Food - inteiro.");
	    } else{
    		ContratoFestFood cf = new ContratoFestFood(Integer.parseInt(festfoodContFestFood.getText()), segurancaContFestFood.getText(), 0,0);
	    	try {
				ContratoFestFood.deleteContratoFestFood(cf);
				abrirSuccessScreen("Remoção realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
}

