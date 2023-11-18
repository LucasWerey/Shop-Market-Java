/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import Model.ConnectionDataBase;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class ProjetJava {

    private ArrayList<Vendeur> vendeurs = new ArrayList<>();
    private ArrayList<Acheteur> acheteurs = new ArrayList<>();
    private ArrayList<Produit> produits = new ArrayList<>();
    private ArrayList<Commande> commandes = new ArrayList<>();
    //   private int numberOfCustomer;
    private ConnectionDataBase connection;
    //   private int firstDiscStat,secDiscStat,thirdDiscStat;

    public ProjetJava() {

        try {
            try {
                connection = new ConnectionDataBase(this);
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
                System.out.println("class issues");
            }
        } catch (SQLException e2) {
            //e2.printStackTrace();
            System.out.println("connection with database failed");
        }

        vendeurs = connection.initializeVendeurs();
        acheteurs = connection.initializeAcheteurs();
        produits = connection.initializeProduits();
        commandes = connection.initializeCommandes();
    }

    public void addAcheteurs(Acheteur acheteur) {
        acheteurs.add(acheteur);
        connection.addAcheteur(acheteur);
    }

    public void deleteAch(Acheteur acheteur) {

        for (int i = 0; i < acheteurs.size(); i++) {
            if (acheteurs.get(i) == acheteur) {
                // we save the change in the database
                connection.deleteRow(String.valueOf(acheteurs.get(i).getId()), "id_acheteur", "acheteur");
                acheteurs.remove(i);
            }
        }
    }

    public Acheteur searchAch(int _id) {
        for (int i = 0; i < acheteurs.size(); i++) {
            if (acheteurs.get(i).getId() == _id) {
                return acheteurs.get(i);
            }
        }
        return new Guest(-1, "", "", "", "");
    }

    public ArrayList<Acheteur> getAcheteurs() {
        return acheteurs;
    }

    public ArrayList<Vendeur> getVendeurs() {
        return vendeurs;
    }

    public Vendeur searchVendeur(int _id) {
        for (int i = 0; i < vendeurs.size(); i++) {
            if (vendeurs.get(i).getId() == _id) {
                return vendeurs.get(i);
            }
        }
        return new Vendeur(-1, "", "", "", "");
    }

    public void deleteVendeurs(Vendeur Vendeur) {

        for (int i = 0; i < vendeurs.size(); i++) {
            if (vendeurs.get(i) == Vendeur) {
                // we save the change in the database
                System.out.println("testvend");
                connection.deleteRow(String.valueOf(vendeurs.get(i).getId()), "id_vendeur", "vendeur");
                vendeurs.remove(i);
            }
        }
    }

    // AJOUTER ET SUPPRIMER PRODUIT ++ GETTER
    public void deleteProd(Produit produit) {

        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i) == produit) {
                // we save the change in the database
                connection.deleteRow(String.valueOf(produits.get(i).getId()), "id_produit", "produit");

                produits.remove(i);
            }
        }
    }

    public void addProduits(Produit produit) {
        produits.add(produit);
        connection.addProduit(produit);
    }

    public Produit getProduits(int i) {
        return produits.get(i);
    }

    public Produit searchProduit(int _id) {
        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getId() == _id) {
                return produits.get(i);
            }
        }
        return new Produit(-1, "", -1, -1, -1, null);
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public Produit getProduit(int i) {
        return produits.get(i);
    }

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void addCommande(Commande commande) {
        commandes.add(commande);
        connection.addCommande(commande);
    }

    public void addVendeurs(Vendeur vendeur) {
        vendeurs.add(vendeur);
        connection.addVendeur(vendeur);
    }

    public void ReplaceProduit(int Id, double prix, String nom, int qte_reduc, double prix_reduc) {
        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getId() == Id) {
                produits.get(i).updateProduit(nom, prix, qte_reduc, prix_reduc);
            }
        }
        connection.replaceProduitParameter(Id, nom, prix, qte_reduc, prix_reduc);
    }

}
