package com.example.entities;

import com.example.map.Coordinates;
import com.example.map.WorldMap;

public class Predator extends Creature {
    private final static int SPEED = 3;
    private final static int MAX_HEALTH = 40;
    private final static int CURRENT_HEALTH = MAX_HEALTH;
    private final static int ACTION_POINT = 0;
    public final static int ATTACK_STRENGTH = 10;
    private final static int MAX_HEALTH_RECOVERY = ATTACK_STRENGTH;
    private final static Class<? extends Entity> TARGET = Herbivore.class;

    public Predator() {
        super(SPEED, CURRENT_HEALTH, MAX_HEALTH, ACTION_POINT, MAX_HEALTH_RECOVERY, TARGET);
    }

    @Override
    protected void attackTarget(WorldMap worldMap, Coordinates coordinates) {
        restoreHealth();

        Creature target = (Creature) worldMap.get(coordinates);
        int targetHealth = target.getCurrentHealth() - ATTACK_STRENGTH;
        target.setCurrentHealth(targetHealth);

        if (targetHealth > 0) {
            if (onAttack != null) {
                onAttack.execute(coordinates);
            }
            if (onUpdateHealth != null) {
                onUpdateHealth.execute(coordinates);
            }
        } else {
            if (onEat != null) {
                onEat.execute(coordinates);
            }
            worldMap.remove(coordinates);
        }
    }
}
