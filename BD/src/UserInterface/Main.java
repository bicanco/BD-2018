package UserInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principal do programa que inicializa a interface base.
 * 
 * @author David Rodrigues, Gabriel Toschi, Marcos Wendell
 */
public class Main extends Application {
    
    private static Stage myStage;
    
    /**
     * Metodo que prepara o cenario do fxml para carregara tela.
     * 
     * @return cenario
     */
    public static Stage getMyStage() {
        return myStage;
    }
    
    @Override
    /**
     * Metodo que carregar a tela inicial de login.
     */
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        myStage = stage;
        
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
    }

    /**
     * Metodo estatico main que inicializa os argumentos.
     * 
     * @param args os argumentos da linha de comando
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}