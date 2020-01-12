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
                plateau[i][j] = "     0    ";
            }
        }
        switch (nb){
            case 2 :
                Joyau joyau1_2j = new Joyau(1);
                joyau1_2j.setPosXJoyaux(6);
                joyau1_2j.setPosYJoyaux(6);
                GestionJoueurs.listeJoueurs.get(0).setPosInitialeX(0);
                GestionJoueurs.listeJoueurs.get(0).setPosInitialeY(2);
                GestionJoueurs.listeJoueurs.get(1).setPosInitialeX(0);
                GestionJoueurs.listeJoueurs.get(1).setPosInitialeY(5);
                System.out.println("Voici votre plateau de jeu \n");
                plateau[GestionJoueurs.listeJoueurs.get(0).getPosInitialeX()][GestionJoueurs.listeJoueurs.get(0).getPosInitialeY()] = " tortue 1";
                plateau[GestionJoueurs.listeJoueurs.get(1).getPosInitialeX()][GestionJoueurs.listeJoueurs.get(1).getPosInitialeY()] = " tortue 2";
                plateau[joyau1_2j.getPosXJoyaux()][joyau1_2j.getPosYJoyaux()] = " joyau ";
                for (String[] ligne : getPlateau()) { //parcours toute les lignes du tableau
                System.out.println(Arrays.toString(ligne)+"\n"); //affiche ligne par ligne le plateau
            }
                break;
            case 3 :
                Joyau joyau1_3j = new Joyau(1);
                Joyau joyau2_3j = new Joyau(2);
                joyau1_3j.setPosXJoyaux(6);
                joyau1_3j.setPosYJoyaux(1);
                joyau2_3j.setPosXJoyaux(6);
                joyau2_3j.setPosYJoyaux(7);
                GestionJoueurs.listeJoueurs.get(0).setPosInitialeX(0);
                GestionJoueurs.listeJoueurs.get(0).setPosInitialeY(2);
                GestionJoueurs.listeJoueurs.get(1).setPosInitialeX(0);
                GestionJoueurs.listeJoueurs.get(1).setPosInitialeY(4);
                GestionJoueurs.listeJoueurs.get(2).setPosInitialeY(0);
                GestionJoueurs.listeJoueurs.get(2).setPosInitialeY(6);
                System.out.println("Voici votre plateau de jeu \n");
                plateau[GestionJoueurs.listeJoueurs.get(0).getPosInitialeX()][GestionJoueurs.listeJoueurs.get(0).getPosInitialeY()] = " tortue 1";
                plateau[GestionJoueurs.listeJoueurs.get(1).getPosInitialeX()][GestionJoueurs.listeJoueurs.get(1).getPosInitialeY()] = " tortue 2";
                plateau[GestionJoueurs.listeJoueurs.get(2).getPosInitialeX()][GestionJoueurs.listeJoueurs.get(2).getPosInitialeY()] = " tortue 3";
                plateau[joyau1_3j.getPosXJoyaux()][joyau1_3j.getPosYJoyaux()] = " joyau 1 ";
                plateau[joyau2_3j.getPosXJoyaux()][joyau2_3j.getPosYJoyaux()] = " joyau 2 ";
                for (String[] ligne : getPlateau()) {
                    System.out.println(Arrays.toString(ligne)+"\n");
                }
                break;
            case 4 :
                Joyau joyau1_4j = new Joyau(1);
                Joyau joyau2_4j = new Joyau(2);
                Joyau joyau3_4j = new Joyau(3);
                joyau1_4j.setPosXJoyaux(6);
                joyau1_4j.setPosYJoyaux(1);
                joyau2_4j.setPosXJoyaux(6);
                joyau2_4j.setPosYJoyaux(7);
                joyau3_4j.setPosXJoyaux(7);
                joyau3_4j.setPosYJoyaux(4);
                GestionJoueurs.listeJoueurs.get(0).setPosInitialeX(0);
                GestionJoueurs.listeJoueurs.get(0).setPosInitialeY(1);
                GestionJoueurs.listeJoueurs.get(1).setPosInitialeX(0);
                GestionJoueurs.listeJoueurs.get(1).setPosInitialeY(3);
                GestionJoueurs.listeJoueurs.get(2).setPosInitialeY(0);
                GestionJoueurs.listeJoueurs.get(2).setPosInitialeY(5);
                GestionJoueurs.listeJoueurs.get(3).setPosInitialeY(0);
                GestionJoueurs.listeJoueurs.get(3).setPosInitialeY(7);
                System.out.println("Voici votre plateau de jeu \n");
                plateau[GestionJoueurs.listeJoueurs.get(0).getPosInitialeX()][GestionJoueurs.listeJoueurs.get(0).getPosInitialeY()] = " tortue 1";
                plateau[GestionJoueurs.listeJoueurs.get(1).getPosInitialeX()][GestionJoueurs.listeJoueurs.get(1).getPosInitialeY()] = " tortue 2";
                plateau[GestionJoueurs.listeJoueurs.get(2).getPosInitialeX()][GestionJoueurs.listeJoueurs.get(2).getPosInitialeY()] = " tortue 3";
                plateau[GestionJoueurs.listeJoueurs.get(3).getPosInitialeX()][GestionJoueurs.listeJoueurs.get(3).getPosInitialeY()] = " tortue 4";
                plateau[joyau1_4j.getPosXJoyaux()][joyau1_4j.getPosYJoyaux()] = " joyau 1 ";
                plateau[joyau2_4j.getPosXJoyaux()][joyau2_4j.getPosYJoyaux()] = " joyau 2 ";
                plateau[joyau3_4j.getPosXJoyaux()][joyau3_4j.getPosYJoyaux()] = " joyau 3 ";
                for (String[] ligne : getPlateau()) {
                    System.out.println(Arrays.toString(ligne)+"\n");
                }
                break;
            default:
                System.out.println("Vous ne pouvez jouer que à 2,3 ou 4 joueurs");
        }
    }
}


