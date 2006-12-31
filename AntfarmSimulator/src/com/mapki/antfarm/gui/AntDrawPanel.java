package com.mapki.antfarm.gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
}
