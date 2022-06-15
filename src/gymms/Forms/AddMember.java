package gymms.Forms;

import gymms.Gymms;
import gymms.classes.Receptionist;
import gymms.classes.Member;
import gymms.classes.User;
import gymms.classes.Package;
import gymms.database.DatabaseManeger;
import gymms.database.javaconnect;
import java.sql.Connection;
import java.sql.Date;
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
    ArrayList<String> branchlist = new ArrayList<>();
    

    public int trainermodifyCombobox() {
        int counter = 0;
        try {
            ResultSet rss = user.getUser("TRAINER");
            while (rss.next()) {
                trainerlist.add(rss.getString("USERS_FNAME") +" "+ rss.getString("USERS_LNAME"));
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
    Gymms gymms =new Gymms();
    
    public int branchmodifyCombobox() {
        int counter = 0;
        try {
            ResultSet rss = gymms.getbranch();
            while (rss.next()) {
                branchlist.add(rss.getString("GYM_NAME"));
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
            subComboBox.addItem(subscribelist.get(i));
        }
        size = branchmodifyCombobox();
        for (int i = 0; i < size; i++) {
            branchComboBox.addItem(branchlist.get(i));
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
            subComboBox.addItem(subscribelist.get(i));
        }
        size = branchmodifyCombobox();
        for (int i = 0; i < size; i++) {
            branchComboBox.addItem(branchlist.get(i));
        }
       
    }
    
    utilsFunctions utilfuncs =new utilsFunctions();
    
    public void add() {
        if (fnameTextField.getText().isEmpty()
                ||lnameTextField.getText().isEmpty()
                || birthdateTextField.getText().isEmpty()
                || heightSpinner.getValue().equals(0)
                || weightSpinner.getValue().equals(0)
                || MaleButton1.isSelected() == false && FemailButton2.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Missing");
        } else {
//            if (utilfuncs.checkname(fnameTextField.getText())
//                    && utilfuncs.checkname(lnameTextField.getText())
//                    && utilfuncs.checkemail(emailTextField.getText())
//                    && utilfuncs.checkphone(phoneTextField.getText())
//                    && utilfuncs.checkage(birthdateTextField.getText())
//                    && utilfuncs.checkaddress(addressTextField.getText())) {
                try {
                    Member member = new Member(fnameTextField.getText(),
                            lnameTextField.getText(),
                            Date.valueOf(birthdateTextField.getText()),
                            (Integer) (weightSpinner.getValue()),
                            (Integer) heightSpinner.getValue(),
                            phoneTextField.getText(),
                            emailTextField.getText(),
                            Integer.parseInt(Apt_noTextField.getText()),StreetTextField2.getText(),CityTextField1.getText(), GenderbuttonGroup.getSelection().getActionCommand()
                    );
                    boolean flag = receptionist.addmember(member, subComboBox.getSelectedItem().toString(), trainerComboBox.getSelectedItem().toString(),branchComboBox.getSelectedItem().toString());
                    if (flag) {
                        JOptionPane.showMessageDialog(null, "ADDED");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to ADD");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            //}
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
        lnameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        Apt_noTextField = new javax.swing.JTextField();
        subComboBox = new javax.swing.JComboBox<>();
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
        birthdateTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        branchComboBox = new javax.swing.JComboBox<>();
        fnameTextField = new javax.swing.JTextField();
        CityTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        StreetTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email  :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone  :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Apt_NO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        addButton.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        addButton.setText("Add Member");
        addButton.setToolTipText("Click Here To Add Ther Mamber");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 425, -1));

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 39)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Add New Member");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 34, 384, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fname  :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 103, -1, -1));

        phoneTextField.setToolTipText("Enter Member's Phone");
        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 300, -1));

        lnameTextField.setToolTipText("Enter Member's Name");
        lnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(lnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 302, -1));

        emailTextField.setToolTipText("Enter MeMber's Email");
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 302, -1));

        Apt_noTextField.setToolTipText("Enter Member's Address");
        Apt_noTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apt_noTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(Apt_noTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 30, -1));

        subComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        subComboBox.setToolTipText("Select Suitable Subscription");
        subComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(subComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 302, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Branch:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BirthDate");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Weight :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Height :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 52, -1));

        heightSpinner.setModel(new javax.swing.SpinnerNumberModel(165, 140, 200, 1));
        heightSpinner.setToolTipText("Select Member's Height");
        heightSpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(heightSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 105, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Assigned Trainer :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, -1));

        trainerComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        trainerComboBox.setToolTipText("Select Trainer For The Member");
        trainerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainerComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(trainerComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 290, -1));

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

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
        jPanel1.add(MaleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));

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
        jPanel1.add(FemailButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, -1, -1));

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
        jPanel1.add(weightSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 105, -1));

        birthdateTextField.setToolTipText("Enter Member's Age");
        birthdateTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdateTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(birthdateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 302, -1));

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Lname  :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 143, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Subscribtion  :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, -1, -1));

        branchComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        branchComboBox.setToolTipText("Select Suitable Subscription");
        branchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(branchComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 302, -1));

        fnameTextField.setToolTipText("Enter Member's Name");
        fnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(fnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 101, 300, -1));

        CityTextField1.setToolTipText("Enter Member's Address");
        CityTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(CityTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 80, -1));

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("City:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Street:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        StreetTextField2.setToolTipText("Enter Member's Address");
        StreetTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StreetTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(StreetTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        add();
    }//GEN-LAST:event_addButtonActionPerformed

    private void phoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTextFieldActionPerformed

    private void Apt_noTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apt_noTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apt_noTextFieldActionPerformed

    private void subComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subComboBoxActionPerformed

    private void lnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameTextFieldActionPerformed

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

    private void branchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchComboBoxActionPerformed

    private void birthdateTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdateTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdateTextFieldActionPerformed

    private void fnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameTextFieldActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void CityTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CityTextField1ActionPerformed

    private void StreetTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StreetTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StreetTextField2ActionPerformed

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
    private javax.swing.JTextField Apt_noTextField;
    private javax.swing.JTextField CityTextField1;
    private javax.swing.JRadioButton FemailButton2;
    private javax.swing.ButtonGroup GenderbuttonGroup;
    private javax.swing.JRadioButton MaleButton1;
    private javax.swing.JTextField StreetTextField2;
    private javax.swing.JButton addButton;
    private javax.swing.JTextField birthdateTextField;
    private javax.swing.JComboBox<String> branchComboBox;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField fnameTextField;
    private javax.swing.JSpinner heightSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTextField lnameTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton returnmainpageButton;
    private javax.swing.JComboBox<String> subComboBox;
    private javax.swing.JComboBox<String> trainerComboBox;
    private javax.swing.JSpinner weightSpinner;
    // End of variables declaration//GEN-END:variables
}
