package exec;
import Projet.ActionDB;
import utils.helper;


public class Menu {

    /**
     * La méthode exécution permet à l'utilisateur d'interagir avec le menu
     */
    public void execution () {
        while (true) {

            System.out.printf("<<<<<<< MENU >>>>>>>");
            System.out.printf("1. Afficher les programmeurs");
            System.out.printf("2. Afficher un programmeur");
            System.out.printf("3. Supprimer un programmeur");
            System.out.printf("4. Ajouter un programmeur");
            System.out.printf("5. Modifier le salaire");
            System.out.printf("6. Quitter le programme");
            System.out.printf("Quel est votre choix ?");

            //lancer la bdd
            ActionDB bdd = new ActionDB();
            bdd.getConnexion();

            //lancer le menu
            int choice = helper.askInteger();
            switch (choice) {
                case 1:
                // Afficher tous les programmeurs de la BDD
                    System.out.println("Affichez tous les programmeurs :");
                    bdd.afficheProgrammeurs();
                    break;
                case 2:
                // Afficher le programmeur souhaité par l'utilisateur
                    System.out.println("Quelle est l'id du programmeur que vous souhaitez afficher ?");
                    int idPrint = helper.askInteger();
                    bdd.printProgrammeurById(idPrint);
                    break;
                case 3:
                //supprimer un programmeur
                    System.out.println("Quelle est l'id du programmeur que vous souhaitez supprimer ?");
                    int idDelete = helper.askInteger();
                    bdd.deleteProgrammeurById(idDelete);
                    break;
                case 4:
                    //ajouter un programmeur dans la base de données
                    bdd.ajouterProgrammeur();
                    break;

                case 5:
                    //modifier le salaire
                    System.out.println("Quelle est l'id du programmeur que vous souhaitez modifier le salaire ?");
                    int id5 = helper.askInteger();
                    bdd.updateSalaireProgrammeurById(id5);
                    break;
                case 6:
                    //quitter le programme
                    return;
                default:
                    System.out.println("Veuillez saisir un choix valide");
                    break;
            }
        }
    }
}