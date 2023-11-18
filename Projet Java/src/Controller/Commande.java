/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cleme
 */
public class Commande {

    private int id_acheteur;
    private int id_vendeur;
    private ArrayList<Integer> id_produits = new ArrayList<>();
    private ArrayList<Integer> qte_produits = new ArrayList<>();
    private ArrayList<Double> prix_produits = new ArrayList<>();
    private int num_cmd;

    public Commande(int _acheteur, int _vendeur, int _num_cmd) {
        this.id_acheteur = _acheteur;
        this.id_vendeur = _vendeur;
        this.num_cmd = _num_cmd;
    }

    public Commande(int _acheteur, int _vendeur, ArrayList<Integer> id_, ArrayList<Integer> qte_, ArrayList<Double> prix_, int _num_cmd) {
        this.id_acheteur = _acheteur;
        this.id_vendeur = _vendeur;
        this.id_produits = id_;
        this.qte_produits = qte_;
        this.prix_produits = prix_;
        this.num_cmd = _num_cmd;
    }

    public int getAcheteur() {
        return this.id_acheteur;
    }

    public int getVendeur() {
        return this.id_vendeur;
    }

    public ArrayList<Integer> getIdProduits() {
        return this.id_produits;
    }

    public ArrayList<Integer> getQteProduits() {
        return this.qte_produits;
    }

    public ArrayList<Double> getPrixProduits() {
        return this.prix_produits;
    }

    public int getNumCmd() {
        return this.num_cmd;
    }

    public void addIdProduits(int id) {
        this.id_produits.add(id);
    }

    public void addQteProduits(int qte) {
        this.qte_produits.add(qte);
    }

    public void addPrixProduits(double prix) {
        this.prix_produits.add(prix);
    }

}
