/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.student;

import domain.GenericEntity;
import domain.Student;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class GetAllStudentsSO extends AbstractSO{
    private ArrayList<Student> students;

    @Override
    public void validate(GenericEntity entity) throws Exception {
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        ArrayList<GenericEntity> list=(ArrayList<GenericEntity>) broker.getAll(entity);
        
        students=(ArrayList<Student>)(ArrayList<?>) list;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
