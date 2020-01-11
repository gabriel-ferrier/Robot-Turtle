package com.robot_turtle;

public enum Cartes {
    BLEU("carte bleue"),
    JAUNE("carte jaune"),
    VIOLET("carte violette"),
    PIERRE("obstacle marron"),
    GLACE("obstacle de glace");

    private final String couleur;

    Cartes(String couleur) {
        this.couleur = couleur;
    }

    public String couleur() {
        return couleur;
    }
}