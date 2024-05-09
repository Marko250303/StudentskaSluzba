/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.finals;

import domain.FinalsPeriod;
import domain.GenericEntity;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author Mare
 */
public class GetAllFinalsPeriodsSO extends AbstractSO{
    private ArrayList<FinalsPeriod> periods;

    @Override
    public void validate(GenericEntity entity) throws Exception {
    }

    @Override
    public void executeSO(GenericEntity entity) throws Exception {
        ArrayList<GenericEntity> list=(ArrayList<GenericEntity>) broker.getAll(entity);
        
        periods=(ArrayList<FinalsPeriod>)(ArrayList<?>)list;
    }

    public ArrayList<FinalsPeriod> getPeriods() {
        return periods;
    }
    
    
}
