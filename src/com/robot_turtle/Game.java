package com.robot_turtle;

public class Game {

    public static int nbJoueurs;
    //public static int manche;

    public static void main(String[] args) {
        Menu menu = new Menu();
        nbJoueurs = menu.getNombreJoueurs();
        GestionJoueurs joueurs = new GestionJoueurs(nbJoueurs); // Lance la création des joueurs
        Plateau plateau = new Plateau();
        plateau.afficherPlateauInit(nbJoueurs); // Affiche plateau initial

        int joueurActuel = 0;
        while (true) {
            joueurs.getListeJoueurs().get(joueurActuel).instruction(plateau); // Lance les tours de jeu
            joueurActuel++;
            joueurActuel = joueurActuel % nbJoueurs; // Répéter pour tous les joueurs
        }
        //Joueur joueur = new Joueur(2);
        //TourDeJeu tourDeJeu = new TourDeJeu(joueurs.getNoms(), menu.getNombreJoueurs());
        //Fenetre test = new Fenetre();

    }
}
