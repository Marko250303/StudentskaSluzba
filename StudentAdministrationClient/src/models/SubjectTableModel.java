/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import domain.Subject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import logic.ClientController;
import view.subject.FrmViewSubjects;

/**
 *
 * @author Mare
 */
public class SubjectTableModel extends AbstractTableModel implements Runnable {

    private FrmViewSubjects viewSubjects;
    private ArrayList<Subject> list;
    private String[] columns = {"ID", "NAZIV", "ESPB", "SEMESTAR"};
    private String search = "";

    public SubjectTableModel(FrmViewSubjects viewSubjects) {
        try {
            this.viewSubjects = viewSubjects;
            list = ClientController.getInstance().getAllSubjects();
        } catch (Exception e) {
            Logger.getLogger(SubjectTableModel.class.getName()).log(Level.SEVERE, null, e);
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        Subject subject=list.get(rowIndex);
        
        switch (columnIndex) {
            case 0 ->{
               return subject.getSubjectID();
            }
            
            case 1 ->{
               return subject.getSubjectName();
            }
            
            case 2 ->{
               return subject.getEsbp();
            }
            
            case 3 ->{
               return subject.getSemester();
            }
            default -> {
                return "N/A";
            }       
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    public Subject getSubject(int row){
        return list.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(SubjectTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshTable() {
        try {
            list = ClientController.getInstance().getAllSubjects();
            
            if (!search.equals("")) {
                ArrayList<Subject> helpList = new ArrayList<>();
                
                for (Subject s : list) {
                    if (s.getSubjectName().toLowerCase().contains(search.toLowerCase())) {
                        helpList.add(s);
                    }
                }
                
                list = helpList;
            }

            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(viewSubjects, "Sistem ne moze da nadje predmete po zadatoj vrednosti", "GRESKA PRI PRETRAZIVANJU", JOptionPane.ERROR_MESSAGE);
                return;
            } 

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setParametar(String search) {
        this.search = search;
        refreshTable();
    }
}
