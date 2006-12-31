package com.mapki.antfarm.farm;

import java.util.ArrayList;
import java.util.Iterator;

import javax.vecmath.Vector3d;

import com.mapki.antfarm.creatures.Ant;

public class Farm {
    /** The size of the farm. */
    private Vector3d size;
    
    private ArrayList<Ant> ants;
    
    public Farm() {
        this(40,40,1);
    }
    
    public Farm(int x, int y, int z) {
        this(new Vector3d(x,y,z));
    }

    public Farm(Vector3d vector3d) {
        size = vector3d;
        ants = new ArrayList<Ant>();
    }

    public void addAnt(Ant ant) {
        ants.add(ant);
        System.err.println("Added ant " + ant);
    }
    
    public Vector3d getSize() {
        return size;
    }

    public void tick() {
        for (Ant ant : ants) {
            ant.tick();
        }
    }
    
    public ArrayList<Ant> getAnts() {
        return ants;
    }
}
