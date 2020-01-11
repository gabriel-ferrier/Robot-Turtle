package com.robot_turtle;

import java.util.ArrayList;
import java.util.Scanner;
import com.robot_turtle.Joueur;

public class GestionJoueurs {
    public static ArrayList<Joueur> listeJoueurs = new ArrayList<>(); //liste de tous les joueurs

    public GestionJoueurs(int nombreDeJoueurs) {
        for (int i = 1; i <= nombreDeJoueurs; i++) {
            listeJoueurs.add(new Joueur(i));
        }
        System.out.println(listeJoueurs);
    }

    public ArrayList<Joueur> getListeJoueurs() {
        return listeJoueurs;
    }
}

