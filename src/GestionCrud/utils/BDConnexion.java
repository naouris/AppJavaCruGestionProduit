/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionCrud.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class BDConnexion {
     private String url="jdbc:mysql://localhost:3306/stockage_produit";
    private String login="root";
    private String pwd="";
    private static Connection connection;
    private static BDConnexion instance;

    private BDConnexion() {
        try {
            connection=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            Logger.getLogger(BDConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static BDConnexion getInstance(){
        if(instance==null)
            instance=new BDConnexion(); 
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
