package com.mapki.antfarm.creatures;

import java.util.Random;

import javax.vecmath.Vector3d;

import com.mapki.antfarm.creatures.scent.Scent;
import com.mapki.antfarm.creatures.scent.ScentType;
import com.mapki.antfarm.farm.Farm;

public class Ant {
    /** The maximum health value for the ant. */
    private static final int MAX_HEALTH = 100;

    private static final double MOVEMENT_HEALTH_CONSTANT = 0.98;

    /** The ant's location in 3D space. */
    private Vector3d location;
    
    /** The ant's current speed and direction. */
    private Vector3d velocity;
    
    /** The ant's health points. */
    private double health;

    private Farm farm;
    
    /**
     * Complete Constructor.
     * 
     * @param loc The initial location of the ant.
     * @param vel The initial velocity (speed and direction) of the ant.
     * @param healthVal The initial health value for the ant.
     */
    public Ant(Farm f, Vector3d loc, Vector3d vel, int healthVal) {
        farm = f;
        location = loc;
        velocity = vel;
        health = healthVal;
    }
    
    /**
     * Blank constructor.
     * 
     * Creates a default ant that doesn't move and starts out at the origin.
     */
    public Ant(Farm f) {
        this(f, new Vector3d(0,0,0), new Vector3d(0,0,0), MAX_HEALTH);
    }
    
    /**
     * Incomplete constructor.
     * 
     * Creates an ant at the specified location.
     * 
     * @param location The location for the ant to start at.
     */
    public Ant(Farm f, Vector3d location) {
        this(f, location, new Vector3d(0,0,0), MAX_HEALTH);
    }

    public double getHealth() {
        return health;
    }

    public Vector3d getLocation() {
        return location;
    }

    public Vector3d getVelocity() {
        return velocity;
    }

    public void tick() {
        dropScent();
        move();
        reaim();
    }

    private void dropScent() {
        farm.dropScent(this, new Scent(getLocation(), ScentType.TRAIL));
    }

    private void reaim() {
        Random r = new Random();
        velocity = new Vector3d(r.nextInt(2) == 0 ? r.nextDouble() : -r.nextDouble(),
                r.nextInt(2) == 0 ? r.nextDouble() : -r.nextDouble(),
                0);
    }

    private void move() {
        location.add(velocity);
        health *= MOVEMENT_HEALTH_CONSTANT;
    }
}