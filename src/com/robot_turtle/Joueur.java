package com.robot_turtle;

import java.util.Scanner;

public class Joueur {

    public static Scanner scanner = new Scanner(System.in);
    private int numero;
    private int posX; // Position tortue
    private int posY; // Position tortue
    private int posXInit; // Position tortue initiale
    private int posYInit; // Position tortue initiale

    private String direction = " SUD "; // Direction initiale de la tortue
    public int choixInstruction;
    private GestionCartes toutesCartes; // Avoir accès aux jeux de cartes de chaque joueur
    //private GestionObstacles tousObstacles;


    public Joueur(int numero) {
        this.numero = numero;
        this.toutesCartes = new GestionCartes(numero); //creer un env de cartes qui est associé au joueur du meme numero
        //this.tousObstacles = new GestionObstacles(numero);
    }


    public int getPosXInit() { return posXInit; }

    public void setPosXInit(int posXInit) { this.posXInit = posXInit; }

    public int getPosYInit() { return posYInit; }

    public void setPosYInit(int posYInit) { this.posYInit = posYInit; }

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

   /* public GestionObstacles getTousObstacles() {
        return tousObstacles;
    }

    public void setTousObstacles(GestionObstacles tousObstacles) {
        this.tousObstacles = tousObstacles;
    }*/

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
        for (int i = 0; i < Game.nbJoueurs; i++) {
            System.out.println(" Tour de Joueur " + GestionJoueurs.listeJoueurs.get(i).getNumero() +
                    "\n 0 : Tapez 0 pour passer ou si vous avez déjà gagné");
            System.out.println(" 1 : Compléter programme " +
                    " \n 2 : Placer un mur  " +
                    " \n 3 : Exécuter programme  " +
                    " \n 4 : Tapez 4 si vous etes tout seul sur le plateau " );
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
                    executerProgramme(i,plateau.getPlateau());
                    collision2Joueurs(Game.nbJoueurs,plateau.getPlateau());
                    collisionFinale(Game.nbJoueurs, i ,plateau.getPlateau());
                    plateau.afficherPlateau();
                    break;
                case 4:
                    Game.finDuJeu = 1;
                    System.out.println(" ***** FIN DU JEU ***** " +
                            " \n Vous n'avez pas réussi a rejoindre le joyau a temps " +
                            " \n Vous avez malheureusement perdu... ");
                    break;
            }
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
                switch (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().get(i)) {
                    case BLEU: // Le joueur souhaite avancer
                        switch (GestionJoueurs.listeJoueurs.get(valueOfPlayer).getDirection()) {
                            case " SUD ":
                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() + 1);
                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero();
                                break;
                            case " NORD ":
                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() - 1);
                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero();
                                break;
                            case " EST ":
                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY() - 1);
                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero();
                                break;
                            case " OUEST ":
                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY() + 1);
                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero();
                                break;
                        }
                        break;
                    case JAUNE:  // Le joueur souhaite faire un decalage de 90° vers la gauche
                        switch (GestionJoueurs.listeJoueurs.get(valueOfPlayer).getDirection()) {
                            case " SUD ":
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" OUEST ");       // Si direction = SUD : prochaine direction = OUEST
                                break;
                            case " NORD ":
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" EST ");       // Si direction = NORD : prochaine direction = EST
                                break;
                            case " EST ":
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" SUD ");       // Si direction = EST : prochaine direction = SUD
                                break;
                            case " OUEST ":
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" NORD ");       // Si direction = OUEST : prochaine direction = NORD
                                break;
                        }
                        break;
                    case VIOLET:  // Le joueur souhaite faire un ecalage de 90° vers la droite
                        switch (GestionJoueurs.listeJoueurs.get(valueOfPlayer).getDirection()) {
                            case " SUD ":
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" EST ");       // Si direction = SUD : prochaine direction = EST
                                break;
                            case " NORD ":
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" OUEST ");     // Si direction = NORD : prochaine direction = EST
                                break;
                            case " EST ":
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" NORD ");      // Si direction = EST : prochaine direction = EST
                                break;
                            case " OUEST ":
                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" SUD ");       // Si direction = OUEST : prochaine direction = EST
                                break;
                        }
                        break;
                }
        }

        // Réinitialiser le programme de chaque joueurs après exécution
        for (int i = 0; i < GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size(); i++){
            do{
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDefausse().add(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().get(i));
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().remove(i);
            }while(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size() != 0);
        }

    }


    public void collision2Joueurs(int nombreDeJoueur, String [][] plateau) {
        switch (nombreDeJoueur) {
            case 2:
                if (GestionJoueurs.listeJoueurs.get(0).getPosX() == GestionJoueurs.listeJoueurs.get(1).getPosX() && GestionJoueurs.listeJoueurs.get(0).getPosY() == GestionJoueurs.listeJoueurs.get(1).getPosY()) {
                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                    plateau[GestionJoueurs.listeJoueurs.get(0).getPosX()][GestionJoueurs.listeJoueurs.get(0).getPosY()] = "        0        ";
                    plateau[GestionJoueurs.listeJoueurs.get(1).getPosX()][GestionJoueurs.listeJoueurs.get(1).getPosY()] = "        0        ";
                    plateau[GestionJoueurs.listeJoueurs.get(0).getPosXInit()][GestionJoueurs.listeJoueurs.get(0).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(0).getNumero();
                    plateau[GestionJoueurs.listeJoueurs.get(1).getPosXInit()][GestionJoueurs.listeJoueurs.get(1).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(1).getNumero();
                }
                break;
            case 3:
                //TODO: a verifier
               for (int i = 0; i < 1; i++) {           // Imposer joueur1
                    for (int j = 1; j < 2; j++) {      // Imposer joueur2
                        for (int k = 2; k < 3; k++) {  // Imposer joueur3

                            if (GestionJoueurs.listeJoueurs.get(i).getPosX() == GestionJoueurs.listeJoueurs.get(j).getPosX() && GestionJoueurs.listeJoueurs.get(i).getPosY() == GestionJoueurs.listeJoueurs.get(j).getPosY()) {
                                System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                plateau[GestionJoueurs.listeJoueurs.get(i).getPosX()][GestionJoueurs.listeJoueurs.get(i).getPosY()] = "        0        ";
                                plateau[GestionJoueurs.listeJoueurs.get(j).getPosX()][GestionJoueurs.listeJoueurs.get(j).getPosY()] = "        0        ";
                                plateau[GestionJoueurs.listeJoueurs.get(i).getPosXInit()][GestionJoueurs.listeJoueurs.get(i).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(i).getNumero();
                                plateau[GestionJoueurs.listeJoueurs.get(j).getPosXInit()][GestionJoueurs.listeJoueurs.get(j).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(j).getNumero();
                            }
                            else if (GestionJoueurs.listeJoueurs.get(i).getPosX() == GestionJoueurs.listeJoueurs.get(k).getPosX() && GestionJoueurs.listeJoueurs.get(i).getPosY() == GestionJoueurs.listeJoueurs.get(k).getPosY()) {
                                System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                plateau[GestionJoueurs.listeJoueurs.get(i).getPosX()][GestionJoueurs.listeJoueurs.get(i).getPosY()] = "        0        ";
                                plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                plateau[GestionJoueurs.listeJoueurs.get(i).getPosXInit()][GestionJoueurs.listeJoueurs.get(i).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(i).getNumero();
                                plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(k).getNumero();
                            }
                            else if (GestionJoueurs.listeJoueurs.get(j).getPosX() == GestionJoueurs.listeJoueurs.get(k).getPosX() && GestionJoueurs.listeJoueurs.get(j).getPosY() == GestionJoueurs.listeJoueurs.get(k).getPosY()) {
                                System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                plateau[GestionJoueurs.listeJoueurs.get(j).getPosX()][GestionJoueurs.listeJoueurs.get(j).getPosY()] = "        0        ";
                                plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                plateau[GestionJoueurs.listeJoueurs.get(j).getPosXInit()][GestionJoueurs.listeJoueurs.get(j).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(j).getNumero();
                                plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(k).getNumero();
                            }
                        }

                    }
                }
                break;
            case 4:
                for (int i = 0; i < 1; i++) {               // Imposer joueur1
                    for (int j = 1; j < 2; j++) {           // Imposer joueur2
                        for (int k = 2; k < 3; k++) {       // Imposer joueur3
                            for (int l = 3; l < 4 ; l++) {  // Imposer joueur4

                                if (GestionJoueurs.listeJoueurs.get(i).getPosX() == GestionJoueurs.listeJoueurs.get(j).getPosX() && GestionJoueurs.listeJoueurs.get(i).getPosY() == GestionJoueurs.listeJoueurs.get(j).getPosY()) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosX()][GestionJoueurs.listeJoueurs.get(i).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosX()][GestionJoueurs.listeJoueurs.get(j).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosXInit()][GestionJoueurs.listeJoueurs.get(i).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(i).getNumero();
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosXInit()][GestionJoueurs.listeJoueurs.get(j).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(j).getNumero();
                                }
                                else if (GestionJoueurs.listeJoueurs.get(i).getPosX() == GestionJoueurs.listeJoueurs.get(k).getPosX() && GestionJoueurs.listeJoueurs.get(i).getPosY() == GestionJoueurs.listeJoueurs.get(k).getPosY()) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosX()][GestionJoueurs.listeJoueurs.get(i).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosXInit()][GestionJoueurs.listeJoueurs.get(i).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(i).getNumero();
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(k).getNumero();
                                }
                                else if (GestionJoueurs.listeJoueurs.get(i).getPosX() == GestionJoueurs.listeJoueurs.get(l).getPosX() && GestionJoueurs.listeJoueurs.get(i).getPosY() == GestionJoueurs.listeJoueurs.get(l).getPosY()) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosX()][GestionJoueurs.listeJoueurs.get(i).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosX()][GestionJoueurs.listeJoueurs.get(l).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosXInit()][GestionJoueurs.listeJoueurs.get(i).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(i).getNumero();
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosXInit()][GestionJoueurs.listeJoueurs.get(l).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(l).getNumero();
                                }
                                else if (GestionJoueurs.listeJoueurs.get(j).getPosX() == GestionJoueurs.listeJoueurs.get(k).getPosX() && GestionJoueurs.listeJoueurs.get(j).getPosY() == GestionJoueurs.listeJoueurs.get(k).getPosY()) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosX()][GestionJoueurs.listeJoueurs.get(j).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosXInit()][GestionJoueurs.listeJoueurs.get(j).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(j).getNumero();
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(k).getNumero();
                                }
                                else if (GestionJoueurs.listeJoueurs.get(j).getPosX() == GestionJoueurs.listeJoueurs.get(l).getPosX() && GestionJoueurs.listeJoueurs.get(j).getPosY() == GestionJoueurs.listeJoueurs.get(l).getPosY()) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosX()][GestionJoueurs.listeJoueurs.get(j).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosX()][GestionJoueurs.listeJoueurs.get(l).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosXInit()][GestionJoueurs.listeJoueurs.get(j).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(j).getNumero();
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosXInit()][GestionJoueurs.listeJoueurs.get(l).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(l).getNumero();
                                }
                                else if (GestionJoueurs.listeJoueurs.get(k).getPosX() == GestionJoueurs.listeJoueurs.get(l).getPosX() && GestionJoueurs.listeJoueurs.get(k).getPosY() == GestionJoueurs.listeJoueurs.get(l).getPosY()) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosX()][GestionJoueurs.listeJoueurs.get(l).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(k).getNumero();
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosXInit()][GestionJoueurs.listeJoueurs.get(l).getPosYInit()] = "      tortue    " + GestionJoueurs.listeJoueurs.get(l).getNumero();
                                }
                            }
                        }

                    }
                }
                break;
        }
    }

    //TODO: méthode collision si joueur out of bands




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
            case 3:
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
                    //GestionJoueurs.listeJoueurs.remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer));
                }
                else if (positionXJoueur3 == positionXJoyau2  && positionYJoueur3 == positionYJoyau2) {
                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "     joyau " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                    //GestionJoueurs.listeJoueurs.remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer));
                }
                else if (positionXJoueur3 == positionXJoyau3  && positionYJoueur3 == positionYJoyau3) {
                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "     joyau " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                    //GestionJoueurs.listeJoueurs.remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer));
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
                    //GestionJoueurs.listeJoueurs.remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer));
                }
                else if (positionXJoueur4 == positionXJoyau2_4  && positionYJoueur4 == positionYJoyau2_4) {
                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "     joyau " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                    //GestionJoueurs.listeJoueurs.remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer));
                }
                break;
        }
    }






}

