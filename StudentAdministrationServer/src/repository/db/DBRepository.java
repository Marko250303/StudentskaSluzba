/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.db;

import repository.Repository;

/**
 *
 * @author Mare
 */
public interface DBRepository<T> extends Repository<T>{
    default public void startConnection() throws Exception{
        DBConnection.getInstance().getConnection();
    }
    
    default public void stopConnection() throws Exception{
        DBConnection.getInstance().getConnection().close();
    }
    
    default public void commit() throws Exception{
        DBConnection.getInstance().getConnection().commit();
    }
    
    default public void rollback() throws Exception{
        DBConnection.getInstance().getConnection().rollback();
    }
}
