/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;

/**
 *
 * @author lucas
 */
public class Email {

    private String to;
    private String from = "cinomnes@gmail.com";
    final String username = "cinomnes@gmail.com";
    final String password = "programmingTest12.";
    private String name;
    private String lastname;
    private Commande cmd;
    private double price;
    private int num_cmd;
    private ArrayList<Produit> produits;

    public void sendEmail(Commande cmd, String nom, String prenom, String mail, ArrayList<Produit> _prod) {
        

        this.cmd = cmd;
        this.name=prenom;
        this.lastname=nom;
        this.to=mail;
        this.produits=_prod;
        this.num_cmd=cmd.getNumCmd();

        Properties props = new Properties();
       
        props.put("mail.smtp.auth", "true");
   
        props.put("mail.smtp.starttls.enable", "true");
                System.out.println("3");

        props.put("mail.smtp.host", "smtp.gmail.com");
              

        props.put("mail.smtp.port", "587");
              


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

               

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("cinomnes@gmail.com"));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            message.setSubject("Your Order Summary at ShopMarket");
            String debutmail = ("<h1> Thank you for your order " + name + "</h1> <br/> <h2><b> Your payment has been accepted.</b></h2> <br/> <br/><h3><b> Here is a summary of your order #" + num_cmd + ": </b></h3> ");
            String milieumail="";

            
            for (int i=0; i<cmd.getIdProduits().size();i++) {
                for (int j=0; j<produits.size();j++) {
                    if (cmd.getIdProduits().get(i)==produits.get(j).getId()) {
                        milieumail = milieumail+produits.get(j).getNom() + " ............... " + cmd.getQteProduits().get(i) + " ............... " + cmd.getPrixProduits().get(i) +" &euro; <br/>";
                        price=price+cmd.getPrixProduits().get(i);
                    }
                }
            }

            String finmail = ("<br/> <br/><h2><b> The total price is : " + price +" &euro; </b></h2>");
            String htmlCode = debutmail + milieumail + finmail;
            /*String htmlCode = ("<h1> Thank you for your order " + name + "</h1> <br/> <h2><b> Your payment has been accepted.</b></h2> <br/> <br/><h3><b> Here is a summary of your order #" + num_cmd + ": </b></h3> " 
                    + "<br/> <br/><h2><b> The total price is : </b></h2>");*/
            message.setContent(htmlCode, "text/html");

            // we send the message
            Transport.send(message);
            System.out.println("Sent message successfully....");


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
