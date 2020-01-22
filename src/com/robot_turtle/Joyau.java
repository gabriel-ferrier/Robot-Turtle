package com.robot_turtle;

public class Joyau {

    private int numeroJoyau;
    private int posXJoyaux;
    private int posYJoyaux;

    Joyau(int numeroJoyau) {
        this.numeroJoyau = numeroJoyau;
    }

    /**
     * Getter du numero du joyau souhaité dans la liste des joyaux
     **/
    int getNumeroJoyau() {
        return numeroJoyau;
    }

    /**
     * Getters et Setters positions du joyau
     **/
    int getPosXJoyau() {
        return posXJoyaux;
    }

    void setPosXJoyau() {
        this.posXJoyaux = 7; // La position d'un joyau reste toujours la meme
    }

    int getPosYJoyau() {
        return posYJoyaux;
    }

    void setPosYJoyau(int posYJoyaux) {
        this.posYJoyaux = posYJoyaux;
    }

}


