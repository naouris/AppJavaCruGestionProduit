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
public class MainG extends Application {

    @Override
 
  
       public void start(Stage stage) throws IOException{
    
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
