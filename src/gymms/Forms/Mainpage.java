package gymms.Forms;

import javax.swing.JOptionPane;

public class Mainpage extends javax.swing.JFrame {

    public Mainpage() {
        initComponents();
    }

    int loginid;
    Mainpage(int login) {
        initComponents();
        loginid=login;
        switch (login) {
            case 1:
                adddUserButton.setEnabled(true);
                viewUsersDataButton.setEnabled(true);
                addpackageButton.setEnabled(true);
                addMemberButton.setEnabled(false);
                AddProgramButton.setEnabled(false);
                break;
            case 2:
                adddUserButton.setEnabled(false);
                viewUsersDataButton.setEnabled(false);
                addpackageButton.setEnabled(false);
                AddProgramButton.setEnabled(true);
                addMemberButton.setEnabled(false);
                break;
            case 3:
                adddUserButton.setEnabled(false);
                viewUsersDataButton.setEnabled(false);
                addpackageButton.setEnabled(false);
                AddProgramButton.setEnabled(false);
                addMemberButton.setEnabled(true);
                break;
            default:
                break;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addMemberButton = new javax.swing.JButton();
        adddUserButton = new javax.swing.JButton();
        veiwMemberDataButton = new javax.swing.JButton();
        viewUsersDataButton = new javax.swing.JButton();
        addpackageButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        AddProgramButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        menubar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        LogOutMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addMemberButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addMemberButton.setText("Add Member");
        addMemberButton.setToolTipText("Click Here To Add New Member");
        addMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addMemberButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 57, 145, 30));

        adddUserButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        adddUserButton.setText("Add User");
        adddUserButton.setToolTipText("Click Here To Add New User");
        adddUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adddUserButtonActionPerformed(evt);
            }
        });
        jPanel1.add(adddUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 105, 145, 30));

        veiwMemberDataButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        veiwMemberDataButton.setText("View Members Data");
        veiwMemberDataButton.setToolTipText("Click Here To View Members' Data");
        veiwMemberDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veiwMemberDataButtonActionPerformed(evt);
            }
        });
        jPanel1.add(veiwMemberDataButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 153, -1, 30));

        viewUsersDataButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        viewUsersDataButton.setText("View Users Data");
        viewUsersDataButton.setToolTipText("Click Here To View Users' Data");
        viewUsersDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUsersDataButtonActionPerformed(evt);
            }
        });
        jPanel1.add(viewUsersDataButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 201, 145, 30));

        addpackageButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addpackageButton.setText("Add Package");
        addpackageButton.setToolTipText("Click Here To Add New Package");
        addpackageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addpackageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addpackageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 249, 145, 30));

        jLabel1.setFont(new java.awt.Font("Niagara Engraved", 1, 48)); // NOI18N
        jLabel1.setText("Fittnes Club");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        AddProgramButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AddProgramButton.setText("Add Program");
        AddProgramButton.setToolTipText("Click Here To Add New Program For A Member");
        AddProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProgramButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddProgramButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 297, 145, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/Webp.net-resizeimage.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        FileMenu.setText("File");
        FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileMenuActionPerformed(evt);
            }
        });

        LogOutMenu.setText("Logout");
        LogOutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutMenuActionPerformed(evt);
            }
        });
        FileMenu.add(LogOutMenu);

        menubar.add(FileMenu);

        jMenu3.setText("Help");
        menubar.add(jMenu3);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutMenuActionPerformed
        JOptionPane.showMessageDialog(null, "Logout Sucessfull.....");
        dispose();
        new login().setVisible(true); 
    }//GEN-LAST:event_LogOutMenuActionPerformed

    private void addMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new AddMember(loginid).setVisible(true);
    }//GEN-LAST:event_addMemberButtonActionPerformed

    private void adddUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adddUserButtonActionPerformed
        ///if role equall gymowner add user
        dispose();
        new AddUser(loginid).setVisible(true);
    }//GEN-LAST:event_adddUserButtonActionPerformed

    private void veiwMemberDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veiwMemberDataButtonActionPerformed
        dispose();
        new ViewMembersData(loginid).setVisible(true);
    }//GEN-LAST:event_veiwMemberDataButtonActionPerformed

    private void viewUsersDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUsersDataButtonActionPerformed
        dispose();
        new ViewUsersData(loginid).setVisible(true);
    }//GEN-LAST:event_viewUsersDataButtonActionPerformed

    private void addpackageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addpackageButtonActionPerformed
        dispose();
        new AddPackage(loginid).setVisible(true);
    }//GEN-LAST:event_addpackageButtonActionPerformed

    private void FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileMenuActionPerformed
           
    }//GEN-LAST:event_FileMenuActionPerformed

    private void AddProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProgramButtonActionPerformed
        dispose();
        new AddProgram().setVisible(true);
    }//GEN-LAST:event_AddProgramButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Mainpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProgramButton;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem LogOutMenu;
    private javax.swing.JButton addMemberButton;
    private javax.swing.JButton adddUserButton;
    private javax.swing.JButton addpackageButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JButton veiwMemberDataButton;
    private javax.swing.JButton viewUsersDataButton;
    // End of variables declaration//GEN-END:variables
}
