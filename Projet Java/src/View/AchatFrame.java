/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ProjetJava;
import Controller.*;
import javax.swing.ImageIcon;
import Controller.Produit;
import Model.ConnectionDataBase;
import java.awt.Cursor;
import java.awt.Image;
import java.io.File;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import static javax.management.Query.gt;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas
 */
public class AchatFrame extends javax.swing.JFrame {

    /**
     * Creates new form AchatFrame
     */
    private ProjetJava projet;
    private WelcomeFrame welcomeFrame;
    private LoginFrame previousFrame;
    private char type;
    private int idAcheteur;
    private Commande commande;

    //private ArrayList<JLabel> imageP = new ArrayList<>();
    public AchatFrame() {
        initComponents();
    }

    // Type c g ou m tu les fais passer en para depuis la frame Login
    public AchatFrame(ProjetJava projet, char type, WelcomeFrame welcome, LoginFrame previousFrame, int IdAcheteur) {
        initComponents();
                
        this.projet = projet;
        this.type = type;
        this.welcomeFrame = welcome;
        this.previousFrame = previousFrame;
        this.idAcheteur = IdAcheteur;
        
        //Init images de la frame
        ImageIcon fond = new ImageIcon("Fond.png");
        Fond.setIcon(fond);
        ImageIcon b = new ImageIcon("Retour.png");
        Retour.setIcon(b);
        
        //num de commande aléatoire
        int cmd = CmdAlea();
        //sélection d'un vendeur aleatoirement
        Random r = new Random();
        int n = r.nextInt(projet.getVendeurs().size());
        //création d'une nouvelle commande
        for (int i = 0; i < projet.getAcheteurs().size(); i++) {
            if (projet.getAcheteurs().get(i).getId() == idAcheteur) {
                this.commande = new Commande(idAcheteur, projet.getVendeurs().get(n).getId(), cmd);
            }
        }
        
        // Init Jtable
        DefaultTableModel dm = (DefaultTableModel) Table.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();

        // Update la table
        for (int i = 0; i < projet.getProduits().size(); i++) {
            String id = String.valueOf(projet.getProduits().get(i).getId());
            String nom = projet.getProduits().get(i).getNom();
            String prix = String.valueOf(projet.getProduits().get(i).getPrix() + " €");
            int qte = (int) projet.getProduits().get(i).getQteReduc();
            String reduc = String.valueOf(qte + " units for " + projet.getProduits().get(i).getPrixReduc() + " €");
            
            String Table1[] = {id, nom, prix, reduc};
            DefaultTableModel Tblmodel = (DefaultTableModel) Table.getModel();
            Tblmodel.addRow(Table1);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pprice = new javax.swing.JLabel();
        ImageP = new javax.swing.JLabel();
        Pname = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        TotalPrice = new javax.swing.JLabel();
        Retour = new javax.swing.JButton();
        Payement = new javax.swing.JButton();
        Fond = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Pprice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Pprice.setText("Price");
        getContentPane().add(Pprice);
        Pprice.setBounds(450, 40, 50, 17);

        ImageP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(ImageP);
        ImageP.setBounds(20, 70, 490, 440);

        Pname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Pname.setText("Product Name ");
        getContentPane().add(Pname);
        Pname.setBounds(40, 40, 170, 17);

        Table.setAutoCreateRowSorter(true);
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Price ", "Reduction for members"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setToolTipText("");
        Table.setName(""); // NOI18N
        Table.setShowGrid(false);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(540, 10, 650, 270);

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToggleButton1.setText("Add to your basket");
        jToggleButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(170, 520, 180, 30);

        jPanel1.setBackground(new java.awt.Color(207, 199, 216));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Your Basket");

        jToggleButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jToggleButton2.setText("Delete the product");
        jToggleButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToggleButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Total price :");

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Price "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table1);

        TotalPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TotalPrice.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287)
                        .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TotalPrice)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(540, 290, 650, 290);

