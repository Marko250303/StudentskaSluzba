/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.student;

import domain.GenericEntity;
import domain.StudentType;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class GetAllStudentTypesSO extends AbstractSO{
    private ArrayList<StudentType> studentTypes;

    @Override
    public void validate(GenericEntity entity) throws Exception {
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        ArrayList<GenericEntity> list=(ArrayList<GenericEntity>) broker.getAll(entity);
        
        studentTypes=(ArrayList<StudentType>)(ArrayList<?>)list;
    }

    public ArrayList<StudentType> getStudentTypes() {
        return studentTypes;
    }
}
