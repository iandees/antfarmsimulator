package com.mapki.antfarm.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.mapki.antfarm.creatures.Ant;
import com.mapki.antfarm.game.AntGame;

public class AntDrawPanel extends JPanel {

    private AntGame game;
    
    public AntDrawPanel(AntGame theGame) {
        game = theGame;
    }

    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

    public Border getBorder() {
        return new LineBorder(Color.black, 1);
    }

    public void tick() {
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        
        ArrayList<Ant> ants = game.getFarm().getAnts();
        for (Ant ant : ants) {
            int x = (int) ant.getLocation().x;
            int y = (int) ant.getLocation().y;
            g.drawRect(x, y, 1, 1);
        }
    }
    
}
