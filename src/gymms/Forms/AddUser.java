package gymms.Forms;

import gymms.Gymms;
import gymms.classes.Gymowner;
import gymms.database.DatabaseManeger;
import gymms.database.javaconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.utilsFunctions;

public class AddUser extends javax.swing.JFrame {

    Connection con = javaconnect.connectdb();
    PreparedStatement ps;
    ResultSet rs;

    DatabaseManeger dbmanager = new DatabaseManeger();
    ArrayList<String> jobtypelist = new ArrayList<>();
    ArrayList<String> branchlist = new ArrayList<>();

    public int jobtypemodifyCombobox() {
        int counter = 4;
        jobtypelist.add("GYMOWNER");
        jobtypelist.add("TRAINER");
        jobtypelist.add("GYMMANAGER");
        jobtypelist.add("RECEPTIONIST");
        return counter;
    }

    Gymms gymms = new Gymms();

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

    int size = jobtypemodifyCombobox();

    public AddUser() {
        initComponents();
        for (int i = 0; i < size; i++) {
            jobtypeComboBox.addItem(jobtypelist.get(i));
        }
        size = branchmodifyCombobox();
        for (int i = 0; i < size; i++) {
            branchComboBox.addItem(branchlist.get(i));
        }
    }

    int loginidx;

    AddUser(int loginid) {
        initComponents();
        loginidx = loginid;
        for (int i = 0; i < size; i++) {
            jobtypeComboBox.addItem(jobtypelist.get(i));
        }

        size = branchmodifyCombobox();
        for (int i = 0; i < size; i++) {
            branchComboBox.addItem(branchlist.get(i));
        }
    }

    utilsFunctions utilfuncs = new utilsFunctions();

