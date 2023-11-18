/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ProjetJava;
import javax.swing.ImageIcon;

/**
 *
 * @author lucas
 */
public class EmployeeFrame extends javax.swing.JFrame {

    /**
     * Creates new form EmployeePage
     */
    private ProjetJava projetjava;
    private WelcomeFrame welcomeFrame;
    private LoginVendeursFrame loginvendeursframe;
    private TabEmployeeFrame employeeframe;
    private int id_vend;

    public EmployeeFrame() {
        initComponents();
    }

    public EmployeeFrame(LoginVendeursFrame loginV, WelcomeFrame welcomeFrame, ProjetJava ProjetJava, int id) {
        initComponents();
        ImageIcon fond = new ImageIcon("Fond.png");
        Fond.setIcon(fond);
        ImageIcon ret = new ImageIcon("Retour.png");
        RetBtn.setIcon(ret);

        this.projetjava = ProjetJava;
        this.welcomeFrame = welcomeFrame;
        this.id_vend = id;

    }

    public EmployeeFrame(TabEmployeeFrame employeeframe, WelcomeFrame welcomeFrame, ProjetJava ProjetJava) {
        initComponents();
        ImageIcon fond = new ImageIcon("Fond.png");
        Fond.setIcon(fond);

        this.projetjava = ProjetJava;
        this.employeeframe = employeeframe;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RetBtn = new javax.swing.JButton();
        prod = new javax.swing.JButton();
        Employee = new javax.swing.JButton();
        Buyer = new javax.swing.JButton();
        DispEmp = new javax.swing.JButton();
        DispMemb = new javax.swing.JButton();
        Order = new javax.swing.JButton();
        Fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        RetBtn.setBounds(20, 570, 100, 40);

        prod.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        prod.setText("Products");
        prod.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        prod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodActionPerformed(evt);
            }
        });
        getContentPane().add(prod);
        prod.setBounds(150, 190, 900, 35);

        Employee.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Employee.setText("Add an employee");
        Employee.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Employee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(Employee);
        Employee.setBounds(150, 290, 900, 35);

        Buyer.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Buyer.setText("Add a buyer");
        Buyer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Buyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuyerActionPerformed(evt);
            }
        });
        getContentPane().add(Buyer);
        Buyer.setBounds(150, 340, 900, 37);

        DispEmp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DispEmp.setText("View Employees");
        DispEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DispEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DispEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DispEmpActionPerformed(evt);
            }
        });
        getContentPane().add(DispEmp);
        DispEmp.setBounds(150, 390, 900, 35);

        DispMemb.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DispMemb.setText("View Members");
        DispMemb.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DispMemb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DispMemb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DispMembActionPerformed(evt);
            }
        });
        getContentPane().add(DispMemb);
        DispMemb.setBounds(150, 240, 900, 35);

        Order.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Order.setText("See previous orders");
        Order.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Order.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderActionPerformed(evt);
            }
        });
        getContentPane().add(Order);
        Order.setBounds(150, 140, 900, 35);
        getContentPane().add(Fond);
        Fond.setBounds(0, 0, 1200, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetBtnActionPerformed
        
        LoginVendeursFrame log = new LoginVendeursFrame(welcomeFrame, projetjava);
        welcomeFrame.fullScreen(log, this);
    }//GEN-LAST:event_RetBtnActionPerformed

    private void OrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderActionPerformed
        TabEmployeeFrame ord = new TabEmployeeFrame(projetjava, welcomeFrame, this, id_vend, 'o');
        welcomeFrame.fullScreen(ord, this);
    }//GEN-LAST:event_OrderActionPerformed

    private void DispMembActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DispMembActionPerformed
        // TODO add your handling code here:
        TabEmployeeFrame buy = new TabEmployeeFrame(projetjava, welcomeFrame, this, id_vend, 'b');
        welcomeFrame.fullScreen(buy, this);
    }//GEN-LAST:event_DispMembActionPerformed

    private void DispEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DispEmpActionPerformed
        // TODO add your handling code here:
        TabEmployeeFrame emp = new TabEmployeeFrame(projetjava, welcomeFrame, this, 1, 'e');
        welcomeFrame.fullScreen(emp, this);
    }//GEN-LAST:event_DispEmpActionPerformed

    private void prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodActionPerformed
        // TODO add your handling code here:
        AddOrRemoveProductsFrame products = new AddOrRemoveProductsFrame(this, welcomeFrame, projetjava, id_vend);
        welcomeFrame.fullScreen(products, this);
    }//GEN-LAST:event_prodActionPerformed

    private void BuyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuyerActionPerformed
        // TODO add your handling code here:
        SignUpFrame signUp = new SignUpFrame(this, projetjava, welcomeFrame, 'e', id_vend);
        welcomeFrame.fullScreen(signUp, this);
    }//GEN-LAST:event_BuyerActionPerformed

    private void EmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeActionPerformed
        SignUpEmployeeFrame signEUp = new SignUpEmployeeFrame(this, projetjava);
        welcomeFrame.fullScreen(signEUp, this);
    }//GEN-LAST:event_EmployeeActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buyer;
    private javax.swing.JButton DispEmp;
    private javax.swing.JButton DispMemb;
    private javax.swing.JButton Employee;
    private javax.swing.JLabel Fond;
    private javax.swing.JButton Order;
    private javax.swing.JButton RetBtn;
    private javax.swing.JButton prod;
    // End of variables declaration//GEN-END:variables
}
