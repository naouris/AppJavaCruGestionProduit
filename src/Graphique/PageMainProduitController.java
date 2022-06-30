/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphique;

import Entiter.Produit;
import Service.ServiceProduit;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class PageMainProduitController implements Initializable {

    @FXML
    private TableView<Produit> prod;
    @FXML
    private TableColumn<Produit, Integer> idcol;
    @FXML
    private TableColumn<Produit, String> Produitcol; // todo: i see generally that you use different name convension sometimes uppcase sometimes lower case , please to be consistent pick one convention, PascalCase or camelCase
    @FXML
    private TableColumn<Produit, String> Magazincol;
    @FXML
    private TableColumn<Produit, Integer> Prixcol;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnmodifier;
    @FXML
    private TextField idtt;
    @FXML
    private TextField produitt;
    @FXML
    private TextField magazint;
    @FXML
    private TextField prixt;

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showProduit();
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        Produit e = new Produit(
                parseInt(idtt.getText()),
                produitt.getText(), magazint.getText(),
                parseInt(prixt.getText()));

        ServiceProduit se = new ServiceProduit();

        se.add(e);
        idtt.setText("");
        produitt.setText("");
        magazint.setText("");
        prixt.setText("");
         showProduit();
                    System.out.println("supprission avec succee");


    }

    @FXML
    private void supprimer(ActionEvent event) {
          try {
            ServiceProduit se = new ServiceProduit();
            Produit e = se.getById(parseInt(idtt.getText()));
          
            se.delete(e);
            
            idtt.setText("");
           
        produitt.setText("");
        magazint.setText("");
        prixt.setText("");
            System.out.println("supprission avec succee");
        } catch (SQLException ex) {
            System.out.println("erreur de connexion" + ex);
        }
       showProduit();
       
    }

    @FXML
    private void modifier(ActionEvent event) {
        try {
            ServiceProduit se = new ServiceProduit();
            Produit e = se.getById(parseInt(idtt.getText()));
           
            
              
            
            e.setId(parseInt(idtt.getText()));          
            e.setProduit(produitt.getText());
            e.setMagazin(magazint.getText());
            e.setPrix(parseInt(prixt.getText()));
            
            se.update(e);
            
            showProduit();
            
             idtt.setText("");
        produitt.setText("");
        magazint.setText("");
        prixt.setText("");
            
                        System.out.println("modifier avec succee");

            System.out.println("modification avec succee");
        } catch (SQLException ex) {
            System.out.println("erreur de connexion" + ex);
        }
        showProduit();
    }
    
    
    private void showProduit() {
        ServiceProduit se = new ServiceProduit();
        for (Produit e : se.getTout()) {
            ObservableList<Produit> list = se.getTout();

            idcol.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("id"));
            Produitcol.setCellValueFactory(new PropertyValueFactory<Produit, String>("produit"));
            Magazincol.setCellValueFactory(new PropertyValueFactory<Produit, String>("Magazin"));
            Prixcol.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("Prix"));
            prod.refresh();

            prod.setItems(list);
            
        }

        //se.getAll();  
    }

  

    private void handleMouseAction(javafx.scene.input.MouseEvent event) {
         Produit p=prod.getSelectionModel().getSelectedItem();
  idtt.setText(""+p.getId());
  produitt.setText(p.getProduit());
  magazint.setText(""+p.getMagazin());
  prixt.setText(""+p.getPrix());
  
  
  
    }
    
}
