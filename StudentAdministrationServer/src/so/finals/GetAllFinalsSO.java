/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.finals;

import domain.Finals;
import domain.FinalsPeriod;
import domain.GenericEntity;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class GetAllFinalsSO extends AbstractSO{
    private ArrayList<Finals> finalsPeriods;

    @Override
    public void validate(GenericEntity entity) throws Exception {
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        ArrayList<GenericEntity> list=(ArrayList<GenericEntity>) broker.getAll(entity);
        
        finalsPeriods=(ArrayList<Finals>)(ArrayList<?>)list;
    }

    public ArrayList<Finals> getFinals() {
        return finalsPeriods;
    }
}
