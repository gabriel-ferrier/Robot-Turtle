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
            //TODO: seting positions des obstacles
            //      positionner les obstacles sur le plateau initiale pour 2 et 3 joueurs
            case 2 :
                //  Positions du joyau
                GestionJoyaux.listeJoyaux.get(0).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(0).setPosYJoyau(3);

                // Positions initiales des joueurs
                GestionJoueurs.listeJoueurs.get(0).setPosXInit(0);
                GestionJoueurs.listeJoueurs.get(0).setPosYInit(1);
                GestionJoueurs.listeJoueurs.get(1).setPosXInit(0);
                GestionJoueurs.listeJoueurs.get(1).setPosYInit(5);

                // Initialisation des posistions des joueurs à ses positions initiales pour pouvoir travailler dessus apres
                GestionJoueurs.listeJoueurs.get(0).setPosX(GestionJoueurs.listeJoueurs.get(0).getPosXInit());
                GestionJoueurs.listeJoueurs.get(0).setPosY(GestionJoueurs.listeJoueurs.get(0).getPosYInit());
                GestionJoueurs.listeJoueurs.get(1).setPosX(GestionJoueurs.listeJoueurs.get(1).getPosXInit());
                GestionJoueurs.listeJoueurs.get(1).setPosY(GestionJoueurs.listeJoueurs.get(1).getPosYInit());

                System.out.println("Chaque joueur se voit attribué la tortue de son numéro. " +
                        "\nAttention, il est FORMELLEMENT INTERDIT de bloquer le chemin à un autre joueur lorsque vous placé un obstacle !! ");
                System.out.println("Voici votre plateau de jeu :\n");

                // Positionnement des tortues
                plateau[GestionJoueurs.listeJoueurs.get(0).getPosXInit()][GestionJoueurs.listeJoueurs.get(0).getPosYInit()] = "      tortue 1   ";
                plateau[GestionJoueurs.listeJoueurs.get(1).getPosXInit()][GestionJoueurs.listeJoueurs.get(1).getPosYInit()] = "      tortue 2   ";
                // Positionnement du joyau
                plateau[GestionJoyaux.listeJoyaux.get(0).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(0).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
                for (String[] ligne : getPlateau()) {               // Parcourrir toute les lignes du tableau
                System.out.println(Arrays.toString(ligne)+"\n");    // Afficher ligne par ligne le plateau
            }
                break;
            case 3 :
                // Positions des joyaux
                GestionJoyaux.listeJoyaux.get(0).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(0).setPosYJoyau(0);
                GestionJoyaux.listeJoyaux.get(1).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(1).setPosYJoyau(3);
                GestionJoyaux.listeJoyaux.get(2).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(2).setPosYJoyau(7);

                // Positions initiales des joueurs
                GestionJoueurs.listeJoueurs.get(0).setPosXInit(5);
                GestionJoueurs.listeJoueurs.get(0).setPosYInit(4);
                GestionJoueurs.listeJoueurs.get(1).setPosXInit(5);
                GestionJoueurs.listeJoueurs.get(1).setPosYInit(3);
                GestionJoueurs.listeJoueurs.get(2).setPosXInit(5);
                GestionJoueurs.listeJoueurs.get(2).setPosYInit(5);

                // Initialisation des posistions des joueurs à ses positions initiales pour pouvoir travailler dessus apres
                GestionJoueurs.listeJoueurs.get(0).setPosX(GestionJoueurs.listeJoueurs.get(0).getPosXInit());
                GestionJoueurs.listeJoueurs.get(0).setPosY(GestionJoueurs.listeJoueurs.get(0).getPosYInit());
                GestionJoueurs.listeJoueurs.get(1).setPosX(GestionJoueurs.listeJoueurs.get(1).getPosXInit());
                GestionJoueurs.listeJoueurs.get(1).setPosY(GestionJoueurs.listeJoueurs.get(1).getPosYInit());
                GestionJoueurs.listeJoueurs.get(2).setPosX(GestionJoueurs.listeJoueurs.get(2).getPosXInit());
                GestionJoueurs.listeJoueurs.get(2).setPosY(GestionJoueurs.listeJoueurs.get(2).getPosYInit());

                System.out.println("Chaque joueur se voit attribué la tortue de son numéro. " +
                        "\nAttention, il est FORMELLEMENT INTERDIT de bloquer le chemin à un autre joueur lorsque vous placé un obstacle !! ");
                System.out.println("Voici votre plateau de jeu :\n");

                // Positionnement des tortues
                plateau[GestionJoueurs.listeJoueurs.get(0).getPosXInit()][GestionJoueurs.listeJoueurs.get(0).getPosYInit()] = "      tortue 1   ";
                plateau[GestionJoueurs.listeJoueurs.get(1).getPosXInit()][GestionJoueurs.listeJoueurs.get(1).getPosYInit()] = "      tortue 2   ";
                plateau[GestionJoueurs.listeJoueurs.get(2).getPosXInit()][GestionJoueurs.listeJoueurs.get(2).getPosYInit()] = "      tortue 3   ";
                // Positionnement des joyaux
                plateau[GestionJoyaux.listeJoyaux.get(0).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(0).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
                plateau[GestionJoyaux.listeJoyaux.get(1).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(1).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ";
                plateau[GestionJoyaux.listeJoyaux.get(2).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(2).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(2).getNumeroJoyau() + "     ";
                for (String[] ligne : getPlateau()) {
                    System.out.println(Arrays.toString(ligne)+"\n");
                }
                break;
            case 4 :
                // Position des joyaux
                GestionJoyaux.listeJoyaux.get(0).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(0).setPosYJoyau(1);
                GestionJoyaux.listeJoyaux.get(1).setPosXJoyau(7);
                GestionJoyaux.listeJoyaux.get(1).setPosYJoyau(6);

                // Positions initiales des joueurs
                GestionJoueurs.listeJoueurs.get(0).setPosXInit(0);
                GestionJoueurs.listeJoueurs.get(0).setPosYInit(0);
                GestionJoueurs.listeJoueurs.get(1).setPosXInit(0);
                GestionJoueurs.listeJoueurs.get(1).setPosYInit(2);
                GestionJoueurs.listeJoueurs.get(2).setPosXInit(0);
                GestionJoueurs.listeJoueurs.get(2).setPosYInit(5);
                GestionJoueurs.listeJoueurs.get(3).setPosXInit(0);
                GestionJoueurs.listeJoueurs.get(3).setPosYInit(7);

                // Initialisation des posistions des joueurs à ses positions initiales pour pouvoir travailler dessus apres
                GestionJoueurs.listeJoueurs.get(0).setPosX(GestionJoueurs.listeJoueurs.get(0).getPosXInit());
                GestionJoueurs.listeJoueurs.get(0).setPosY(GestionJoueurs.listeJoueurs.get(0).getPosYInit());
                GestionJoueurs.listeJoueurs.get(1).setPosX(GestionJoueurs.listeJoueurs.get(1).getPosXInit());
                GestionJoueurs.listeJoueurs.get(1).setPosY(GestionJoueurs.listeJoueurs.get(1).getPosYInit());
                GestionJoueurs.listeJoueurs.get(2).setPosX(GestionJoueurs.listeJoueurs.get(2).getPosXInit());
                GestionJoueurs.listeJoueurs.get(2).setPosY(GestionJoueurs.listeJoueurs.get(2).getPosYInit());
                GestionJoueurs.listeJoueurs.get(3).setPosX(GestionJoueurs.listeJoueurs.get(3).getPosXInit());
                GestionJoueurs.listeJoueurs.get(3).setPosY(GestionJoueurs.listeJoueurs.get(3).getPosYInit());

                System.out.println("Chaque joueur se voit attribué la tortue de son numéro. " +
                        "\nAttention, il est FORMELLEMENT INTERDIT de bloquer le chemin à un autre joueur lorsque vous placé un obstacle !! ");
                System.out.println("Voici votre plateau de jeu :\n");

                // Positionnement des tortues
                plateau[GestionJoueurs.listeJoueurs.get(0).getPosXInit()][GestionJoueurs.listeJoueurs.get(0).getPosYInit()] = "      tortue 1   ";
                plateau[GestionJoueurs.listeJoueurs.get(1).getPosXInit()][GestionJoueurs.listeJoueurs.get(1).getPosYInit()] = "      tortue 2   ";
                plateau[GestionJoueurs.listeJoueurs.get(2).getPosXInit()][GestionJoueurs.listeJoueurs.get(2).getPosYInit()] = "      tortue 3   ";
                plateau[GestionJoueurs.listeJoueurs.get(3).getPosXInit()][GestionJoueurs.listeJoueurs.get(3).getPosYInit()] = "      tortue 4   ";
                // Positionnement des joyaux
                plateau[GestionJoyaux.listeJoyaux.get(0).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(0).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
                plateau[GestionJoyaux.listeJoyaux.get(1).getPosXJoyau()][GestionJoyaux.listeJoyaux.get(1).getPosYJoyau()] = "     joyau " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ";
                for (String[] ligne : getPlateau()) {
                    System.out.println(Arrays.toString(ligne)+"\n");
                }
                break;
            default:
                System.out.println(" Vous ne pouvez jouer que à 2,3 ou 4 joueurs ");
                Game.finDuJeu = 1;
        }
    }
}


