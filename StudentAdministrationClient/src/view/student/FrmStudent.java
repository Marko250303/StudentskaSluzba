/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view.student;

import domain.Student;
import domain.StudentType;
import domain.StudentYear;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.ClientController;
import view.FormMode;

/**
 *
 * @author Mare
 */
public class FrmStudent extends javax.swing.JDialog {

    private FormMode mode = FormMode.KREIRAJ;

    private Student s;

    /**
     * Creates new form FrmStudent
     */
    public FrmStudent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        populateForm(s, mode);
    }

    FrmStudent(FrmViewStudents aThis, boolean modal, FormMode mode, Student s) {
        super(aThis, modal);
        initComponents();

        this.s = s;

        populateForm(s, mode);
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
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblLastname = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        lblIndex = new javax.swing.JLabel();
        txtIndex = new javax.swing.JTextField();
        lblStudyYear = new javax.swing.JLabel();
        cbStudyYear = new javax.swing.JComboBox<>();
        btnCreateStudent = new javax.swing.JButton();
        btnUpdateStudent = new javax.swing.JButton();
        btnDeleteStudent = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblType = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblID.setText("ID:");

        lblName.setText("Ime:");

        lblLastname.setText("Prezime:");

        lblIndex.setText("Indeks:");

        lblStudyYear.setText("Godina studija:");

        btnCreateStudent.setText("Kreiraj");
        btnCreateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateStudentActionPerformed(evt);
            }
        });

        btnUpdateStudent.setText("Azuriraj");
        btnUpdateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStudentActionPerformed(evt);
            }
        });

        btnDeleteStudent.setText("Obrisi");
        btnDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStudentActionPerformed(evt);
            }
        });

        btnCancel.setText("Otkazi");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblType.setText("Tip studenta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnUpdateStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteStudent))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStudyYear)
                            .addComponent(lblIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblType))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCreateStudent)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtLastname)
                                .addComponent(txtIndex)
                                .addComponent(cbStudyYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtName)
                                .addComponent(txtID)
                                .addComponent(cbType, 0, 228, Short.MAX_VALUE))
                            .addComponent(btnCancel))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastname)
                    .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIndex)
                    .addComponent(txtIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudyYear)
                    .addComponent(cbStudyYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblType)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateStudent)
                    .addComponent(btnUpdateStudent)
                    .addComponent(btnDeleteStudent))
                .addGap(46, 46, 46)
                .addComponent(btnCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCreateStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateStudentActionPerformed
        String firstName = txtName.getText().trim();
        String lastName = txtLastname.getText().trim();
         
        if(!validateStudent(firstName, lastName)){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira studenta", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int index = Integer.parseInt(txtIndex.getText().trim());
        StudentYear year = (StudentYear) cbStudyYear.getSelectedItem();
        StudentType type = (StudentType) cbType.getSelectedItem();

        //validacija
        Student create = new Student(null, firstName, lastName, index, year, type);

        try {
            Student createdStudentt = ClientController.getInstance().createStudent(create);

            JOptionPane.showMessageDialog(this, "Sistem je kreirao studenta", "STUDENT JE KREIRAN", JOptionPane.INFORMATION_MESSAGE);

            int choice = JOptionPane.showConfirmDialog(this, "Zelite li dakreirate jos studenata?", "NOVO KREIRANJE", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                txtName.setText("");
                txtLastname.setText("");
                txtIndex.setText("");
                cbStudyYear.setSelectedIndex(-1);
                cbType.setSelectedIndex(-1);
            } else if (choice == JOptionPane.NO_OPTION) {
                this.dispose();
            }

        } catch (Exception ex) {
            Logger.getLogger(FrmStudent.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da kreira studenta", "GRESKA PRI KREIRANJU STUDENTA", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCreateStudentActionPerformed

    public boolean validateStudent(String firstName, String lastName) throws HeadlessException {
        if (firstName.equals("")) {
            JOptionPane.showMessageDialog(this, "Ime studenta ne sme da bude prazno", "GRESKA KOD IMENA", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (firstName.length() < 2 || firstName.length() > 15) {
            JOptionPane.showMessageDialog(this, "Ime mora da sadrzi izmedju 3 i 15 slova", "Greska kod imena", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (firstName.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(this, "Ime ne sme da sadrzi brojeve", "Greska kod imena", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (lastName.equals("")) {
            JOptionPane.showMessageDialog(this, "Prezime studenta ne sme da bude prazno", "GRESKA KOD PREZIMENA", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (lastName.length() < 2 || lastName.length() > 15) {
            JOptionPane.showMessageDialog(this, "Prezime mora da sadrzi izmedju 3 i 15 slova", "Greska kod prezimena", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (lastName.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(this, "Prezime ne sme da sadrzi brojeve", "Greska kod imena", JOptionPane.ERROR_MESSAGE);
            return false;
        }
//        if (txtID.getText().trim().matches("^[a-zA-Z]*$")) {
//            JOptionPane.showMessageDialog(this, "Broj indeksa ne sme da sadrzi slova", "Greska kod indeksa", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
        if (cbStudyYear.getSelectedIndex()<0) {
            JOptionPane.showMessageDialog(this, "Niste odabrali godinu studija", "Greska kod godine", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (cbType.getSelectedIndex()<0) {
            JOptionPane.showMessageDialog(this, "Niste odabrali tip studenta", "Greska kod godine", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    private void btnUpdateStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStudentActionPerformed
        String firstName = txtName.getText().trim();
        String lastName = txtLastname.getText().trim();
        
        if(!validateStudent(firstName, lastName)){
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti studenta", "GRESKA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int index = Integer.parseInt(txtIndex.getText().trim()); //da li je uneto slovo
        StudentYear year = (StudentYear) cbStudyYear.getSelectedItem();
        StudentType type = (StudentType) cbType.getSelectedItem();

        //validacija
        Student forUpdate = new Student(Long.valueOf(txtID.getText().trim()), firstName, lastName, index, year, type);

        try {
            ClientController.getInstance().updateStudent(forUpdate);

            FrmViewStudents fws = (FrmViewStudents) getParent();
            fws.refreshTable();
            
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio studenta", "USPESNA IZMENA", JOptionPane.INFORMATION_MESSAGE);

            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti studenta", "GRESKA PRI IZMENI", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateStudentActionPerformed

    private void btnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStudentActionPerformed
        try {
            ClientController.getInstance().deleteStudent(s);

            JOptionPane.showMessageDialog(this, "Sistem je obrisao studenta", "USPESNO BRISANJE", JOptionPane.INFORMATION_MESSAGE);

            FrmViewStudents fvs = (FrmViewStudents) getParent();
            fvs.deleteStudent(s);
            fvs.refreshTable();
            
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FrmStudent.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise studenta studenta", "GRESKA PRI BRISANJU", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteStudentActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreateStudent;
    private javax.swing.JButton btnDeleteStudent;
    private javax.swing.JButton btnUpdateStudent;
    private javax.swing.JComboBox<Object> cbStudyYear;
    private javax.swing.JComboBox<Object> cbType;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIndex;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStudyYear;
    private javax.swing.JLabel lblType;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIndex;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void populateForm(Student s, FormMode mode) {
        setLocationRelativeTo(null);

        try {
            ArrayList<StudentType> types = ClientController.getInstance().getAllStudentTypes();

            for (StudentType type : types) {
                cbType.addItem(type);
            }
        } catch (Exception ex) {
            Logger.getLogger(FrmStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

        StudentYear[] years = StudentYear.values();

        for (StudentYear year : years) {
            cbStudyYear.addItem(year);
        }

        switch (mode) {
            case KREIRAJ -> {
                setTitle("KREIRAJ STUDENTA");

                lblID.setVisible(false);
                txtID.setVisible(false);

                btnUpdateStudent.setVisible(false);
                btnDeleteStudent.setVisible(false);

                cbStudyYear.setSelectedIndex(-1);
                cbType.setSelectedIndex(-1);
            }
            case IZMENI -> {
                setTitle("AZURIRAJ STUDENTA");

                txtID.setText(String.valueOf(s.getStudentID()));
                txtName.setText(s.getFirstName());
                txtLastname.setText(s.getLastName());
                txtIndex.setText(String.valueOf(s.getIndex()));
                cbStudyYear.setSelectedItem(s.getYear());

                System.out.println(s.getStudentType());
                System.out.println(s.getStudentType().getStudentTypeID());
                System.out.println(s.getStudentType().getTypeName());
                cbType.setSelectedItem(s.getStudentType().getTypeName());

                lblID.setVisible(true);
                txtID.setVisible(true);

                txtID.setEnabled(false);

                btnCreateStudent.setVisible(false);
                btnDeleteStudent.setVisible(false);
            }
            case PRIKAZI -> {
                setTitle("DETALJI STUDENTA");

                txtID.setText(String.valueOf(s.getStudentID()));
                txtName.setText(s.getFirstName());
                txtLastname.setText(s.getLastName());
                txtIndex.setText(String.valueOf(s.getIndex()));
                cbStudyYear.setSelectedItem(s.getYear());
                cbType.setSelectedItem(s.getStudentType());

                lblID.setVisible(true);
                txtID.setVisible(true);

                txtID.setEnabled(false);
                txtName.setEnabled(false);
                txtLastname.setEnabled(false);
                txtIndex.setEnabled(false);
                cbStudyYear.setEnabled(false);
                cbType.setEnabled(false);

                btnCreateStudent.setVisible(false);
                btnUpdateStudent.setVisible(false);
                btnDeleteStudent.setVisible(false);

            }
            case OBRISI -> {
                setTitle("OBRISI STUDENTA");

                txtID.setText(String.valueOf(s.getStudentID()));
                txtName.setText(s.getFirstName());
                txtLastname.setText(s.getLastName());
                txtIndex.setText(String.valueOf(s.getIndex()));
                cbStudyYear.setSelectedItem(s.getYear());
                cbType.setSelectedItem(s.getStudentType());

                lblID.setVisible(true);
                txtID.setVisible(true);

                txtID.setEnabled(false);
                txtName.setEnabled(false);
                txtLastname.setEnabled(false);
                txtIndex.setEnabled(false);
                cbStudyYear.setEnabled(false);
                cbType.setEnabled(false);

                btnCreateStudent.setVisible(false);
                btnUpdateStudent.setVisible(false);
            }

            default ->
                throw new AssertionError();
        }
    }
}
