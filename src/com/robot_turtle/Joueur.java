package com.robot_turtle;

import java.util.Scanner;

public class Joueur {

    public static Scanner scanner = new Scanner(System.in);
    private int numero;
    private int posX;                   // Position tortue
    private int posY;                   // Position tortue
    private int posXInit;               // Position tortue initiale
    private int posYInit;               // Position tortue initiale
    private String direction = " SUD "; // Direction initiale de la tortue
    public int choixInstruction;
    private GestionCartes toutesCartes; // Avoir accès aux jeux de cartes de chaque joueur




    public Joueur(int numero) {
        this.numero = numero;
        this.toutesCartes = new GestionCartes(numero); // Creer un env de cartes qui est associé au joueur du meme numero
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
                    try{                                                                                // Essayer d'executer le prgramme et les fonctions de collisions
                        executerProgramme(i,Game.nbJoueurs,plateau.getPlateau());
                        collision2Joueurs(Game.nbJoueurs,plateau.getPlateau());                         // S'execute  si collision entre 2 joueurs
                        collisionFinale(Game.nbJoueurs, i ,plateau.getPlateau());                       // S'execute si un joueur atteint un joyau
                        plateau.afficherPlateau();                                                      // Affiche le plateau à chaque fois qu'un joueur execute son programme et affiche tous les parametres ajoutés au plateau
                    }catch (Exception e){                                                               // Si on a une erreur c'est que le joueurs est sorti du plateau
                        System.out.println("Retour à la case départ, vous etes sorti du plateau " +
                                "\n Attention, vous retrouvez votre direction initale !");
                        collisionHorsPlateau(i,plateau.getPlateau());                                            // On renvoit ainsi le joueur en question à sa position initiale
                        plateau.afficherPlateau();
                    }
                    break;
                case 4:
                    Game.finDuJeu = 1;                                                                  // Impact dans le main
                    System.out.println("Vous n'avez pas réussi a rejoindre le joyau a temps " +
                            " \nVous avez malheureusement perdu... ");
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
                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDefausse().add(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indiceDefausse0));     // Ajout de la carte retirée du deck a la defausse du joueur
                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indiceDefausse0)); // On retire la carte retirée du deck de cartes
                }
                System.out.println(" Votre deck de cartes est maintenant " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte());
                System.out.println(" Tapez 1 pour piocher ");
                int pioche0 = scanner.nextInt();
                if (pioche0 == 1){
                    do{
                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().add((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().get((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1))));  // Ajout du nombre de cartes manquant au deck pour avoir 5 cartes dans le deck
                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().remove((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1)); // On retire les cartes piochées piochées dans la pioche et destinées au deck de carte
                    } while (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().size() != 5);
                }
                System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes ");
            }
        }
        else {
        for (int i = 0; i < nombreCarte; i++) {
            System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes \n");
            System.out.println(" Quel indice de carte voulez-vous ajouter ?");
            int indice = scanner.nextInt();
            GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().add(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indice));     // Ajouter la carte choisit au programme
            GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indice));  // On retire la carte choisit du deck de carte
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
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDefausse().add(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indiceDefausse));      // Ajout de la carte choisit à la défausse du joueur
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().remove(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().get(indiceDefausse));  // On retire la carte choisit du deck de cartes
            }
            System.out.println(" Votre deck de cartes est maintenant " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte());
            System.out.println(" Tapez 1 pour piocher ");
            int pioche = scanner.nextInt();
            if (pioche == 1){
                do{
                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().add((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().get((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1)))); // Ajout du nombre de cartes manquant au deck pour avoir 5 cartes dans le deck
                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().remove((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1)); // On retire les cartes piochées dans la pioche et destinées au deck de carte
                } while (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().size() != 5);
            }
            System.out.println(GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte() + " est votre deck de cartes ");
        } else if (choix == 1) {
            do {
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckCarte().add((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().get((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1)))); // Ajout du nombre de cartes manquant au deck pour avoir 5 cartes dans le deck
                GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().remove((GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getPioche().size() - 1)); // On retire les cartes piochées piochées dans la pioche et destinées au deck de carte
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
               plateau[posXMur_Marron][posYMur_Marron] = "  mur en pierre  ";
               break;
           case GLACE:
               System.out.println(" Indiquer les coordonnées de votre mur en X");
               int posXMur_Glace = scanner.nextInt();
               System.out.println(" Indiquer les coordonnées de votre mur en Y");
               int posYMur_Glace = scanner.nextInt();
               plateau[posXMur_Glace][posYMur_Glace] = "   mur en glace  ";
               break;
       }
        GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getDeckObstacle().remove(indiceObs);
    }



    public void executerProgramme(int valueOfPlayer, int nombreDeJoueur, String[][] plateau) {
        System.out.println(" Votre programme est : " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme());

        for (int i = 0; i < GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size(); i++) {
                switch (GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().get(i)) {
                    case BLEU: // Le joueur souhaite avancer
                       /* if ( (GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()==GestionJoueurs.listeJoueurs.get(valueOfPlayer+1).getPosX() || GestionJoueurs.listeJoueurs.get(valueOfPlayer+1).getPosX()==GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() ) && (GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()==GestionJoueurs.listeJoueurs.get(valueOfPlayer+1).getPosY() || GestionJoueurs.listeJoueurs.get(valueOfPlayer+1).getPosY()==GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY() ) ){


                        }*/
                        switch (GestionJoueurs.listeJoueurs.get(valueOfPlayer).getDirection()) {
                            case " SUD ":
                                // Conditions si le joueur heurte un obstacle de pierre : direction = NORD
                                if ( plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()+1][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()].equals("  mur en pierre  ")) {     // Le joueur avance et se retrouve a la case obstacle
                                    System.out.println(" Demi-tour, vous avez heurté un obstacle, attention votre direction a tourné de 180° ");
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" NORD ");   // Il n'a pas le droit d'y etre et fait ainsi demi-tour, le programme continue de s'executer avec cette nouvelle direction
                                }
                                // Conditions si le joueur heurte un obstacle de glace : direction = NORD
                                else if (plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()+1][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()].equals("   mur en glace  ") ){
                                    System.out.println(" Demi-tour, vous avez heurté un obstacle, attention votre direction a tourné de 180° ");
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" NORD ");
                                }
                                // Si pas d'obstacles alors le joueur avance vers le SUD
                                else {
                                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() + 1);
                                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                }
                                break;
                            case " NORD ":
                                // Conditions si le joueur heurte un obstacle de pierre : direction = SUD
                                if (plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()-1][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()].equals("  mur en pierre  ") ){
                                    System.out.println(" Demi-tour, vous avez heurté un obstacle, attention votre direction a tourné de 180° ");
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" SUD ");
                                }
                                // Conditions si le joueur heurte un obstacle de glace : direction = SUD
                                else if (plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()-1][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()].equals("   mur en glace  ") ){
                                    System.out.println(" Demi-tour, vous avez heurté un obstacle, attention votre direction a tourné de 180° ");
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" SUD ");
                                }
                                // Si pas d'obstacles alors le joueur avance vers le NORD
                                else {
                                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() - 1);
                                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                }
                                break;
                            case " EST ":
                                // Conditions si le joueur heurte un obstacle de pierre : direction = OUEST
                                if (plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()-1].equals("  mur en pierre  ") ){
                                    System.out.println(" Demi-tour, vous avez heurté un obstacle, attention votre direction a tourné de 180° ");
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" OUEST ");
                                }
                                // Conditions si le joueur heurte un obstacle de glace : direction = OUEST
                                else if (plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()-1].equals("   mur en glace  ") ){
                                    System.out.println(" Demi-tour, vous avez heurté un obstacle, attention votre direction a tourné de 180° ");
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" OUEST ");
                                }
                                // Si pas d'obstacles alors le joueur avance vers l'EST
                                else {
                                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY() - 1);
                                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                }
                                break;
                            case " OUEST ":
                                // Conditions si le joueur heurte un obstacle de pierre : direction = EST
                                if (plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()+1].equals("  mur en pierre  ") ){
                                    System.out.println(" Demi-tour, vous avez heurté un obstacle, attention votre direction a tourné de 180° ");
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" EST ");
                                }
                                // Conditions si le joueur heurte un obstacle de glace : direction = EST
                                else if (plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()+1].equals("   mur en glace  ") ){
                                    System.out.println(" Demi-tour, vous avez heurté un obstacle, attention votre direction a tourné de 180° ");
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" EST ");
                                }
                                // Si pas d'obstacles alors le joueur avance vers l'OUEST
                                else {
                                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                    GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY() + 1);
                                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                }
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
                    case ROUGE: // Le joueur souhaite utiliser un laser dans sa direction
                        //TODO: TOUT REVOIR !!!!!
                            switch (GestionJoueurs.listeJoueurs.get(valueOfPlayer).getDirection()) {
                                case " SUD ":
                                    boolean test = true;
                                    //for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()+1; j < 8 ; j++) { // Parcourir la colonne entre la tortue qui envoie un laser et la derniere ligne du plateau
                                    //for (int k = 0; k < Game.nbJoueurs; k++) { // Parcourir le nombre de joueur
                                    //System.out.println(k);
                                    for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() + 1; j < 8; j++) {
                                        if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("   mur en glace  ")) {
                                            // On remplace la case de l'obstacle detruit par une case vide
                                            System.out.println("Vous avez détruit l'obstacle devant vous \n");
                                            plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                            test = false;
                                        }
                                    }
                                    switch (nombreDeJoueur) {
                                        case 2: //TODO: A REVOIR !!!
                                            for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() + 1; j < 8; j++) {
                                                for (int k = 0; k < nombreDeJoueur; k++) {
                                                    if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") && test == true) {
                                                        // La tortue touchée fait demi-tour
                                                        System.out.println("Vous avez touché une tortue, celle-ci fait demi-tour \n");
                                                        GestionJoueurs.listeJoueurs.get(k).setDirection(" NORD ");
                                                        test = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && test == true) {
                                                        System.out.println("Vous avez touché un joyau, vous faites donc demi-tour : attention votre direction est décalée de 180° \n");
                                                        // La tortue qui a envoyé le laser fait demi-tour
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" NORD");
                                                        test = false;
                                                    }
                                                }
                                            }
                                            break;
                                        case 3:
                                        case 4:
                                            for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() + 1; j < 8; j++) {
                                                for (int k = 0; k < nombreDeJoueur; k++) {
                                                    if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") && test == true) {
                                                        System.out.println("La tortue " + GestionJoueurs.listeJoueurs.get(k).getNumero() + " a été touchée par un laser et retourne donc a sa position initiale \n");
                                                        // Position de la tortue touchée devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue touchée a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue touchée : sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(k).setPosX(GestionJoueurs.listeJoueurs.get(k).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(k).setPosY(GestionJoueurs.listeJoueurs.get(k).getPosYInit());
                                                        test = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && test == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ") && test == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(2).getNumeroJoyau() + "     ") && test == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test = false;
                                                    }
                                                }

                                            }
                                            break;
                                    }
                                        /*if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("   mur en glace  ")) {
                                                // On remplace la case de l'obstacle detruit par une case vide
                                                System.out.println("Vous avez détruit l'obstacle devant vous \n");
                                                plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                test = false;
                                            }
                                            else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") && Game.nbJoueurs == 2 && test == true) {
                                                // La tortue touchée fait demi-tour
                                                System.out.println("Vous avez touché une tortue, celle-ci fait demi-tour \n");
                                                GestionJoueurs.listeJoueurs.get(k).setDirection(" NORD ");
                                                test = false;
                                            }*/
                                            /*else if ( (plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") && Game.nbJoueurs > 2 && test == true){
                                                System.out.println("La tortue " + GestionJoueurs.listeJoueurs.get(k).getNumero() + " a été touchée par un laser et retourne donc a sa position initiale \n");
                                                // Position de la tortue touchée devient une case vide
                                                plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                                // Renvoie de la tortue touchée a sa position initiale
                                                plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "   tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero();
                                                // Réattribuer les parametres initiaux a la tortue touchée : sa direction reste le SUD
                                                GestionJoueurs.listeJoueurs.get(k).setPosX(GestionJoueurs.listeJoueurs.get(k).getPosXInit());
                                                GestionJoueurs.listeJoueurs.get(k).setPosY(GestionJoueurs.listeJoueurs.get(k).getPosYInit());
                                                test = false;
                                            }
                                            else if ( (plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && Game.nbJoueurs == 2 && test == true ){
                                                System.out.println("Vous avez touché un joyau, vous faites donc demi-tour : attention votre direction est décalée de 180° \n");
                                                // La tortue qui a envoyé le laser fait demi-tour
                                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" NORD");
                                                test = false;
                                            }
                                            else if ( (plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && Game.nbJoueurs > 2 && test == true){
                                                System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                // Position de la tortue ayant envoyé le laser devient une case vide
                                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                // Renvoie de la tortue a sa position initiale
                                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                test = false;
                                            }
                                            else if ( (plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ") && Game.nbJoueurs > 2 && test == true){
                                                System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                // Position de la tortue ayant envoyé le laser devient une case vide
                                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                // Renvoie de la tortue a sa position initiale
                                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                test = false;
                                            }
                                            else if ( (plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(2).getNumeroJoyau() + "     ") && Game.nbJoueurs > 2 && test == true ){
                                                System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                // Position de la tortue ayant envoyé le laser devient une case vide
                                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                // Renvoie de la tortue a sa position initiale
                                                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                test = false;
                                            }*/
                                    //}
                                    //}
                                    //break;
                                case " NORD ":
                                    boolean test2 = true;
                                    for (int j = 0 ; j <= GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() - 1; j++) {
                                        if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("   mur en glace  ")) {
                                            // On remplace la case de l'obstacle detruit par une case vide
                                            System.out.println("Vous avez détruit l'obstacle devant vous \n");
                                            plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                            test2 = false;
                                        }
                                    }
                                    switch (nombreDeJoueur) {
                                        case 2:
                                            for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() - 1; j <= 0; j--) {
                                                for (int k = 0; k < nombreDeJoueur; k++) {
                                                    if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") && test2 == true) {
                                                        // La tortue touchée fait demi-tour
                                                        System.out.println("Vous avez touché une tortue, celle-ci fait demi-tour \n");
                                                        GestionJoueurs.listeJoueurs.get(k).setDirection(" NORD ");
                                                        test2 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && test2 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous faites donc demi-tour : attention votre direction est décalée de 180° \n");
                                                        // La tortue qui a envoyé le laser fait demi-tour
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" NORD");
                                                        test2 = false;
                                                    }
                                                }
                                            }
                                            break;
                                        case 3:
                                        case 4:
                                            for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() - 1; j <= 0; j--) {
                                                for (int k = 0; k < nombreDeJoueur; k++) {
                                                    if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") && test2 == true) {
                                                        System.out.println("La tortue " + GestionJoueurs.listeJoueurs.get(k).getNumero() + " a été touchée par un laser et retourne donc a sa position initiale \n");
                                                        // Position de la tortue touchée devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue touchée a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "   tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero();
                                                        // Réattribuer les parametres initiaux a la tortue touchée : sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(k).setPosX(GestionJoueurs.listeJoueurs.get(k).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(k).setPosY(GestionJoueurs.listeJoueurs.get(k).getPosYInit());
                                                        test2 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && test2 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test2 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ") && test2 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test2 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(2).getNumeroJoyau() + "     ") && test2 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test2 = false;
                                                    }
                                                }

                                            }
                                            break;

                                    }
                                case " OUEST ":
                                    boolean test3 = true;
                                    for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY() + 1; j < 8; j++) {
                                        if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("   mur en glace  ")) {
                                            // On remplace la case de l'obstacle detruit par une case vide
                                            System.out.println("Vous avez détruit l'obstacle devant vous \n");
                                            plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                            test = false;
                                        }
                                    }
                                    switch (nombreDeJoueur) {
                                        case 2: //TODO: A REVOIR !!!
                                            for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() + 1; j < 8; j++) {
                                                for (int k = 0; k < nombreDeJoueur; k++) {
                                                    if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") && test3 == true) {
                                                        // La tortue touchée fait demi-tour
                                                        System.out.println("Vous avez touché une tortue, celle-ci fait demi-tour \n");
                                                        GestionJoueurs.listeJoueurs.get(k).setDirection(" NORD ");
                                                        test3 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && test3 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous faites donc demi-tour : attention votre direction est décalée de 180° \n");
                                                        // La tortue qui a envoyé le laser fait demi-tour
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" NORD");
                                                        test3 = false;
                                                    }
                                                }
                                            }
                                            break;
                                        case 3:
                                        case 4:
                                            for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() + 1; j < 8; j++) {
                                                for (int k = 0; k < nombreDeJoueur; k++) {
                                                    if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") && test3 == true) {
                                                        System.out.println("La tortue " + GestionJoueurs.listeJoueurs.get(k).getNumero() + " a été touchée par un laser et retourne donc a sa position initiale \n");
                                                        // Position de la tortue touchée devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue touchée a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue touchée : sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(k).setPosX(GestionJoueurs.listeJoueurs.get(k).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(k).setPosY(GestionJoueurs.listeJoueurs.get(k).getPosYInit());
                                                        test3 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && test3 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test3 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ") && test3 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test3 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(2).getNumeroJoyau() + "     ") && test3 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test3 = false;
                                                    }
                                                }

                                            }
                                            break;
                                    }
                                case " EST ":
                                    boolean test4 = true;
                                    for (int j = 0 ; j <= GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY() - 1; j++) {
                                        if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("   mur en glace  ")) {
                                            // On remplace la case de l'obstacle detruit par une case vide
                                            System.out.println("Vous avez détruit l'obstacle devant vous \n");
                                            plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                            test4 = false;
                                        }
                                    }
                                    switch (nombreDeJoueur) {
                                        case 2: //TODO: A REVOIR !!!
                                            for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() + 1; j < 8; j++) {
                                                for (int k = 0; k < nombreDeJoueur; k++) {
                                                    if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") && test4 == true) {
                                                        // La tortue touchée fait demi-tour
                                                        System.out.println("Vous avez touché une tortue, celle-ci fait demi-tour \n");
                                                        GestionJoueurs.listeJoueurs.get(k).setDirection(" NORD ");
                                                        test4 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && test4 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous faites donc demi-tour : attention votre direction est décalée de 180° \n");
                                                        // La tortue qui a envoyé le laser fait demi-tour
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" NORD");
                                                        test4 = false;
                                                    }
                                                }
                                            }
                                            break;
                                        case 3:
                                        case 4:
                                            for (int j = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX() + 1; j < 8; j++) {
                                                for (int k = 0; k < nombreDeJoueur; k++) {
                                                    if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") && test4 == true) {
                                                        System.out.println("La tortue " + GestionJoueurs.listeJoueurs.get(k).getNumero() + " a été touchée par un laser et retourne donc a sa position initiale \n");
                                                        // Position de la tortue touchée devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue touchée a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue touchée : sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(k).setPosX(GestionJoueurs.listeJoueurs.get(k).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(k).setPosY(GestionJoueurs.listeJoueurs.get(k).getPosYInit());
                                                        test4 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && test4 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test4 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ") && test4 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test4 = false;
                                                    } else if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(2).getNumeroJoyau() + "     ") && test4 == true) {
                                                        System.out.println("Vous avez touché un joyau, vous retournez donc à votre position initiale \n");
                                                        // Position de la tortue ayant envoyé le laser devient une case vide
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "        0        ";
                                                        // Renvoie de la tortue a sa position initiale
                                                        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
                                                        // Réattribuer les parametres initiaux a la tortue ; sa direction reste le SUD
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
                                                        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
                                                        test4 = false;
                                                    }
                                                }

                                            }
                                            break;
                                    }
                                    break;

                                /* switch (Game.nbJoueurs){
                                                case 2:
                                                    int sortie = 0;
                                                        if ((plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ") ) {
                                                            // La tortue touchée fait demi-tour
                                                            System.out.println("Vous avez touché une tortue, celle-ci fait demi-tour \n");
                                                            GestionJoueurs.listeJoueurs.get(k).setDirection(" NORD ");
                                                            sortie = 1;
                                                        }
                                                        else if ( (plateau[j][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()]).equals("    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ") && sortie == 0) {
                                                            System.out.println("Vous avez touché un joyau, vous faites donc demi-tour : attention votre direction est décalée de 180° \n");
                                                            // La tortue qui a envoyé le laser fait demi-tour
                                                            GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" NORD");
                                                        }
                                                    break;
                                            }*/
                            }
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


    public void collisionHorsPlateau(int valueOfPlayer,String [][] plateau){
        plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + "    ";
        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosX(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosXInit());
        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setPosY(GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosYInit());
        GestionJoueurs.listeJoueurs.get(valueOfPlayer).setDirection(" SUD ");

    }


    public void collision2Joueurs(int nombreDeJoueur, String [][] plateau) {
        //TODO: refaire et simplifier la fonction !!!
        //TODO: collision 2 joueurs et que le programme continu : ne peut pas depasser la tortue une fois l'avoir rencontrée : retour position initiale des qu'il l'a touche
        switch (nombreDeJoueur) {
            case 2:
                // Comparaison des positions entre joueurs 1 et 2
                if (GestionJoueurs.listeJoueurs.get(0).getPosX() == GestionJoueurs.listeJoueurs.get(1).getPosX() && GestionJoueurs.listeJoueurs.get(0).getPosY() == GestionJoueurs.listeJoueurs.get(1).getPosY() ) {
                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue \n");
                    // Remplacer la position de collision des tortues par une case vide
                    plateau[GestionJoueurs.listeJoueurs.get(0).getPosX()][GestionJoueurs.listeJoueurs.get(0).getPosY()] = "        0        ";
                    plateau[GestionJoueurs.listeJoueurs.get(1).getPosX()][GestionJoueurs.listeJoueurs.get(1).getPosY()] = "        0        ";
                    // Renvoyer les tortues à leurs positions initales
                    plateau[GestionJoueurs.listeJoueurs.get(0).getPosXInit()][GestionJoueurs.listeJoueurs.get(0).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(0).getNumero() + "    ";
                    plateau[GestionJoueurs.listeJoueurs.get(1).getPosXInit()][GestionJoueurs.listeJoueurs.get(1).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(1).getNumero() + "    ";
                    // Réattribuer les parametres initiaux aux tortues retournées à leurs positions initiales
                    GestionJoueurs.listeJoueurs.get(0).setPosX(GestionJoueurs.listeJoueurs.get(0).getPosXInit());
                    GestionJoueurs.listeJoueurs.get(0).setPosY(GestionJoueurs.listeJoueurs.get(0).getPosYInit());
                    GestionJoueurs.listeJoueurs.get(1).setPosX(GestionJoueurs.listeJoueurs.get(1).getPosXInit());
                    GestionJoueurs.listeJoueurs.get(1).setPosY(GestionJoueurs.listeJoueurs.get(1).getPosYInit());
                    GestionJoueurs.listeJoueurs.get(0).setDirection(" SUD ");
                    GestionJoueurs.listeJoueurs.get(1).setDirection(" SUD ");

                }
                break;
            case 3:
               for (int i = 0; i < 1; i++) {           // Imposer joueur1
                    for (int j = 1; j < 2; j++) {      // Imposer joueur2
                        for (int k = 2; k < 3; k++) {  // Imposer joueur3

                            // Comparaison des positions entre joueurs 1 et 2
                            if ( (GestionJoueurs.listeJoueurs.get(i).getPosX() == GestionJoueurs.listeJoueurs.get(j).getPosX() || GestionJoueurs.listeJoueurs.get(j).getPosX() == GestionJoueurs.listeJoueurs.get(i).getPosX()) && (GestionJoueurs.listeJoueurs.get(i).getPosY() == GestionJoueurs.listeJoueurs.get(j).getPosY() || GestionJoueurs.listeJoueurs.get(j).getPosY() == GestionJoueurs.listeJoueurs.get(i).getPosY())) {
                                System.out.println(" Retour à la case départ, vous avez heurté une autre tortue \n");
                                // Remplacer la position de collision des tortues par une case vide
                                plateau[GestionJoueurs.listeJoueurs.get(i).getPosX()][GestionJoueurs.listeJoueurs.get(i).getPosY()] = "        0        ";
                                plateau[GestionJoueurs.listeJoueurs.get(j).getPosX()][GestionJoueurs.listeJoueurs.get(j).getPosY()] = "        0        ";
                                // Renvoyer les tortues à leurs positions initales
                                plateau[GestionJoueurs.listeJoueurs.get(i).getPosXInit()][GestionJoueurs.listeJoueurs.get(i).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(i).getNumero() + "    ";
                                plateau[GestionJoueurs.listeJoueurs.get(j).getPosXInit()][GestionJoueurs.listeJoueurs.get(j).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(j).getNumero() + "    ";

                                // Remettre les parametres initiaux aux tortues retournées à leurs positions initiales
                                GestionJoueurs.listeJoueurs.get(i).setPosX(GestionJoueurs.listeJoueurs.get(i).getPosXInit());
                                GestionJoueurs.listeJoueurs.get(i).setPosY(GestionJoueurs.listeJoueurs.get(i).getPosYInit());
                                GestionJoueurs.listeJoueurs.get(j).setPosX(GestionJoueurs.listeJoueurs.get(j).getPosXInit());
                                GestionJoueurs.listeJoueurs.get(j).setPosY(GestionJoueurs.listeJoueurs.get(j).getPosYInit());
                                GestionJoueurs.listeJoueurs.get(i).setDirection(" SUD ");
                                GestionJoueurs.listeJoueurs.get(j).setDirection(" SUD ");

                            }
                            // Comparaison des positions entre joueurs 1 et 3
                            else if ( (GestionJoueurs.listeJoueurs.get(i).getPosX() == GestionJoueurs.listeJoueurs.get(k).getPosX() || GestionJoueurs.listeJoueurs.get(k).getPosX() == GestionJoueurs.listeJoueurs.get(i).getPosX()) && (GestionJoueurs.listeJoueurs.get(i).getPosY() == GestionJoueurs.listeJoueurs.get(k).getPosY() || GestionJoueurs.listeJoueurs.get(k).getPosY() == GestionJoueurs.listeJoueurs.get(i).getPosY()) ) {
                                System.out.println(" Retour à la case départ, vous avez heurté une autre tortue \n");
                                // Remplacer la position de collision des tortues par une case vide
                                plateau[GestionJoueurs.listeJoueurs.get(i).getPosX()][GestionJoueurs.listeJoueurs.get(i).getPosY()] = "        0        ";
                                plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                // Renvoyer les tortues à leurs positions initales
                                plateau[GestionJoueurs.listeJoueurs.get(i).getPosXInit()][GestionJoueurs.listeJoueurs.get(i).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(i).getNumero() + "    ";
                                plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ";

                                // Remettre les parametres initiaux aux tortues retournées à leurs positions initiales
                                GestionJoueurs.listeJoueurs.get(i).setPosX(GestionJoueurs.listeJoueurs.get(i).getPosXInit());
                                GestionJoueurs.listeJoueurs.get(i).setPosY(GestionJoueurs.listeJoueurs.get(i).getPosYInit());
                                GestionJoueurs.listeJoueurs.get(k).setPosX(GestionJoueurs.listeJoueurs.get(k).getPosXInit());
                                GestionJoueurs.listeJoueurs.get(k).setPosY(GestionJoueurs.listeJoueurs.get(k).getPosYInit());
                                GestionJoueurs.listeJoueurs.get(i).setDirection(" SUD ");
                                GestionJoueurs.listeJoueurs.get(k).setDirection(" SUD ");
                            }
                            // Comparaison des positions enter joueurs 2 et 3
                            else if ( (GestionJoueurs.listeJoueurs.get(j).getPosX() == GestionJoueurs.listeJoueurs.get(k).getPosX() || GestionJoueurs.listeJoueurs.get(k).getPosX() == GestionJoueurs.listeJoueurs.get(j).getPosX()) && (GestionJoueurs.listeJoueurs.get(j).getPosY() == GestionJoueurs.listeJoueurs.get(k).getPosY() || GestionJoueurs.listeJoueurs.get(k).getPosY() == GestionJoueurs.listeJoueurs.get(j).getPosY()) ) {
                                System.out.println(" Retour à la case départ, vous avez heurté une autre tortue \n");
                                // Remplacer la position de collision des tortues par une case vide
                                plateau[GestionJoueurs.listeJoueurs.get(j).getPosX()][GestionJoueurs.listeJoueurs.get(j).getPosY()] = "        0        ";
                                plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                // Renvoyer les tortues à leurs positions initales
                                plateau[GestionJoueurs.listeJoueurs.get(j).getPosXInit()][GestionJoueurs.listeJoueurs.get(j).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(j).getNumero() + "    ";
                                plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ";

                                // Remettre les parametres initiaux aux tortues retournées à leurs positions initiales
                                GestionJoueurs.listeJoueurs.get(j).setPosX(GestionJoueurs.listeJoueurs.get(j).getPosXInit());
                                GestionJoueurs.listeJoueurs.get(j).setPosY(GestionJoueurs.listeJoueurs.get(j).getPosYInit());
                                GestionJoueurs.listeJoueurs.get(k).setPosX(GestionJoueurs.listeJoueurs.get(k).getPosXInit());
                                GestionJoueurs.listeJoueurs.get(k).setPosY(GestionJoueurs.listeJoueurs.get(k).getPosYInit());
                                GestionJoueurs.listeJoueurs.get(j).setDirection(" SUD ");
                                GestionJoueurs.listeJoueurs.get(k).setDirection(" SUD ");
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

                                // Comparaison des positions entre joueurs 1 et 2
                                if ( (GestionJoueurs.listeJoueurs.get(i).getPosX() == GestionJoueurs.listeJoueurs.get(j).getPosX() || GestionJoueurs.listeJoueurs.get(j).getPosX() == GestionJoueurs.listeJoueurs.get(i).getPosX()) && (GestionJoueurs.listeJoueurs.get(i).getPosY() == GestionJoueurs.listeJoueurs.get(j).getPosY() || GestionJoueurs.listeJoueurs.get(j).getPosY() == GestionJoueurs.listeJoueurs.get(i).getPosY()) ) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    System.out.println(" Attention, vous retrouvez votre direction de depart !");
                                    // Remplacer la position de collision des tortues par une case vide
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosX()][GestionJoueurs.listeJoueurs.get(i).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosX()][GestionJoueurs.listeJoueurs.get(j).getPosY()] = "        0        ";
                                    // Renvoyer les tortues à leurs positions initales
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosXInit()][GestionJoueurs.listeJoueurs.get(i).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(i).getNumero() + "    ";
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosXInit()][GestionJoueurs.listeJoueurs.get(j).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(j).getNumero() + "    ";

                                    // Remettre les parametres initiaux aux tortues retournées à leurs positions initiales
                                    GestionJoueurs.listeJoueurs.get(i).setPosX(GestionJoueurs.listeJoueurs.get(i).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(i).setPosY(GestionJoueurs.listeJoueurs.get(i).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(j).setPosX(GestionJoueurs.listeJoueurs.get(j).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(j).setPosY(GestionJoueurs.listeJoueurs.get(j).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(i).setDirection(" SUD ");
                                    GestionJoueurs.listeJoueurs.get(j).setDirection(" SUD ");
                                }
                                // Comparaison des positions entre joueurs 1 et 3
                                else if ( (GestionJoueurs.listeJoueurs.get(i).getPosX() == GestionJoueurs.listeJoueurs.get(k).getPosX() || GestionJoueurs.listeJoueurs.get(k).getPosX() == GestionJoueurs.listeJoueurs.get(i).getPosX()) && (GestionJoueurs.listeJoueurs.get(i).getPosY() == GestionJoueurs.listeJoueurs.get(k).getPosY() || GestionJoueurs.listeJoueurs.get(k).getPosY() == GestionJoueurs.listeJoueurs.get(i).getPosY()) ) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue \n");
                                    System.out.println(" Attention, vous retrouvez votre direction de depart !");
                                    // Remplacer la position de collision des tortues par une case vide
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosX()][GestionJoueurs.listeJoueurs.get(i).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                    // Renvoyer les tortues à leurs positions initales
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosXInit()][GestionJoueurs.listeJoueurs.get(i).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(i).getNumero() + "    ";
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ";

                                    // Remettre les parametres initiaux aux tortues retournées à leurs positions initiales
                                    GestionJoueurs.listeJoueurs.get(i).setPosX(GestionJoueurs.listeJoueurs.get(i).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(i).setPosY(GestionJoueurs.listeJoueurs.get(i).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(k).setPosX(GestionJoueurs.listeJoueurs.get(k).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(k).setPosY(GestionJoueurs.listeJoueurs.get(k).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(i).setDirection(" SUD ");
                                    GestionJoueurs.listeJoueurs.get(k).setDirection(" SUD ");
                                }
                                // Comparaison des positions entre joueurs 1 et 4
                                else if ( (GestionJoueurs.listeJoueurs.get(i).getPosX() == GestionJoueurs.listeJoueurs.get(l).getPosX() || GestionJoueurs.listeJoueurs.get(l).getPosX() == GestionJoueurs.listeJoueurs.get(i).getPosX()) && (GestionJoueurs.listeJoueurs.get(i).getPosY() == GestionJoueurs.listeJoueurs.get(l).getPosY() || GestionJoueurs.listeJoueurs.get(l).getPosY() == GestionJoueurs.listeJoueurs.get(i).getPosY()) ) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    System.out.println(" Attention, vous retrouvez votre direction de depart !");
                                    // Remplacer la position de collision des tortues par une case vide
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosX()][GestionJoueurs.listeJoueurs.get(i).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosX()][GestionJoueurs.listeJoueurs.get(l).getPosY()] = "        0        ";
                                    // Renvoyer les tortues à leurs positions initales
                                    plateau[GestionJoueurs.listeJoueurs.get(i).getPosXInit()][GestionJoueurs.listeJoueurs.get(i).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(i).getNumero() + "    ";
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosXInit()][GestionJoueurs.listeJoueurs.get(l).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(l).getNumero() + "    ";

                                    // Remettre les parametres initiaux aux tortues retournées à leurs positions initiales
                                    GestionJoueurs.listeJoueurs.get(i).setPosX(GestionJoueurs.listeJoueurs.get(i).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(i).setPosY(GestionJoueurs.listeJoueurs.get(i).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(l).setPosX(GestionJoueurs.listeJoueurs.get(l).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(l).setPosY(GestionJoueurs.listeJoueurs.get(l).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(i).setDirection(" SUD ");
                                    GestionJoueurs.listeJoueurs.get(l).setDirection(" SUD ");
                                }
                                // Comparaison des positions entre joueurs 2 et 3
                                else if ( (GestionJoueurs.listeJoueurs.get(j).getPosX() == GestionJoueurs.listeJoueurs.get(k).getPosX() || GestionJoueurs.listeJoueurs.get(k).getPosX() == GestionJoueurs.listeJoueurs.get(j).getPosX()) && (GestionJoueurs.listeJoueurs.get(j).getPosY() == GestionJoueurs.listeJoueurs.get(k).getPosY() || GestionJoueurs.listeJoueurs.get(k).getPosY() == GestionJoueurs.listeJoueurs.get(j).getPosY()) ) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    System.out.println(" Attention, vous retrouvez votre direction de depart !");
                                    // Remplacer la position de collision des tortues par une case vide
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosX()][GestionJoueurs.listeJoueurs.get(j).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                    // Renvoyer les tortues à leurs positions initales
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosXInit()][GestionJoueurs.listeJoueurs.get(j).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(j).getNumero() + "    ";
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ";

                                    // Remettre les parametres initiaux aux tortues retournées à leurs positions initiales
                                    GestionJoueurs.listeJoueurs.get(j).setPosX(GestionJoueurs.listeJoueurs.get(j).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(j).setPosY(GestionJoueurs.listeJoueurs.get(j).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(k).setPosX(GestionJoueurs.listeJoueurs.get(k).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(k).setPosY(GestionJoueurs.listeJoueurs.get(k).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(j).setDirection(" SUD ");
                                    GestionJoueurs.listeJoueurs.get(k).setDirection(" SUD ");
                                }
                                // Comparaison des positions entre joueurs 2 et 4
                                else if ( (GestionJoueurs.listeJoueurs.get(j).getPosX() == GestionJoueurs.listeJoueurs.get(l).getPosX() || GestionJoueurs.listeJoueurs.get(l).getPosX() == GestionJoueurs.listeJoueurs.get(j).getPosX()) && (GestionJoueurs.listeJoueurs.get(j).getPosY() == GestionJoueurs.listeJoueurs.get(l).getPosY() || GestionJoueurs.listeJoueurs.get(l).getPosY() == GestionJoueurs.listeJoueurs.get(j).getPosY()) ) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    System.out.println(" Attention, vous retrouvez votre direction de depart !");
                                    // Remplacer la position de collision des tortues par une case vide
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosX()][GestionJoueurs.listeJoueurs.get(j).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosX()][GestionJoueurs.listeJoueurs.get(l).getPosY()] = "        0        ";
                                    // Renvoyer les tortues à leurs positions initales
                                    plateau[GestionJoueurs.listeJoueurs.get(j).getPosXInit()][GestionJoueurs.listeJoueurs.get(j).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(j).getNumero() + "    ";
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosXInit()][GestionJoueurs.listeJoueurs.get(l).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(l).getNumero() + "    ";

                                    // Remettre les parametres initiaux aux tortues retournées à leurs positions initiales
                                    GestionJoueurs.listeJoueurs.get(j).setPosX(GestionJoueurs.listeJoueurs.get(j).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(j).setPosY(GestionJoueurs.listeJoueurs.get(j).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(l).setPosX(GestionJoueurs.listeJoueurs.get(l).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(l).setPosY(GestionJoueurs.listeJoueurs.get(l).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(j).setDirection(" SUD ");
                                    GestionJoueurs.listeJoueurs.get(l).setDirection(" SUD ");
                                }
                                // Comparaison des positions entre joueurs 3 et 4
                                else if ( (GestionJoueurs.listeJoueurs.get(k).getPosX() == GestionJoueurs.listeJoueurs.get(l).getPosX() || GestionJoueurs.listeJoueurs.get(l).getPosX() == GestionJoueurs.listeJoueurs.get(k).getPosX()) && (GestionJoueurs.listeJoueurs.get(k).getPosY() == GestionJoueurs.listeJoueurs.get(l).getPosY() || GestionJoueurs.listeJoueurs.get(l).getPosY() == GestionJoueurs.listeJoueurs.get(k).getPosY()) ) {
                                    System.out.println(" Retour à la case départ, vous avez heurté une autre tortue ");
                                    System.out.println(" Attention, vous retrouvez votre direction de depart !");
                                    // Remplacer la position de collision des tortues par une case vide
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosX()][GestionJoueurs.listeJoueurs.get(k).getPosY()] = "        0        ";
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosX()][GestionJoueurs.listeJoueurs.get(l).getPosY()] = "        0        ";
                                    // Renvoyer les tortues à leurs positions initales
                                    plateau[GestionJoueurs.listeJoueurs.get(k).getPosXInit()][GestionJoueurs.listeJoueurs.get(k).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(k).getNumero() + "    ";
                                    plateau[GestionJoueurs.listeJoueurs.get(l).getPosXInit()][GestionJoueurs.listeJoueurs.get(l).getPosYInit()] = "    tortue  " + GestionJoueurs.listeJoueurs.get(l).getNumero() + "    ";

                                    // Remettre les parametres initiaux aux tortues retournées à leurs positions initiales
                                    GestionJoueurs.listeJoueurs.get(k).setPosX(GestionJoueurs.listeJoueurs.get(k).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(k).setPosY(GestionJoueurs.listeJoueurs.get(k).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(l).setPosX(GestionJoueurs.listeJoueurs.get(l).getPosXInit());
                                    GestionJoueurs.listeJoueurs.get(l).setPosY(GestionJoueurs.listeJoueurs.get(l).getPosYInit());
                                    GestionJoueurs.listeJoueurs.get(k).setDirection(" SUD ");
                                    GestionJoueurs.listeJoueurs.get(l).setDirection(" SUD ");
                                }
                            }
                        }

                    }
                }
                break;
        }
    }


    public void collisionFinale(int nombreDeJoueur, int valueOfPlayer, String [][] plateau){
        switch (nombreDeJoueur){
            case 2:
                // Positions du joyau
                int positionXJoyau = GestionJoyaux.listeJoyaux.get(0).getPosXJoyau();
                int positionYJoyau = GestionJoyaux.listeJoyaux.get(0).getPosYJoyau();
                // Positions d'un joueur sur les deux
                int positionXJoueur2 = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX();
                int positionYJoueur2 = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY();
                // Si elles correspondent alors le joueur est sur le joyau
                if (positionXJoueur2 == positionXJoyau && positionYJoueur2 == positionYJoyau && GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size() == 0){                                            // Verifier la taille du programme pour etre sur que la tortue s'arrete sur le joyau et ne continue pas apres
                   plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
                   System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau en 1er " +
                           " \n\n Vous avez gagné la partie !!!!! \n");
                }
                else {
                    plateau[positionXJoyau][positionYJoyau] = "    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
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

                if (positionXJoueur3 == positionXJoyau1  && positionYJoueur3 == positionYJoyau1 && GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size()==0) {
                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "    joyau  " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                }
                else if (positionXJoueur3 == positionXJoyau2  && positionYJoueur3 == positionYJoyau2 && GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size()==0) {
                plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "    joyau  " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                }
                else if (positionXJoueur3 == positionXJoyau3  && positionYJoueur3 == positionYJoyau3 && GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size()==0) {
                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "    joyau  " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                }
               else{
                    plateau[positionXJoyau1][positionYJoyau1] = "    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
                    plateau[positionXJoyau2][positionYJoyau2] = "    joyau  " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ";
                    plateau[positionXJoyau3][positionYJoyau3] = "    joyau  " + GestionJoyaux.listeJoyaux.get(2).getNumeroJoyau() + "     ";

                }
                break;
            case 4:
                int positionXJoyau1_4 = GestionJoyaux.listeJoyaux.get(0).getPosXJoyau();
                int positionYJoyau1_4 = GestionJoyaux.listeJoyaux.get(0).getPosYJoyau();
                int positionXJoyau2_4 = GestionJoyaux.listeJoyaux.get(1).getPosXJoyau();
                int positionYJoyau2_4 = GestionJoyaux.listeJoyaux.get(1).getPosYJoyau();

                int positionXJoueur4 = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX();
                int positionYJoueur4 = GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY();

                if (positionXJoueur4 == positionXJoyau1_4  && positionYJoueur4 == positionYJoyau1_4 && GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size() == 0) {
                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "    joyau  " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                }
                else if (positionXJoueur4 == positionXJoyau2_4  && positionYJoueur4 == positionYJoyau2_4 && GestionJoueurs.listeJoueurs.get(valueOfPlayer).toutesCartes.getProgramme().size() == 0) {
                    plateau[GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosX()][GestionJoueurs.listeJoueurs.get(valueOfPlayer).getPosY()] = "    joyau  " + GestionJoyaux.listeJoyaux.get(valueOfPlayer).getNumeroJoyau() + "     ";
                    System.out.println(" \n Bravo Joueur " + GestionJoueurs.listeJoueurs.get(valueOfPlayer).getNumero() + " vous avez atteint le joyau " );
                }
                else{
                    plateau[positionXJoyau1_4][positionYJoyau1_4] = "    joyau  " + GestionJoyaux.listeJoyaux.get(0).getNumeroJoyau() + "     ";
                    plateau[positionXJoyau2_4][positionYJoyau2_4] = "    joyau  " + GestionJoyaux.listeJoyaux.get(1).getNumeroJoyau() + "     ";
                }
                break;
        }
    }


}

