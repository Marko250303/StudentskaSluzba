/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.subject;

import domain.GenericEntity;
import domain.Subject;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class CreateSubjectSO extends AbstractSO{
    @Override
    public void validate(GenericEntity entity) throws Exception {
        if(entity==null || !(entity instanceof Subject)){
            throw new Exception("Nije poslat predmet");
        }
        
        Subject subject= (Subject) entity;
        
        if(subject.getSubjectName().isEmpty() || subject.getSubjectName()==null){
            throw new Exception("Naziv predmeta ne sme da bude prazan");
        }
        
        List<Subject> subjects=broker.getAll(new Subject());
        
        for (Subject s : subjects) {
            if(s.equals(subject)){
                throw new Exception("Predmet vec postoji u bazi");
            }
        }
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        broker.create((Subject)entity);
    }
}
