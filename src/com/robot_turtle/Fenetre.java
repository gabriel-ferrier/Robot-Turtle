package com.robot_turtle;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class Fenetre extends JFrame {

    public Fenetre() {

        JPanel panel = new JPanel(); // Couche sur la fenetre

        this.setTitle(" Robot turtle ");
        this.setSize(620, 802); //definir la taille : 400pixels de large et 500 de long
        this.setLocationRelativeTo(null); //positioner fenetre au centre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermer la fenetre quand croix rouge
        this.getContentPane().setLayout(null);
        this.setVisible(true);

        Icon fondEcran = new ImageIcon(this.getClass().getResource("background.png"));
        JLabel ImageFond = new JLabel(); // Zone ou faire les modifs
        ImageFond.setIcon(fondEcran);
        ImageFond.setBounds(0,0,620,802); // Dimension de l'image
        panel.setBounds(0,0,620,802);
        panel.add(ImageFond);
        this.add(panel);







    }


}