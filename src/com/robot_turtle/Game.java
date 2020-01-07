package com.robot_turtle;

public class Game {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.NombreJoueurs();
        Plateau plateau = new Plateau();
        plateau.initialiserPlateau();
    }

}
