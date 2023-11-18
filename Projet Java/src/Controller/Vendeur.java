/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author lucas
 */
public class Vendeur {

    private int id_vendeur;
    private String mdp_vendeur;
    private String mail_vendeur;
    private String nom_vendeur;
    private String prenom_vendeur;

    /**
     * Construct an employee with all his informations.
     *
     * @param lastName : last name of the employee
     * @param password : password of the employee
     * @param name : name of the employee
     * @param username : username of the employee
     */
    public Vendeur(int _id, String _mdp, String _mail, String _nom, String _prenom) {
        this.id_vendeur = _id;
        this.mdp_vendeur = _mdp;
        this.mail_vendeur = _mail;
        this.nom_vendeur = _nom;
        this.prenom_vendeur = _prenom;
    }

    /*----------------------------- guetters and setters -----------------------------*/
    /**
     * Return the username of the employee
     *
     * @return the username
     */
    public int getId() {
        return this.id_vendeur;
    }

    /**
     * Return the password of the employee
     *
     * @return the password
     */
    public String getMdp() {
        return this.mdp_vendeur;
    }

    public String getMail() {
        return this.mail_vendeur;
    }

    public String getNom() {
        return this.nom_vendeur;
    }

    public String getPrenom() {
        return this.prenom_vendeur;
    }
}
