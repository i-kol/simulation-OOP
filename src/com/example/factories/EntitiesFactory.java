package com.example.factories;

import com.example.callback.ModelCallbackManager;
import com.example.entities.*;
import com.example.map.Coordinates;
import com.example.map.WorldMap;
import com.example.dialog.ConsoleViewMessage;

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
            Coordinates coordinates = new Coordinates(random.nextInt(worldMap.getHeight()), random.nextInt(worldMap.getWidth()));

            while (!worldMap.isEmpty(coordinates)) {
                coordinates = new Coordinates(random.nextInt(worldMap.getHeight()), random.nextInt(worldMap.getWidth()));
            }
            worldMap.put(entity, coordinates);
            addCallBack(entity);
        }
    }

    private void addCallBack(Entity entity) {
        ConsoleViewMessage consoleViewMessage = new ConsoleViewMessage();
        ModelCallbackManager modelCallbackManager = new ModelCallbackManager(consoleViewMessage);

        if (entity instanceof Predator) {
            modelCallbackManager.setupMoveCallBack((Creature) entity);
            modelCallbackManager.setupAttackCallBack((Creature) entity);
        }
        if (entity instanceof Herbivore) {
            modelCallbackManager.setupMoveCallBack((Creature) entity);
            modelCallbackManager.setupAttackCallBack((Creature) entity);
            modelCallbackManager.setupHealthCallBack((Creature) entity);
        }
    }

    private int calculateEntitiesQuantity(WorldMap worldMap, Class<? extends Entity> entity) {
        return (int) Math.ceil(getEntityRatio(entity) * worldMap.getWidth() * worldMap.getHeight());
    }

    private double getEntityRatio(Class<? extends Entity> entity) {
        String entityType = entity.getSimpleName();

        return switch (entityType) {
            case "Herbivore" -> 0.03;    // 0.03 by default
            case "Tree", "Rock" -> 0.04; // 0.04 by default
            case "Predator" -> 0.02;    // 0.02 by default
            case "Grass" -> 0.06;    // 0,06 by default
            default -> throw new IllegalArgumentException("Unknown type of entity: " + entityType);
        };
    }
}
