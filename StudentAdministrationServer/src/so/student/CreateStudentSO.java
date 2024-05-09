/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.student;

import domain.GenericEntity;
import domain.Student;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class CreateStudentSO extends AbstractSO{
    @Override
    public void validate(GenericEntity entity) throws Exception {
        if(entity==null || !(entity instanceof Student)){
            throw new Exception("Nije poslat student");
        }
        
        Student student=(Student) entity;
        
        if(student.getFirstName().isEmpty() || student.getFirstName()==null){
            throw new Exception("Ime ne sme da bude prazno polje");
        }
        
        if(student.getFirstName().length()<3 || student.getFirstName().length()>15){
            throw new Exception("Ime mora imati duzinu izmedju 3 i 15 znakova");
        }
        
        List<Student> students=broker.getAll(new Student());
        
        for (Student s : students) {
            if(s.equals(student)){
                throw new Exception("Student vec postoji u bazi");
            }
        }
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        broker.create((Student)entity);
    }
}
