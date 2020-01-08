package com.robot_turtle;

import java.util.Arrays;

public class Plateau {
    private static final int taille = 8;
    public static String[][] plateau = new String[getTaille()][getTaille()];

    public static int getTaille() {
        return taille;
    }

   public Plateau(int nbj) { //Constructeur en parametre nombre de joueurs (appel ds main)
        afficherPlateau(nbj);
    }

    public String[][] getPlateau() {
        return plateau;
    }

    public String[][] setPlateau(String[][] plateau) {
        this.plateau = plateau;
        return plateau;
    }

    public void afficherPlateau(int nb) {
        plateau = new String[getTaille()][getTaille()];
        for (int i = 0; i < getTaille(); i++) {
            for (int j = 0; j < getTaille(); j++) {
                plateau[i][j] = "    0   ";
            }
        }
        switch (nb){
            case 2 :
                System.out.println("Voici votre plateau de jeu \n");
                plateau[0][2] = "tortue 1";
                plateau[0][5] = "tortue 2";
                for (String[] ligne : getPlateau()) { //parcours toute les lignes du tableau
                    System.out.println(Arrays.toString(ligne)); //affiche ligne par ligne le plateau
                }
                break;
            case 3 :
                System.out.println("Voici votre plateau de jeu \n");
                plateau[0][2] = "tortue 1";
                plateau[0][5] = "tortue 2";
                plateau[7][3] = "tortue 3";
                for (String[] ligne : getPlateau()) {
                    System.out.println(Arrays.toString(ligne));
                }
                break;
            case 4 :
                System.out.println("Voici votre plateau de jeu \n");
                plateau[0][2] = "tortue 1";
                plateau[0][5] = "tortue 2";
                plateau[7][2] = "tortue 3";
                plateau[7][5] = "tortue 4";
                for (String[] ligne : getPlateau()) {
                    System.out.println(Arrays.toString(ligne));
                }
                break;
            default:
                System.out.println("Vous ne pouvez jouer que à 2,3 ou 4 joueurs");
        }
    }
}


