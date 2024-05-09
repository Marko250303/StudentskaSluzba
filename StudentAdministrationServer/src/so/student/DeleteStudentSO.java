/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.student;

import domain.GenericEntity;
import domain.Student;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class DeleteStudentSO extends AbstractSO{

    @Override
    public void validate(GenericEntity entity) throws Exception {
        if(entity==null || !(entity instanceof Student)){
            throw new Exception("Nije poslat student");
        }
        
        Student student=(Student) entity;
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        broker.delete(entity);
    }
}