    public void submitdatabase() {
        if (fnameTextField.getText().isEmpty() || lnameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || usernameTextField.getText().isEmpty()
                || passwordTextField.getText().isEmpty() || confpasswordTextField.getText().isEmpty() || MaleRadioButton.isSelected() == false && FemaleRadioButton.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Missing");
        } else {
//            if (utilfuncs.checkname(fnameTextField.getText())&& utilfuncs.checkname(lnameTextField.getText())
//                    && utilfuncs.checkemail(emailTextField.getText())
//                    && utilfuncs.checkphone(phoneTextField.getText())
//                    && utilfuncs.checkusername(usernameTextField.getText())) {
            if (utilfuncs.checkpassword(passwordTextField.getText(), confpasswordTextField.getText())) {
                Gymowner gymowner = new Gymowner(fnameTextField.getText(), lnameTextField.getText(),
                        emailTextField.getText(), usernameTextField.getText(),
                        passwordTextField.getText(), Integer.parseInt(Apt_noTextField.getText()), 
                        StreetTextField2.getText(), CityTextField1.getText(),
                        phoneTextField.getText(),
                        jobtypeComboBox.getSelectedItem().toString(),
                        GenderButtonGroup.getSelection().getActionCommand(),
                        branchComboBox.getSelectedItem().toString());
                if (gymowner.adduser()) {
                    JOptionPane.showMessageDialog(null, "Add User complete");
                    dispose();
                    new login().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Add User failed......");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password doesn't match.......");
                passwordTextField.setText("");
                confpasswordTextField.setText("");
            }
//            } else {
//                JOptionPane.showMessageDialog(null, "error");
//            }
            //TODO give user a note to know what entered wrong
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        GenderButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        fnameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        confpasswordTextField = new javax.swing.JPasswordField();
        jobtypeComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        MaleRadioButton = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        FemaleRadioButton = new javax.swing.JRadioButton();
        returnmainpageButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        branchComboBox = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lnameTextField = new javax.swing.JTextField();
        CityTextField1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        StreetTextField2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Apt_noTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirm Password  :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, 22));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password  :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email  :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone  :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 16));

        registerButton.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        registerButton.setText("Add User");
        registerButton.setToolTipText("Click Here To Complete Registeration");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        jPanel1.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 520, -1));

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Add New User");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, 54));

        phoneTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        phoneTextField.setToolTipText("Enter User's Phone");
        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 303, -1));

        fnameTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        fnameTextField.setToolTipText("Enter User's Name");
        fnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(fnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 303, 30));

        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        emailTextField.setToolTipText("Enter User's Email");
        jPanel1.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 302, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username  :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 40));

        passwordTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        passwordTextField.setToolTipText("Enter User's Password");
        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(passwordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 302, -1));

        confpasswordTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        confpasswordTextField.setToolTipText("Enter User's Password Again");
        jPanel1.add(confpasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 303, -1));

        jobtypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        jobtypeComboBox.setToolTipText("Select User's Role");
        jobtypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobtypeComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(jobtypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 304, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("JobType:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        usernameTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        usernameTextField.setToolTipText("Enter User's Username");
        jPanel1.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 302, -1));

        GenderButtonGroup.add(MaleRadioButton);
        MaleRadioButton.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        MaleRadioButton.setText("Male");
        MaleRadioButton.setToolTipText("Select User's  Gender");
        MaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleRadioButtonActionPerformed(evt);
            }
        });
        jPanel1.add(MaleRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        GenderButtonGroup.add(FemaleRadioButton);
        FemaleRadioButton.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        FemaleRadioButton.setText("Female");
        FemaleRadioButton.setToolTipText("Select User's  Gender");
        FemaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleRadioButtonActionPerformed(evt);
            }
        });
        jPanel1.add(FemaleRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, -1, -1));

        returnmainpageButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        returnmainpageButton.setText("Back To Mainpage");
        returnmainpageButton.setToolTipText("Click Here To Back To MainPage");
        returnmainpageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnmainpageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(returnmainpageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 160, 40));

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Branch:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        branchComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        branchComboBox.setToolTipText("Select Suitable Subscription");
        branchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(branchComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, 302, -1));

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Fname:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Lname :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        lnameTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lnameTextField.setToolTipText("Enter User's Name");
        lnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(lnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 303, -1));

        CityTextField1.setToolTipText("Enter Member's Address");
        CityTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(CityTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 80, -1));

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("City:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

        StreetTextField2.setToolTipText("Enter Member's Address");
        StreetTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StreetTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(StreetTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 80, -1));

        jLabel17.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Street:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, -1, -1));

        Apt_noTextField.setToolTipText("Enter Member's Address");
        Apt_noTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apt_noTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(Apt_noTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 30, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        submitdatabase();
    }//GEN-LAST:event_registerButtonActionPerformed

    private void phoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTextFieldActionPerformed

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    private void jobtypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobtypeComboBoxActionPerformed

    }//GEN-LAST:event_jobtypeComboBoxActionPerformed

    private void returnmainpageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnmainpageButtonActionPerformed
        dispose();
        new Mainpage(loginidx).setVisible(true);
    }//GEN-LAST:event_returnmainpageButtonActionPerformed

    private void FemaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleRadioButtonActionPerformed
        FemaleRadioButton.setActionCommand("Female");
    }//GEN-LAST:event_FemaleRadioButtonActionPerformed

    private void MaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleRadioButtonActionPerformed
        MaleRadioButton.setActionCommand("Male");
    }//GEN-LAST:event_MaleRadioButtonActionPerformed

    private void branchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchComboBoxActionPerformed

    private void lnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameTextFieldActionPerformed

    private void fnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameTextFieldActionPerformed

    private void CityTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CityTextField1ActionPerformed

    private void StreetTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StreetTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StreetTextField2ActionPerformed

    private void Apt_noTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apt_noTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apt_noTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apt_noTextField;
    private javax.swing.JTextField CityTextField1;
    private javax.swing.JRadioButton FemaleRadioButton;
    private javax.swing.ButtonGroup GenderButtonGroup;
    private javax.swing.JRadioButton MaleRadioButton;
    private javax.swing.JTextField StreetTextField2;
    private javax.swing.JComboBox<String> branchComboBox;
    private javax.swing.JPasswordField confpasswordTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField fnameTextField;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jobtypeComboBox;
    private javax.swing.JTextField lnameTextField;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton returnmainpageButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
