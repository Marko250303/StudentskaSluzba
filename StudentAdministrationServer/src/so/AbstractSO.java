/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import domain.GenericEntity;
import repository.Repository;
import repository.db.DBRepository;
import repository.db.implementation.DBBroker;

/**
 *
 * @author Mare
 */
public abstract class AbstractSO {
    protected final Repository broker;

    public AbstractSO() {
        broker = new DBBroker();
    }
    
    public void execute(GenericEntity entity) throws Exception{
        try {
            validate(entity);
            startTransaction();
            executeSO(entity);
            commit();
        } catch(Exception ex){
            rollback();
            
            throw ex;
        } finally {
            stopConnection();
        }
    }

    public abstract void validate(GenericEntity entity) throws Exception;

    private void startTransaction() throws Exception {
        ((DBRepository) broker).startConnection();
    }

    public abstract void executeSO(GenericEntity entity) throws Exception;

    private void commit() throws Exception {
        ((DBRepository) broker).commit();
    }

    private void rollback() throws Exception {
        ((DBRepository) broker).rollback();
    }

    private void stopConnection() throws Exception {
        ((DBRepository) broker).stopConnection();
    } 
}
