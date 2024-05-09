/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import domain.Finals;
import domain.FinalsItem;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import logic.ClientController;

/**
 *
 * @author Mare
 */
public class FinalsItemTableModel extends AbstractTableModel{
    private ArrayList<FinalsItem> list;
    private String[] columns={"RB","PREDMET","TIP ISPITA","TRAJANJE"};
    private int rb=0;
    
    public FinalsItemTableModel(){
        list=new ArrayList<>();
    }
    
    public FinalsItemTableModel(Finals f){
        try {
            list=ClientController.getInstance().getAllFinalsItems(f);
        } catch (Exception ex) {
            Logger.getLogger(FinalsItemTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FinalsItem fi=list.get(rowIndex);
        
        switch (columnIndex) {
            case 0 ->{
                return fi.getFinalsItemID();
            }
            case 1 ->{
                return fi.getSubject().getSubjectName();
            }
            case 2 ->{
                return fi.getType();
            }
            case 3 ->{
                return fi.getDuration();
            }
            default -> throw new AssertionError();
        }
    }

    public void addItem(FinalsItem fi) {
//        for (StavkaNarudzbine stavkaPorudzbine : lista) {
//            if(stavkaPorudzbine.getProizvod().getProizvodID().equals(sn.getProizvod().getProizvodID())){
//                stavkaPorudzbine.setKolicina(stavkaPorudzbine.getKolicina() + sn.getKolicina());
//                stavkaPorudzbine.setCenaStavke(stavkaPorudzbine.getCenaStavke().add(sn.getCenaStavke()));
//                fireTableDataChanged();
//                return;
//            }
//        }
        
        rb = list.size();
        fi.setFinalsItemID(1L+rb);
        list.add(fi);
        fireTableDataChanged();
    }
    
    public void deleteItem(int row) {
        list.remove(row);
        
        rb = 0;
        for (FinalsItem finalsItem : list) {
            finalsItem.setFinalsItemID(1l+rb);
        }
        
        fireTableDataChanged();
    }

    public FinalsItem getFinalsItem(int row) {
        return list.get(row);
    }

    public ArrayList<FinalsItem> getList() {
        return list;
    }

    public void clearTable() {
        list.clear();
        fireTableDataChanged();
    }

    public void setList(ArrayList<FinalsItem> list) {
        this.list = list;
    }
}
