package gymms.Forms;

import gymms.classes.Trainer;
import javax.swing.JOptionPane;

public class AddProgram extends javax.swing.JFrame {

    Trainer trainer = new Trainer();

    
    public AddProgram() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MemberSearchTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProgramTextArea = new javax.swing.JTextArea();
        AddProgramButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backmainpageButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MemberSearchTextField.setToolTipText("Enter Member's ID Or Name");
        jPanel1.add(MemberSearchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 152, 206, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter ID or (Name) :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 154, -1, -1));

        ProgramTextArea.setColumns(20);
        ProgramTextArea.setRows(5);
        ProgramTextArea.setText("Saturday: \nSunday:\nMonday: ");
        ProgramTextArea.setToolTipText("Enter A Suitable Program For A Member");
        jScrollPane1.setViewportView(ProgramTextArea);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 235, 368, 174));

        AddProgramButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AddProgramButton.setText("ADD");
        AddProgramButton.setToolTipText("Click Here To Add The Program");
        AddProgramButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProgramButtonActionPerformed(evt);
            }
        });
        jPanel1.add(AddProgramButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 422, 68, 30));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add Training Program");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 70, 368, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Training Program:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 192, -1, 25));

        backmainpageButton.setText("Back to main page");
        backmainpageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backmainpageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backmainpageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 143, 39));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gymms/Forms/AUSER.PNG"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -110, 540, 620));

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

    private void AddProgramButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProgramButtonActionPerformed

        if (MemberSearchTextField.getText().isEmpty() || ProgramTextArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Missing");
        } else {
            try {
                gymms.classes.Member member = new gymms.classes.Member();
                boolean flag = trainer.generateprogram(MemberSearchTextField.getText(), ProgramTextArea.getText());
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
    }//GEN-LAST:event_AddProgramButtonActionPerformed

    private void backmainpageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backmainpageButtonActionPerformed
        dispose();
        new Mainpage(2).setVisible(true);
        
    }//GEN-LAST:event_backmainpageButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddProgram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProgram().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProgramButton;
    public javax.swing.JTextField MemberSearchTextField;
    private javax.swing.JTextArea ProgramTextArea;
    private javax.swing.JButton backmainpageButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