        Retour.setBackground(new java.awt.Color(207, 199, 216));
        Retour.setBorder(null);
        Retour.setBorderPainted(false);
        Retour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetourActionPerformed(evt);
            }
        });
        getContentPane().add(Retour);
        Retour.setBounds(10, 560, 70, 50);

        Payement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Payement.setText("Payment");
        Payement.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Payement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Payement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayementActionPerformed(evt);
            }
        });
        getContentPane().add(Payement);
        Payement.setBounds(730, 580, 280, 23);
        getContentPane().add(Fond);
        Fond.setBounds(0, 0, 1200, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // mouse click

        int number = Table.getSelectedRow();
        int id = Integer.parseInt(Table.getValueAt(number, 0).toString());
        
        Pname.setText(Table.getValueAt(number, 1).toString());
        Pprice.setText(Table.getValueAt(number, 2).toString());

        // AFFICHAGE IMAGE PRODUIT 
        for (int i = 0; i < projet.getProduits().size(); i++) {
            if (projet.getProduits().get(i).getId() == id) {
                byte[] img = projet.getProduits().get(i).getMyImage();
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image imageprod = im.getScaledInstance(ImageP.getWidth(), ImageP.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon improd = new ImageIcon(imageprod);
                ImageP.setIcon(improd);
            }
            
        }
        
    }//GEN-LAST:event_TableMouseClicked
    
    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Table1MouseClicked
    
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // Ajout de produits au panier 
        int number = Table.getSelectedRow();
        
        String id = Table.getValueAt(number, 0).toString();
        String nom = Table.getValueAt(number, 1).toString();
        String prix = Table.getValueAt(number, 2).toString();
        
        DefaultTableModel dm = (DefaultTableModel) Table1.getModel();
        
        String Table1[] = {id, nom, prix};
        dm.addRow(Table1);

        // FAIRE LA SOMME POUR TROUVER LE PRIX TOTAL
        String labelTotal = TotalPrice.getText();
        float totalprice = Float.parseFloat(labelTotal) + Float.parseFloat(prix.replaceAll(" €", ""));
        TotalPrice.setText(Float.toString(totalprice));
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    
    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        

        // FAIRE LA SOUSTRACTION POUR TROUVER LE PRIX TOTAL
        int number = Table.getSelectedRow();
        String prix = Table.getValueAt(number, 2).toString();
        
        String labelTotal = TotalPrice.getText();
        float totalprice = Float.parseFloat(labelTotal) - Float.parseFloat(prix);
        TotalPrice.setText(Float.toString(totalprice));

        // SUPPRIMER PRODUIT DU PANIER
        ((DefaultTableModel) Table1.getModel()).removeRow(Table1.getSelectedRow());
        
    }//GEN-LAST:event_jToggleButton2ActionPerformed
    
    private void PayementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayementActionPerformed
       
        
        while (Table1.getRowCount() != 0) {
            //Récupération d'un premier produit de la table
            String id_produit = Table1.getValueAt(0, 0).toString();
            // SUPPRIMER PRODUIT DU PANIER
            ((DefaultTableModel) Table1.getModel()).removeRow(0);
            int qte_prod = 1;
            for (int i = Table1.getRowCount() - 1; i >= 0; i--) {
                if (Table1.getValueAt(i, 0).toString().equals(id_produit)) {
                    qte_prod++;
                    ((DefaultTableModel) Table1.getModel()).removeRow(i);
                }
            }
            double price = 0;
            int qte = qte_prod;
            String typeach = "";
            for (int i = 0; i < projet.getAcheteurs().size(); i++) {
                if (projet.getAcheteurs().get(i).getId() == commande.getAcheteur()) {
                    typeach = projet.getAcheteurs().get(i).getType();
                }
            }
            for (int i = 0; i < projet.getProduits().size(); i++) {
                if (projet.getProduits().get(i).getId() == Integer.parseInt(id_produit)) {
                    if (typeach.equals("m")) {
                        int qte_reduc = projet.getProduits().get(i).getQteReduc();
                        double prix_reduc = projet.getProduits().get(i).getPrixReduc();
                        int nb_reduc = 0;
                        while (qte_prod - qte_reduc >= 0) {
                            nb_reduc++;
                            qte_prod = qte_prod - qte_reduc;
                        }
                        price = prix_reduc * nb_reduc + qte_prod * projet.getProduits().get(i).getPrix();
                    } else {
                        price = qte_prod * projet.getProduits().get(i).getPrix();
                    }
                    
                }
            }
            this.commande.addIdProduits(Integer.parseInt(id_produit));
            this.commande.addQteProduits(qte);
            this.commande.addPrixProduits(price);
        }

        // projet.addCommande(this.commande);
        //Changement de frame
        //  this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        PaymentFrame paye = new PaymentFrame(welcomeFrame, this, projet, this.commande.getNumCmd(), this.commande, this.type, this.idAcheteur, this.previousFrame);
        welcomeFrame.fullScreen(paye, this);
    }//GEN-LAST:event_PayementActionPerformed
    
    private void RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetourActionPerformed
        
        // Retour frame précédente
        
        if (type == 'g') {
            LoginFrame back = new LoginFrame(welcomeFrame, projet);
            welcomeFrame.fullScreen(back, this);
        } else if (type == 'm') {
            BuyerFrame buy = new BuyerFrame(welcomeFrame, projet, previousFrame, idAcheteur);
            welcomeFrame.fullScreen(buy, this);
        }
    }//GEN-LAST:event_RetourActionPerformed

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
            java.util.logging.Logger.getLogger(AchatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AchatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AchatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AchatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AchatFrame().setVisible(true);
                
            }
        });
    }
    
    // Générateur ID cmd aléatoire
    public int CmdAlea() {
        Random r = new Random();
        int n = r.nextInt(1000);
        
        for (int i = 0; i < projet.getCommandes().size(); i++) {
            if (n == projet.getCommandes().get(i).getNumCmd()) {
                CmdAlea();
            }
        }
        // System.out.println(n); 
        return n;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fond;
    private javax.swing.JLabel ImageP;
    private javax.swing.JButton Payement;
    private javax.swing.JLabel Pname;
    private javax.swing.JLabel Pprice;
    private javax.swing.JButton Retour;
    private javax.swing.JTable Table;
    private javax.swing.JTable Table1;
    private javax.swing.JLabel TotalPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}