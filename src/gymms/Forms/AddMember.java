package gymms.Forms;

import gymms.classes.Receptionist;
import gymms.classes.Member;
import gymms.classes.User;
import gymms.classes.Package;
import gymms.database.DatabaseManeger;
import gymms.database.javaconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.utilsFunctions;

public class AddMember extends javax.swing.JFrame {

    Connection con = javaconnect.connectdb();
    PreparedStatement ps;
    ResultSet rs;

    DatabaseManeger dbmanager = new DatabaseManeger();
    User user = new User();
    Package packagee = new Package();

    Receptionist receptionist = new Receptionist();
    ArrayList<String> trainerlist = new ArrayList<>();

    ArrayList<String> subscribelist = new ArrayList<>();

    public int trainermodifyCombobox() {
        int counter = 0;
        try {
            ResultSet rss = user.getUser("trainer");
            while (rss.next()) {
                trainerlist.add(rss.getString("USERS_NAME"));
                counter++;
            }
            return counter;
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int subcribemodifyCombobox() {
        int counter = 0;
        try {
            ResultSet rss = packagee.getpackage();
            while (rss.next()) {
                subscribelist.add(rss.getString("PACKAGE_NAME"));
                counter++;
            }
            return counter;
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    int size;

    public AddMember() {
        initComponents();
        size = trainermodifyCombobox();
        for (int i = 0; i < size; i++) {
            trainerComboBox.addItem(trainerlist.get(i));
        }
        size = subcribemodifyCombobox();
        for (int i = 0; i < size; i++) {
            subscribtionComboBox.addItem(subscribelist.get(i));
        }
    }

    int loginidx;

    public AddMember(int loginid) {
        loginidx = loginid;
        initComponents();
        size = trainermodifyCombobox();
        for (int i = 0; i < size; i++) {
            trainerComboBox.addItem(trainerlist.get(i));
        }
        size = subcribemodifyCombobox();
        for (int i = 0; i < size; i++) {
            subscribtionComboBox.addItem(subscribelist.get(i));
        }
    }
    
    utilsFunctions utilfuncs =new utilsFunctions();
    
    public void add() {
        if (nameTextField.getText().isEmpty()
                || ageTextField.getText().isEmpty()
                || heightSpinner.getValue().equals(0)
                || weightSpinner.getValue().equals(0)
                || MaleButton1.isSelected() == false && FemailButton2.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Missing");
        } else {
            if (utilfuncs.checkname(nameTextField.getText())
                    && utilfuncs.checkemail(emailTextField.getText())
                    && utilfuncs.checkphone(phoneTextField.getText())
                    && utilfuncs.checkage(ageTextField.getText())
                    && utilfuncs.checkaddress(addressTextField.getText())) {
                try {
                    Member member = new Member(nameTextField.getText(),
                            Integer.parseInt(ageTextField.getText()),
                            (Integer) (weightSpinner.getValue()),
                            (Integer) heightSpinner.getValue(),
                            Long.parseLong(phoneTextField.getText()),
                            emailTextField.getText(),
                            addressTextField.getText(), GenderbuttonGroup.getSelection().getActionCommand()
                    );
                    boolean flag = receptionist.addmember(member, subscribtionComboBox.getSelectedItem().toString(), trainerComboBox.getSelectedItem().toString());
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "ADDED");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to ADD");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GenderbuttonGroup = new javax.swing.ButtonGroup();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        subscribtionComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        heightSpinner = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        trainerComboBox = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        MaleButton1 = new javax.swing.JRadioButton();
        FemailButton2 = new javax.swing.JRadioButton();
        returnmainpageButton = new javax.swing.JButton();
        weightSpinner = new javax.swing.JSpinner();
        ageTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email  :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 143, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone  :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 184, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address  :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 223, -1, -1));

        addButton.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        addButton.setText("Add Member");
        addButton.setToolTipText("Click Here To Add Ther Mamber");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 480, 425, -1));

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 39)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Add New Member");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 34, 384, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name  :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 103, -1, -1));

        phoneTextField.setToolTipText("Enter Member's Phone");
        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 181, 302, -1));

        nameTextField.setToolTipText("Enter Member's Name");
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 101, 302, -1));

        emailTextField.setToolTipText("Enter MeMber's Email");
        jPanel1.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 141, 302, -1));

        addressTextField.setToolTipText("Enter Member's Address");
        addressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 221, 302, -1));

        subscribtionComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        subscribtionComboBox.setToolTipText("Select Suitable Subscription");
        subscribtionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subscribtionComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(subscribtionComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 419, 302, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Subscribtion  :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 421, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Age :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 263, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Weight :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 303, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Height :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 303, 52, -1));

        heightSpinner.setModel(new javax.swing.SpinnerNumberModel(165, 140, 200, 1));
        heightSpinner.setToolTipText("Select Member's Height");
        heightSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(heightSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 301, 105, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Assigned Trainer :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 386, -1, -1));

        trainerComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        trainerComboBox.setToolTipText("Select Trainer For The Member");
        trainerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainerComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(trainerComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 384, 302, -1));

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 344, -1, -1));

        GenderbuttonGroup.add(MaleButton1);
        MaleButton1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        MaleButton1.setForeground(new java.awt.Color(0, 51, 51));
        MaleButton1.setText("Male");
        MaleButton1.setToolTipText("Select Member's Gender");
        MaleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(MaleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 341, -1, -1));

        GenderbuttonGroup.add(FemailButton2);
        FemailButton2.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        FemailButton2.setForeground(new java.awt.Color(0, 51, 51));
        FemailButton2.setText("Female");
        FemailButton2.setToolTipText("Select Member's Gender");
        FemailButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemailButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(FemailButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 341, -1, -1));

        returnmainpageButton.setText("Back To Main Page");
        returnmainpageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnmainpageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(returnmainpageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 34, -1, -1));

        weightSpinner.setModel(new javax.swing.SpinnerNumberModel(40, 30, 130, 1));
        weightSpinner.setToolTipText("Select Member's Weight");
        weightSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(weightSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 301, 105, -1));

        ageTextField.setToolTipText("Enter Member's Age");
        jPanel1.add(ageTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 261, 302, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/AUSER.PNG"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, 0, 880, 560));

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Email  :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 143, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Phone  :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 184, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        add();
    }//GEN-LAST:event_addButtonActionPerformed

    private void phoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTextFieldActionPerformed

    private void addressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextFieldActionPerformed

    private void subscribtionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subscribtionComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subscribtionComboBoxActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void MaleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleButton1ActionPerformed
        MaleButton1.setActionCommand("Male");
    }//GEN-LAST:event_MaleButton1ActionPerformed

    private void FemailButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemailButton2ActionPerformed
        FemailButton2.setActionCommand("Female");
    }//GEN-LAST:event_FemailButton2ActionPerformed

    private void returnmainpageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnmainpageButtonActionPerformed
        dispose();
        new Mainpage(loginidx).setVisible(true);
    }//GEN-LAST:event_returnmainpageButtonActionPerformed

    private void trainerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainerComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trainerComboBoxActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddMember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton FemailButton2;
    private javax.swing.ButtonGroup GenderbuttonGroup;
    private javax.swing.JRadioButton MaleButton1;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JTextField ageTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JSpinner heightSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton returnmainpageButton;
    private javax.swing.JComboBox<String> subscribtionComboBox;
    private javax.swing.JComboBox<String> trainerComboBox;
    private javax.swing.JSpinner weightSpinner;
    // End of variables declaration//GEN-END:variables
}
