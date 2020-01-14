package com.robot_turtle;

import java.util.Arrays;

public class Plateau {
    private static final int taille = 8;
    public static String[][] plateau = new String[getTaille()][getTaille()];


   public Plateau() {
    }


    public static int getTaille() {
        return taille;
    }
    public String[][] getPlateau() {
        return plateau;
    }

    public String[][] setPlateau(String[][] plateau) {
        this.plateau = plateau;
        return plateau;
    }

    public void afficherPlateau(){
        for (String[] ligne : getPlateau()) {
            System.out.println(Arrays.toString(ligne)+"\n");
        }
    }

    public void afficherPlateauInit(int nb) {
        plateau = new String[getTaille()][getTaille()];
        for (int i = 0; i < getTaille(); i++) {
            for (int j = 0; j < getTaille(); j++) {
                plateau[i][j] = "        0        ";
            }
        }
        switch (nb){
            case 2 :
                GestionJoyaux.listeJoyaux.get(0).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(0).setPosYJoyau(3);
                GestionJoueurs.listeJoueurs.get(0).setPosX(0);
                GestionJoueurs.listeJoueurs.get(0).setPosY(1);
                GestionJoueurs.listeJoueurs.get(1).setPosX(0);
                GestionJoueurs.listeJoueurs.get(1).setPosY(5);
                System.out.println("Voici votre plateau de jeu \n");
                plateau[GestionJoueurs.listeJoueurs.get(0).getPosX()][GestionJoueurs.listeJoueurs.get(0).getPosY()] = "      tortue 1   ";
                plateau[GestionJoueurs.listeJoueurs.get(1).getPosX()][GestionJoueurs.listeJoueurs.get(1).getPosY()] = "      tortue 2   ";
                plateau[GestionJoyaux.listeJoyaux.get(0).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(0).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
                for (String[] ligne : getPlateau()) { // Parcourre toute les lignes du tableau
                System.out.println(Arrays.toString(ligne)+"\n"); // Affiche ligne par ligne le plateau
            }
                break;
            case 3 :
                GestionJoyaux.listeJoyaux.get(0).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(0).setPosYJoyau(0);
                GestionJoyaux.listeJoyaux.get(1).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(1).setPosYJoyau(3);
                GestionJoyaux.listeJoyaux.get(2).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(2).setPosYJoyau(7);
                GestionJoueurs.listeJoueurs.get(0).setPosX(0);
                GestionJoueurs.listeJoueurs.get(0).setPosY(0);
                GestionJoueurs.listeJoueurs.get(1).setPosX(0);
                GestionJoueurs.listeJoueurs.get(1).setPosY(3);
                GestionJoueurs.listeJoueurs.get(2).setPosY(0);
                GestionJoueurs.listeJoueurs.get(2).setPosY(7);
                System.out.println("Voici votre plateau de jeu \n");
                plateau[GestionJoueurs.listeJoueurs.get(0).getPosX()][GestionJoueurs.listeJoueurs.get(0).getPosY()] = "      tortue 1   ";
                plateau[GestionJoueurs.listeJoueurs.get(1).getPosX()][GestionJoueurs.listeJoueurs.get(1).getPosY()] = "      tortue 2   ";
                plateau[GestionJoueurs.listeJoueurs.get(2).getPosX()][GestionJoueurs.listeJoueurs.get(2).getPosY()] = "      tortue 3   ";
                plateau[GestionJoyaux.listeJoyaux.get(0).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(0).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
                plateau[GestionJoyaux.listeJoyaux.get(1).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(1).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ";
                plateau[GestionJoyaux.listeJoyaux.get(2).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(2).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(2).getNumeroJoyau() + "     ";
                for (String[] ligne : getPlateau()) {
                    System.out.println(Arrays.toString(ligne)+"\n");
                }
                break;
            case 4 :
                GestionJoyaux.listeJoyaux.get(0).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(0).setPosYJoyau(1);
                GestionJoyaux.listeJoyaux.get(1).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(1).setPosYJoyau(6);

                GestionJoueurs.listeJoueurs.get(0).setPosX(0);
                GestionJoueurs.listeJoueurs.get(0).setPosY(0);
                GestionJoueurs.listeJoueurs.get(1).setPosX(0);
                GestionJoueurs.listeJoueurs.get(1).setPosY(2);
                GestionJoueurs.listeJoueurs.get(2).setPosY(0);
                GestionJoueurs.listeJoueurs.get(2).setPosY(5);
                GestionJoueurs.listeJoueurs.get(3).setPosY(0);
                GestionJoueurs.listeJoueurs.get(3).setPosY(7);
                System.out.println("Voici votre plateau de jeu \n");
                plateau[GestionJoueurs.listeJoueurs.get(0).getPosX()][GestionJoueurs.listeJoueurs.get(0).getPosY()] = "      tortue 1   ";
                plateau[GestionJoueurs.listeJoueurs.get(1).getPosX()][GestionJoueurs.listeJoueurs.get(1).getPosY()] = "      tortue 2   ";
                plateau[GestionJoueurs.listeJoueurs.get(2).getPosX()][GestionJoueurs.listeJoueurs.get(2).getPosY()] = "      tortue 3   ";
                plateau[GestionJoueurs.listeJoueurs.get(3).getPosX()][GestionJoueurs.listeJoueurs.get(3).getPosY()] = "      tortue 4   ";
                plateau[GestionJoyaux.listeJoyaux.get(0).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(0).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
                plateau[GestionJoyaux.listeJoyaux.get(1).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(1).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ";
                for (String[] ligne : getPlateau()) {
                    System.out.println(Arrays.toString(ligne)+"\n");
                }
                break;
            default:
                System.out.println("Vous ne pouvez jouer que à 2,3 ou 4 joueurs");
        }
    }
}


