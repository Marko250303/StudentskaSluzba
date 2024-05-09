/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domain.Administrator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.ClientController;
import view.finals.FrmFinals;
import view.finals.FrmViewFinals;
import view.student.FrmStudent;
import view.student.FrmViewStudents;
import view.subject.FrmSubject;
import view.subject.FrmViewSubjects;

/**
 *
 * @author Mare
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    
    private Administrator logged;
    
    public FrmMain(Administrator logged) {
        initComponents();
        
        this.logged=logged;
        
        lblAdmin.setText("Dobrodosli " +logged);
        
        setTitle("E-STUDENT");
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdmin = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmStudent = new javax.swing.JMenu();
        jmiCreateStudent = new javax.swing.JMenuItem();
        jmiViewStudents = new javax.swing.JMenuItem();
        jmSubject = new javax.swing.JMenu();
        jmiCreateSubject = new javax.swing.JMenuItem();
        jmiViewAllSubjects = new javax.swing.JMenuItem();
        jmFinals = new javax.swing.JMenu();
        jmiCreateFinals = new javax.swing.JMenuItem();
        jmiViewFinals = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAdmin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAdmin.setText("jLabel1");

        btnLogout.setText("Odjava");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jmStudent.setText("Student");

        jmiCreateStudent.setText("Kreiraj");
        jmiCreateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCreateStudentActionPerformed(evt);
            }
        });
        jmStudent.add(jmiCreateStudent);

        jmiViewStudents.setText("Prikazi sve");
        jmiViewStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewStudentsActionPerformed(evt);
            }
        });
        jmStudent.add(jmiViewStudents);

        jMenuBar1.add(jmStudent);

        jmSubject.setText("Predmet");

        jmiCreateSubject.setText("Kreiraj");
        jmiCreateSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCreateSubjectActionPerformed(evt);
            }
        });
        jmSubject.add(jmiCreateSubject);

        jmiViewAllSubjects.setText("Prikazi sve");
        jmiViewAllSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewAllSubjectsActionPerformed(evt);
            }
        });
        jmSubject.add(jmiViewAllSubjects);

        jMenuBar1.add(jmSubject);

        jmFinals.setText("Prijava ispita");

        jmiCreateFinals.setText("Kreiraj");
        jmiCreateFinals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCreateFinalsActionPerformed(evt);
            }
        });
        jmFinals.add(jmiCreateFinals);

        jmiViewFinals.setText("Prikazi sve");
        jmiViewFinals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewFinalsActionPerformed(evt);
            }
        });
        jmFinals.add(jmiViewFinals);

        jMenuBar1.add(jmFinals);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(389, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
            .addGroup(layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int choice=JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da se odjavite?", "ODJAVA", JOptionPane.YES_NO_OPTION);
        
        if(choice==JOptionPane.YES_OPTION){
            try {
                ClientController.getInstance().logout(logged);
                
                JOptionPane.showMessageDialog(this, "Uspesna odjava", "ODJAVA", JOptionPane.INFORMATION_MESSAGE);
                
                new FrmLogin().setVisible(true);
                this.dispose();
                
                //System.exit(0)
            } catch (Exception ex) {
                Logger.getLogger(FrmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if(choice==JOptionPane.NO_OPTION){
            
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void jmiCreateSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCreateSubjectActionPerformed
        new FrmSubject(this, true).setVisible(true);
    }//GEN-LAST:event_jmiCreateSubjectActionPerformed

    private void jmiViewAllSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewAllSubjectsActionPerformed
        new FrmViewSubjects(this, true).setVisible(true);
    }//GEN-LAST:event_jmiViewAllSubjectsActionPerformed

    private void jmiCreateStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCreateStudentActionPerformed
        new FrmStudent(this, true).setVisible(true);
    }//GEN-LAST:event_jmiCreateStudentActionPerformed

    private void jmiViewStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewStudentsActionPerformed
        new FrmViewStudents(this, true).setVisible(true);
    }//GEN-LAST:event_jmiViewStudentsActionPerformed

    private void jmiCreateFinalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCreateFinalsActionPerformed
        new FrmFinals(this, true).setVisible(true);
    }//GEN-LAST:event_jmiCreateFinalsActionPerformed

    private void jmiViewFinalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewFinalsActionPerformed
        new FrmViewFinals(this, true).setVisible(true);
    }//GEN-LAST:event_jmiViewFinalsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmFinals;
    private javax.swing.JMenu jmStudent;
    private javax.swing.JMenu jmSubject;
    private javax.swing.JMenuItem jmiCreateFinals;
    private javax.swing.JMenuItem jmiCreateStudent;
    private javax.swing.JMenuItem jmiCreateSubject;
    private javax.swing.JMenuItem jmiViewAllSubjects;
    private javax.swing.JMenuItem jmiViewFinals;
    private javax.swing.JMenuItem jmiViewStudents;
    private javax.swing.JLabel lblAdmin;
    // End of variables declaration//GEN-END:variables
}
