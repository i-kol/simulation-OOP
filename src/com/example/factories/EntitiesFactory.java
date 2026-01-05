package com.example.factories;

import com.example.entities.*;
import com.example.map.Coordinates;
import com.example.map.WorldMap;

import java.util.List;
import java.util.Random;

public class EntitiesFactory {
    public void spawnEntities(WorldMap worldMap, List<Entity> entitiesOnMap) {
        for (Entity e : entitiesOnMap) {
            addEntityType(worldMap, e);
        }
    }

    public void addEntityType(WorldMap worldMap, Entity entity) {
        Random random = new Random();
        int entityNumber = calculateEntitiesQuantity(worldMap, entity.getClass());

        for (int i = 0; i < entityNumber; i++) {
            int randomHeight = random.nextInt(worldMap.getHeight());
            int randomWidth = random.nextInt(worldMap.getWidth());

            Coordinates coordinates = new Coordinates(randomHeight, randomWidth);

            while (!worldMap.isEmpty(coordinates)) {
                coordinates = new Coordinates(randomHeight, randomWidth);
            }
            worldMap.put(entity, coordinates);
        }
    }

    private int calculateEntitiesQuantity(WorldMap worldMap, Class<? extends Entity> entity) {
        return (int) Math.ceil(getEntityRatio(entity) * worldMap.getWidth() * worldMap.getHeight());
    }

    private double getEntityRatio(Class<? extends Entity> entity) {
        return switch (entity.getSimpleName()) {
            case "Herbivore" -> 0.03;    // 0.03 by default
            case "Tree", "Rock" -> 0.04; // 0.04 by default
            case "Predator" -> 0.02;    // 0.02 by default
            case "Grass" -> 0.06;    // 0,06 by default
            default -> throw new IllegalArgumentException("Unknown type of entity: " + entity.getSimpleName());
        };
    }
}
