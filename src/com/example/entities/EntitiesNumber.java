package com.example.entities;

import com.example.map.WorldMap;

public class EntitiesNumber {
    public int calculateEntitiesNumber(WorldMap worldMap, Class<? extends Entity> entity) {
        return (int) Math.ceil(getEntityCoefficient(entity) * worldMap.getWidth() * worldMap.getHeight());
    }

    private final double getEntityCoefficient(Class<? extends Entity> entity) {
        return switch (entity.getSimpleName()) {
            case "Herbivore" -> 0.03;    // 0.03 by default
            case "Tree", "Rock" -> 0.04; // 0.04 by default
            case "Predator" -> 0.02;    // 0.02 by default
            case "Grass" -> 0.06;    // 0,06 by default
            default -> throw new IllegalArgumentException("Unknown type of entity: " + entity.getSimpleName());
        };
    }
}
