package com.robot_turtle;

import java.util.Scanner;

class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private int nombreJoueurs;

    /**
     * Constructeur appellé dans le main de la classe Game pour implémenter le jeu selon le nombre de joueurs de la partie
     **/
    Menu() {
        System.out.println("         ****** Bienvenue dans le jeu ROBOT TURTLE !!! ******         \n" +
                "Pour commencer veuillez indiquer combien de joueurs seront de la partie (2,3 ou 4) \n");
        nombreJoueurs = scanner.nextInt();
    }


    int getNombreJoueurs() {
        return nombreJoueurs;
    }


}

