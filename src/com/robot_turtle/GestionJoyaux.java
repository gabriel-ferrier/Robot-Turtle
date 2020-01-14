package com.robot_turtle;

import java.util.ArrayList;

public class GestionJoyaux {
    public static ArrayList<Joyau> listeJoyaux = new ArrayList<>(); //liste de tous les joyaux

    public GestionJoyaux(int nbJoueurs) {
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

    public ArrayList<Joyau> getListeJoyaux() {
        return listeJoyaux;
    }
}
