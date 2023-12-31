/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ProjetJava;
import javax.swing.*;

/**
 *
 * @author lucas
 */
public class LoginVendeursFrame extends javax.swing.JFrame {

    private ProjetJava projetjava;
    private WelcomeFrame welcomeFrame;

    public LoginVendeursFrame() {
        initComponents();
    }

    /**
     * Creates new form Loginpage
     */
    public LoginVendeursFrame(WelcomeFrame welcomeFrame, ProjetJava ProjetJava) {
        initComponents();
        ImageIcon fond = new ImageIcon("Login.png");
        Fond.setIcon(fond);
        ImageIcon visible = new ImageIcon("View.png");
        ImageIcon caché = new ImageIcon("Hide.png");
        Hide.setIcon(caché);
        View.setIcon(visible);
        Hide.setVisible(false);
        this.projetjava = ProjetJava;
        this.welcomeFrame = welcomeFrame;
        LogTest.setVisible(false);
        ImageIcon ret = new ImageIcon("Retour.png");
        RetBtn.setIcon(ret);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Id = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        RetBtn = new javax.swing.JButton();
        View = new javax.swing.JLabel();
        Hide = new javax.swing.JLabel();
        LogTest = new javax.swing.JLabel();
        Fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setResizable(false);
        getContentPane().setLayout(null);

        Id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdActionPerformed(evt);
            }
        });
        getContentPane().add(Id);
        Id.setBounds(380, 290, 570, 40);

        Password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        getContentPane().add(Password);
        Password.setBounds(410, 400, 520, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Sign In");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(600, 520, 90, 23);

        RetBtn.setBackground(new java.awt.Color(207, 199, 216));
        RetBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\lucas\\Documents\\NetBeansProjects\\Projet Java v.lulu\\Projet Java\\Projet Java\\Retour.png")); // NOI18N
        RetBtn.setBorder(null);
        RetBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetBtnActionPerformed(evt);
            }
        });
        getContentPane().add(RetBtn);
        RetBtn.setBounds(40, 540, 130, 70);

        View.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ViewMousePressed(evt);
            }
        });
        getContentPane().add(View);
        View.setBounds(940, 410, 40, 30);

        Hide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HideMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HideMousePressed(evt);
            }
        });
        getContentPane().add(Hide);
        Hide.setBounds(940, 410, 40, 30);

        LogTest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LogTest.setForeground(new java.awt.Color(255, 51, 51));
        LogTest.setText("CAN'T CONNECT PLEASE CHECK YOUR LOGIN INFORMATION");
        getContentPane().add(LogTest);
        LogTest.setBounds(450, 480, 500, 30);

        Fond.setIcon(new javax.swing.ImageIcon("C:\\Users\\lucas\\Documents\\NetBeansProjects\\Projet Java v.lulu aaa\\Projet Java v.lulu\\Projet Java\\Projet Java\\Login.png")); // NOI18N
        getContentPane().add(Fond);
        Fond.setBounds(0, 0, 1200, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String password = String.valueOf(Password.getPassword());
        String mail = Id.getText();
        boolean test = true;

        for (int i = 0; i < projetjava.getVendeurs().size(); i++) {

            if (projetjava.getVendeurs().get(i).getMail().equals(mail) && projetjava.getVendeurs().get(i).getMdp().equals(password)) {
                test = false;
                EmployeeFrame emp = new EmployeeFrame(this, welcomeFrame, projetjava, projetjava.getVendeurs().get(i).getId());
                welcomeFrame.fullScreen(emp, this);

            } else if (test) {
                System.out.println("erreur d'identifiant");
                LogTest.setVisible(true);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void RetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetBtnActionPerformed
        // TODO add your handling code here:
        WelcomeFrame welcome = new WelcomeFrame();
        welcomeFrame.fullScreen(welcome, this);
    }//GEN-LAST:event_RetBtnActionPerformed

    private void ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewMouseClicked

    }//GEN-LAST:event_ViewMouseClicked

    private void ViewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewMousePressed
        Password.setEchoChar((char) 0);
        Hide.setVisible(true);
        View.setVisible(false);
    }//GEN-LAST:event_ViewMousePressed

    private void HideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HideMouseClicked

    }//GEN-LAST:event_HideMouseClicked

    private void HideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HideMousePressed
        Password.setEchoChar('*');
        Hide.setVisible(false);
        View.setVisible(true);
    }//GEN-LAST:event_HideMousePressed

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
            java.util.logging.Logger.getLogger(LoginVendeursFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginVendeursFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginVendeursFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginVendeursFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginVendeursFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fond;
    private javax.swing.JLabel Hide;
    private javax.swing.JTextField Id;
    private javax.swing.JLabel LogTest;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton RetBtn;
    private javax.swing.JLabel View;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
