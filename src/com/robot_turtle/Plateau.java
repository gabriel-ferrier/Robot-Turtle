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
                plateau[0][2] = "tortue 1";   // definir position joueur 1 pour réutiliser instruction
                plateau[0][5] = "tortue 2";
                plateau[4][1] = "joyau 1 ";
                plateau[5][7] = "joyau 2 ";
                for (String[] ligne : getPlateau()) { //parcours toute les lignes du tableau
                    System.out.println(Arrays.toString(ligne)+"\n"); //affiche ligne par ligne le plateau
                }
                break;
            case 3 :
                System.out.println("Voici votre plateau de jeu \n");
                plateau[0][2] = "tortue 1";
                plateau[0][4] = "tortue 2";
                plateau[0][6] = "tortue 3";
                plateau[5][1] = "joyau 1 ";
                plateau[5][7] = "joyau 2 ";
                plateau[7][4] = "joyau 3 ";
                for (String[] ligne : getPlateau()) {
                    System.out.println(Arrays.toString(ligne)+"\n");
                }
                break;
            case 4 :
                System.out.println("Voici votre plateau de jeu \n");
                plateau[0][1] = "tortue 1";
                plateau[0][3] = "tortue 2";
                plateau[0][5] = "tortue 3";
                plateau[0][7] = "tortue 4";
                plateau[5][1] = "joyau 1 ";
                plateau[5][7] = "joyau 2 ";
                plateau[7][4] = "joyau 3 ";
                plateau[7][7] = "joyaux 4 ";
                for (String[] ligne : getPlateau()) {
                    System.out.println(Arrays.toString(ligne)+"\n");
                }
                break;
            default:
                System.out.println("Vous ne pouvez jouer que à 2,3 ou 4 joueurs");
        }
    }
}


