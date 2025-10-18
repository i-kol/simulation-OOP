package com.example.entities;

import com.example.map.Coordinates;
import com.example.map.WorldMap;

public class Predator extends Creature {
    public Predator(int speed, int health, int actionPoint, Class<? extends Entity> target) {
        super(speed, health, actionPoint, target);
    }

    @Override
    protected void attackTarget(WorldMap worldMap, Coordinates coordinates) {

    }
}
