package com.mapki.antfarm.creatures;

import java.util.Random;

import javax.vecmath.Vector3d;

public class Ant {
    /** The maximum health value for the ant. */
    private static final int MAX_HEALTH = 100;

    /** The ant's location in 3D space. */
    private Vector3d location;
    
    /** The ant's current speed and direction. */
    private Vector3d velocity;
    
    /** The ant's health points. */
    private int health;
    
    /**
     * Complete Constructor.
     * 
     * @param loc The initial location of the ant.
     * @param vel The initial velocity (speed and direction) of the ant.
     * @param healthVal The initial health value for the ant.
     */
    public Ant(Vector3d loc, Vector3d vel, int healthVal) {
        location = loc;
        velocity = vel;
        health = healthVal;
    }
    
    /**
     * Blank constructor.
     * 
     * Creates a default ant that doesn't move and starts out at the origin.
     */
    public Ant() {
        this(new Vector3d(0,0,0), new Vector3d(0,0,0), MAX_HEALTH);
    }
    
    /**
     * Incomplete constructor.
     * 
     * Creates an ant at the specified location.
     * 
     * @param location The location for the ant to start at.
     */
    public Ant(Vector3d location) {
        this(location, new Vector3d(0,0,0), MAX_HEALTH);
    }

    public int getHealth() {
        return health;
    }

    public Vector3d getLocation() {
        return location;
    }

    public Vector3d getVelocity() {
        return velocity;
    }

    public void tick() {
        move();
        reaim();
    }

    private void reaim() {
        Random r = new Random();
        velocity = new Vector3d(r.nextDouble(), r.nextDouble(), r.nextDouble());
    }

    private void move() {
        location.add(velocity);
    }
}
