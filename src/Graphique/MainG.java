/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ACER
 */
public class MainG extends Application { // todo: what does mainG means , it could be a good idea to rename this

    @Override
 
  
       public void start(Stage stage) throws IOException{ // please handle the exception with logs and good info and print message
    
    Parent root = FXMLLoader.load(getClass().getResource("/Graphique/PageLogin.fxml"));
    
    stage.initStyle(StageStyle.UNDECORATED);// pour éliminer le bar en haut 
    Scene scene = new Scene(root);
    
    stage.setScene (scene);

    stage.show ();
} 
       
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
