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

    public int getChoixInstruction() {
        return choixInstruction;
    }

    public void setChoixInstruction(int choixInstruction) {
        this.choixInstruction = choixInstruction;
    }

    public int getNumero() {
        return numero;
    }

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

    }

    public void choixInstruction() {
        for (int i = 1; i <= Game.nbJoueurs; i++) {
            System.out.println(" Tour de " + GestionJoueurs.listeJoueurs.get(i));
            System.out.println(" 1 : Compléter programme \n " +
                    " 2 : Placer un mur \n " +
                    " 3 : Exécuter programme \n ");
            choixInstruction = scanner.nextInt();
        }
        switch (choixInstruction) {
            case 1:
                completerProgramme();
                break;
            case 2:
                placerMur();
                break;
            case 3:
                break;
        }
    }

    public void completerProgramme() {
        System.out.println(this.toutesCartes.getDeckCarte() + " est votre jeu actuel \n" +
                " Combien de carte(s) voulez-vous ajouter à votre programme ? ");
        int nombreCarte = scanner.nextInt();
        for (int i = 0; i < nombreCarte; i++) {
            System.out.println(" Quel indice de carte voulez-vous ajouter ");
            int indice = scanner.nextInt();
            this.toutesCartes.getProgramme().add(this.toutesCartes.getDeckCarte().get(indice));
            this.toutesCartes.getDeckCarte().remove(this.toutesCartes.getDeckCarte().get(indice));
            System.out.println("Il vous reste " + (this.toutesCartes.getDeckCarte().size() - nombreCarte) + " carte(s) " +
                    " Que voulez- vous en faire (0 = défausse et 1 = piocher) ? ");
            int choix = scanner.nextInt();
            if (choix == 0) {
                System.out.println("Combien de carte(s) voulez-vous mettre à la défausse ? ");
                int combien = scanner.nextInt();
                for (int j = 0; j < combien; j++) {
                    System.out.println(" Quel indice de carte voulez-vous mettre à la défausse ? ");
                    int indiceDefausse = scanner.nextInt();
                    this.toutesCartes.getDefausse().add(this.toutesCartes.getDeckCarte().get(indiceDefausse));
                }
            } else if (choix == 1) {
                do {
                    this.toutesCartes.getDeckCarte().add(this.toutesCartes.getPioche().get((toutesCartes.getPioche().size() - 1)));
                    this.toutesCartes.getPioche().remove(this.toutesCartes.getPioche().get((toutesCartes.getPioche().size() - 1)));
                } while (this.toutesCartes.getDeckCarte().size() != 5);
            }
        }
    }

    public void placerMur() {
        System.out.println(this.toutesCartes.getDeckObstacle() + " est votre deck d'obstacles ");
        System.out.println(" Quel indice d'obstacle de votre deck voulez-vous placer ? ");
        int indiceObs = scanner.nextInt();
        System.out.println(" Indiquer les coordonnées de votre mur ");
        int posXMur = scanner.nextInt();
        int posYMur = scanner.nextInt();
        if (indiceObs == 0 | indiceObs == 1 || indiceObs == 2) {
            Plateau.plateau[posXMur][posYMur] = " obstacle marron ";
        } else if (indiceObs == 3 || indiceObs == 4) {
            Plateau.plateau[posXMur][posYMur] = " obstacle de glace ";
        }
    }

    public void executerProgramme() {
        System.out.println("Votre programme est : " + this.toutesCartes.getProgramme());
        for (int i = 0; i < this.toutesCartes.getProgramme().size(); i++) {
            
        }
    }

}
