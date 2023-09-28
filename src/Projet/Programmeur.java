package Projet;

import utils.helper;

import java.util.Scanner;

/**
 * Cette classe représente un programmeur avec des informations telles que le prénom, le nom, la date de naissance,
 * le salaire, la prime et le pseudo.
 */
public class Programmeur {
    private String prenom;
    private String nom;
    private String date;
    private float salaire;
    private float prime;
    private String pseudo;

    private int id;

    /**
     * Constructeur par défaut de la classe Programmeur.
     */
    public Programmeur(){}

    /**
     * Constructeur avec des paramètres pour initialiser un objet Programmeur.
     *
     * @param prenom Le prénom du programmeur.
     * @param nom Le nom du programmeur.
     * @param date La date de naissance du programmeur.
     * @param salaire Le salaire du programmeur.
     * @param prime La prime du programmeur.
     * @param pseudo Le pseudo du programmeur.
     */
    public Programmeur(String prenom, String nom, String date, float salaire, float prime, String pseudo) {
        this.prenom = prenom;
        this.nom = nom;
        this.date = date;
        this.salaire = salaire;
        this.prime = prime;
        this.pseudo = pseudo;
    }

    /**
     * Récupère le prénom du programmeur.
     *
     * @return Le prénom du programmeur.
     */
    public String getPrenom(){
        return this.prenom;
    }

    /**
     * Récupère le nom du programmeur.
     *
     * @return Le nom du programmeur.
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Récupère la date de naissance du programmeur.
     *
     * @return La date de naissance du programmeur.
     */
    public String getDate(){
        return this.date;
    }

    /**
     * Récupère le salaire du programmeur.
     *
     * @return Le salaire du programmeur.
     */
    public float getSalaire(){
        return this.salaire;
    }

    /**
     * Récupère la prime du programmeur.
     *
     * @return La prime du programmeur.
     */
    public float getPrime(){
        return this.prime;
    }

    /**
     * Récupère le pseudo du programmeur.
     *
     * @return Le pseudo du programmeur.
     */
    public String getPseudo(){
        return this.pseudo;
    }

    /**
     * Récupère l'id du programmeur.
     *
     * @return id Le nouvel id du programmeur.
     */
    public int getId()
    {
        return id;
    }

    /**
     * Modifie le prénom du programmeur.
     *
     * @param prenom Le nouveau prénom du programmeur.
     */
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    /**
     * Modifie le nom du programmeur.
     *
     * @param nom Le nouveau nom du programmeur.
     */
    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     * Modifie la date de naissance du programmeur.
     *
     * @param date La nouvelle date de naissance du programmeur.
     */
    public void setDate(String date){
        this.date = date;
    }

    /**
     * Modifie le salaire du programmeur.
     *
     * @param salaire Le nouveau salaire du programmeur.
     */
    public void setSalaire(float salaire){
        this.salaire = salaire;
    }

    /**
     * Modifie la prime du programmeur.
     *
     * @param prime La nouvelle prime du programmeur.
     */
    public void setPrime(float prime){
        this.prime = prime;
    }

    /**
     * Modifie le pseudo du programmeur.
     *
     * @param pseudo Le nouveau pseudo du programmeur.
     */
    public void setPseudo(String pseudo){
        this.pseudo = pseudo;
    }

    /**
     * Créér un programmeur en demandant à l'utilisateur les informations nécessaires
     * @return
     */
    public static Programmeur scanProgrammeur() {
        Scanner sc = new Scanner(System.in);
        Programmeur p;

        System.out.println("Ajoutons un nouveau programmeur");
        System.out.println("Entrez son prénom :");
        String prénom = sc.next();
        System.out.println("Entrez son nom :");
        String nom = sc.next();
        System.out.println("Entrez sa date de naissance :");
        String date = sc.next();
        System.out.println("Entrez son pseudo :");
        String pseudo = sc.next();
        System.out.println("Entrez son salaire :");
        float salaire = helper.askFloat();
        System.out.println("Entrez sa prime :");
        float prime = helper.askFloat();

        p = new Programmeur(prénom, nom, date, salaire, prime, pseudo);

        return (p);
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'objet Programmeur.
     *
     * @return Une chaîne de caractères représentant l'objet Programmeur.
     */
    @Override
    public String toString()
    {
        return  "Id      : " + id + '\n' +
                "Nom     : " + nom + '\n' +
                "Prenom  : " + prenom + '\n' +
                "Pseudo  : " + pseudo + '\n' +
                "Date    : " + date + '\n' +
                "Salaire : " + salaire + '\n' +
                "Prime   : " + prime + '\n' +
                "----------------------------------------";
    }
}