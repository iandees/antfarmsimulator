package com.mapki.antfarm.game;

import javax.vecmath.Vector3d;

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
        f.addAnt(new Ant(f, new Vector3d(20, 20, 0)));
        f.addAnt(new Ant(f, new Vector3d(40, 20, 0)));
        
        AntGame g = new AntGame(f, 125);
        GameDisplay gui = new GameDisplay2D(g);
        gui.start();
    }

}
