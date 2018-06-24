package UserInterface;

import backend.ConnectionManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Classe de controle da Interface de Login.
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class LoginController implements Initializable { 
   
    @FXML
    private JFXTextField usuario;

    @FXML
    private JFXButton entrar;

    @FXML
    private JFXPasswordField senha;
    
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
    
    /**
     * Metodo que verifica se o usuario e a senha digitados sao validos.
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    void validarLogin(ActionEvent event) throws IOException {
    	boolean exc = true;
        
        try {
    		ConnectionManager.connect(usuario.getText(), senha.getText());
    	} catch (Exception e){
    		exc = false;
    		abrirErroLogin();
    	}
        
        if(exc)
        	abrirTela();
    }
    
    /**
     * Metodo que sinaliza que o usuario e a senha sao invalidos.
     * 
     * @throws IOException 
     */
    private void abrirErroLogin() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginController.class.getResource("erroLogin.fxml"));
        AnchorPane root = loader.load();

        Stage erroLoginStage = new Stage();
        erroLoginStage.setResizable(false);
        erroLoginStage.setTitle("Erro Login");
        erroLoginStage.initModality(Modality.WINDOW_MODAL);
        erroLoginStage.initOwner(Main.getMyStage());
        Scene scene = new Scene(root);
        erroLoginStage.setScene(scene);
        ErroLoginController controller = loader.getController();
        controller.setAdicionarStage(erroLoginStage);
        
        erroLoginStage.showAndWait();
    }
    
    /**
     * Metodo que chama a interface principal da aplicacao.
     * 
     * @param area - area do funcionario logado
     * @throws IOException 
     */
    private void abrirTela() throws IOException {
    	AnchorPane pane = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        
        Scene scene = new Scene(pane);
        
        myStage = Main.getMyStage();      
                
        myStage.setScene(scene);
        myStage.show();
        myStage.setResizable(false);
    }
}
