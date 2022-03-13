/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entiter.Produit;
import GestionCrud.utils.BDConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ACER
 */
public class ServiceProduit {
     Connection cnx;
    public ServiceProduit(){
       BDConnexion c = BDConnexion.getInstance();
        cnx = c.getConnection();
        
      
    }
     

    
    public void add(Produit  V) {
        String req;
       req = "INSERT INTO `stockage_produit`.`produit` (`id`, `produit`, `Magazin`, `Prix`) values ('"+V.getId()+"','"+V.getProduit()+"','"+V.getMagazin()+"','"+V.getPrix()+"')";
                  
                try{
                    Statement stm = cnx.createStatement();
                    stm.executeUpdate(req);
                }catch(SQLException ex){
                    System.out.println("afficher"+ex);
                }
                   
           }

    
   public ArrayList<Produit> getAll() {
     ArrayList<Produit> produits  = new ArrayList<>();
     String req ="SELECT * FROM produit";
     try{
         
     Statement stm =cnx.createStatement();
     ResultSet rst = stm.executeQuery(req);
     
     while(rst.next()){
         Produit  V = new Produit();
         V.setId(rst.getInt(1));
         V.setProduit(rst.getString("produit"));
         V.setMagazin(rst.getString("Magazin"));
          V.setPrix(rst.getInt(4));
         produits.add(V);
         
     }
     
     }catch (SQLException ex){
         
         System.out.println(ex);
     }
       return produits;
    }
    
   
    
     public ObservableList<Produit> getTout() {
     ObservableList <Produit> produits = FXCollections.observableArrayList();
     String req ="SELECT * FROM produit";
     try{
         
     Statement stm =cnx.createStatement();
     ResultSet rst = stm.executeQuery(req);
     
     while(rst.next()){
         Produit v = new Produit();
         v.setId(rst.getInt(1));
         v.setProduit(rst.getString("produit"));
         v.setMagazin(rst.getString("Magazin"));
          
          v.setPrix(rst.getInt(4));
         produits.add(v);
         
     }
     
     }catch (SQLException ex){
         
         System.out.println(ex);
     }
       return produits;
    }

    public void update(Produit V) {
        String req = "UPDATE `produit` SET `produit`=?,`Magazin`=?,`Prix`=?  WHERE id=?";
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
           pst.setInt(4, V.getId());
           pst.setString(1, V.getProduit());
             pst.setString(2, V.getMagazin());
            pst.setInt(3, V.getPrix());
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(Produit V) {
        String req = "DELETE FROM produit where id = ?";
        
        try {
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setInt(1,   V.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    public Produit getById(int id) throws SQLException{
        Produit V = new Produit();
        String req = "SELECT * FROM produit WHERE id="+id;
        Statement stm = cnx.createStatement();
        ResultSet rst=stm.executeQuery(req);
        while (rst.next()){
            V.setId(rst.getInt("id"));
            V.setProduit(rst.getString("produit"));
            V.setMagazin(rst.getString("Magazin"));
            V.setPrix(rst.getInt("Prix"));
                   
        }
        
        return V;
    } 
}
