package com.example.entities;

import com.example.map.Coordinates;
import com.example.map.WorldMap;

public class Herbivore extends Creature {
    private final static int SPEED = 2;
    private final static int MAX_HEALTH = 25;
    private final static int CURRENT_HEALTH = MAX_HEALTH;
    private final static int ACTION_POINT = 0;
    private final static int MAX_HEALTH_RECOVERY = Grass.HEALTH_RECOVERY;
    private final static Class<? extends Entity> TARGET = Grass.class;

    public Herbivore() {
        super(SPEED, CURRENT_HEALTH, MAX_HEALTH, ACTION_POINT, MAX_HEALTH_RECOVERY, TARGET);
    }

    //TODO сделать механизм наступания на траву (и проверить ТЗ, нужно ли наступать на съеденное травоядное хищнику)

    @Override
    protected void attackTarget(WorldMap worldMap, Coordinates coordinates) {
        restoreHealth();

    }
}
