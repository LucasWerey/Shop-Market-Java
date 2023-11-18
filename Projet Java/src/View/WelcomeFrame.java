/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ProjetJava;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import static java.lang.System.exit;
import javax.swing.ImageIcon;

/**
 *
 * @author lucas
 */
public class WelcomeFrame extends javax.swing.JFrame {

    ProjetJava projet = new ProjetJava();

    /**
     * Creates new form WelcomeFrame
     */
    public WelcomeFrame() {
        initComponents();
         
        ImageIcon fond = new ImageIcon("welcome.png");
        Fond.setIcon(fond);
        ImageIcon croix = new ImageIcon("croix.png");
        jButton1.setIcon(croix);
        ImageIcon cust = new ImageIcon("customer.png");
        CustomerBtn.setIcon(cust);
        ImageIcon emp = new ImageIcon("employee.png");
        EmployeeBtn.setIcon(emp);
    }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CustomerBtn = new javax.swing.JButton();
        EmployeeBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        CustomerBtn.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        CustomerBtn.setText("Customer");
        CustomerBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CustomerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerBtnActionPerformed(evt);
            }
        });
        getContentPane().add(CustomerBtn);
        CustomerBtn.setBounds(280, 310, 290, 140);

        EmployeeBtn.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        EmployeeBtn.setText("Employee");
        EmployeeBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        EmployeeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EmployeeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(EmployeeBtn);
        EmployeeBtn.setBounds(720, 310, 290, 140);

        jButton1.setBackground(new java.awt.Color(207, 199, 216));
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1140, 10, 40, 40);
        getContentPane().add(Fond);
        Fond.setBounds(0, 0, 1200, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerBtnActionPerformed
        // TODO add your handling code here:
        LoginFrame log = new LoginFrame(this, projet);
        this.fullScreen(log, this);

    }//GEN-LAST:event_CustomerBtnActionPerformed

    private void EmployeeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeBtnActionPerformed
        // TODO add your handling code here:
        LoginVendeursFrame logV = new LoginVendeursFrame(this, projet);
        this.fullScreen(logV, this);
        

    }//GEN-LAST:event_EmployeeBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        exit(0);
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
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeFrame().setVisible(true);
            }
        });
    }
    
     // Sous programme pour la taille de la fenetre à l'ouverture du programme
    public static void fullScreen(javax.swing.JFrame frame, javax.swing.JFrame currentFrame) {
        frame.setVisible(true);
        GraphicsDevice device;
        currentFrame.dispose();
        // full screen 
        device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        frame.setExtendedState(frame.NORMAL);
        if (device.isFullScreenSupported()) {
            frame.setExtendedState(frame.MAXIMIZED_BOTH);;
            frame.setBounds(0, 0,1205, 665);
        } else {
            System.err.println("Le mode plein ecran n'est pas disponible");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CustomerBtn;
    private javax.swing.JButton EmployeeBtn;
    private javax.swing.JLabel Fond;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
