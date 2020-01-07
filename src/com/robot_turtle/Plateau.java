package com.robot_turtle;

import java.util.Arrays;

public class Plateau {
    private static final int taille = 8;
    public static char[][] plateau = new char[getTaille()][getTaille()];

    public static int getTaille() {
        return taille;
    }

    public char[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(char[][] plateau) {
        this.plateau = plateau;
    }

    public void initialiserPlateau() {
        System.out.println("Voici le plateau de jeu");
        plateau = new char[getTaille()][getTaille()];
        for (int i = 0; i < getTaille(); i++) {
            for (int j = 0; j < getTaille(); j++) {
                plateau[i][j] = '0';
            }
        }
        for (char[] ligne : getPlateau()){ //parcours toute les lignes du tableau
            System.out.println(Arrays.toString(ligne)); //affiche ligne par ligne le plateau
        }
    }

    //TODO : recup nombre de joueurs et afficher plateau en fonction
}
