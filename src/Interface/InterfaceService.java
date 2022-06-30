/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author ACER
 */
public interface InterfaceService <T>{ //todo: the name should be ServiceInterface 
     public void add(T entity);
    public ArrayList<T> getAll();
    public ObservableList<T> getTout();
    public void update(T entity); 
    public void delete (T entity); // it's always better to return a flag true or false to let the user know if all was correct or something got broken
    
    public T getById(int id) throws SQLException;
    
}
