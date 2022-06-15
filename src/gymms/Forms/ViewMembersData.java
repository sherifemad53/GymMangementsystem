package gymms.Forms;

import gymms.Gymms;
import gymms.classes.Receptionist;
import gymms.classes.User;
import gymms.database.DatabaseManeger;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static java.util.Calendar.DATE;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewMembersData extends javax.swing.JFrame {

    User user = new User();

    DatabaseManeger dbmanager = new DatabaseManeger();

    Receptionist receptionist = new Receptionist();

    ArrayList<String> subscribelist = new ArrayList<>();
    ArrayList<String> branchlist = new ArrayList<>();
    
    gymms.classes.Package packagee = new gymms.classes.Package();

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
    
    public int branchmodifyCombobox() {
        Gymms gymms =new Gymms();
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

    public void viewdata() {
        DefaultTableModel tbmodel = (DefaultTableModel) jTable1.getModel();
        tbmodel.setNumRows(0);
        try {
            ResultSet rss = user.viewMemberdata();
            while (rss.next()) {
                String ID=Integer.toString(rss.getInt("MEMBERS_ID"));
                String trainerfname = rss.getString("USERS_FNAME"); 
                String trainerlname = rss.getString("USERS_LNAME");
                String memberfname = rss.getString("MEMBERS_FNAME");
                String memberlname = rss.getString("MEMBERS_LNAME");
                String packagename = rss.getString("PACKAGE_NAME");
                String packagecost = rss.getString("PACKAGE_COST");
                String startdate = rss.getDate("STARTDATE").toString();
                String enddate = rss.getDate("ENDDATE").toString();
                String program = rss.getString("MEMBERS_PROGRAM");
                String tbdata[] = {ID,memberfname, memberlname,trainerfname,trainerlname, packagename, packagecost, startdate, enddate, program};
                tbmodel.addRow(tbdata);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean search_member_ID(int loginidx) {
        ResultSet rss2 = receptionist.SearchMember(searchTextField.getText());
        int Age;
        if (rss2 == null) {
            JOptionPane.showMessageDialog(null, "Not Found....");
            return false;
        } else {
            ViewMemberProfile obj = new ViewMemberProfile(loginidx);
            try {
                int ID = rss2.getInt("MEMBERS_ID");
                obj.idTextField.setText(ID + "");
                String fname = rss2.getString("MEMBERS_FNAME");
                obj.fnameTextField.setText(fname);
                String lname = rss2.getString("MEMBERS_LNAME");
                obj.lnameTextField.setText(lname);
                Date birthdate = rss2.getDate("MEMBERS_BIRTHDATE");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
                LocalDateTime now = LocalDateTime.now();
                Age = now.getYear() - birthdate.getYear();
                obj.ageTextField.setText(Integer.toString(Age));
                obj.birthTextField.setText(Integer.toString(Age));
                obj.emailTextField.setText(rss2.getString("MEMBERS_EMAIL"));
                //obj.phoneTextField.setText(rss2.getString("MEMBERS_PHONE"));
                obj.Apt_noTextField.setText(rss2.getString("MEMBERS_APT_NO"));
                obj.StreetTextField2.setText(rss2.getString("MEMBERS_STREET"));
                obj.CityTextField1.setText(rss2.getString("MEMBERS_CITY"));
                obj.heightTextField.setText(rss2.getString("MEMBERS_HEIGHT"));
                obj.ProgramTextArea.setText(rss2.getString("MEMBERS_PROGRAM"));
                obj.weightTextField.setText(rss2.getString("MEMBERS_WEIGHT"));
                obj.genderTextField.setText(rss2.getString("MEMBERS_GENDER"));
                obj.SubscribtionTextField.setText(rss2.getString("PACKAGE_NAME"));
                obj.StartDateTextField.setText(rss2.getDate("STARTDATE").toString());
                obj.CostTextField.setText(rss2.getString("PACKAGE_COST"));
                obj.EndDateTextField.setText(rss2.getDate("ENDDATE").toString());
            } catch (SQLException ex) {
                Logger.getLogger(ViewMembersData.class.getName()).log(Level.SEVERE, null, ex);
            }
            obj.setVisible(true);
        }
        return true;
    }

    public ViewMembersData() {
        initComponents();
        viewdata();
        int size = subcribemodifyCombobox();
        for (int i = 0; i < size; i++) {
            subscribeComboBox.addItem(subscribelist.get(i));
        }
        size = branchmodifyCombobox();
        for (int i = 0; i < size; i++) {
            branchComboBox.addItem(subscribelist.get(i));
        }
    }

    int loginidx;

    ViewMembersData(int loginid) {
        loginidx = loginid;
        initComponents();
        viewdata();
        int size = subcribemodifyCombobox();
        for (int i = 0; i < size; i++) {
            subscribeComboBox.addItem(subscribelist.get(i));
        }
        size = branchmodifyCombobox();
        for (int i = 0; i < size; i++) {
            branchComboBox.addItem(subscribelist.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        AddMemberButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        searchTextField = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        AddProgramButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        subscribeComboBox = new javax.swing.JComboBox<>();
        branchButton = new javax.swing.JButton();
        branchComboBox = new javax.swing.JComboBox<>();
        resubscribeButton1 = new javax.swing.JButton();
        countTextField1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mainpageMenuItem = new javax.swing.JMenuItem();
        LogOutMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddMemberButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AddMemberButton.setText("Add Member");
        AddMemberButton.setToolTipText("Click Here To Add New Member");
        AddMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMemberButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddMemberButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 43, 127, 32));

        SearchButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SearchButton.setText("Search");
        SearchButton.setToolTipText("Click To Search For A Member ");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 96, 127, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Member FName", "Member LName", "Trainer FName", "Trainer LName", "Package Name", "Cost", "Start date", "End date", "Program"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 674, 234));

        searchTextField.setToolTipText("Enter Member's ID Or Name ");
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 95, 127, 23));

        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        deleteButton.setText("Delete Member");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 137, 127, 30));

        AddProgramButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AddProgramButton.setText("Add Program");
        AddProgramButton.setToolTipText("Click Here To Add Program");
        AddProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProgramButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddProgramButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 126, 32));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jPanel1.add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 79, -1));

        subscribeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subscribeComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(subscribeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 185, 127, -1));

        branchButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        branchButton.setText("Changebranch");
        branchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(branchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 127, -1));

        branchComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        branchComboBox.setToolTipText("Select Suitable Subscription");
        branchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(branchComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 130, 20));

        resubscribeButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        resubscribeButton1.setText("Resubscribe");
        resubscribeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resubscribeButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(resubscribeButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 186, 127, -1));
        jPanel1.add(countTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 120, 20));

        jLabel19.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Total members:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 150, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/ADDDD.PNG"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

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


    private void AddMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMemberButtonActionPerformed
        if (loginidx == 3) {
            dispose();
            new AddMember().setVisible(true);
        }
    }//GEN-LAST:event_AddMemberButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        if (search_member_ID(loginidx)) {
            dispose();
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void LogOutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutMenuActionPerformed
        JOptionPane.showMessageDialog(null, "Logout Sucessfull.....");
        dispose();
        new login().setVisible(true);     }//GEN-LAST:event_LogOutMenuActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (loginidx == 3) {
            String memberfname = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
            receptionist.deletemember(memberfname);
            viewdata();
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void mainpageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainpageMenuItemActionPerformed
        dispose();
        new Mainpage(loginidx).setVisible(true);
    }//GEN-LAST:event_mainpageMenuItemActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        dispose();
        new Mainpage().setVisible(true);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void AddProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProgramButtonActionPerformed
        //this code to take member name from table to add program page
        if (loginidx == 2) {
            dispose();
            AddProgram obj = new AddProgram();
            //obj.MemberNameTextField.setText( jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 1).toString());
            obj.setVisible(true);
        }
    }//GEN-LAST:event_AddProgramButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        viewdata();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void subscribeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subscribeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subscribeComboBoxActionPerformed

    private void branchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchButtonActionPerformed
        if (loginidx == 3) {
            String memberid = jTable1.getModel().getValueAt(jTable1.getSelectedRow(), -1).toString();
            receptionist.resubscribe(subscribeComboBox.getSelectedItem().toString(), memberid);
        }
    }//GEN-LAST:event_branchButtonActionPerformed

    private void branchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchComboBoxActionPerformed

    private void resubscribeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resubscribeButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resubscribeButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMembersData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMembersData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMembersData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMembersData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMembersData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddMemberButton;
    private javax.swing.JButton AddProgramButton;
    private javax.swing.JMenuItem LogOutMenu;
    private javax.swing.JButton SearchButton;
    private javax.swing.JButton branchButton;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mainpageMenuItem;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton resubscribeButton1;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JComboBox<String> subscribeComboBox;
    // End of variables declaration//GEN-END:variables
}
