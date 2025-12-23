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
            System.out.printf("%s attacked the Herbivore at: [%d, %d]%n", getClass().getSimpleName(), coordinates.row(), coordinates.column());
            System.out.printf("Herbivore health is %d points %n", targetHealth);
        } else {
            System.out.printf("%s ate the Herbivore at: [%d, %d]%n", getClass().getSimpleName(), coordinates.row(), coordinates.column());
            worldMap.remove(coordinates);
        }

        //TODO: реализовать паттерн CallBack для оповещении представления моделью о реализованных действиях
    }
}
