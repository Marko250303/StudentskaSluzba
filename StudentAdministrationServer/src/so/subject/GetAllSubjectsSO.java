/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.subject;

import domain.GenericEntity;
import domain.Subject;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class GetAllSubjectsSO extends AbstractSO{
    private ArrayList<Subject> subjects;

    @Override
    public void validate(GenericEntity entity) throws Exception {
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        ArrayList<GenericEntity> list=(ArrayList<GenericEntity>) broker.getAll(entity);
        
        subjects=(ArrayList<Subject>)(ArrayList<?>)list;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }
}
