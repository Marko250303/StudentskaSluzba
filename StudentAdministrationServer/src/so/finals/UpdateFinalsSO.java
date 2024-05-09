/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.finals;

import domain.Finals;
import domain.GenericEntity;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class UpdateFinalsSO extends AbstractSO{

    @Override
    public void validate(GenericEntity entity) throws Exception {
         if (entity == null || !(entity instanceof Finals)) {
            throw new Exception("Nije poslata prijava ispita");
        }

        Finals finals = (Finals) entity;
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        broker.update(entity);
    }
    
}
