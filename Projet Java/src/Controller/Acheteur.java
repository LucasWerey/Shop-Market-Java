/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author cleme
 */
public abstract class Acheteur {

    private int id_acheteur;
    private String mdp_acheteur;
    private String mail_acheteur;
    private String nom_acheteur;
    private String prenom_acheteur;
    public String type;

    public Acheteur(int _id, String _mdp, String _mail, String _nom, String _prenom) {
        this.id_acheteur = _id;
        this.mdp_acheteur = _mdp;
        this.mail_acheteur = _mail;
        this.nom_acheteur = _nom;
        this.prenom_acheteur = _prenom;
    }

    public int getId() {
        return this.id_acheteur;
    }

    public String getMdp() {
        return this.mdp_acheteur;
    }

    public String getMail() {
        return this.mail_acheteur;
    }

    public String getNom() {
        return this.nom_acheteur;
    }

    public String getPrenom() {
        return this.prenom_acheteur;
    }

    public String getType() {
        return this.type;
    }

}
