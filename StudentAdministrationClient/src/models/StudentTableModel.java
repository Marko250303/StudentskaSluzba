/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import domain.Student;
import domain.Subject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import logic.ClientController;
import view.student.FrmViewStudents;

/**
 *
 * @author Mare
 */
public class StudentTableModel extends AbstractTableModel implements Runnable {

    private FrmViewStudents viewStudents;
    private ArrayList<Student> list;
    private String[] columns = {"ID", "IME", "PREZIME", "INDEKS", "GODINA", "STATUS"};
    private String search = "";

    public StudentTableModel(FrmViewStudents viewStudents) {
        try {
            this.viewStudents = viewStudents;
            list = ClientController.getInstance().getAllStudents();
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
        Student student = list.get(rowIndex);

        switch (columnIndex) {
            case 0 -> {
                return student.getStudentID();
            }

            case 1 -> {
                return student.getFirstName();
            }

            case 2 -> {
                return student.getLastName();
            }

            case 3 -> {
                int index = student.getIndex();

                int year = index / 10000;
                int rank = index % 10000;

                //return rank+ "/" +year;
                return student.getIndex();
            }
            case 4 -> {
                return student.getYear();
            }
            case 5 -> {
                //return student.getStudentType().getTypeName();

                return student.getStudentType();
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

    public Student getStudent(int row) {
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
            list = ClientController.getInstance().getAllStudents();

            if (!search.equals("")) {
                ArrayList<Student> helpList = new ArrayList<>();

                for (Student s : list) {
                    if (s.getFirstName().toLowerCase().contains(search.toLowerCase())) {
                        helpList.add(s);
                    }
                }

                list = helpList;
            }

            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(viewStudents, "Sistem ne moze da nadje studente po zadatoj vrednosti", "GRESKA PRI PRETRAZIVANJU", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(viewStudents, "Sistem je nasao studente po zadatoj vrenosti", "USPESNA PRETRAGA", JOptionPane.INFORMATION_MESSAGE);
                fireTableDataChanged();
            }

            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setParametar(String search) {
        this.search = search;
        refreshTable();
    }

    public void deleteStudent(Student s) {
        list.remove(s);

        fireTableDataChanged();
    }
}
