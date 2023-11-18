package Model;

import Controller.*;
import Controller.Vendeur;
import Controller.Acheteur;
import Controller.Produit;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Connect the project with the data base, make queries to retrieve values,
 * delete rows, add some new rows and columns, alter tables and update tables.
 *
 * @author
 * @author
 * @author
 */
public class ConnectionDataBase {

    private Connection con;
    private final Statement stmt;
    private final Statement stmt2;
    private ResultSet resultats;
    private boolean order;
    private String columnName;

    /*private Shopping shopping;
    private int nbCustomerBeforeChange;
    private boolean order;
    private String columnName;*/
    /**
     * Create the connection with the shopping database with a specific username
     * and password, initialize shopping parameter, resultats is initialize to
     * null.
     *
     * @param shopping : class which contains acheteurs,vendeurs, produits,
     * commande et facture
     * @throws SQLException : provides information on a database access error or
     * other errors
     * @throws ClassNotFoundException : when an application tries to load in a
     * class through its string name using: the forName method in class Class,
     * the findSystemClass method in class ClassLoader ot the loadClass method
     * in class ClassLoader
     */
    public ConnectionDataBase(ProjetJava projetjava) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        resultats = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "shopping" + "?verifyServerCertificate=false&useSSL=true", "root", "");

        stmt = con.createStatement();
        stmt2 = con.createStatement();

        this.order = true;
    }

    public ArrayList<Vendeur> initializeVendeurs() {
        ArrayList<Vendeur> vendeurs = new ArrayList<>();
        try {
            resultats = stmt.executeQuery("SELECT * FROM vendeur");
            while (resultats.next()) {
                Vendeur vendeur = new Vendeur(resultats.getInt(1), resultats.getString(2), resultats.getString(3), resultats.getString(4), resultats.getString(5));
                vendeurs.add(vendeur);
            }
        } catch (SQLException e) {
            System.out.println("pb with vendeur table");
        }
        System.out.println("Les vendeurs ont été récupérés et enregistrés");
        return vendeurs;
    }

    public void addVendeur(Vendeur vendeur) {
        try {
            stmt.executeUpdate("INSERT INTO `vendeur`(`id_vendeur`, `mdp_vendeur`, `mail_vendeur`, `nom_vendeur`, `prenom_vendeur`) VALUES (" + vendeur.getId() + ", '" + vendeur.getMdp() + "', '" + vendeur.getMail() + "', '" + vendeur.getNom() + "', '" + vendeur.getPrenom() + "')");
        } catch (SQLException e) {
            System.out.println("new vendeur's datas have not been saved");
        }
    }

    /**
     * Retrieve acheteurs datas with a query, fill the list of acheteurs with
     * id, password, mail, last name, name, num_cmd and return the list of
     * acheteurs.
     *
     * @return an array list of acheteur from the database
     */
    public ArrayList<Acheteur> initializeAcheteurs() {
        ArrayList<Acheteur> acheteurs = new ArrayList<>();
        try {
            resultats = stmt.executeQuery("SELECT * FROM acheteur");
            while (resultats.next()) {
                //Ce sont des membres
                if ("m".equals(resultats.getString(6))) {
                    Member member = new Member(resultats.getInt(1), resultats.getString(2), resultats.getString(3), resultats.getString(4), resultats.getString(5));
                    acheteurs.add(member);
                } else {
                    //Ce sont des guest
                    Guest guest = new Guest(resultats.getInt(1), resultats.getString(2), resultats.getString(3), resultats.getString(4), resultats.getString(5));
                    acheteurs.add(guest);
                }

            }
        } catch (SQLException e) {
            System.out.println("pb with acheteur table");
        }
        // we return the list of acheteurs
        System.out.println("Les acheteurs ont été récupérés et enregistrés");
        return acheteurs;
    }

    /**
     * Create a new array list of produits, browse the produits of the database,
     * add a new produit in the array list of produits with every
     * characteristics of the produit (id,name,prix)
     *
     * @return an array list of produits from the database
     */
    public ArrayList<Produit> initializeProduits() {
        ArrayList<Produit> produits = new ArrayList<>();

        try {
            //  if(order)
            //      resultats = stmt.executeQuery("SELECT * FROM produit ORDER BY `id_produit` ASC");
            //  else
            //      resultats = stmt.executeQuery("SELECT * FROM produit ORDER BY `id_produit` DESC");
            resultats = stmt.executeQuery("SELECT * FROM produit");
            while (resultats.next()) // we browse the rows (every products)
            {
                Produit produit = new Produit(resultats.getInt(1), resultats.getString(2), resultats.getDouble(3), resultats.getInt(4), resultats.getDouble(5), resultats.getBytes(6));
                // produit.setFile(resultats.getString(4));
                produits.add(produit);
            }

        } catch (SQLException e) {
            System.out.println("problem with produit table");
        }
        System.out.println("Les produits ont été récupérés et enregistrés");
        return produits;
    }

    public ArrayList<Commande> initializeCommandes() {

        ArrayList<Commande> commandes = new ArrayList<>();
        ResultSet sqlfacture;
        ResultSet sqlcommande;

        try {
            sqlcommande = stmt2.executeQuery("SELECT * FROM commande");
            while (sqlcommande.next()) {
                Commande commande = new Commande(sqlcommande.getInt("id_acheteur"), sqlcommande.getInt("id_vendeur"), sqlcommande.getInt("num_cmd"));
                commandes.add(commande);
            }
        } catch (SQLException e) {
            System.out.println("problem with commande table");
        }

        try {
            sqlfacture = stmt.executeQuery("SELECT * FROM facture");
            while (sqlfacture.next()) {
                for (int i = 0; i < commandes.size(); i++) {
                    if (commandes.get(i).getNumCmd() == sqlfacture.getInt("num_cmd")) {

                        commandes.get(i).addIdProduits(sqlfacture.getInt("id_produit"));
                        commandes.get(i).addQteProduits(sqlfacture.getInt("qte_produit"));
                        commandes.get(i).addPrixProduits(sqlfacture.getDouble("prix"));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("problem with facture table");
        }

        System.out.println("Les commandes ont été récupérées et enregistrées");
        return commandes;
    }

    public void addCommande(Commande commande) {
        try {

            stmt.executeUpdate("INSERT INTO `commande`(`num_cmd`, `id_acheteur`, `id_vendeur`) VALUES (" + commande.getNumCmd() + ", " + commande.getAcheteur() + ", " + commande.getVendeur() + ")");
            for (int i = 0; i < commande.getIdProduits().size(); i++) {
                stmt.executeUpdate("INSERT INTO `facture`(`num_cmd`, `id_produit`, `qte_produit`, `prix`) VALUES (" + commande.getNumCmd() + ", " + commande.getIdProduits().get(i) + ", " + commande.getQteProduits().get(i) + ", " + commande.getPrixProduits().get(i) + ")");
            }
        } catch (SQLException e) {
            System.out.println("new commande's datas have not been saved");
        }
    }

    /**
     * Add a new acheteur in the database.
     *
     * @param acheteur : acheteur to add in the database
     */
    public void addAcheteur(Acheteur acheteur) {
        try {
            stmt.executeUpdate("INSERT INTO `acheteur`(`id_acheteur`, `mdp_acheteur`, `mail_acheteur`, `nom_acheteur`, `prenom_acheteur`, `type`) VALUES (" + acheteur.getId() + ", '" + acheteur.getMdp() + "', '" + acheteur.getMail() + "', '" + acheteur.getNom() + "', '" + acheteur.getPrenom() + "', '" + acheteur.getType() + "')");
        } catch (SQLException e) {
            System.out.println("new acheteur's datas have not been saved");
        }
    }

    /**
     * Delete a row of a table.
     *
     * @param primaryKey : name of the variable which permits to recognize the
     * row which should be deleted.
     * @param primaryKeyName : primary key of the table where the row sould be
     * deleted
     * @param tableName : name of the table where the row should be deleted
     */
    public void deleteRow(String primaryKey, String primaryKeyName, String tableName) {
        try {
            stmt.executeUpdate("DELETE FROM " + tableName + " WHERE " + primaryKeyName + "=" + primaryKey + "");

        } catch (SQLException e) {
            System.out.println("Row has not been deleted");
        }
    }

    /**
     * Add a new produit in the database.
     *
     * @param produit : produit to add in the database
     */
    public void addProduit(Produit produit) {
        try {
            stmt.executeUpdate("INSERT INTO `produit`(`id_produit`, `nom_produit`, `prix`, `qte_reduc`, `prix_reduc`) VALUES (" + produit.getId() + ", '" + produit.getNom() + "', " + produit.getPrix() + ", " + produit.getQteReduc() + ", " + produit.getPrixReduc() + ")");
        } catch (SQLException e) {
            System.out.println("new produit's datas have not been saved");
        }
    }

    /**
     * Replace a value in the database on a specific column and row.
     *
     * @param parameter : new value to enter in the database
     * @param type : name of the column where the value should be added
     * @param nameProduit : name of the produit where the value should be added
     */
    public void replaceProduitParameter(int Id, String nom, double prix, int qte_reduc, double prix_reduc) {
        try {

            stmt.executeUpdate("UPDATE `produit` SET `nom_produit`='" + nom + "',`prix`=" + prix + ",`qte_reduc`=" + qte_reduc + ",`prix_reduc`=" + prix_reduc + " WHERE (`id_produit`=" + Id + ")");

            System.out.println("test");
        } catch (SQLException e) {
            System.out.println("new produit's datas have not been saved");
        }
    }

    /**
     * Order the table in the database in order to order it on the produit frame
     * if the user ask it and return the matching produits
     *
     * @param order : true for ascending order or false for descending order
     * @param columnName : name of the column to order by
     * @return the array list of matching produits
     */
    public void orderProduits(boolean order, String columnName) {
        this.order = order;
        this.columnName = columnName;
    }

    /**
     * Search the produits names who matches with the user's search and return
     * the matching produits
     *
     * @param nameProduit : name of the searched produit
     * @return the array list of matching produits
     */
    public ArrayList<Produit> filterNameProduits(String nameProduit) {
        ArrayList<Produit> produits = new ArrayList<>();

        try {
            if (order) {
                resultats = stmt.executeQuery("SELECT * FROM produit WHERE name like'%" + nameProduit + "%'" + " ORDER BY `" + columnName + "` ASC");
            } else {
                resultats = stmt.executeQuery("SELECT * FROM produit WHERE name like'%" + nameProduit + "%'" + " ORDER BY `" + columnName + "` DESC");
            }

            while (resultats.next()) // we browse the rows (every produits)
            {
                Produit produit = new Produit(resultats.getInt(1), resultats.getString(2), resultats.getDouble(3), resultats.getInt(4), resultats.getDouble(5), resultats.getBytes(6));
                produits.add(produit);
            }
        } catch (SQLException e) {
            System.out.println("problem with produit table");
        }
        return produits;
    }
}
