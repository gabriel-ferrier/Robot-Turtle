package com.robot_turtle;

import java.util.Scanner;

public class Menu {
    //TODO : menu etc. definir nombre de joueurs
    public static Scanner scanner = new Scanner(System.in);
    public int nombreJoueurs;

    /*CONSTRUCTEUR*/
    public Menu() {
    }

    public int getNombreJoueurs() {
        return nombreJoueurs;
    }

    public void setNombreJoueurs(int nombreJoueurs) {
        this.nombreJoueurs = nombreJoueurs;
    }

    public void NombreJoueurs() {
        System.out.println("Bienvenue dans le jeu ROBOT TURTLE \n" +
                "Pour commencer veuillez indiquer combien de joueurs seront de la partie (2,3 ou 4)\n");
        nombreJoueurs = scanner.nextInt();
    }

}

