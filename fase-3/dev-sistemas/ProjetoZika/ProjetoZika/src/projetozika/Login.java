/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetozika;

import Utils.UtilsElements;
import javax.swing.JFrame;

/**
 *
 * @author Welison
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        UtilsElements.positionFrameInCenter(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBg = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        fSenha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(37, 38, 39));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBg.setBackground(new java.awt.Color(37, 38, 39));
        jBg.setPreferredSize(new java.awt.Dimension(400, 300));
        jBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Faça seu login");
        jBg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");
        jBg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 20));

        fEmail.setBackground(new java.awt.Color(55, 57, 59));
        fEmail.setForeground(new java.awt.Color(255, 255, 255));
        fEmail.setText("welison");
        fEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        fEmail.setOpaque(false);
        fEmail.setPreferredSize(new java.awt.Dimension(200, 35));
        jBg.add(fEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 240, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Senha");
        jBg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, 20));

        fSenha.setBackground(new java.awt.Color(55, 57, 59));
        fSenha.setForeground(new java.awt.Color(255, 255, 255));
        fSenha.setText("123456");
        fSenha.setCaretColor(new java.awt.Color(255, 255, 255));
        fSenha.setOpaque(false);
        fSenha.setPreferredSize(new java.awt.Dimension(200, 35));
        jBg.add(fSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 240, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(8, 253, 216));
        jButton1.setText("Entrar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(8, 253, 216)));
        jButton1.setContentAreaFilled(false);
        jButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton1.setPreferredSize(new java.awt.Dimension(200, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jBg.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 70, 30));

        lInfo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lInfo.setForeground(new java.awt.Color(255, 0, 0));
        jBg.add(lInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 160, 30));

        getContentPane().add(jBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // login
        lInfo.setText("Login ou senha inválidos");
        String login = fEmail.getText();
        String password = fSenha.getText();
        if (login.equals("welison") && password.equals("123456")) {
            this.setVisible(false);
            JFrame main = new Main();
            main.setVisible(true);
        } else {
            lInfo.setText("Login ou senha inválidos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fEmail;
    private javax.swing.JTextField fSenha;
    private javax.swing.JPanel jBg;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lInfo;
    // End of variables declaration//GEN-END:variables
}
