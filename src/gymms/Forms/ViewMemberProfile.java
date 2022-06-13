package gymms.Forms;

import gymms.classes.Member;
import javax.swing.JOptionPane;
import gymms.classes.Receptionist;
import gymms.classes.Trainer;
import gymms.classes.User;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.utilsFunctions;

public class ViewMemberProfile extends javax.swing.JFrame {

    ArrayList<String> subscribelist = new ArrayList<>();
    gymms.classes.Package packagee = new gymms.classes.Package();
    Receptionist receptionist = new Receptionist();

    //print
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

    public ViewMemberProfile() {
        initComponents();
        idTextField.setEditable(false);
        fnameTextField.setEditable(false);
        lnameTextField.setEditable(false);
        
        birthTextField.setEditable(false);
        emailTextField.setEditable(false);
        phoneTextField.setEditable(false);
        Apt_noTextField.setEditable(false);
        StreetTextField2.setEditable(false);
        CityTextField1.setEditable(false);
        heightTextField.setEditable(false);
        ProgramTextArea.setEditable(false);
        weightTextField.setEditable(false);
        genderTextField.setEditable(false);
        SubscribtionTextField.setEditable(false);
        StartDateTextField.setEditable(false);
        CostTextField.setEditable(false);
        EndDateTextField.setEditable(false);
        //   subscribeComboBox.setEditable(false);
        subscribeButton.setEnabled(false);
        int size = subcribemodifyCombobox();
        for (int i = 0; i < size; i++) {
            subscribeComboBox.addItem(subscribelist.get(i));
        }
    }
    int loginid;

    ViewMemberProfile(int loginidx) {
        loginid = loginidx;
        initComponents();
        idTextField.setEditable(false);
        fnameTextField.setEditable(false);
        birthTextField.setEditable(false);
        emailTextField.setEditable(false);
        phoneTextField.setEditable(false);
        Apt_noTextField.setEditable(false);
        StreetTextField2.setEditable(false);
        CityTextField1.setEditable(false);
        heightTextField.setEditable(false);
        ProgramTextArea.setEditable(false);
        weightTextField.setEditable(false);
        genderTextField.setEditable(false);
        SubscribtionTextField.setEditable(false);
        StartDateTextField.setEditable(false);
        CostTextField.setEditable(false);
        EndDateTextField.setEditable(false);
        subscribeButton.setEnabled(false);
        int size = subcribemodifyCombobox();
        for (int i = 0; i < size; i++) {
            subscribeComboBox.addItem(subscribelist.get(i));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        fnameTextField = new javax.swing.JTextField();
        birthTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        weightTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        heightTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SubscribtionTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        StartDateTextField = new javax.swing.JTextField();
        CostTextField = new javax.swing.JTextField();
        EndDateTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        PrintButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        genderTextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProgramTextArea = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        subscribeButton = new javax.swing.JButton();
        subscribeComboBox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        branchTextField1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lnameTextField = new javax.swing.JTextField();
        nameTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        CityTextField1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        StreetTextField2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        Apt_noTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LogOutMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 34, -1, -1));

        idTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        idTextField.setToolTipText("Member's ID");
        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(idTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 230, 370, -1));

        fnameTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        fnameTextField.setToolTipText("Member's Name");
        jPanel1.add(fnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 265, 370, -1));

        birthTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        birthTextField.setToolTipText("Member's Age");
        birthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(birthTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, 370, -1));

        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        emailTextField.setToolTipText("Member's Email");
        jPanel1.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 390, 370, -1));

        phoneTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        phoneTextField.setToolTipText("Member's Phone");
        jPanel1.add(phoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 370, -1));

        weightTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        weightTextField.setToolTipText("Member's Date");
        jPanel1.add(weightTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 490, 370, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 230, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fname:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 265, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("birth:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 460, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Weight:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Height:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, -1, -1));

        heightTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        heightTextField.setToolTipText("Member's Height");
        jPanel1.add(heightTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 530, 370, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Subscribtion  :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 230, -1, -1));

        SubscribtionTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        SubscribtionTextField.setToolTipText("Member's Subscribtion Name");
        SubscribtionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubscribtionTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(SubscribtionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 230, 345, -1));

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cost:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 270, -1, -1));

        StartDateTextField.setBackground(new java.awt.Color(51, 255, 0));
        StartDateTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        StartDateTextField.setToolTipText("Start Date Of Subscribtion");
        jPanel1.add(StartDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 305, 345, -1));

        CostTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        CostTextField.setToolTipText("Member's Subscribtion Cost");
        jPanel1.add(CostTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 270, 345, -1));

        EndDateTextField.setBackground(new java.awt.Color(255, 0, 0));
        EndDateTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        EndDateTextField.setToolTipText("End Date Of Subscribtion");
        jPanel1.add(EndDateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 340, 345, -1));

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Start Date:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 305, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("End Date:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 340, -1, -1));

        PrintButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PrintButton.setText("Print");
        PrintButton.setToolTipText("Click Here To Print Member's Info");
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });
        jPanel1.add(PrintButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 610, 107, 38));

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Member Profile");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 41, -1, -1));

        genderTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        genderTextField.setToolTipText("MEmber's Gender");
        jPanel1.add(genderTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 560, 370, -1));

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Gender:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 560, -1, -1));

        editButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        editButton.setText("Edit");
        editButton.setToolTipText("Click Here To enable Editing");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        jPanel1.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 610, 107, 38));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Delete");
        jButton2.setToolTipText("Click Here To Delete Member");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 610, 107, 38));

        ProgramTextArea.setColumns(20);
        ProgramTextArea.setRows(5);
        ProgramTextArea.setToolTipText("Member's Program");
        jScrollPane1.setViewportView(ProgramTextArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 468, 508, 180));

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Training Program :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 429, -1, -1));

        saveButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        saveButton.setText("Save");
        saveButton.setToolTipText("Click Here To Save Data");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 660, 107, 42));

        subscribeButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        subscribeButton.setText("Resubscribe");
        subscribeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subscribeButtonActionPerformed(evt);
            }
        });
        jPanel1.add(subscribeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 380, -1, -1));

        subscribeComboBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel1.add(subscribeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 381, 345, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/GENDER.PNG"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(753, 41, -1, -1));

        branchTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        branchTextField1.setToolTipText("MEmber's Gender");
        jPanel1.add(branchTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, 370, -1));

        jLabel19.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Branch:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Lname:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, -1, -1));

        lnameTextField.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lnameTextField.setToolTipText("Member's Name");
        jPanel1.add(lnameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 370, -1));

        nameTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nameTextField1.setToolTipText("Member's Name");
        jPanel1.add(nameTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 265, 232, -1));

        jLabel20.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Fname:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(612, 265, -1, -1));

        CityTextField1.setToolTipText("Enter Member's Address");
        CityTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(CityTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 460, 100, -1));

        jLabel22.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("City:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 460, -1, -1));

        StreetTextField2.setToolTipText("Enter Member's Address");
        StreetTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StreetTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(StreetTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 100, -1));

        jLabel23.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Street:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 460, -1, -1));

        Apt_noTextField.setToolTipText("Enter Member's Address");
        Apt_noTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apt_noTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(Apt_noTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 40, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/AUSER.PNG"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 720));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogOutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutMenuActionPerformed
        JOptionPane.showMessageDialog(null, "Logout Sucessfull.....");
        dispose();
        new login().setVisible(true);     }//GEN-LAST:event_LogOutMenuActionPerformed

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        PrintMember obj = new PrintMember();
        obj.MemberTextArea.setText("ID :\t" + idTextField.getText() + "\nFname :\t" + fnameTextField.getText()+ "\nLname :\t" + lnameTextField.getText() + "\nAge :\t" + birthTextField.getText() + "\nEmail"
                + " :\t" + emailTextField.getText() + "\nPhone :\t" + phoneTextField.getText() + "\nAddress \t" + Apt_noTextField.getText()+ StreetTextField2.getText() + CityTextField1.getText() + "\nWeight :\t" + weightTextField.getText()
                + "\nHeight :\t" + heightTextField.getText() + "\nGender :\t" + genderTextField.getText() + "\nSubsribtion :\t" + SubscribtionTextField.getText() + ""
                + "\nCost :\t" + CostTextField.getText() + "\nStart Date :+\t" + StartDateTextField.getText() + "\nEnd Date :\t" + EndDateTextField.getText() + "\nProgram :\n\n" + ProgramTextArea.getText());
        obj.setVisible(true);
    }//GEN-LAST:event_PrintButtonActionPerformed

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        //   loginid = 2;
        if (loginid == 3) {
            fnameTextField.setEditable(true);
            lnameTextField.setEditable(true);
            
            birthTextField.setEditable(true);
            
            
            emailTextField.setEditable(true);
            phoneTextField.setEditable(true);
            Apt_noTextField.setEditable(true);
            StreetTextField2.setEditable(true);
            CityTextField1.setEditable(true);
            heightTextField.setEditable(true);
            weightTextField.setEditable(true);
            genderTextField.setEditable(true);
            subscribeButton.setEnabled(true);
            subscribeComboBox.setEditable(true);
        } else if (loginid == 2) {
            ProgramTextArea.setEditable(true);
        }
        //  subscribeButton.setEnabled(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        receptionist.deletemember(Integer.parseInt(idTextField.getText()));
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SubscribtionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubscribtionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SubscribtionTextFieldActionPerformed

    utils.utilsFunctions utilfuncs =new utilsFunctions();
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (loginid == 3) {
            if (utilfuncs.checkname(fnameTextField.getText())
                    && utilfuncs.checkemail(emailTextField.getText())
                    && utilfuncs.checkphone(phoneTextField.getText())
                    && utilfuncs.checkage(birthTextField.getText())
                    && utilfuncs.checkaddress(Apt_noTextField.getText() + " " + StreetTextField2.getText() + " " +CityTextField1.getText())) {
                try {
                    Member member = new Member(fnameTextField.getText(),lnameTextField.getText(),
                            Date.valueOf(birthTextField.getText()), Integer.parseInt(weightTextField.getText()),
                            Integer.parseInt(heightTextField.getText()), Long.parseLong(phoneTextField.getText()),
                            emailTextField.getText(), Integer.parseInt(Apt_noTextField.getText()),StreetTextField2.getText(),CityTextField1.getText(), genderTextField.getText());
                    member.setID(Integer.parseInt(idTextField.getText()));
                    if (receptionist.editmember(member)) {
                        JOptionPane.showMessageDialog(null, "Editted successfully...");
                    }
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            } else if (loginid == 2) {
                Trainer trainer = new Trainer();
                try {
                    if (trainer.generateprogram(fnameTextField.getText(), ProgramTextArea.getText())) {
                        JOptionPane.showMessageDialog(null, "Editted successfully...");
                    }
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void subscribeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subscribeButtonActionPerformed
        String membername = fnameTextField.getText();
        receptionist.resubscribe(subscribeComboBox.getSelectedItem().toString(), membername);
        User user = new User();

        ResultSet rs = user.SearchMember(membername);
        try {
            StartDateTextField.setText(rs.getDate("STARTDATE").toString());
            EndDateTextField.setText(rs.getDate("ENDDATE").toString());
            SubscribtionTextField.setText(rs.getString("PACKAGE_NAME"));
            CostTextField.setText(Integer.toString(rs.getInt("PACKAGE_COST")));
        } catch (SQLException ex) {
            Logger.getLogger(ViewMemberProfile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_subscribeButtonActionPerformed

    private void birthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(ViewMemberProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMemberProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMemberProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMemberProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new ViewMemberProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Apt_noTextField;
    public javax.swing.JTextField CityTextField1;
    public javax.swing.JTextField CostTextField;
    public javax.swing.JTextField EndDateTextField;
    private javax.swing.JMenuItem LogOutMenu;
    private javax.swing.JButton PrintButton;
    public javax.swing.JTextArea ProgramTextArea;
    public javax.swing.JTextField StartDateTextField;
    public javax.swing.JTextField StreetTextField2;
    public javax.swing.JTextField SubscribtionTextField;
    public javax.swing.JTextField birthTextField;
    public javax.swing.JTextField branchTextField1;
    private javax.swing.JButton editButton;
    public javax.swing.JTextField emailTextField;
    public javax.swing.JTextField fnameTextField;
    public javax.swing.JTextField genderTextField;
    public javax.swing.JTextField heightTextField;
    public javax.swing.JTextField idTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField lnameTextField;
    public javax.swing.JTextField nameTextField1;
    public javax.swing.JTextField phoneTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton subscribeButton;
    private javax.swing.JComboBox<String> subscribeComboBox;
    public javax.swing.JTextField weightTextField;
    // End of variables declaration//GEN-END:variables
}
