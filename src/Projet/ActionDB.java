package Projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.helper;

/**
 * Cette classe gère les interactions avec la base de données pour récupérer et afficher les informations
 * sur les programmeurs.
 */
public class ActionDB {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String url = "jdbc:mysql://localhost:3306/bdtpjava";
    private String user = "root";
    private String password = "sqlHello!6894210";

    /**
     * Établit une connexion à la base de données et renvoie un objet Statement pour exécuter des requêtes SQL.
     *
     * @return Un objet Statement pour exécuter des requêtes SQL.
     * @throws RuntimeException Si une erreur survient lors de la création de la connexion.
     */
    public Statement getConnexion(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }

    /**
     * Récupère la liste de tous les programmeurs depuis la base de données.
     *
     * @return Une liste d'objets Programmeur contenant les informations des programmeurs.
     */
    public ArrayList<Programmeur> recupProgrammeurs(){
        ArrayList<Programmeur> listeProgrammeurs = new ArrayList<>();
        try {
            statement = getConnexion();
            ResultSet res = statement.executeQuery("SELECT * FROM programmeur");
            // Récupérer les Programmeurs
            while (res.next()){
                // Ordre : prenom, nom, date, salaire, prime, pseudo
                Programmeur p = new Programmeur(res.getString("PRENOM"), res.getString("NOM"), res.getString("ANNAISSANCE"), res.getFloat("SALAIRE"), res.getFloat("PRIME"), res.getString("PSEUDO"));
                listeProgrammeurs.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeProgrammeurs;
    }

    /**
     * Récupère la liste des programmeurs qui ne s'appellent pas "Simpson" depuis la base de données.
     *
     * @return Une liste d'objets Programmeur contenant les informations des programmeurs qui ne s'appellent pas "Simpson".
     */
    public ArrayList<Programmeur> recupProgrammeursPasSimpson(){
        ArrayList<Programmeur> listeProgrammeurs = new ArrayList<>();
        try {
            statement = getConnexion();
            ResultSet res = statement.executeQuery("SELECT * FROM programmeur WHERE NOM != \"Simpson\"");
            // Récupérer les Programmeurs
            while (res.next()){
                // Ordre : prenom, nom, date, salaire, prime, pseudo
                Programmeur p = new Programmeur(res.getString("PRENOM"), res.getString("NOM"), res.getString("ANNAISSANCE"), res.getFloat("SALAIRE"), res.getFloat("PRIME"), res.getString("PSEUDO"));
                listeProgrammeurs.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeProgrammeurs;
    }

    /**
     * Affiche tous les programmeurs récupérés depuis la base de données.
     */
    public void afficheProgrammeurs(){
        ArrayList<Programmeur> listeProgrammeurs = recupProgrammeurs();
        // Afficher tous les programmeurs
        System.out.println("On affiche les programmeurs :");
        for (Programmeur programmeur : listeProgrammeurs) {
            System.out.println(programmeur.toString());
        }
    }

    /**
     * Affiche tous les programmeurs qui ne s'appellent pas "Simpson".
     */
    public void afficheProgrammeursPasSimpson(){
        ArrayList<Programmeur> listeProgrammeurs = recupProgrammeursPasSimpson();
        // Afficher tous les programmeurs
        System.out.println("On affiche les programmeurs qui ne s'appellent pas Simpson :");
        for (Programmeur programmeur : listeProgrammeurs) {
            System.out.println(programmeur.toString());
        }
    }

    /**
     * Affiche une liste de programmeurs sélectionnés.
     *
     * @param listeProgrammeurs La liste des programmeurs à afficher.
     */
    public void afficheSelectProgrammeurs(ArrayList<Programmeur> listeProgrammeurs){
        // Afficher tous les programmeurs
        System.out.println("On affiche les programmeurs sélectionnés :");
        for (Programmeur programmeur : listeProgrammeurs) {
            System.out.println(programmeur.toString());
        }
    }

    /**
     * Affiche un programmeur selon son id
     * @param id
     */
    public void printProgrammeurById(int id)
    {
        ArrayList<Programmeur> listProgrammeur = recupProgrammeurs();
        for (Programmeur programmeur : listProgrammeur)
        {
            if (programmeur.getId() == id)
            {
                System.out.println("Programmeur n°" + id + " :");
                programmeur.toString();
                return ;
            }
        }
        System.out.println("Aucun programmeur trouvé pour cet id.");
        return ;
    }

    /**
     * Supprime un programmeur selon son id
     * @param id
     */
    public void deleteProgrammeurById(int id) {
        Statement statement = getConnexion();

        try {
            int rowsDeleted = statement.executeUpdate("DELETE FROM programmeur WHERE id = " + id);

            if (rowsDeleted > 0) {
                System.out.println("Le programmeur a été supprimé de la base de données.");
            } else {
                System.out.println("Aucun programmeur trouvé pour cet ID.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du programmeur : ");
            e.printStackTrace();
        }
    }

    /**
     * Cette méthode permet de mettre à jour le salaire d'un programmeur selon son id
     * @param id
     */
    public void updateSalaireProgrammeurById(int id)
    {
        ArrayList<Programmeur> listProgrammeur = recupProgrammeurs();
        for (Programmeur programmeur : listProgrammeur)
        {
            if (programmeur.getId() == id)
            {
                System.out.println("Modification Salaire Programmeur n°" + id + " :");
                int salaire = helper.askInteger();
                programmeur.setSalaire(salaire);
                System.out.println("Le salaire à bien été modifié.");
                return ;
            }
        }
        System.out.println("Aucun programmeur trouvé pour cet id.");
        return ;
    }

    /**
     * Cette méthode permet d'ajouter un programmeur à la base de donnée en demandant à l'utilisateur les données.
     */
    public void ajouterProgrammeur() {
        Programmeur p = Programmeur.scanProgrammeur();

        Statement statement = getConnexion();

        String sql = "INSERT INTO programmeur (prenom, nom, annaissance, salaire, prime, pseudo) VALUES ('" +
                p.getPrenom() + "', '" + p.getNom() + "', '" + p.getDate() + "', " + p.getSalaire() + ", " + p.getPrime() + ", '" + p.getPseudo() + "')";

        try {
            int rowsInserted = statement.executeUpdate(sql);

            if (rowsInserted > 0) {
                System.out.println("Le programmeur a été ajouté à la base de données.");
            } else {
                System.out.println("Erreur lors de l'ajout du programmeur.");
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du programmeur : ");
            e.printStackTrace();
        }
    }
}
