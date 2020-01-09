package com.robot_turtle;

public class Game {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.NombreJoueurs();
        Joueur joueur = new Joueur(menu.getNombreJoueurs());
        Plateau plateau = new Plateau(menu.getNombreJoueurs());

        /*Joueur joueur1 = new Joueur("Gab");
        Joueur joueur2 = new Joueur("Salim");
        Joueur joueur3 = new Joueur("Oussama");*/
    }
}
