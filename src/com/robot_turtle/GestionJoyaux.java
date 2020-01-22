package com.robot_turtle;

import java.util.ArrayList;

class GestionJoyaux {
    static ArrayList<Joyau> listeJoyaux = new ArrayList<>();    // Liste de tous les joyaux

    /**
     * Constructeur pour l'initialisation des joyaux nécessaires au plateau, selon le nombre de joueurs de la partie
     **/
    GestionJoyaux(int nbJoueurs) {
        switch (nbJoueurs) {
            case 2:
                listeJoyaux.add(new Joyau(1));
                break;
            case 3:
                for (int i = 1; i < 4; i++) {
                    listeJoyaux.add(new Joyau(i));
                }
                break;
            case 4:
                for (int i = 1; i < 3; i++) {
                    listeJoyaux.add(new Joyau(i));
                }
                break;
        }

    }

}
