/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import domain.Finals;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import logic.ClientController;
import view.finals.FrmViewFinals;

/**
 *
 * @author Mare
 */
public class FinalsTableModel extends AbstractTableModel implements Runnable {

    private FrmViewFinals frmViewFinals;
    private ArrayList<Finals> list;
    private String[] columns = {"ID", "IME", "PREZIME", "DATUM PRIJAVE", "PRIJAVLJENO", "ROK"};
    private String search = "";

    public FinalsTableModel(FrmViewFinals frmViewFinals) {
        try {
            this.frmViewFinals = frmViewFinals;
            list = ClientController.getInstance().getAllFinals(null);
        } catch (Exception ex) {
            Logger.getLogger(FinalsTableModel.class.getName()).log(Level.SEVERE, null, ex);
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
        Finals f = list.get(rowIndex);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (columnIndex) {
            case 0 -> {
                return f.getFinalsID();
            }
            case 1 -> {
                return f.getStudent().getFirstName();

            }
            case 2 -> {
                return f.getStudent().getLastName();
            }
            case 3 -> {
                return sdf.format(f.getApplicationDate());
            }
            case 4 -> {
                return f.getTotalApplied();
            }
            case 5 -> {
                return f.getFinalsPeriod().getFinalsPeriodName();
            }
            default ->
                throw new AssertionError();
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(FinalsTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setSearch(String search) {
        this.search = search;
        refreshTable();
    }

    public void refreshTable() {
        try {
            list = ClientController.getInstance().getAllFinals(null);
            if (!search.equals("")) {
                ArrayList<Finals> novaLista = new ArrayList<>();
                for (Finals f : list) {
                    if (f.getStudent().getFirstName().toLowerCase().contains(search.toLowerCase())
                            || f.getStudent().getLastName().toLowerCase().contains(search.toLowerCase())) {
                        novaLista.add(f);
                    }
                }
                list = novaLista;
            }

            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(frmViewFinals, "Sistem ne moze da nadje prijave ispita po zadatoj vrednosti", "NEUSPESNA PRETRAGA", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                //JOptionPane.showMessageDialog(frmViewFinals, "Sistem je nasao prijave ispita po zadatoj vrednosti", "USPESNA PRETRAGA", JOptionPane.INFORMATION_MESSAGE);
                fireTableDataChanged();
            }

            

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Finals> getList() {
        return list;
    }

    public Finals getFinals(int selectedFinals) {
        return list.get(selectedFinals);
    }
}
