package gymms.Forms;

import gymms.classes.Gymowner;
import gymms.classes.User;
import gymms.database.DatabaseManeger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.utilsFunctions;

public class ViewUserProfile extends javax.swing.JFrame {

    Gymowner gymowner = new Gymowner();

    public ViewUserProfile() {
        initComponents();
        idTextField.setEditable(false);
        lnameTextField.setEditable(false);
        emailTextField.setEditable(false);
        usernameTextField.setEditable(false);
        passwordTextField.setEditable(false);
        Apt_noTextField.setEditable(false);
        StreetTextField2.setEditable(false);
        CityTextField1.setEditable(false);
        genderTextField.setEditable(false);
    }
    int loginidx;

    public ViewUserProfile(int loginid) {
        initComponents();
        loginidx = loginid;
        idTextField.setEditable(false);
        lnameTextField.setEditable(false);
        emailTextField.setEditable(false);
        usernameTextField.setEditable(false);
        passwordTextField.setEditable(false);
        Apt_noTextField.setEditable(false);
        StreetTextField2.setEditable(false);
        CityTextField1.setEditable(false);
        genderTextField.setEditable(false);
    }
    DatabaseManeger dbmanager = new DatabaseManeger();

    public int phonemodifycombobox(String userormember, int id) {
        try {
            System.out.println(id);
            ResultSet rss = dbmanager.getphone(userormember, id);
            while (rss.next()) {
                phoneComboBox.addItem(rss.getString("PHONE_NUMBER"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        lnameTextField = new javax.swing.JTextField();
        jobtypeTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        PrintButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        genderTextField = new javax.swing.JTextField();
        DeleteButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        branchTextField1 = new javax.swing.JTextField();
        fnameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Apt_noTextField = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        StreetTextField2 = new javax.swing.JTextField();
        CityTextField1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        addmoreButton = new javax.swing.JButton();
        phoneComboBox = new javax.swing.JComboBox<>();
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

        idTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        idTextField.setToolTipText("User's ID");
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(idTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 370, -1));

        lnameTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lnameTextField.setToolTipText("User's Name");
        lnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(lnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 265, 370, -1));

        jobtypeTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jobtypeTextField.setToolTipText("User's Role");
        jPanel1.add(jobtypeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 300, 370, -1));

        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        emailTextField.setToolTipText("User's Email");
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 335, 370, -1));

        usernameTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        usernameTextField.setToolTipText("User's Username");
        jPanel1.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 436, 370, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lname:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jobtype:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

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

        passwordTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        passwordTextField.setToolTipText("User's Password");
        jPanel1.add(passwordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 471, 370, -1));

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

        genderTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        genderTextField.setToolTipText("User's Gender");
        jPanel1.add(genderTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 506, 370, -1));

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

        jLabel19.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Branch:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 70, -1));

        branchTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        branchTextField1.setToolTipText("MEmber's Gender");
        jPanel1.add(branchTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 370, -1));

        fnameTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fnameTextField.setToolTipText("User's Name");
        fnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(fnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 370, -1));

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fname:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

        Apt_noTextField.setToolTipText("Enter Member's Address");
        Apt_noTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apt_noTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(Apt_noTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 40, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Street:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, -1, -1));

        StreetTextField2.setToolTipText("Enter Member's Address");
        StreetTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StreetTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(StreetTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 100, -1));

        CityTextField1.setToolTipText("Enter Member's Address");
        CityTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(CityTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 100, -1));

        jLabel17.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("City:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, -1, -1));

        addmoreButton.setText("Add more");
        addmoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addmoreButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addmoreButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, -1, 30));

        phoneComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        phoneComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(phoneComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, 270, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/AUSER.PNG"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-170, -260, 1000, 900));

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

    utils.utilsFunctions utilfuncs = new utilsFunctions();

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (utilfuncs.checkname(lnameTextField.getText())
                && utilfuncs.checkemail(emailTextField.getText())
                && utilfuncs.checkusername(usernameTextField.getText())
                && utilfuncs.checkaddress(Apt_noTextField.getText() + " " + StreetTextField2.getText() + " " + CityTextField1.getText())) {
            try {
                User user = new User();
                user.setID(Integer.parseInt(idTextField.getText()));
                user.setFNAME(fnameTextField.getText());
                user.setLNAME(lnameTextField.getText());
                user.setApt_no(Integer.parseInt(Apt_noTextField.getText()));
                user.setStreet(StreetTextField2.getText());
                user.setCity(CityTextField1.getText());
                user.setEMAIL(emailTextField.getText());
                user.setPHONE(null);
                user.setUSERNAME(usernameTextField.getText());
                user.setPASSWORD(passwordTextField.getText());
                user.setGENDER(genderTextField.getText());
                if (gymowner.editUser(user)) {
                    JOptionPane.showMessageDialog(null, "Editted successfully...");
                }
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        lnameTextField.setEditable(true);
        emailTextField.setEditable(true);
        usernameTextField.setEditable(true);
        passwordTextField.setEditable(true);
        Apt_noTextField.setEditable(true);
        StreetTextField2.setEditable(true);
        CityTextField1.setEditable(true);
        genderTextField.setEditable(true);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        gymowner.deleteUser(Integer.parseInt(idTextField.getText()));
        dispose();
        new ViewUsersData(loginidx).setVisible(true);
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        //   dispose();
        PrintUser obj = new PrintUser();

        obj.InformationTextArea.setText("ID :\t" + idTextField.getText() + "\nName :\t" + lnameTextField.getText() + "\nRole :\t" + jobtypeTextField.getText() + "\nEmail"
                + " :\t" + emailTextField.getText() + "\nPhone :\t" + phoneComboBox.getSelectedItem().toString()+ "\nAddress \t" + Integer.parseInt(Apt_noTextField.getText()) + " " + StreetTextField2.getText() + " " + CityTextField1.getText() + "\nUsername :\t"
                + usernameTextField.getText() + "\nPassword :\t" + passwordTextField.getText() + "\nGender :\t" + genderTextField.getText());
        obj.setVisible(true);

    }//GEN-LAST:event_PrintButtonActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void lnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameTextFieldActionPerformed

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void fnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameTextFieldActionPerformed

    private void Apt_noTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apt_noTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apt_noTextFieldActionPerformed

    private void StreetTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StreetTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StreetTextField2ActionPerformed

    private void CityTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CityTextField1ActionPerformed

    private void addmoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addmoreButtonActionPerformed
        String temp = JOptionPane.showInputDialog(null, "Enter phone", null, JOptionPane.PLAIN_MESSAGE);
        DatabaseManeger db = new DatabaseManeger();
        if (db.useraddphone(Integer.parseInt(idTextField.getText()), temp)) {
            JOptionPane.showMessageDialog(null, "done");
        }
    }//GEN-LAST:event_addmoreButtonActionPerformed

    private void phoneComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneComboBoxActionPerformed

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
    public javax.swing.JTextField Apt_noTextField;
    public javax.swing.JTextField CityTextField1;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JMenuItem LogOutMenu;
    private javax.swing.JButton PrintButton;
    public javax.swing.JTextField StreetTextField2;
    private javax.swing.JButton addmoreButton;
    public javax.swing.JTextField branchTextField1;
    public javax.swing.JTextField emailTextField;
    public javax.swing.JTextField fnameTextField;
    public javax.swing.JTextField genderTextField;
    public javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
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
    public javax.swing.JTextField jobtypeTextField;
    public javax.swing.JTextField lnameTextField;
    public javax.swing.JTextField passwordTextField;
    private javax.swing.JComboBox<String> phoneComboBox;
    private javax.swing.JButton saveButton;
    public javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
