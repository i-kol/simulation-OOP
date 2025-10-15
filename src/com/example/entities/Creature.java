package com.example.entities;

import com.example.map.Coordinates;
import com.example.map.WorldMap;

public class Creature extends Entity {
    private final int speed;
    private final int health;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    public void makeMove(WorldMap worldMap, Coordinates coordinates) {
//        WorldMap.put(worldMap, coordinates);
    }
}
