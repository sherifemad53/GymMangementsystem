package gymms.Forms;

import gymms.classes.Gymowner;
import gymms.classes.User;
import javax.swing.JOptionPane;

public class ViewUserProfile extends javax.swing.JFrame {

    Gymowner gymowner = new Gymowner();

    public ViewUserProfile() {
        initComponents();
        IDTextField.setEditable(false);
        NameTextField.setEditable(false);
        EmailTextField.setEditable(false);
        UsernameTextField.setEditable(false);
        PasswordTextField.setEditable(false);
        PhoneTextField.setEditable(false);
        AddressTextField.setEditable(false);
        GenderTextField.setEditable(false);
    }
    int loginidx;
    public ViewUserProfile(int loginid) {
        initComponents();
        loginidx=loginid;
        IDTextField.setEditable(false);
        NameTextField.setEditable(false);
        EmailTextField.setEditable(false);
        UsernameTextField.setEditable(false);
        PasswordTextField.setEditable(false);
        PhoneTextField.setEditable(false);
        AddressTextField.setEditable(false);
        GenderTextField.setEditable(false);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        IDTextField = new javax.swing.JTextField();
        NameTextField = new javax.swing.JTextField();
        RoleTextField = new javax.swing.JTextField();
        EmailTextField = new javax.swing.JTextField();
        PhoneTextField = new javax.swing.JTextField();
        AddressTextField = new javax.swing.JTextField();
        UsernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PasswordTextField = new javax.swing.JTextField();
        PrintButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        GenderTextField = new javax.swing.JTextField();
        DeleteButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LogOutMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 77, -1, -1));

        IDTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        IDTextField.setToolTipText("User's ID");
        IDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(IDTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 230, 166, -1));

        NameTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        NameTextField.setToolTipText("User's Name");
        NameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(NameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 265, 166, -1));

        RoleTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        RoleTextField.setToolTipText("User's Role");
        jPanel1.add(RoleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 300, 166, -1));

        EmailTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        EmailTextField.setToolTipText("User's Email");
        EmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(EmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 335, 166, -1));

        PhoneTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PhoneTextField.setToolTipText("User's Phone");
        jPanel1.add(PhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 370, 166, -1));

        AddressTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        AddressTextField.setToolTipText("User's Address");
        jPanel1.add(AddressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 403, 166, -1));

        UsernameTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        UsernameTextField.setToolTipText("User's Username");
        jPanel1.add(UsernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 436, 166, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Role:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Username :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, -1, -1));

        PasswordTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        PasswordTextField.setToolTipText("User's Password");
        jPanel1.add(PasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 471, 166, -1));

        PrintButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PrintButton.setText("Print");
        PrintButton.setToolTipText("Click To Print User's Info");
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });
        jPanel1.add(PrintButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 318, 107, 38));

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("User Profile");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 28, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Gender :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, -1, -1));

        GenderTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        GenderTextField.setToolTipText("User's Gender");
        jPanel1.add(GenderTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 506, 166, -1));

        DeleteButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.setToolTipText("Click Here To Delete User");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 374, 107, 38));

        EditButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        EditButton.setText("Edit");
        EditButton.setToolTipText("Click Here to Edit User's Info");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });
        jPanel1.add(EditButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 432, 107, 38));

        saveButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 488, 107, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/BY.PNG"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 84, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/AUSER.PNG"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, -260, 760, 920));

        jMenu1.setText("File");

        LogOutMenu.setText("Logout");
        LogOutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutMenuActionPerformed(evt);
            }
        });
        jMenu1.add(LogOutMenu);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutMenuActionPerformed
        JOptionPane.showMessageDialog(null, "Logout Sucessfull.....");
        dispose();
        new login().setVisible(true);     }//GEN-LAST:event_LogOutMenuActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            User user = new User();
            user.setID(Integer.parseInt(IDTextField.getText()));
            user.setNAME(NameTextField.getText());
            user.setADDRESS(AddressTextField.getText());
            user.setEMAIL(EmailTextField.getText());
            user.setPHONE(Long.parseLong(PhoneTextField.getText()));
            user.setUSERNAME(UsernameTextField.getText());
            user.setPASSWORD(PasswordTextField.getText());
            user.setGENDER(GenderTextField.getText());
            if (gymowner.editUser(user)) {
                JOptionPane.showMessageDialog(null, "Editted successfully...");
            }
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        NameTextField.setEditable(true);
        EmailTextField.setEditable(true);
        UsernameTextField.setEditable(true);
        PasswordTextField.setEditable(true);
        PhoneTextField.setEditable(true);
        AddressTextField.setEditable(true);
        GenderTextField.setEditable(true);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        gymowner.deleteUser(Integer.parseInt(IDTextField.getText()));
        dispose();
        new ViewUsersData(loginidx).setVisible(true);
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        //   dispose();
        PrintUser obj = new PrintUser();

        obj.InformationTextArea.setText("ID :\t" + IDTextField.getText() + "\nName :\t" + NameTextField.getText() + "\nRole :\t" + RoleTextField.getText() + "\nEmail"
                + " :\t" + EmailTextField.getText() + "\nPhone :\t" + PhoneTextField.getText() + "\nAddress \t" + AddressTextField.getText() + "\nUsername :\t"
                + UsernameTextField.getText() + "\nPassword :\t" + PasswordTextField.getText() + "\nGender :\t" + GenderTextField.getText());
        obj.setVisible(true);

    }//GEN-LAST:event_PrintButtonActionPerformed

    private void EmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailTextFieldActionPerformed

    private void NameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameTextFieldActionPerformed

    private void IDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(ViewUserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUserProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField AddressTextField;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    public javax.swing.JTextField EmailTextField;
    public javax.swing.JTextField GenderTextField;
    public javax.swing.JTextField IDTextField;
    private javax.swing.JMenuItem LogOutMenu;
    public javax.swing.JTextField NameTextField;
    public javax.swing.JTextField PasswordTextField;
    public javax.swing.JTextField PhoneTextField;
    private javax.swing.JButton PrintButton;
    public javax.swing.JTextField RoleTextField;
    public javax.swing.JTextField UsernameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
