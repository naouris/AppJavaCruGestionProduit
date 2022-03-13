/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;


import GestionBDPro.utils.BDConnection;
import GestionCrud.utils.BDConnexion;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ACER
 */
public class PageLoginController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button validButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private PasswordField passwordTextField;

 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelButtonAction(ActionEvent event) {
        Stage stage =(Stage)cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void LoginButtonAction(ActionEvent event) {
       
       if (usernameTextField.getText().isEmpty() == false && passwordTextField.getText().isEmpty()== false ){
           //  loginMessageLabel.setText("You try to login!!!");
           ValidateLogin();
       }else{
             loginMessageLabel.setText("Please enter username and password");
        }
    }

    private void ValidateLogin(){
        BDConnexion connectNow= BDConnexion.getInstance();
        Connection connectDB= connectNow.getConnection();
        
        String verifyLogin= "SELECT count(1) FROM useraccounts WHERE userName ='" + usernameTextField.getText() + "' AND password = '" + passwordTextField.getText() +"'";
        
        try {
            
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
         
         while(queryResult.next()){
         if (queryResult.getInt(1)== 1){   
            //  loginMessageLabel.setText("Welcome!");
             Stage stage =new Stage();
             Parent r=FXMLLoader.load(getClass().getResource("/Graphique/PageWelcome.fxml"));
             Scene sc=new Scene(r);
             stage.setScene(sc);
             stage.show();
          
        
          
         } else {
               loginMessageLabel.setText("Invalid login. Please try again");
         }
         }
        
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
