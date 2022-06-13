package gymms.Forms;

import gymms.classes.Gymowner;
import gymms.classes.User;
import gymms.database.DatabaseManeger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ViewUsersData extends javax.swing.JFrame {

    Gymowner gymowner = new Gymowner();

    DatabaseManeger dbmanager = new DatabaseManeger();
    
    public void viewdata() {
        DefaultTableModel tbmodel = (DefaultTableModel) UserDataTable.getModel();
        tbmodel.setRowCount(0);
        try {
            ResultSet rss = gymowner.viewUserdata();
            UserDataTable.removeAll();
            while (rss.next()) {
                String id = Integer.toString(rss.getInt("USERS_ID"));
                String fname = rss.getString("USERS_FNAME");
                String lname = rss.getString("USERS_LNAME");
                
                String email = rss.getString("USERS_EMAIL");
                String username = rss.getString("USERS_USERNAME");
                String password = rss.getString("USERS_PASSWORD");
                String address = rss.getString("USERS_APT_NO") + rss.getString("USERS_STREET")+rss.getString("USERS_CITY");
                String phone = null; //Long.toString(rss.getLong("USERS_PHONE"));
                String jobtype = rss.getString("USERS_JOBTYPE");
                String gender = rss.getString("USERS_GENDER");

                String tbdata[] = {id, fname,lname, email, username, password, address, phone, jobtype,gender};

                tbmodel.addRow(tbdata);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean search_user_ID() {
        ResultSet rss2 = gymowner.searchUser(searchTextField.getText());
        if (rss2 == null) {
            JOptionPane.showMessageDialog(null, "Not Found....");
            return false;
        } else {
            ViewUserProfile obj = new ViewUserProfile(loginidx);
            try {
                int ID = rss2.getInt("USERS_ID");
                obj.idTextField.setText(ID + "");
                String fname = rss2.getString("USERS_FNAME");
                obj.fnameTextField.setText(fname);
                String lname = rss2.getString("USERS_LNAME");
                obj.lnameTextField.setText(lname);
                obj.emailTextField.setText(rss2.getString("USERS_EMAIL"));
                //obj.phoneTextField.setText(rss2.getString("USERS_PHONE"));
                obj.Apt_noTextField.setText(rss2.getString("USERS_APT_NO"));
                obj.StreetTextField2.setText(rss2.getString("USERS_STREET"));
                obj.CityTextField1.setText(rss2.getString("USERS_CITY"));
                obj.genderTextField.setText(rss2.getString("USERS_GENDER"));
                obj.jobtypeTextField.setText(rss2.getString("USERS_JOBTYPE"));
                obj.usernameTextField.setText(rss2.getString("USERS_USERNAME"));
                obj.passwordTextField.setText(rss2.getString("USERS_PASSWORD"));
            } catch (SQLException ex) {
                Logger.getLogger(ViewMembersData.class.getName()).log(Level.SEVERE, null, ex);
            }
            obj.setVisible(true);
        }
        return true;
    }

    public ViewUsersData() {
        initComponents();
        viewdata();
    }
    int loginidx;
    ViewUsersData(int loginid) {
        initComponents();
        loginidx=loginid;
        viewdata();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AddUserButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserDataTable = new javax.swing.JTable();
        searchTextField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        branchButton = new javax.swing.JButton();
        branchComboBox = new javax.swing.JComboBox<>();
        branchButton1 = new javax.swing.JButton();
        orderbyComboBox1 = new javax.swing.JComboBox<>();
        countTextField1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mainpageMenuItem = new javax.swing.JMenuItem();
        LogOutMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddUserButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AddUserButton.setText("Add User");
        AddUserButton.setToolTipText("Clic Here To Add New User");
        AddUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddUserButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 30, 127, 30));

        UserDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FName", "LName", "Email", "Username", "Password", "Address", "Phone", "Role", "Gender"
            }
        ));
        UserDataTable.setToolTipText("User Data Table");
        jScrollPane1.setViewportView(UserDataTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 30, 644, 199));

        searchTextField.setToolTipText("Enter User ID or Name");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 127, -1));

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteButton.setText("Delete User");
        deleteButton.setToolTipText("Click Here To Delet User");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 78, 127, 30));

        searchButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        searchButton.setText("Search");
        searchButton.setToolTipText("Click Here To Serach For A User");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 124, 127, -1));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jPanel1.add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        branchButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        branchButton.setText("Changebranch");
        branchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(branchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 160, 130, -1));

        branchComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        branchComboBox.setToolTipText("Select Suitable Subscription");
        branchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(branchComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 130, 20));

        branchButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        branchButton1.setText("Order By");
        branchButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(branchButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 130, 20));

        orderbyComboBox1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        orderbyComboBox1.setToolTipText("Select Suitable Subscription");
        orderbyComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderbyComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(orderbyComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 130, 20));
        jPanel1.add(countTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 120, -1));

        jLabel19.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Total users:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 130, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/Gymback.PNG"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -160, -1, 470));

        jMenu1.setText("File");

        mainpageMenuItem.setText("Main Page");
        mainpageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainpageMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(mainpageMenuItem);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddUserButtonActionPerformed
        dispose();
        new AddUser(loginidx).setVisible(true);
    }//GEN-LAST:event_AddUserButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed

    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void LogOutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutMenuActionPerformed
        JOptionPane.showMessageDialog(null, "Logout Sucessfull.....");
        dispose();
        new login().setVisible(true);     }//GEN-LAST:event_LogOutMenuActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        //int row= jTable1.getSelectedRow();
        int id = Integer.parseInt(UserDataTable.getModel().getValueAt(UserDataTable.getSelectedRow(), 0).toString());
        gymowner.deleteUser(id);
        viewdata();
        //System.out.println(id);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
    if(search_user_ID()){
        dispose();
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        viewdata();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void mainpageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainpageMenuItemActionPerformed
        dispose();
        new Mainpage(loginidx).setVisible(true);
    }//GEN-LAST:event_mainpageMenuItemActionPerformed

    private void branchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchButtonActionPerformed
        if (loginidx == 3) {
//            String membername = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
//            receptionist.resubscribe(subscribeComboBox.getSelectedItem().toString(), membername);
        }
    }//GEN-LAST:event_branchButtonActionPerformed

    private void branchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchComboBoxActionPerformed

    private void branchButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchButton1ActionPerformed

    private void orderbyComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderbyComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderbyComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewUsersData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUsersData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUsersData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUsersData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUsersData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUserButton;
    private javax.swing.JMenuItem LogOutMenu;
    private javax.swing.JTable UserDataTable;
    private javax.swing.JButton branchButton;
    private javax.swing.JButton branchButton1;
    private javax.swing.JComboBox<String> branchComboBox;
    private javax.swing.JTextField countTextField1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mainpageMenuItem;
    private javax.swing.JComboBox<String> orderbyComboBox1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
