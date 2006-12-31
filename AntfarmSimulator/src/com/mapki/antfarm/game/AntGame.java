package com.mapki.antfarm.game;

import java.util.Timer;
import java.util.TimerTask;

import com.mapki.antfarm.farm.Farm;

public class AntGame {

    private Farm farm;
    private int time;
    private Timer timer;
    private TimerTask tTask;
    
    public AntGame(Farm f, int stepTime) {
        farm = f;
        time = stepTime;
        
        initTimer();
    }
    
    private void initTimer() {
        timer = new Timer();
        tTask = new TimerTask() {
        
            public void run() {
                System.err.println("Tick");
            }
        
        };
    }

    public void start() {
        timer.scheduleAtFixedRate(tTask, 0, time);
    }

    public void stop() {
        System.err.println("Game stop.");
        
        tTask.cancel();
        timer.cancel();
    }

}
