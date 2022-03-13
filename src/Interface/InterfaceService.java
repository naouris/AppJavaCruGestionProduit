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
public interface InterfaceService <T>{
     public void add(T entity);
    public ArrayList<T> getAll();
    public ObservableList<T> getTout();
    public void update(T entity);
    public void delete (T entity);
    
    public T getById(int id) throws SQLException;
    
}
