package com.robot_turtle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;


public class Fenetre extends JFrame {
        private Panneau pan = new Panneau();


    public Fenetre() {
        this.setTitle("Ma première fenêtre Java");
        this.setSize(400, 500); //definir la taille : 400pixels de large et 500 de long
        this.setLocationRelativeTo(null); //positioner objet au centre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermer la fenetre quand croix rouge
        this.setVisible(true); //rendre la fenetre visible

        //pan.setBackground(Color.GREEN);
        this.setContentPane(new Panneau()); //On prévient notre JFrame que notre JPanel sera son content pane
        //this.add(pan);
        this.setVisible(true);


    }
}