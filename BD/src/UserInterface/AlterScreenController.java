package UserInterface;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Modality;
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
    private JFXComboBox<String> cidadeLocal;
    @FXML
    private JFXTextField ruaLocal;
    @FXML
    private JFXTextField numeroLocal;
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
    private JFXComboBox<String> locacaoLote;
    @FXML
    private JFXTextField numeroLote;
    @FXML
    private JFXComboBox<String> fornecedoraLote;
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
        
        ObservableList<String> categoria = CategoriaFornecimento.getListaCategoria();
        
        ObservableList<String> festfood = FestFood.getListaFestFood();
        
        ObservableList<String> coquetel = Coquetel.getListaCoquetel();
        
        ObservableList<String> fornecedora = Fornecedora.getListaFornecedora();
        
        cnpjEmpresa.setItems(Empresa.getListaEmpresa());
        
        emailContatos.setItems(ContatoEmpresa.getListaEmail());
        
        nomeCatFornecimento.setItems(categoria);
        
        fornecedoraCatFornecedora.setItems(fornecedora);
        
        categoriaCatFornecedora.setItems(categoria);
        
        idFesta.setItems(Festa.getListaFesta());
        
        festaFestFood.setItems(festfood);
        
        festaCoquetel.setItems(coquetel);
 
        localCoquetel.setItems(Local.getListaLocal());
        
        emailConvidado.setItems(Convidado.getListaConvidado());
        
        coquetelBrinde.setItems(coquetel);
        
        fornecedoraFornecimento.setItems(fornecedora);
        
        coquetelFornecimento.setItems(coquetel);
        
        fornecedoraProdutos.setItems(fornecedora);
        
        coquetelProdutos.setItems(coquetel);
        
        nomeLocal.setItems(Local.getListaNome());
        
        cidadeLocal.setItems(Local.getListaCidade());
        
        idLocacao.setItems(Locacao.getListaId());
        
        localLocacao.setItems(Local.getListaLocal());
        
        fornecedoraLote.setItems(fornecedora);
        
        locacaoLote.setItems(Locacao.getListaLocacao());
        
        cpfFuncionario.setItems(Funcionario.getListaCpf());
        
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
    void alterarEmpresa(ActionEvent event) throws IOException{
    	if(cnpjEmpresa.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else {
    		Empresa e = new Empresa(cnpjEmpresa.getValue().split("[ /]")[0], nomeEmpresa.getText(), null, enderecoEmpresa.getText(), null);
    		try {
				Empresa.updateEmpresa(e);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e1) {
				abrirErrorScreen(e1.getMessage());
			}
    	}
    }
    
    
    @FXML
    void alterarContato(ActionEvent event) throws IOException{
    	if(emailContatos.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else {
	    	ContatoEmpresa c = new ContatoEmpresa(null, emailContatos.getValue().split("[ /]")[0], null, telefoneContatos.getText());
	    	try {
				ContatoEmpresa.updateContatoEmpresa(c);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarCategoriaFornecimento(ActionEvent event) throws IOException{
    	if(nomeCatFornecimento.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else {
	    	CategoriaFornecimento c = new CategoriaFornecimento(nomeCatFornecimento.getValue(), descricaoCatFornecimento.getText());
	    	try {
				CategoriaFornecimento.updateCategoriaFornecimento(c);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarCategoriaFornecedora(ActionEvent event) throws IOException{
    	if(fornecedoraCatFornecedora.getValue() == null || categoriaCatFornecedora.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else {
	    	AtribuicaoCategoria a = new AtribuicaoCategoria(fornecedoraCatFornecedora.getValue().split("[ /]")[0], categoriaCatFornecedora.getValue(), precoCatFornecedora.getText());
	    	try {
	    		AtribuicaoCategoria.updateAtribuicaoCategoria(a);
	    		abrirSuccessScreen("Atualização realizada com sucesso");
	    	}catch(Exception e) {
	    		abrirErrorScreen(e.getMessage());
	    	}
    	}
    }
    
    @FXML
    void alterarFesta(ActionEvent event) throws IOException{
    	if(idFesta.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else if(!dataFesta.getText().matches("[0-9][0-9]/[0-9][0-9]/[0-9][0-9][0-9][0-9]") || !horarioFesta.getText().matches("[0-9][0-9]:[0-9][0-9]") || !duracaoFesta.getText().matches("[0-9][0-9]:[0-9][0-9]")) {
    		abrirErrorScreen("Formato necessário: Data - XX/XX/XXXX; Horário de Início e Duração - XX:XX");
    	} else {
    		Festa f = new Festa(Integer.parseInt(idFesta.getValue().toString()), null, dataFesta.getText(), nomeFesta.getText(), horarioFesta.getText(), duracaoFesta.getText(), null);
    		try {
				Festa.updateFesta(f);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    	
    }
    
    @FXML
    void alterarFestFood(ActionEvent event) throws IOException{
    	if(festaFestFood.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else if(!precoFestFood.getText().matches("^[0-9]+[.]?[0-9]*$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Preço - decimal.");
    	} else{
    		FestFood f = new FestFood(Integer.parseInt(festaFestFood.getValue().split(" / ")[0]), Float.parseFloat(precoFestFood.getText()));
    		try {
				FestFood.updateFestFood(f);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarCoquetel(ActionEvent event) throws IOException{
    	if(festaCoquetel.getValue() == null || localCoquetel.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else {
    		Coquetel c = new Coquetel(Integer.parseInt(festaCoquetel.getValue().split(" / ")[0]), 0, localCoquetel.getValue().split(" / ")[0], localCoquetel.getValue().split(" / ")[1]);
       		try {
				Coquetel.updateCoquetel(c);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarConvidado(ActionEvent event) throws IOException{
    	if(emailConvidado.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else {
    		Convidado c = new Convidado(emailConvidado.getValue().split("[ /]")[0], null, telefoneConvidado.getText());
    		try {
				Convidado.updateConvidado(c);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarBrinde(ActionEvent event) throws IOException{
    	if(coquetelBrinde.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else {
	    	Brinde b = new Brinde(Integer.parseInt(coquetelBrinde.getValue().split("[ /]")[0]), nomeBrinde.getText(), descricaoBrinde.getText());
	    	try {
				Brinde.updateBrinde(b);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarFornecimentoCoquetel(ActionEvent event) throws IOException{
    	if(fornecedoraFornecimento.getValue() == null || coquetelFornecimento.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else if(!precoFornecimento.getText().matches("^[0-9]+[.]?[0-9]*$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Preço - decimal.");
    	} else {
    		FornecimentoCoquetel f = new FornecimentoCoquetel(fornecedoraFornecimento.getValue().split(" / ")[0], Integer.parseInt(coquetelFornecimento.getValue().split(" / ")[0]), Float.parseFloat(precoFornecimento.getText()));
    		try {
				FornecimentoCoquetel.updateFornecimentoCoquetel(f);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarProduto(ActionEvent event) throws IOException{
    	if(fornecedoraProdutos.getValue() == null || coquetelProdutos.getValue() == null || nomeProdutos.getText() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else if(!quantidadeProdutos.getText().matches("^[0-9]+$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Quantidade - inteiro.");
    	}  else{
    		ProdutosFornecidos p = new ProdutosFornecidos(fornecedoraProdutos.getValue().split(" / ")[0], Integer.parseInt(coquetelProdutos.getValue().split(" / ")[0]), nomeProdutos.getText(), Integer.parseInt(quantidadeProdutos.getText()));
    		try {
				ProdutosFornecidos.updateProdutosFornecidos(p);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarLocal(ActionEvent event) throws IOException{
    	if(nomeLocal.getValue() == null || cidadeLocal.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else if(!numeroLocal.getText().matches("^[0-9]+$") || !capacidadeLocal.getText().matches("^[0-9]+$") || !diariaLocal.getText().matches("^[0-9]+[.]?[0-9]*$")){
     		abrirErrorScreen("Os seguintes campos aceitam somente valores numéricos: Número e Capacidade - inteiro; Valor da Diária - decimal.");
     	} else {
    		String aux = aberturaLocal.isSelected()?"S":"N";
    		Local l = new Local(nomeLocal.getValue(), cidadeLocal.getValue(), null, ruaLocal.getText(), Integer.parseInt(numeroLocal.getText()), Integer.parseInt(capacidadeLocal.getText()), aux, Integer.parseInt(diariaLocal.getText()));
    		try {
				Local.updateLocal(l);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarLocacao(ActionEvent event) throws IOException{
    	if(idLocacao.getValue() == null || localLocacao.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else {
    		Locacao l = new Locacao(Integer.parseInt(idLocacao.getValue().toString()), 0, localLocacao.getValue().split(" / ")[0], localLocacao.getValue().split(" / ")[1]);
    		try {
    			Locacao.updateLocacao(l);
    			abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarLote(ActionEvent event) throws IOException{
    	if(locacaoLote.getValue() == null || numeroLote.getText() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else if(!numeroLote.getText().matches("^[0-9]+$") || !precoLote.getText().matches("^[0-9]+[.]?[0-9]*$") || !larguraLote.getText().matches("^[0-9]+[.]?[0-9]*$") || !comprimentoLote.getText().matches("^[0-9]+[.]?[0-9]*$")){
    		abrirErrorScreen("Os seguintes campos aceitam somente valores numéricos: Número - inteiro; Preço, Largura e Comprimento - decimal.");
    	} else {
    		String aux = fornecedoraLote.getValue();
    		aux = aux == null?" ":aux.split(" / ")[0];
    		Lote l = new Lote(Integer.parseInt(locacaoLote.getValue().split(" / ")[0]), Integer.parseInt(numeroLote.getText()), aux, Float.parseFloat(precoLote.getText()), Float.parseFloat(larguraLote.getText()), Float.parseFloat(comprimentoLote.getText()));
    		try {
				Lote.updateLote(l);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarFuncionario(ActionEvent event) throws IOException{
    	if(cpfFuncionario.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else if(!numeroFuncionario.getText().matches("^[0-9]+$") || !valorFuncionario.getText().matches("^[0-9]+[.]?[0-9]*$")){
     		abrirErrorScreen("Os seguintes campos aceitam somente valores numéricos: Número - inteiro; Valor/Hora - decimal.");
     	} else {
    		Funcionario f = new Funcionario(cpfFuncionario.getValue(), null, estadoFuncionario.getText(), null, cidadeFuncionario.getText(), ruaFuncionario.getText(), Integer.parseInt(numeroFuncionario.getText()), emailFuncionario.getText(), telefoneFuncionario.getText(), celularFuncionario.getText(), Float.parseFloat(valorFuncionario.getText()), null);
    		try {
				Funcionario.updateFuncionario(f);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarContratoCoquetel(ActionEvent event) throws IOException{
    	if(coquetelContCoquetel.getValue() == null || funcionarioContCoquetel.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");
    	} else if(!horastrabContCoquetel.getText().matches("^[0-9]+$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Horas Trabalhadas - inteiro.");
    	}  else {
	    	ContratoCoquetel cc = new ContratoCoquetel(Integer.parseInt(coquetelContCoquetel.getValue().split(" / ")[0]), funcionarioContCoquetel.getValue().split(" / ")[1], Integer.parseInt(horastrabContCoquetel.getText()),0);
	    	try {
				ContratoCoquetel.updateContratoCoquetel(cc);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
    
    @FXML
    void alterarContratoFestFood(ActionEvent event) throws IOException{
    	if(festfoodContFestFood.getValue() == null || segurancaContFestFood.getValue() == null) {
    		abrirErrorScreen("Necessário preencher as caixas de seleção.");	
    	} else if(!horastrabContFestFood.getText().matches("^[0-9]+$")){
    		abrirErrorScreen("O seguinte campo aceita somente valores numéricos: Horas Trabalhadas - inteiro.");
    	}  else {
	    	ContratoFestFood cf = new ContratoFestFood(Integer.parseInt(festfoodContFestFood.getValue().split(" / ")[0]), segurancaContFestFood.getValue().split(" / ")[1], Integer.parseInt(horastrabContFestFood.getText()),0);
	    	try {
				ContratoFestFood.deleteContratoFestFood(cf);
				abrirSuccessScreen("Atualização realizada com sucesso");
			} catch (Exception e) {
				abrirErrorScreen(e.getMessage());
			}
    	}
    }
}
