package com.robot_turtle;

public class Game {

    public static int nbJoueurs;

    public static void main(String[] args) {
        Menu menu = new Menu();
        nbJoueurs = menu.getNombreJoueurs();
        GestionJoueurs joueurs = new GestionJoueurs(nbJoueurs);
        //Joueur joueurs = new Joueur(nbJoueurs);
        joueurs.getListeJoueurs().get(0);
        //Plateau plateau = new Plateau(nbJoueurs);
        //TourDeJeu tourDeJeu = new TourDeJeu(joueurs.getNoms(), menu.getNombreJoueurs());
        //Fenetre test = new Fenetre();
    }
}
