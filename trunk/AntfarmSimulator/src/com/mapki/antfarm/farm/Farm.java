package com.mapki.antfarm.farm;

import java.util.ArrayList;
import java.util.Iterator;

import javax.vecmath.Vector3d;

import com.mapki.antfarm.creatures.Ant;
import com.mapki.antfarm.creatures.scent.Scent;

public class Farm {
    /** The size of the farm. */
    private Vector3d size;
    
    private ArrayList<Ant> ants;

    private ArrayList<Scent> scents;
    
    public Farm() {
        this(40,40,1);
    }
    
    public Farm(int x, int y, int z) {
        this(new Vector3d(x,y,z));
    }

    public Farm(Vector3d vector3d) {
        size = vector3d;
        ants = new ArrayList<Ant>();
        scents = new ArrayList<Scent>();
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
        
        for (Scent scent : scents) {
            scent.tick();
        }
        
        for (int i = 0; i < ants.size(); i++) {
            if(ants.get(i).getHealth() < 1) {
                System.err.println("Ant died.");
                ants.remove(i);
            }
        }
        
        for (int i = 0; i < scents.size(); i++) {
            if(scents.get(i).getStrength() < 1) {
                System.err.println("Scent died.");
                scents.remove(i);
            }
        }
    }
    
    public ArrayList<Ant> getAnts() {
        return ants;
    }

    public ArrayList<Scent> getScents() {
        return scents;
    }

    public void dropScent(Ant ant, Scent sc) {
        scents.add(sc);
    }
}