package com.robot_turtle;

import java.util.Scanner;

public class Joueur {

    public static Scanner scanner = new Scanner(System.in);
    private int numero;
    private int posX; // Position tortue
    private int posY; // Position tortue
    private String direction = " SUD "; // Direction initiale de la tortue
    public int choixInstruction;
    private GestionCartes toutesCartes; // Avoir accès aux jeux de cartes de chaque joueur


    public Joueur(int numero) {
        this.numero = numero;
        this.toutesCartes = new GestionCartes(numero); //creer un env de cartes qui est associé au joueur du meme numero
    }



    public String getDirection() { return direction; }

    public void setDirection(String direction) { this.direction = direction; }

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

    public GestionCartes getToutesCartes() {
        return toutesCartes;
    }

    public void setToutesCartes(GestionCartes toutesCartes) {
        this.toutesCartes = toutesCartes;
    }



    public void instruction(Plateau plateau) {
        for (int i = 0; i < Game.nbJoueurs; i++) {  // Parcourir les indices de la liste du nombre de joueur
            //for (int j = 0; j < Game.nbJoueurs-1; ){ // Parcourir les indices de la liste du nombre de joyaux
                    //if (GestionJoueurs.listeJoueurs.get(i).getPosX() != GestionJoyaux.listeJoyaux.get(j).getPosXJoyau() && GestionJoueurs.listeJoueurs.get(i).getPosY() != GestionJoyaux.listeJoyaux.get(j).getPosYJoyau()) {
                        System.out.println(" Tour de Joueur " + GestionJoueurs.listeJoueurs.get(i).getNumero());
                        System.out.println(" 1 : Compléter programme " +
                                " \n 2 : Placer un mur  " +
                                " \n 3 : Exécuter programme  ");
                        choixInstruction = scanner.nextInt();
                        switch (choixInstruction) {
                            case 1:
                                completerProgramme(i);
                                //i++;
                                break;
                            case 2:
                                placerMur(i,plateau.getPlateau());
                                plateau.afficherPlateau();
                                //i++;
                                break;
                            case 3:
                                executerProgramme(i,plateau.getPlateau());
                                //plateau.afficherPlateau();
                                //i++;
                                collisionFinale(Game.nbJoueurs, i ,plateau.getPlateau());
                                plateau.afficherPlateau();

                        }
                    //}
                    /*else {
                        System.out.println(" Le jeu est terminé ! ");
                        System.out.println(" Merci d'avoir participé et à bientôt !");
                    }*/

            //}
        }
    }


