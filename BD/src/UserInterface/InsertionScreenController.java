package UserInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import backend.tables.*;

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
import javafx.stage.Modality;
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
    private JFXComboBox<String> precoCatFornecedora;
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
        
        
        ObservableList<String> festfood = FestFood.getListaFestFood();
        
        ObservableList<String> coquetel = Coquetel.getListaCoquetel();
        
        ObservableList<String> fornecedora = Fornecedora.getListaFornecedora();
        
        ObservableList<String> tipoempresa = 
        	    FXCollections.observableArrayList(
        	        "Fornecedora",
        	        "Contratante",
        	        "Ambas");
        tipoEmpresa.setItems(tipoempresa);
        
        empresaContatos.setItems(Empresa.getListaEmpresa());
        
        fornecedoraCatFornecedora.setItems(fornecedora);
        
        categoriaCatFornecedora.setItems(CategoriaFornecimento.getListaCategoria());
        
        ObservableList<String> faixa = FXCollections.observableArrayList("1","2","3","4","5");
       
        precoCatFornecedora.setItems(faixa);
        
        contratanteFesta.setItems(Contratante.getListaContratante());
        
        ObservableList<String> tipofesta = 
        	    FXCollections.observableArrayList(
        	        "FestFood",
        	        "Coquetel");
       
        tipoFesta.setItems(tipofesta);
        
        festaFestFood.setItems(festfood);
        
        festfoodIngresso.setItems(festfood);
        
        festaCoquetel.setItems(coquetel);
        
        localCoquetel.setItems(Local.getListaLocal());
        
        coquetelConvite.setItems(coquetel);
        
        convidadoConvite.setItems(Convidado.getListaConvidado());
        
        coquetelBrinde.setItems(coquetel);
        
        fornecedoraFornecimento.setItems(fornecedora);
        
        coquetelFornecimento.setItems(coquetel);
        
        fornecedoraProdutos.setItems(fornecedora);
        
        coquetelProdutos.setItems(coquetel);
        
        festfoodLocacao.setItems(festfood);
        
        localLocacao.setItems(Local.getListaLocal());
        
        fornecedoraLote.setItems(fornecedora);
        
        locacaoLote.setItems(Locacao.getListaLocacao());
        
        coquetelContCoquetel.setItems(coquetel);
        
        funcionarioContCoquetel.setItems(Funcionario.getListaFuncionario());
        
        festfoodContFestFood.setItems(festfood);
        
        segurancaContFestFood.setItems(Funcionario.getListaSeguranca());
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
    void inserirEmpresa(ActionEvent event) throws IOException{
    	Empresa e = new Empresa(cnpjEmpresa.getText(), nomeEmpresa.getText(), razaoEmpresa.getText(), enderecoEmpresa.getText(), tipoEmpresa.getValue());
    	try {
			Empresa.insertEmpresa(e);
			abrirSuccessScreen("Inserção realizada com sucesso");
		} catch (Exception e1) {
			abrirErrorScreen(e1.getMessage());
		}
    }
    
    @FXML
    void inserirContato(ActionEvent event) throws IOException{
    	if(empresaContatos.getValue() == null){
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else{
	    	ContatoEmpresa c = new ContatoEmpresa(empresaContatos.getValue().split("[ /]")[0], emailContatos.getText(), nomeContatos.getText(), telefoneContatos.getText());
	    	try {
				ContatoEmpresa.insertContatoEmpresa(c);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirCategoriaFornecimento(ActionEvent event) throws IOException{
    	CategoriaFornecimento c = new CategoriaFornecimento(nomeCatFornecimento.getText(), descricaoCatFornecimento.getText());
    	try {
			CategoriaFornecimento.insertCategoriaFornecimento(c);
		} catch (Exception e) {
			abrirErrorScreen(e.getMessage());
		}
    }
    
    @FXML
    void inserirCategoriaFornecedora(ActionEvent event) throws IOException{
    	if(fornecedoraCatFornecedora.getValue() == null || categoriaCatFornecedora.getValue() == null || precoCatFornecedora.getValue() == null){
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else{
	    	AtribuicaoCategoria a = new AtribuicaoCategoria(fornecedoraCatFornecedora.getValue().split("[ /]")[0], categoriaCatFornecedora.getValue(), precoCatFornecedora.getValue());
	    	try {
				AtribuicaoCategoria.insertAtribuicaoCategoria(a);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirFesta(ActionEvent event) throws IOException{
    	if(contratanteFesta.getValue() == null || tipoFesta.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else {
    		Festa f = new Festa(0,contratanteFesta.getValue().split(" / ")[0], dataFesta.getText(), nomeFesta.getText(), horarioFesta.getText(), duracaoFesta.getText(), tipoFesta.getValue());
    		try {
				Festa.insertFesta(f);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirFestFood(ActionEvent event) throws IOException{
    	if(festaFestFood.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else if(!precoFestFood.getText().matches("^[0-9]*[,|.]?[0-9]*$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Preço - decimal.");
    	} else {
    		FestFood f = new FestFood(Integer.parseInt(festaFestFood.getValue().split(" / ")[0]), Float.parseFloat(precoFestFood.getText()));
    		try {
				FestFood.insertFestFood(f);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirIngresso(ActionEvent event) throws IOException{
    	if(festfoodIngresso.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else if(!codigoIngresso.getText().matches("^[0-9]*$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Código - inteiro.");
    	} else {
    		Ingresso i = new Ingresso(Integer.parseInt(festfoodIngresso.getValue().split(" / ")[3]), Integer.parseInt(codigoIngresso.getText()), compradorIngresso.getText());
    		try {
				Ingresso.insertIngresso(i);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirCoquetel(ActionEvent event) throws IOException{
    	if(festaCoquetel.getValue() == null || localCoquetel.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else {
    		Coquetel c = new Coquetel(Integer.parseInt(festaCoquetel.getValue().split(" / ")[0]), 0, localCoquetel.getValue().split(" / ")[0], localCoquetel.getValue().split(" / ")[1]);
    		try {
				Coquetel.insertCoquetel(c);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirConvidado(ActionEvent event) throws IOException{
    	Convidado c = new Convidado(emailConvidado.getText(), nomeConvidado.getText(), telefoneConvidado.getText());
    	try {
			Convidado.insertConvidado(c);
		} catch (Exception e) {
			abrirErrorScreen(e.getMessage());
		}
    }
    
    @FXML
    void inserirConvite(ActionEvent event) throws IOException{
    	if(coquetelConvite.getValue() == null || convidadoConvite.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else {
    		Convite c = new Convite(convidadoConvite.getValue().split("[ /]")[0],Integer.parseInt(coquetelConvite.getValue().split("[ /]")[0]));
    		try {
				Convite.insertConvite(c);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirBrinde(ActionEvent event) throws IOException{
    	if(coquetelBrinde.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else {
	    	Brinde b = new Brinde(Integer.parseInt(coquetelBrinde.getValue().split("[ /]")[0]), nomeBrinde.getText(), descricaoBrinde.getText());
	    	try {
				Brinde.insertBrinde(b);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirFornecimentoCoquetel(ActionEvent event) throws IOException{
    	if(fornecedoraFornecimento.getValue() == null || coquetelFornecimento.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else if(!precoFornecimento.getText().matches("^[0-9]*[,|.]?[0-9]*$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Preço - decimal.");
    	} else {
    		FornecimentoCoquetel f = new FornecimentoCoquetel(fornecedoraFornecimento.getValue().split(" / ")[0], Integer.parseInt(coquetelFornecimento.getValue().split(" / ")[0]), Float.parseFloat(precoFornecimento.getText()));
    		try {
				FornecimentoCoquetel.insertFornecimentoCoquetel(f);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirProduto(ActionEvent event) throws IOException{
    	if(fornecedoraProdutos.getValue() == null || coquetelProdutos.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else if(!quantidadeProdutos.getText().matches("^[0-9]*$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Quantidade - inteiro.");
    	} else {
    		ProdutosFornecidos p = new ProdutosFornecidos(fornecedoraProdutos.getValue().split(" / ")[0], Integer.parseInt(coquetelProdutos.getValue().split(" / ")[0]), nomeProdutos.getText(), Integer.parseInt(quantidadeProdutos.getText()));
    		try {
				ProdutosFornecidos.insertProdutosFornecidos(p);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirLocal(ActionEvent event) throws IOException{
    	String aux = aberturaLocal.isSelected()?"S":"N";
    	if(!numeroLocal.getText().matches("^[0-9]*$") || !capacidadeLocal.getText().matches("^[0-9]*$") || !diariaLocal.getText().matches("^[0-9]*[,|.]?[0-9]*$")){
     		abrirErrorScreen("Os seguintes campos aceitam somente valores numéricos: Número e Capacidade - inteiro; Valor da Diária - decimal.");
     	} else{
	    	Local l = new Local(nomeLocal.getText(), cidadeLocal.getText(), estadoLocal.getText(), ruaLocal.getText(), Integer.parseInt(numeroLocal.getText()), Integer.parseInt(capacidadeLocal.getText()), aux, Float.parseFloat(diariaLocal.getText()));
	    	try {
				Local.insertLocal(l);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
     	}
    }
    
    @FXML
    void inserirLocacao(ActionEvent event) throws IOException{
    	if(festaFestFood.getValue() == null || localLocacao.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else {
    		Locacao l = new Locacao(0,Integer.parseInt(festfoodLocacao.getValue().split(" / ")[3]), localLocacao.getValue().split(" / ")[0], localLocacao.getValue().split(" / ")[1]);
    		try {
				Locacao.insertLocacao(l);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void inserirLote(ActionEvent event) throws IOException{
    	if(locacaoLote.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else if(!numeroLote.getText().matches("^[0-9]*$") || !precoLote.getText().matches("^[0-9]*[,|.]?[0-9]*$") || !larguraLote.getText().matches("^[0-9]*[,|.]?[0-9]*$") || !comprimentoLote.getText().matches("^[0-9]*[,|.]?[0-9]*$")){
    		abrirErrorScreen("Os seguintes campos aceitam somente valores numéricos: Número - inteiro; Preço, Largura e Comprimento - decimal.");
    	} else {
    		String aux = fornecedoraLote.getValue();
    		aux = aux == null?" ":aux.split(" / ")[0];
    		Lote l = new Lote(Integer.parseInt(locacaoLote.getValue().split(" / ")[0]), Integer.parseInt(numeroLote.getText()),aux, Float.parseFloat(precoLote.getText()), Float.parseFloat(larguraLote.getText()), Float.parseFloat(comprimentoLote.getText()));
    		try {
				Lote.insertLote(l);
			} catch (Exception e) {
				System.out.println(e);
			}
    	}
    }
    
    @FXML
    void inserirFuncionario(ActionEvent event) throws IOException{
    	if(!numeroFuncionario.getText().matches("^[0-9]*$") || !valorFuncionario.getText().matches("^[0-9]*[,|.]?[0-9]*$")){
     		abrirErrorScreen("Os seguintes campos aceitam somente valores numéricos: Número - inteiro; Valor/Hora - decimal.");
     	} else{
	    	Funcionario f = new Funcionario(cpfFuncionario.getText(), rgFuncionario.getText(), estadoFuncionario.getText(), nomeFuncionario.getText(), cidadeFuncionario.getText(), ruaFuncionario.getText(),Integer.parseInt(numeroFuncionario.getText()), emailFuncionario.getText(), telefoneFuncionario.getText(), celularFuncionario.getText(), Float.parseFloat(valorFuncionario.getText()), funcaoFuncionario.getText());
	    	try {
				Funcionario.insertFuncionario(f);
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
     	}
    }
    
    @FXML
    void inserirContratoCoquetel(ActionEvent event) throws IOException{
    	if(coquetelContCoquetel.getValue() == null || funcionarioContCoquetel.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else if(!horastrabContCoquetel.getText().matches("^[0-9]*$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Horas Trabalhadas - inteiro.");
    	} else {
    		ContratoCoquetel cc = new ContratoCoquetel(Integer.parseInt(coquetelContCoquetel.getValue().split("[/ ]")[0]), funcionarioContCoquetel.getValue().split(" / ")[1], Integer.parseInt(horastrabContCoquetel.getText()),0);
    		try {
    			ContratoCoquetel.insertContratoCoquetel(cc);
    		} catch (Exception e) {
    			abrirErrorScreen(e.getMessage());
    		}
    	}
    }
    
    @FXML
    void inserirContratoFestFood(ActionEvent event) throws IOException{
    	if(festfoodContFestFood.getValue() == null || segurancaContFestFood.getValue() == null) {
    		abrirErrorScreen("Necessário selecionar todas as caixas de seleção.");
    	} else if(!horastrabContFestFood.getText().matches("^[0-9]*$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Horas Trabalhadas - inteiro.");
    	} else {
    		ContratoFestFood cf = new ContratoFestFood(Integer.parseInt(festfoodContFestFood.getValue().split("[/ ]")[0]), segurancaContFestFood.getValue().split(" / ")[1], Integer.parseInt(horastrabContFestFood.getText()),0);
    		try {
    			ContratoFestFood.insertContratoFestFood(cf);
    		} catch (Exception e) {
    			abrirErrorScreen(e.getMessage());
    		}
    	}
    }
}
