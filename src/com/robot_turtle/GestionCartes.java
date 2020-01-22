package com.robot_turtle;

import java.util.ArrayList;
import java.util.Collections;


class GestionCartes {
    private ArrayList<Cartes> programme = new ArrayList<>();            // Programme formé par un joueur
    private ArrayList<Cartes> pioche = new ArrayList<>();               // Pioche de 37 cartes de chaque joueur
    private ArrayList<Cartes> deckCarte = new ArrayList<>();            // Deck de 5 cartes d'un joueur
    private ArrayList<Cartes> deckObstacle = new ArrayList<>();         // Deck d'obstacles attribué par défaut à chaque joueur
    private ArrayList<Cartes> defausse = new ArrayList<>();             // Défausse des cartes d'un joueur

    /**
     * Constructeur appellé dans Joueur pour associer les attributs de cette classe à chacun des joueurs
     **/
    GestionCartes(int numero) {

        // Creation du deck d'obstacles des joueurs
        for (int i = 0; i < 3; i++) {
            this.deckObstacle.add(Cartes.PIERRE);
        }
        for (int i = 0; i < 2; i++) {
            deckObstacle.add(Cartes.GLACE);
        }

        // Creation de la pioche des joueurs
        for (int i = 0; i < 18; i++) {
            pioche.add(Cartes.BLEU);
        }
        for (int i = 0; i < 8; i++) {
            pioche.add(Cartes.JAUNE);
        }
        for (int i = 0; i < 8; i++) {
            pioche.add(Cartes.VIOLET);
        }
       /* for (int i = 0; i < 2; i++) {
            pioche.add(Cartes.ROUGE);
        }*/
        for (int i = 0; i < 1; i++) {
            deckCarte.add(Cartes.ROUGE);
        }
        Collections.shuffle(pioche);                                    // Melanger l'ordre des cartes de la pioche
        for (int i = 0; i < 4; i++) {                                   // Definir le deck de 5 cartes aléatoires d'un joueur en début de partie
            this.deckCarte.add(this.pioche.get((pioche.size() - 1)));
            this.pioche.remove((pioche.size() - 1));
        }
       if (pioche.size() == 0){  // TODO: vérifier si ca marche
            pioche.addAll(defausse);
        }
    }

    /**
     * Getters necessaires au programme, essentiellement dans la classe Joueur
     **/
    ArrayList<Cartes> getProgramme() {
        return programme;
    }

    ArrayList<Cartes> getPioche() {
        return pioche;
    }

    ArrayList<Cartes> getDeckCarte() {
        return deckCarte;
    }

    ArrayList<Cartes> getDeckObstacle() {
        return deckObstacle;
    }

    ArrayList<Cartes> getDefausse() {
        return defausse;
    }

}
