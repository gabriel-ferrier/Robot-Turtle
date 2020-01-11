package com.robot_turtle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GestionCartes {
    private ArrayList<Cartes> programme = new ArrayList<>(); //correspond au programme personnalisé de chaque joueur
    private ArrayList<Cartes> pioche = new ArrayList<>(); //liste des jeux de 37 cartes de chaque joueur
    private ArrayList<Cartes> deckCarte = new ArrayList<>(); //liste des jeuPerso de carte de chaque joueur
    private ArrayList<Cartes> deckObstacle = new ArrayList<>(); //liste des jeuPerso d'obstacles de chaque joueur
    private ArrayList<Cartes> defausse = new ArrayList<>(); //poubelle de carte

    public ArrayList<Cartes> getProgramme() {
        return programme;
    }

    public void setProgramme(ArrayList<Cartes> programme) {
        this.programme = programme;
    }

    public ArrayList<Cartes> getPioche() {
        return pioche;
    }

    public void setPioche(ArrayList<Cartes> pioche) {
        this.pioche = pioche;
    }

    public ArrayList<Cartes> getDeckCarte() {
        return deckCarte;
    }

    public void setJDeckCarte(ArrayList<Cartes> jeuxPersoCarte) {
        this.deckCarte = jeuxPersoCarte;
    }

    public ArrayList<Cartes> getDeckObstacle() {
        return deckObstacle;
    }

    public void setDeckObstacle(ArrayList<Cartes> jeuxPersoObstacle) {
        this.deckObstacle = jeuxPersoObstacle;
    }

    public ArrayList<Cartes> getDefausse() {
        return defausse;
    }

    public void setDefausse(ArrayList<Cartes> defausse) {
        this.defausse = defausse;
    }

    public GestionCartes() {           //On associe une pioche et un jeuPerso carte/obs a chaque joueur
        for (int i = 0; i < 3; i++) {
            deckObstacle.add(Cartes.PIERRE);
        }
        for (int i = 0; i < 2; i++) {
            deckObstacle.add(Cartes.GLACE);
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
           deckCarte.add(pioche.get(pioche.size()-1));
           pioche.remove(pioche.get(pioche.size()-1));
        }
    }


}
