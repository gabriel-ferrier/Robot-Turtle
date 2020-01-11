package com.robot_turtle;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    public static Scanner scanner = new Scanner(System.in);
    private int numero;
    private int posX;
    private int posY;
    private int posInitialeX;
    private int posInitialeY;
    /*private int posFinaleX;
        private int posFinaleY;*/
    private int choixInstruction;
    private GestionCartes toutesCartes;

    public int getChoixInstruction() { return choixInstruction; }

    public void setChoixInstruction(int choixInstruction) { this.choixInstruction = choixInstruction; }

    public int getNumero() { return numero; }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosInitialeX() {
        return posInitialeX;
    }

    public void setPosInitialeX(int posInitialeX) {
        this.posInitialeX = posInitialeX;
    }

    public int getPosInitialeY() {
        return posInitialeY;
    }

    public void setPosInitialeY(int posInitialeY) {
        this.posInitialeY = posInitialeY;
    }

    public GestionCartes getToutesCartes() {
        return toutesCartes;
    }

    public void setToutesCartes(GestionCartes toutesCartes) {
        this.toutesCartes = toutesCartes;
    }


    public Joueur(int numero) {
        this.toutesCartes = new GestionCartes(); //creer un env de cartes qui est associé au joueur du meme numero
        for (int i = 1; i <= Game.nbJoueurs; i++) {
            System.out.println(" Tour de " + GestionJoueurs.listeJoueurs.get(i));
            System.out.println(" 1 : Compléter programme \n " +
                    " 2 : Placer un mur \n " +
                    " 3 : Exécuter programme \n ");
            choixInstruction = scanner.nextInt();
        }
        switch (choixInstruction){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    public static void completerProgramme(ArrayList<Cartes> programme, ArrayList<Cartes> jeuPersoCarte){
        System.out.println(jeuPersoCarte + " est votre jeu actuel \n" +
                " Quel indice de la carte voulait vous ajouter à votre programme ? ");
        int indiceCarteAjout = scanner.nextInt();
        programme.add(jeuPersoCarte.get(indiceCarteAjout));



    }

}
