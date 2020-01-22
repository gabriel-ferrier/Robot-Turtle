package com.robot_turtle;

import java.util.ArrayList;

class GestionJoueurs {
    static ArrayList<Joueur> listeJoueurs = new ArrayList<>();   // Liste de tous les joueurs

    ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    /**
     * Constructeur pour la création des joueurs
     **/
    GestionJoueurs(int nombreDeJoueurs) {
        ArrayList<String> listJoueurs = new ArrayList<>();
        for (int i = 1; i <= nombreDeJoueurs; i++) {
            listeJoueurs.add(new Joueur(i));            // Creer le nombre de joueurs demandé dans la classe Menu
        }
        for (Joueur listeJoueur : listeJoueurs) {
            listJoueurs.add("Joueur " + listeJoueur.getNumero());
        }
        System.out.println(listJoueurs);
    }


}

