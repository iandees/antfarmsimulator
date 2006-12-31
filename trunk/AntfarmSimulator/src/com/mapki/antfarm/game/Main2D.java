package com.mapki.antfarm.game;

import com.mapki.antfarm.creatures.Ant;
import com.mapki.antfarm.farm.Farm;
import com.mapki.antfarm.gui.GameDisplay;
import com.mapki.antfarm.gui.GameDisplay2D;

public class Main2D {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Farm f = new Farm();
        Ant a = new Ant();
        f.addAnt(a);
        
        AntGame g = new AntGame(f, 750);
        GameDisplay gui = new GameDisplay2D(g);
        gui.start();
    }

}
