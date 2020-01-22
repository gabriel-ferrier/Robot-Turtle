package com.robot_turtle;

public class Game {

    private static int nbJoueurs;
    private static int finDuJeu = 0;


    static int getNbJoueurs() {
        return nbJoueurs;
    }

    static void setFinDuJeu() {
        Game.finDuJeu = 1;  // La seule fois ou on modifie l'attribut est pour le mettre à 1 et enclencher la fin du jeu
    }


    /**
     * Méthode main executant ainsi tout le fonctionnement du jeu
     **/
    public static void main(String[] args) {
        Menu menu = new Menu();
        nbJoueurs = menu.getNombreJoueurs();
        GestionJoueurs joueurs = new GestionJoueurs(nbJoueurs);     // Lance la création des joueurs
        GestionJoyaux joyaux = new GestionJoyaux(nbJoueurs);        // Lance la création des joyaux
        Plateau plateau = new Plateau();
        plateau.afficherPlateauInit(nbJoueurs);                     // Affiche plateau initial en fonction du nombre de joueurs et donc de joyaux

        int joueurActuel = 0;

        // Boucle infinie sous condition permettant d'executer les actions de tour de jeu de chaque joueur tant qu'il n'y en pas un qui perd
        // La vartiable finDuJeu est modifée dans la classe joueur lorsqu'un joueur perd
        while (finDuJeu == 0) {
            do {
                joueurs.getListeJoueurs().get(joueurActuel).instruction(plateau);       // Lance le tour de jeu d'un des jouers
                joueurActuel++;
                joueurActuel = joueurActuel % nbJoueurs;                                // Répéter pour tous les joueurs
            } while (finDuJeu == 0);
            if (finDuJeu == 1) {
                System.out.println(" ***** FIN DU JEU ***** ");
                break;
            }
        }
    }

}

