package com.robot_turtle;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    public static Scanner scanner = new Scanner(System.in);
    private int numero;
    private int posX; // Position tortue
    private int posY; // Position tortue
    private String direction; // Direction tortue
    private String direcionInitiale = " Sud ";
    private int posInitialeX; // Position initiale tortue, = posX pour apres
    private int posInitialeY;
    /*private int posFinaleX;
    private int posFinaleY;*/
    public int choixInstruction;
    private GestionCartes toutesCartes; // Avoir accès aux jeux de cartes de chaque joueur



    public Joueur(int numero) {
        this.numero = numero;
        this.toutesCartes = new GestionCartes(numero); //creer un env de cartes qui est associé au joueur du meme numero
    }



    public String getDirection() { return direction; }

    public void setDirection(String direction) { this.direction = direction; }

    public String getDirecionInitiale() { return direcionInitiale; }

    public void setDirecionInitiale(String direcionInitiale) { this.direcionInitiale = direcionInitiale; }

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



    public void instruction(Plateau plateau) {
        for (int i = 0; i < Game.nbJoueurs; i++) {
            System.out.println(" Tour de Joueur " + GestionJoueurs.listeJoueurs.get(i).getNumero());
            System.out.println(" 1 : Compléter programme " +
                    " \n 2 : Placer un mur  " +
                    " \n 3 : Exécuter programme  ");
            choixInstruction = scanner.nextInt();
            switch (choixInstruction) {
                case 1:
                    completerProgramme(i);
                    break;
                case 2:
                    placerMur(i,plateau.getPlateau());
                    plateau.afficherPlateau();
                    break;
                case 3:
                    executerProgramme(i);
                    break;
            }
        }

    }

    public void completerProgramme(int valueOfPlayer) {
        System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes \n" +
                " Combien de carte(s) voulez-vous ajouter à votre programme ? ");
        int nombreCarte = scanner.nextInt();
        for (int i = 0; i < nombreCarte; i++) {
            System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes \n");
            System.out.println(" Quel indice de carte voulez-vous ajouter ");
            int indice = scanner.nextInt();
            GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().add(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indice));
            GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indice));
        }
        System.out.println(" Votre deck de cartes est maintenant:" + (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte()/*.size() - nombreCarte*/) +
                " \n Que voulez- vous faire (0 = défausse et 1 = piocher) ? ");
        int choix = scanner.nextInt();
        if (choix == 0) {
            System.out.println("Combien de carte(s) voulez-vous mettre à la défausse ? ");
            int combien = scanner.nextInt();
            for (int j = 0; j < combien; j++) {
                System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes \n");
                System.out.println(" Quel indice de carte voulez-vous mettre à la défausse ? ");
                int indiceDefausse = scanner.nextInt();
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDefausse().add(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indiceDefausse));
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().remove(indiceDefausse);
            }
            GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().add(this.toutesCartes.getPioche().get(toutesCartes.getPioche().size() - 1));
            System.out.println(" Votre deck de cartes est maintenant " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte());
        } else if (choix == 1) {
            do {
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().add((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().get((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1))));
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().remove((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1));
            } while (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().size() != 5);
            System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte());
        }
    }

    public void placerMur(int valueOfPlayer, String[][] plateau) {
        //TODO : Indice du deckObstacle et remove l'indice choisit...modifs

        System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckObstacle() + " est votre deck d'obstacles ");
        System.out.println(" Quel indice d'obstacle de votre deck voulez-vous placer ? ");
        int indiceObs = scanner.nextInt();
        System.out.println(" Indiquer les coordonnées de votre mur en X");
        int posXMur = scanner.nextInt();
        System.out.println(" Indiquer les coordonnées de votre mur en Y");
        int posYMur = scanner.nextInt();
        if (indiceObs == 0 || indiceObs == 1 || indiceObs == 2) {
            plateau[posXMur][posYMur] = " obstacle marron ";
        } else if (indiceObs == 3 || indiceObs == 4) {
            plateau[posXMur][posYMur] = " obstacle de glace ";
        }
    }

    public void executerProgramme(int valueOfPlayer) {
        //TODO : Lire chaque indice du programme
        //       switch case de string pour differencier les cartes
        //       switch case des directions
        //       faire les commande de chaque cartes
        //       Plateau en param comme methode placerMur ??
        
        System.out.println(" Votre programme est : " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme());
        for (int i = 0; i < GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size(); i++) {

        }
    }

}
