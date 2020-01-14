package com.robot_turtle;

import java.util.ArrayList;

import com.robot_turtle.Joueur;

public class GestionJoueurs {
    public static ArrayList<Joueur> listeJoueurs = new ArrayList<>(); //liste de tous les joueurs

    public GestionJoueurs(int nombreDeJoueurs) {
        ArrayList<String> listJoueurs = new ArrayList<>();
        for (int i = 1; i <= nombreDeJoueurs; i++) {
            listeJoueurs.add(new Joueur(i));
        }
        for (int i = 0; i < listeJoueurs.size(); i++) {
            listJoueurs.add("Joueur " + listeJoueurs.get(i).getNumero());
        }
        System.out.println(listJoueurs);
    }

    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }
}

