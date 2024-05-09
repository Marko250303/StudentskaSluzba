/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.finals;

import domain.Finals;
import domain.FinalsItem;
import domain.FinalsPeriod;
import domain.FinalsType;
import domain.Student;
import domain.Subject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.ClientController;
import models.FinalsItemTableModel;
import view.FormMode;

/**
 *
 * @author Mare
 */
public class FrmFinals extends javax.swing.JDialog {

    private FormMode mode = FormMode.KREIRAJ;

    private Finals f;

    /**
     * Creates new form FrmFinals
     */
    public FrmFinals(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        populateForm(mode, f);
    }

    FrmFinals(FrmViewFinals aThis, boolean modal, FormMode formMode, Finals f) {
        super(aThis, modal);
        initComponents();
        
        this.f=f;
        
        populateForm(formMode, f);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblStudent = new javax.swing.JLabel();
        cbStudent = new javax.swing.JComboBox<>();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbSubject = new javax.swing.JComboBox<>();
        lblType = new javax.swing.JLabel();
        cbFinalsType = new javax.swing.JComboBox<>();
        btnAddFinalsItem = new javax.swing.JButton();
        btnRemoveFinalsItem = new javax.swing.JButton();
        lblDuration = new javax.swing.JLabel();
        txtDuration = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFinalsItem = new javax.swing.JTable();
        lblFinalsFiled = new javax.swing.JLabel();
        lblFinalsFiledNumber = new javax.swing.JLabel();
        lblFinalsPeriod = new javax.swing.JLabel();
        cbFinalsPeriod = new javax.swing.JComboBox<>();
        btnCreateFinals = new javax.swing.JButton();
        btnUpdateFinals = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblID.setText("ID:");

        lblStudent.setText("Student:");

        lblDate.setText("Datum prijave:");

        txtDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Stavka prijave ispita"));

        jLabel1.setText("Predmet:");

        lblType.setText("Tip ispita:");

        btnAddFinalsItem.setText("Dodaj stavku");
        btnAddFinalsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFinalsItemActionPerformed(evt);
            }
        });

        btnRemoveFinalsItem.setText("Obrisi stavku");
        btnRemoveFinalsItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFinalsItemActionPerformed(evt);
            }
        });

        lblDuration.setText("Trajanje:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cbSubject, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFinalsType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddFinalsItem)
                                .addGap(32, 32, 32)
                                .addComponent(btnRemoveFinalsItem)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDuration))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(cbFinalsType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuration)
                    .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddFinalsItem)
                    .addComponent(btnRemoveFinalsItem))
                .addGap(17, 17, 17))
        );

        tblFinalsItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblFinalsItem);

        lblFinalsFiled.setText("Ispita prijavljeno:");

        lblFinalsFiledNumber.setText("0");

        lblFinalsPeriod.setText("Ispitni rok:");

        btnCreateFinals.setText("Kreiraj");
        btnCreateFinals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateFinalsActionPerformed(evt);
            }
        });

        btnUpdateFinals.setText("Azuriraj");
        btnUpdateFinals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateFinalsActionPerformed(evt);
            }
        });

        btnCancel.setText("Otkazi");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreateFinals, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdateFinals, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFinalsFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFinalsFiledNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFinalsPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtID)
                                    .addComponent(cbStudent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDate)
                                    .addComponent(cbFinalsPeriod, 0, 446, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudent)
                    .addComponent(cbStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFinalsPeriod)
                    .addComponent(cbFinalsPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFinalsFiled)
                    .addComponent(lblFinalsFiledNumber))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateFinals, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateFinals, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddFinalsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFinalsItemActionPerformed
        if (cbSubject.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Morate da odaberete predmet", "GRESKA PRI IZBORU PREDMETA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cbFinalsType.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Morate da odaberete vrstu ispita", "GRESKA PRI IZBORU VRSTE ISPITA", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(txtDuration.getText().trim().equals("")){
            JOptionPane.showMessageDialog(this, "Morate da unesete vrednost za trajanje ispita", "GRESKA PRI IZBORU VRSTE ISPITA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Subject subject = (Subject) cbSubject.getSelectedItem();
        FinalsType type = (FinalsType) cbFinalsType.getSelectedItem();
        int duration = Integer.parseInt(txtDuration.getText().trim());

        FinalsItem fi = new FinalsItem(-1L, f, type, duration, subject);

        FinalsItemTableModel fitm = (FinalsItemTableModel) tblFinalsItem.getModel();
        fitm.addItem(fi);

        int totalApplied = tblFinalsItem.getRowCount();

        lblFinalsFiledNumber.setText(String.valueOf(totalApplied));
    }//GEN-LAST:event_btnAddFinalsItemActionPerformed

    private void btnCreateFinalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateFinalsActionPerformed
        try {
            if (cbStudent.getSelectedIndex() < 0) {
                //JOptionPane.showMessageDialog(this, "Niste odabrali studenta", "GRESKA PRI IZBORU STUDENTA", JOptionPane.ERROR_MESSAGE);

                JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira prijavu", "GRESKA PRI KREIRANJU", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cbFinalsPeriod.getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(this, "Niste odabrali ispitni rok", "GRESKA PRI IZBORU ISPTINOG ROKA", JOptionPane.ERROR_MESSAGE);

                return;
            }

            if (txtDate.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti datum prijave ispita", "GRESKA PRI UNOSU DATUMA", JOptionPane.ERROR_MESSAGE);
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date applyDate = (sdf.parse(txtDate.getText()));

//            if (applyDate.before(((FinalsPeriod) cbFinalsPeriod.getSelectedItem()).getStartDate()) || applyDate.after(((FinalsPeriod) cbFinalsPeriod.getSelectedItem()).getEndDate())) {
//                JOptionPane.showMessageDialog(this, "Datum mora biti izmedju pocetka i kraja ovog ispitnog roka", "GRESKA PRI UNOSU DATUMA", JOptionPane.ERROR_MESSAGE);
//                return;
//            }

            if (tblFinalsItem.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Morate dodati stavke u prijavu ispita", "GRESKA KOD UNOSA STAVKI", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int totalApplied=Integer.parseInt(lblFinalsFiledNumber.getText());
            
            Student student=(Student) cbStudent.getSelectedItem();
            
            FinalsPeriod finalsPeriod=(FinalsPeriod) cbFinalsPeriod.getSelectedItem();
            
            FinalsItemTableModel fitm = (FinalsItemTableModel) tblFinalsItem.getModel();
            
            ArrayList<FinalsItem> items=fitm.getList();
            
            Finals finals=new Finals(null, applyDate, totalApplied, student, finalsPeriod,items);
            
            Finals created=ClientController.getInstance().createFinals(finals);
            
            JOptionPane.showMessageDialog(this, "Sistem je kreirao prijavu ispita", "USPESNO KREIRANJE", JOptionPane.INFORMATION_MESSAGE);

            int response = JOptionPane.showConfirmDialog(this, "Zelite li da kreirate jos prijava ispita?", "KREIRANJE", JOptionPane.YES_NO_OPTION);

            if (response == JOptionPane.YES_OPTION) {
                clearForm();
            } else if (response == JOptionPane.NO_OPTION) {
                this.dispose();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnCreateFinalsActionPerformed

    private void btnUpdateFinalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateFinalsActionPerformed
        try {
            if (cbStudent.getSelectedIndex() < 0) {
                //JOptionPane.showMessageDialog(this, "Niste odabrali studenta", "GRESKA PRI IZBORU STUDENTA", JOptionPane.ERROR_MESSAGE);

                JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira prijavu", "GRESKA PRI KREIRANJU", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (cbFinalsPeriod.getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(this, "Niste odabrali ispitni rok", "GRESKA PRI IZBORU ISPTINOG ROKA", JOptionPane.ERROR_MESSAGE);

                return;
            }

            if (txtDate.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti datum prijave ispita", "GRESKA PRI UNOSU DATUMA", JOptionPane.ERROR_MESSAGE);
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date applyDate = (sdf.parse(txtDate.getText()));

//            if (applyDate.before(((FinalsPeriod) cbFinalsPeriod.getSelectedItem()).getStartDate()) || applyDate.after(((FinalsPeriod) cbFinalsPeriod.getSelectedItem()).getEndDate())) {
//                JOptionPane.showMessageDialog(this, "Datum mora biti izmedju pocetka i kraja ovog ispitnog roka", "GRESKA PRI UNOSU DATUMA", JOptionPane.ERROR_MESSAGE);
//                return;
//            }

//            if (tblFinalsItem.getRowCount() == 0) {
//                JOptionPane.showMessageDialog(this, "Morate dodati stavke u prijavu ispita", "GRESKA KOD UNOSA STAVKI", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
            
            int totalApplied=Integer.parseInt(lblFinalsFiledNumber.getText());
            
            Student student=(Student) cbStudent.getSelectedItem();
            
            FinalsPeriod finalsPeriod=(FinalsPeriod) cbFinalsPeriod.getSelectedItem();
            
            FinalsItemTableModel fitm = (FinalsItemTableModel) tblFinalsItem.getModel();
            
            ArrayList<FinalsItem> items=fitm.getList();
            
            Finals finals=new Finals(Long.valueOf(txtID.getText().trim()), applyDate, totalApplied, student, finalsPeriod,items);
            
            ClientController.getInstance().updateFinals(finals);
            
            FrmViewFinals fwf = (FrmViewFinals) getParent();
            fwf.refreshTable();
            
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio prijavu ispita", "USPESNO KREIRANJE", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti prijavu ispita", "GERSKA PRI AZURIRANJU", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateFinalsActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRemoveFinalsItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFinalsItemActionPerformed
        int selectedItem = tblFinalsItem.getSelectedRow();

        if (selectedItem < 0) {
            JOptionPane.showMessageDialog(this, "Niste izabrali nijednu stavku iz tabele", "GRESKA PRI IZBORU STAVKE", JOptionPane.ERROR_MESSAGE);
            return;
        }

        FinalsItemTableModel fitm = (FinalsItemTableModel) tblFinalsItem.getModel();

        FinalsItem fi = fitm.getFinalsItem(selectedItem);

        fitm.deleteItem(selectedItem);

        int totalApplied = tblFinalsItem.getRowCount();

        lblFinalsFiledNumber.setText(String.valueOf(totalApplied));
    }//GEN-LAST:event_btnRemoveFinalsItemActionPerformed

    private void populateForm(FormMode mode, Finals f) {
        setLocationRelativeTo(null);

        try {
            ArrayList<Student> students = ClientController.getInstance().getAllStudents();

            for (Student student : students) {
                cbStudent.addItem(student);
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmFinals.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ArrayList<FinalsPeriod> finalsPeriods = ClientController.getInstance().getAllFinalsPeriods();

            for (FinalsPeriod finalsPeriod : finalsPeriods) {
                cbFinalsPeriod.addItem(finalsPeriod);
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmFinals.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ArrayList<Subject> subjects = ClientController.getInstance().getAllSubjects();

            for (Subject subject : subjects) {
                cbSubject.addItem(subject);
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmFinals.class.getName()).log(Level.SEVERE, null, ex);
        }

        FinalsType[] type = FinalsType.values();

        for (FinalsType finalsType : type) {
            cbFinalsType.addItem(finalsType);
        }

        tblFinalsItem.setModel(new FinalsItemTableModel());

        switch (mode) {
            case KREIRAJ -> {
                setTitle("KREIRAJ PRIJAVU ISPITA");

                lblID.setVisible(false);
                txtID.setVisible(false);

                cbStudent.setSelectedIndex(-1);
                cbFinalsPeriod.setSelectedIndex(-1);
                cbSubject.setSelectedIndex(-1);
                cbFinalsType.setSelectedIndex(-1);

                btnUpdateFinals.setVisible(false);
            }
            case IZMENI -> {
                setTitle("IZMENA PRIJAVE ISPITA");

                lblID.setVisible(true);
                txtID.setVisible(true);
                
                txtID.setText(String.valueOf(f.getFinalsID()));
                cbStudent.setSelectedItem(f.getStudent());
                cbFinalsPeriod.setSelectedItem(f.getFinalsPeriod());
                txtDate.setText(f.getApplicationDate().toString());

                jPanel1.setVisible(false);
                
                lblFinalsFiledNumber.setText(String.valueOf(f.getTotalApplied()));
                
               // tblFinalsItem.setModel(new FinalsItemTableModel(f));
                
//                txtID.setEnabled(false);
//                cbStudent.setEditable(false);
//                cbFinalsPeriod.setEnabled(false);
//                txtDate.setEnabled(false);

                  tblFinalsItem.setVisible(false);
                
                btnCreateFinals.setVisible(false);
                btnUpdateFinals.setVisible(true);
            }
            case PRIKAZI -> {
                setTitle("DETALJI PRIJAVE ISPITA");

                lblID.setVisible(true);
                txtID.setVisible(true);
                
                txtID.setText(String.valueOf(f.getFinalsID()));
                cbStudent.setSelectedItem(f.getStudent());
                cbFinalsPeriod.setSelectedItem(f.getFinalsPeriod());
                txtDate.setText(f.getApplicationDate().toString());

                jPanel1.setVisible(false);
                
                lblFinalsFiledNumber.setText(String.valueOf(f.getTotalApplied()));
                
                //tblFinalsItem.setModel(new FinalsItemTableModel(f));
                
                txtID.setEnabled(false);
                cbStudent.setEditable(false);
                cbFinalsPeriod.setEnabled(false);
                txtDate.setEnabled(false);
                
                btnCreateFinals.setVisible(false);
                btnUpdateFinals.setVisible(false);
            }

            default ->
                throw new AssertionError();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFinalsItem;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreateFinals;
    private javax.swing.JButton btnRemoveFinalsItem;
    private javax.swing.JButton btnUpdateFinals;
    private javax.swing.JComboBox<Object> cbFinalsPeriod;
    private javax.swing.JComboBox<Object> cbFinalsType;
    private javax.swing.JComboBox<Object> cbStudent;
    private javax.swing.JComboBox<Object> cbSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblFinalsFiled;
    private javax.swing.JLabel lblFinalsFiledNumber;
    private javax.swing.JLabel lblFinalsPeriod;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblStudent;
    private javax.swing.JLabel lblType;
    private javax.swing.JTable tblFinalsItem;
    private javax.swing.JFormattedTextField txtDate;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables

    private void clearForm() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}