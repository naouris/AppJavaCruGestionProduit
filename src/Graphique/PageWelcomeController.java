/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class PageWelcomeController implements Initializable {

    @FXML
    private ImageView exit;
    @FXML
    private Label menu;
    @FXML
    private Label menuBack;
    @FXML
    private AnchorPane slider;
    @FXML
    private AnchorPane root;
    
    private Parent fxml;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        exit.setOnMouseClicked(event ->{
            System.exit(0);
        });
        
        slider.setTranslateX(-176);
        
        menu.setOnMouseClicked(event->{
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
           
            slide.setToX(0);
            slide.play();
            
            slider.setTranslateX(-176);
            
            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(false);
                menuBack.setVisible(true);

            });
        });
        
        
        
        
         menuBack.setOnMouseClicked(event->{
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);
           
            slide.setToX(-176);
            slide.play();
            
            slider.setTranslateX(0);
            
            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(true);
                menuBack.setVisible(false);

            });
        });
    }    

    @FXML
    private void MainProduit(MouseEvent event) {
        try {
            fxml=FXMLLoader.load(getClass().getResource("/Graphique/PageMainProduit.fxml"));
            root.getChildren().removeAll();
            root.getChildren().setAll(fxml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
}
