package com.robot_turtle;

import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Panneau extends JPanel {
    private JButton bouton = new JButton("Mon bouton");

    public void paintComponent(Graphics g) {
        int x1 = this.getWidth()/4; //largeur/4
        int y1 = this.getHeight()/4; //hauteur/4
        /*g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
        g.fillOval(20, 20, 75, 75); //20pix sur x, 20 sur y, 75 de large et 75 de haut
        g.drawRect(30,30,50,70);
        Font font = new Font("Courier",Font.BOLD,20);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("Robot Turtle",150,20);*/

        try {
            Image img = ImageIO.read(new File("background.jpeg"));
            //g.drawImage(img, 0, 0, this);
            //Pour une image de fond
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

        } catch (IOException e) {
            e.printStackTrace();
            this.add(bouton);
        }

    }
}
