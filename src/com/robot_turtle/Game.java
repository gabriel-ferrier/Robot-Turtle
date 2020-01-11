package com.robot_turtle;

public class Game {

    public static int nbJoueurs;
    //public static int manche;

    public static void main(String[] args) {
        Menu menu = new Menu();
        nbJoueurs = menu.getNombreJoueurs();
        GestionJoueurs joueurs = new GestionJoueurs(nbJoueurs); // Lance la création des joueurs
        Plateau plateau = new Plateau(nbJoueurs);
        int joueurActuel = 0;

        while (true){
            joueurs.getListeJoueurs().get(joueurActuel).choixInstruction();



            joueurActuel++;
            joueurActuel = joueurActuel%nbJoueurs; // Répéter pour tous mes joueurs
        }
        //TourDeJeu tourDeJeu = new TourDeJeu(joueurs.getNoms(), menu.getNombreJoueurs());
        //Fenetre test = new Fenetre();
    }
}
