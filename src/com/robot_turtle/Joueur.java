package com.robot_turtle;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<String> noms = new ArrayList<>(); //liste des noms des joueurs
    private static ArrayList<String> deck = new ArrayList<>();
    private static ArrayList<String> pioche = new ArrayList<>();
    private static ArrayList<ArrayList<String>> jeuPerso = new ArrayList<ArrayList<String>>(); //liste des jeuPerso des joueurs

    public Joueur(int value) {
        creationJoueurs(value);
        //creationJeuPerso(nom);
    }

    public static ArrayList<String> getNoms() {
        return noms;
    }

    public static void setNoms(ArrayList<String> noms) {
        Joueur.noms = noms;
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


    public ArrayList<ArrayList<String>> getJeuPerso() {
        return jeuPerso;
    }

    public void setJeuPerso(ArrayList<ArrayList<String>> jeuPerso) {
        this.jeuPerso = jeuPerso;
    }


    public static void creationJoueurs(int value) {
        String[] cartes = {"carte bleu", "carte jaune", "carte violette"};
        switch (value) {
            case 2:
                ArrayList<String> jeuPerso1_2j = new ArrayList<>();
                ArrayList<String> jeuPerso2_2j = new ArrayList<>();
                System.out.println("Quel est le nom du joueur 1 ? ");
                String joueur1_2j = scanner.nextLine();
                System.out.println("Quel est le nom du joueur 2 ? ");
                String joueur2_2j = scanner.nextLine();
                noms.add(joueur1_2j);
                noms.add(joueur2_2j);
                for (int j = 0; j < 5; j++) {
                    int indice1 = (int) (Math.random() * ((2) + 1));
                    int indice2 = (int) (Math.random() * ((2) + 1));
                    jeuPerso1_2j.add(cartes[indice1]);
                    jeuPerso2_2j.add(cartes[indice2]);
                }
                jeuPerso.add(jeuPerso1_2j);
                jeuPerso.add(jeuPerso2_2j);
                System.out.println(getNoms().get(0) + " se voit attribuer : " + jeuPerso.get(0));
                System.out.println(getNoms().get(1) + " se voit attribuer : " + jeuPerso.get(1));
                System.out.println("\n");
                break;
            case 3:
                ArrayList<String> jeuPerso1_3j = new ArrayList<>();
                ArrayList<String> jeuPerso2_3j = new ArrayList<>();
                ArrayList<String> jeuPerso3_3j = new ArrayList<>();
                System.out.println("Quel est le nom du joueur 1 ? ");
                String joueur1_3j = scanner.nextLine();
                System.out.println("Quel est le nom du joueur 2 ? ");
                String joueur2_3j = scanner.nextLine();
                System.out.println("Quel est le nom du joueur 3 ? ");
                String joueur3_3j = scanner.nextLine();
                noms.add(joueur1_3j);
                noms.add(joueur2_3j);
                noms.add(joueur3_3j);
                for (int j = 0; j < 5; j++) {
                    int indice1 = (int) (Math.random() * ((2) + 1));
                    int indice2 = (int) (Math.random() * ((2) + 1));
                    int indice3 = (int) (Math.random() * ((2) + 1));
                    jeuPerso1_3j.add(cartes[indice1]);
                    jeuPerso2_3j.add(cartes[indice2]);
                    jeuPerso3_3j.add(cartes[indice3]);
                }
                jeuPerso.add(jeuPerso1_3j);
                jeuPerso.add(jeuPerso2_3j);
                jeuPerso.add(jeuPerso3_3j);
                System.out.println(getNoms().get(0) + " se voit attribuer : " + jeuPerso.get(0));
                System.out.println(getNoms().get(1) + " se voit attribuer : " + jeuPerso.get(1));
                System.out.println(getNoms().get(2) + " se voit attribuer : " + jeuPerso.get(2));
                System.out.println("\n");
                break;
            case 4:
                ArrayList<String> jeuPerso1_4j = new ArrayList<>();
                ArrayList<String> jeuPerso2_4j = new ArrayList<>();
                ArrayList<String> jeuPerso3_4j = new ArrayList<>();
                ArrayList<String> jeuPerso4_4j = new ArrayList<>();
                System.out.println("Quel est le nom du joueur 1 ? ");
                String joueur1_4j = scanner.nextLine();
                System.out.println("Quel est le nom du joueur 2 ? ");
                String joueur2_4j = scanner.nextLine();
                System.out.println("Quel est le nom du joueur 3 ? ");
                String joueur3_4j = scanner.nextLine();
                System.out.println("Quel est le nom du joueur 4 ? ");
                String joueur4_4j = scanner.nextLine();
                noms.add(joueur1_4j);
                noms.add(joueur2_4j);
                noms.add(joueur3_4j);
                noms.add(joueur4_4j);
                for (int j = 0; j < 5; j++) {
                    int indice1 = (int) (Math.random() * ((2) + 1));
                    int indice2 = (int) (Math.random() * ((2) + 1));
                    int indice3 = (int) (Math.random() * ((2) + 1));
                    int indice4 = (int) (Math.random() * ((2) + 1));
                    jeuPerso1_4j.add(cartes[indice1]);
                    jeuPerso2_4j.add(cartes[indice2]);
                    jeuPerso3_4j.add(cartes[indice3]);
                    jeuPerso4_4j.add(cartes[indice4]);
                }
                jeuPerso.add(jeuPerso1_4j);
                jeuPerso.add(jeuPerso2_4j);
                jeuPerso.add(jeuPerso3_4j);
                jeuPerso.add(jeuPerso4_4j);
                System.out.println(getNoms().get(0) + " se voit attribuer : " + jeuPerso.get(0));
                System.out.println(getNoms().get(1) + " se voit attribuer : " + jeuPerso.get(1));
                System.out.println(getNoms().get(2) + " se voit attribuer : " + jeuPerso.get(2));
                System.out.println(getNoms().get(3) + " se voit attribuer : " + jeuPerso.get(3));
                System.out.println("\n");
                break;
        }
    }

    /*public static void creationJeuPerso(int val, ArrayList<String> list) {
        String[] cartes = {"carte bleu", "carte jaune", "carte violette"};
        int indice1,indice2,indice3,indice4;
        for (int i = 0; i < 5; i++) {
            indice1 = (int) (Math.random() * ((2) + 1));
            indice2 = (int) (Math.random() * ((2) + 1));
            indice3 = (int) (Math.random() * ((2) + 1));
            indice4 = (int) (Math.random() * ((2) + 1));
        }
        System.out.println("Le jeu de " + indice1 + " est : " + jeuPerso);
    }*/
}
