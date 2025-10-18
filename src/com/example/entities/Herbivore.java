package com.example.entities;

import com.example.map.Coordinates;
import com.example.map.WorldMap;

public class Herbivore extends Creature {
    public Herbivore(int speed, int health, int actionPoint, Class<? extends Entity> target) {
        super(speed, health, actionPoint, target);
    }

    //TODO перенести сюда метод из старого проекта

    @Override
    protected void attackTarget(WorldMap worldMap, Coordinates coordinates) {

    }
}
