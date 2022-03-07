package gymms.Forms;

import gymms.classes.Gymowner;
import gymms.classes.Member;
import gymms.classes.Package;
import javax.swing.JOptionPane;

public class AddPackage extends javax.swing.JFrame {

    Gymowner gymowner = new Gymowner();

    public AddPackage() {
        initComponents();
    }

    int loginidx;
    AddPackage(int loginid) {
        initComponents();
        loginidx = loginid;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        returnmainpageButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nameTextfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        costTextfield = new javax.swing.JTextField();
        durationSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        descriptionTextfield = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        returnmainpageButton.setText("Back To Main Page");
        returnmainpageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnmainpageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(returnmainpageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 40)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add Package");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        nameTextfield.setToolTipText("Enter Package's Name");
        nameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextfieldActionPerformed(evt);
            }
        });
        jPanel1.add(nameTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 224, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cost:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        costTextfield.setToolTipText("Enter Package's Cost");
        jPanel1.add(costTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 224, -1));

        durationSpinner.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        durationSpinner.setToolTipText("Select Duration's Months");
        durationSpinner.setValue(1);
        jPanel1.add(durationSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 224, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Duration / month:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Description:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        descriptionTextfield.setToolTipText("Enter Package's Discription");
        jPanel1.add(descriptionTextfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 224, -1));

        addButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addButton.setText("ADD");
        addButton.setToolTipText("Click To Add The Package");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 100, 34));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/istockphoto-1213615964-170667a.PNG.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        if (nameTextfield.getText().isEmpty()
                || costTextfield.getText().isEmpty()
                || durationSpinner.getValue().equals(0)
                || descriptionTextfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Missing");
        } else {
            try {
                Package packagee = new Package(nameTextfield.getText(),
                        descriptionTextfield.getText(),
                        Integer.parseInt(costTextfield.getText()),
                        (Integer) durationSpinner.getValue()
                );
                boolean flag = gymowner.addpackage(packagee);
                if (flag) {
                    JOptionPane.showMessageDialog(null, "ADDED");
                    // dispose();
                    //new Mainpage().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to ADD");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    
    }//GEN-LAST:event_addButtonActionPerformed

    private void nameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextfieldActionPerformed

    private void returnmainpageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnmainpageButtonActionPerformed
        dispose();
        new Mainpage(loginidx).setVisible(true);
    }//GEN-LAST:event_returnmainpageButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPackage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AddPackage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField costTextfield;
    private javax.swing.JTextField descriptionTextfield;
    private javax.swing.JSpinner durationSpinner;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JButton returnmainpageButton;
    // End of variables declaration//GEN-END:variables
}
