package com.robot_turtle;

public class Game {

    public static int nbJoueurs;
    public static int finDuJeu = 0;

    public static void main(String[] args) {
        Menu menu = new Menu();
        nbJoueurs = menu.getNombreJoueurs();
        GestionJoueurs joueurs = new GestionJoueurs(nbJoueurs); // Lance la création des joueurs
        GestionJoyaux joyaux = new GestionJoyaux(nbJoueurs); // Lance la création des joyaux
        //GestionObstacles obstacles = new GestionObstacles(nbJoueurs);
        Plateau plateau = new Plateau();
        plateau.afficherPlateauInit(nbJoueurs); // Affiche plateau initial

        int joueurActuel = 0;
        while (finDuJeu == 0) {
            joueurs.getListeJoueurs().get(joueurActuel).instruction(plateau); // Lance les tours de jeu
            joueurActuel++;
            joueurActuel = joueurActuel % nbJoueurs; // Répéter pour tous les joueurs
            if (finDuJeu == 1) {
                break;
            }
        }
    }
    //Joueur joueur = new Joueur(2);

    //Fenetre test = new Fenetre();
}

