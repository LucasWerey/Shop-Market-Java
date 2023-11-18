/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author cleme
 */
public class Guest extends Acheteur {

    public Guest(int _id, String _mdp, String _mail, String _nom, String _prenom) {
        super(_id, _mdp, _mail, _nom, _prenom);
        this.type = "g";
    }
}
