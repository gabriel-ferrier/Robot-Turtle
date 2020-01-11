package com.robot_turtle;

import java.util.ArrayList;
import java.util.Collections;


public class GestionCartes {
    private ArrayList<Cartes> programme = new ArrayList<>(); //correspond au programme personnalisé de chaque joueur
    private ArrayList<Cartes> pioche = new ArrayList<>(); //liste des jeux de 37 cartes de chaque joueur
    private ArrayList<Cartes> jeuxPersoCarte = new ArrayList<>(); //liste des jeuPerso de carte de chaque joueur
    private ArrayList<Cartes> jeuxPersoObstacle = new ArrayList<>(); //liste des jeuPerso d'obstacles de chaque joueur
    private ArrayList<Cartes> defausse = new ArrayList<>(); //poubelle de carte

    public GestionCartes() {           //On associe une pioche et un jeuPerso carte/obs a chaque joueur
        for (int i = 0; i < 3; i++) {
            jeuxPersoObstacle.add(Cartes.PIERRE);
        }
        for (int i = 0; i < 2; i++) {
            jeuxPersoObstacle.add(Cartes.GLACE);
        }
        for (int i = 0; i < 18; i++) {
            pioche.add(Cartes.BLEU);
        }
        for (int i = 0; i < 7; i++) {
            pioche.add(Cartes.JAUNE);
            pioche.add(Cartes.VIOLET);
        }
        Collections.shuffle(pioche); //Melange l'ordre des cartes de la pioche
        for (int i = 0; i < 5; i++) {
           jeuxPersoCarte.add(pioche.get(0));
           pioche.remove(jeuxPersoCarte.get(0));
        }
    }
}