    public void completerProgramme(int valueOfPlayer) {
        System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes \n" +
                " Combien de carte(s) voulez-vous ajouter à votre programme ? ");
        int nombreCarte = scanner.nextInt();
        if (nombreCarte == 0){
            System.out.println(" Tapez 1 pour mettre des cartes à la défausse ");
            int choix0 = scanner.nextInt();
            if(choix0 == 1){
                System.out.println("Combien de carte(s) voulez-vous mettre à la défausse ? ");
                int combien0 = scanner.nextInt();
                for (int j = 0; j < combien0; j++) {
                    System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes \n");
                    System.out.println(" Quel indice de carte voulez-vous mettre à la défausse ? ");
                    int indiceDefausse0 = scanner.nextInt();
                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDefausse().add(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indiceDefausse0));
                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indiceDefausse0));
                }
                System.out.println(" Votre deck de cartes est maintenant " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte());
                System.out.println(" Tapez 1 pour piocher ");
                int pioche0 = scanner.nextInt();
                if (pioche0 == 1){
                    do{
                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().add((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().get((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1))));
                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().remove((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1));
                    } while (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().size() != 5);
                }
                System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes ");
            }
        }
        else {
        for (int i = 0; i < nombreCarte; i++) {
            System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes \n");
            System.out.println(" Quel indice de carte voulez-vous ajouter ");
            int indice = scanner.nextInt();
            GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().add(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indice));
            GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indice));
        }
        System.out.println(" Votre deck de cartes est maintenant:" + (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte()) +
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
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indiceDefausse));
            }
            System.out.println(" Votre deck de cartes est maintenant " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte());
            System.out.println(" Tapez 1 pour piocher ");
            int pioche = scanner.nextInt();
            if (pioche == 1){
                do{
                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().add((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().get((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1))));
                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().remove((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1));
                } while (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().size() != 5);
            }
            System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes ");
        } else if (choix == 1) {
            do {
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().add((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().get((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1))));
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().remove((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1));
            } while (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().size() != 5);
            System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes ");
        }
        }
    }

    public void placerMur(int valueOfPlayer, String[][] plateau) {
        System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckObstacle() + " est votre deck d'obstacles ");
        System.out.println(" Quel indice d'obstacle de votre deck voulez-vous placer ? ");
        int indiceObs = scanner.nextInt();
       switch (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckObstacle().get(indiceObs)){
           case PIERRE:
               System.out.println(" Indiquer les coordonnées de votre mur en X");
               int posXMur_Marron = scanner.nextInt();
               System.out.println(" Indiquer les coordonnées de votre mur en Y");
               int posYMur_Marron = scanner.nextInt();
               plateau[posXMur_Marron][posYMur_Marron] = " obstacle marron ";
               break;
           case GLACE:
               System.out.println(" Indiquer les coordonnées de votre mur en X");
               int posXMur_Glace = scanner.nextInt();
               System.out.println(" Indiquer les coordonnées de votre mur en Y");
               int posYMur_Glace = scanner.nextInt();
               plateau[posXMur_Glace][posYMur_Glace] = "obstacle de glace";
               break;
       }
        GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckObstacle().remove(indiceObs);
    }

    public void executerProgramme(int valueOfPlayer,  String[][] plateau) {
        System.out.println(" Votre programme est : " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme());
        for (int i = 0; i < GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size(); i++) {
            switch (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().get(i)){
                case BLEU:
                    switch (GestionJoueurs.listeJoueurs.get(valueOfPlayer).getDirection()){
                        case " SUD ":
                            plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                            GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() + 1);
                            plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() ;
                            break;
                        case " EST ":
                            plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                            GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY() + 1);
                            plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "      tortue    "  + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() ;
                            break;
                        case " OUEST ":
                            plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                            GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY() - 1);
                            plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "      tortue    "  + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() ;
                            break;
                    }
                    break;
                case JAUNE:
                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" EST ");
                    break;
                case VIOLET:
                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" OUEST ");
                    break;
            }
            //TODO: Si 2 VIOLETS : direction = SUD
            //      Si 2 JAUNES : direction = SUD
            //                  ou
            //TODO: Creer une carte pour la direction SUD ????

            /*for (int j = 0; i < GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size(); j++){
                if ( GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().get(j))
            }*/
        }

        for (int i = 0; i < GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size(); i++){
            do{
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().remove(i);
            }while(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size() != 0);
        }
    }


    public void collisionFinale(int nombreDeJoueur, int valueOfPlayer, String [][] plateau){
        switch (nombreDeJoueur){
            case 2:
                int positionXJoyau = GestionJoyaux.listeJoyaux.get(0).getPosXJoyau();
                int positionYJoyau = GestionJoyaux.listeJoyaux.get(0).getPosYJoyau();
                int positionXJoueur2 = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX();
                int positionYJoueur2 = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY();
                if (positionXJoueur2 == positionXJoyau && positionYJoueur2 == positionYJoyau){
                   plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "     joyau " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
                   System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau en 1er " +
                           " \n\n Vous avez gagné la partie !!!!! \n");
                }
               break;
            case 3: //TODO: Arreter le tour du premier joueur a trouver joyau et deuxieme...
                int positionXJoyau1 = GestionJoyaux.listeJoyaux.get(0).getPosXJoyau();
                int positionYJoyau1 = GestionJoyaux.listeJoyaux.get(0).getPosYJoyau();
                int positionXJoyau2 = GestionJoyaux.listeJoyaux.get(1).getPosXJoyau();
                int positionYJoyau2 = GestionJoyaux.listeJoyaux.get(1).getPosYJoyau();
                int positionXJoyau3 = GestionJoyaux.listeJoyaux.get(2).getPosXJoyau();
                int positionYJoyau3 = GestionJoyaux.listeJoyaux.get(2).getPosYJoyau();

                int positionXJoueur3 = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX();
                int positionYJoueur3 = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY();

                if (positionXJoueur3 == positionXJoyau1  && positionYJoueur3 == positionYJoyau1) {
                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "     joyau " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                }
                else if (positionXJoueur3 == positionXJoyau2  && positionYJoueur3 == positionYJoyau2) {
                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "     joyau " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                }
                else if (positionXJoueur3 == positionXJoyau3  && positionYJoueur3 == positionYJoyau3) {
                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "     joyau " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                }
                break;
            case 4:
                int positionXJoyau1_4 = GestionJoyaux.listeJoyaux.get(0).getPosXJoyau();
                int positionYJoyau1_4 = GestionJoyaux.listeJoyaux.get(0).getPosYJoyau();
                int positionXJoyau2_4 = GestionJoyaux.listeJoyaux.get(1).getPosXJoyau();
                int positionYJoyau2_4 = GestionJoyaux.listeJoyaux.get(1).getPosYJoyau();

                int positionXJoueur4 = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX();
                int positionYJoueur4 = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY();

                if (positionXJoueur4 == positionXJoyau1_4  && positionYJoueur4 == positionYJoyau1_4) {
                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "     joyau " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                }
                else if (positionXJoueur4 == positionXJoyau2_4  && positionYJoueur4 == positionYJoyau2_4) {
                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "     joyau " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                }
        }

        /*for (int i = 0; i < Game.nbJoueurs; i++) {
            for (int j = 0; j < Game.nbJoueurs-1; j++) {
                int positionXJoyau = GestionJoyaux.listeJoyaux.get(j).getPosXJoyau();
                int positionYJoyau = GestionJoyaux.listeJoyaux.get(j).getPosYJoyau();
                int positionXJoueur = GestionJoueurs.listeJoueurs.get(i).getPosX();
                int positionYJoueur = GestionJoueurs.listeJoueurs.get(i).getPosY();
                if (positionXJoueur == positionXJoyau && positionYJoueur == positionYJoyau){
                    plateau[positionXJoueur][positionYJoueur] = "     joyau " + GestionJoyaux.listeJoyaux.get(j).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(i).getNumero() + " vous avez atteint le joyau en 1er " +
                            " \n\n Vous avez gagné la partie !!!!! \n");
                    for (int k = 0; k < 15; k++) {
                        System.out.println("\n");
                    }
                }
            }
        }*/
    }




    }


