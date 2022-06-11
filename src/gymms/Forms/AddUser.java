package gymms.Forms;

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
    ArrayList<String> rolename_list = new ArrayList<>();

    public int modifyCombobox() {
        int counter = 0;
        try {
            ResultSet rss = dbmanager.getrole();
            while (rss.next()) {
                rolename_list.add(rss.getString("ROLE_NAME"));
                counter++;
            }
            return counter;
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    int size = modifyCombobox();

    public AddUser() {
        initComponents();
        for (int i = 0; i < size; i++) {
            roleComboBox.addItem(rolename_list.get(i));
        }
    }

    int loginidx;

    AddUser(int loginid) {
        initComponents();
        loginidx = loginid;
        for (int i = 0; i < size; i++) {
            roleComboBox.addItem(rolename_list.get(i));
        }
    }

    utilsFunctions utilfuncs = new utilsFunctions();

    public void submitdatabase() {
        if (nameTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || usernameTextField.getText().isEmpty()
                || passwordTextField.getText().isEmpty() || confpasswordTextField.getText().isEmpty() || MaleRadioButton.isSelected() == false && FemaleRadioButton.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Missing");
        } else {
            if (utilfuncs.checkname(nameTextField.getText())
                    && utilfuncs.checkemail(emailTextField.getText())
                    && utilfuncs.checkphone(phoneTextField.getText())
                    && utilfuncs.checkusername(usernameTextField.getText())) {
                if (utilfuncs.checkpassword(passwordTextField.getText(), confpasswordTextField.getText())) {
                    Gymowner gymowner = new Gymowner(nameTextField.getText(),
                            emailTextField.getText(), usernameTextField.getText(),
                            passwordTextField.getText(), addressTextField.getText(),
                            Long.parseLong(phoneTextField.getText()),
                            roleComboBox.getSelectedItem().toString(), GenderButtonGroup.getSelection().getActionCommand());
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

            } else {
                JOptionPane.showMessageDialog(null, "error");
            }
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
        jLabel7 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        confpasswordTextField = new javax.swing.JPasswordField();
        roleComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        MaleRadioButton = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        FemaleRadioButton = new javax.swing.JRadioButton();
        returnmainpageButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        branchComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

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

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address  :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

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

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name  :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        phoneTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        phoneTextField.setToolTipText("Enter User's Phone");
        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 303, -1));

        nameTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        nameTextField.setToolTipText("Enter User's Name");
        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 303, -1));

        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        emailTextField.setToolTipText("Enter User's Email");
        jPanel1.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 302, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username  :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 40));

        addressTextField.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        addressTextField.setToolTipText("Enter User's Address");
        addressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(addressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 400, 303, -1));

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

        roleComboBox.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        roleComboBox.setToolTipText("Select User's Role");
        roleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(roleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 304, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Role  :");
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

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/DumbleForUSer.PNG"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 620, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void addressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextFieldActionPerformed

    private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextFieldActionPerformed

    private void roleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleComboBoxActionPerformed

    }//GEN-LAST:event_roleComboBoxActionPerformed

    private void returnmainpageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnmainpageButtonActionPerformed
        dispose();
        new Mainpage(loginidx).setVisible(true);
    }//GEN-LAST:event_returnmainpageButtonActionPerformed

    private void FemaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleRadioButtonActionPerformed
        FemaleRadioButton.setActionCommand("Female");
    }//GEN-LAST:event_FemaleRadioButtonActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void MaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleRadioButtonActionPerformed
        MaleRadioButton.setActionCommand("Male");
    }//GEN-LAST:event_MaleRadioButtonActionPerformed

    private void branchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchComboBoxActionPerformed

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
    private javax.swing.JRadioButton FemaleRadioButton;
    private javax.swing.ButtonGroup GenderButtonGroup;
    private javax.swing.JRadioButton MaleRadioButton;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JComboBox<String> branchComboBox;
    private javax.swing.JPasswordField confpasswordTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton returnmainpageButton;
    private javax.swing.JComboBox<String> roleComboBox;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
