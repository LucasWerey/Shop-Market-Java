/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author cleme
 */
public class Produit {

    private int id_produit;
    private String nom_produit;
    private double prix;
    private int qte_reduc;
    private double prix_reduc;
    private byte[] image;

    public Produit(int _id, String _nom, double _prix, int _qter, double _prixr, byte[] image) {

        this.id_produit = _id;
        this.nom_produit = _nom;
        this.prix = _prix;
        this.qte_reduc = _qter;
        this.prix_reduc = _prixr;
        this.image = image;
    }

    public int getId() {
        return this.id_produit;
    }

    public String getNom() {
        return this.nom_produit;
    }

    public double getPrix() {
        return this.prix;
    }

    public int getQteReduc() {
        return this.qte_reduc;
    }

    public double getPrixReduc() {
        return this.prix_reduc;
    }

    public byte[] getMyImage() {
        return this.image;
    }

    public void updateProduit(String _nom, double _prix, int _qter, double _prixr) {
        this.nom_produit = _nom;
        this.prix = _prix;
        this.qte_reduc = _qter;
        this.prix_reduc = _prixr;
    }

}
