package com.robot_turtle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joueur {
    private static ArrayList<String> deck = new ArrayList<>();
    private static ArrayList<String> pioche = new ArrayList<>();
    private static ArrayList<String> jeuPerso = new ArrayList<>();

    public Joueur(String nom) {
        creationJeuPerso(nom);
    }

    public ArrayList<String> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<String> deck) {
        this.deck = deck;
    }


    public ArrayList<String> getPioche() {
        return pioche;
    }

    public void setPioche(ArrayList<String> pioche) {
        this.pioche = pioche;
    }


    public ArrayList<String> getJeuPerso() {
        return jeuPerso;
    }

    public void setJeuPerso(ArrayList<String> jeuPerso) {
        this.jeuPerso = jeuPerso;
    }


    public static void creationJeuPerso(String nom) {
        ArrayList<String> carte = new ArrayList<>();
        carte.add("carte bleu");
        carte.add("carte jaune");
        carte.add("carte violette");
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            int indice = rand.nextInt(2 - 0 + 0) + 0;
            jeuPerso.add(carte.get(indice));
        }
        System.out.println("Le jeu de " + nom + " est : " + jeuPerso);
    }

}
