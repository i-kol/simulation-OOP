package com.example.actions;

import com.example.entities.*;
import com.example.factories.EntitiesFactory;
import com.example.map.WorldMap;

import java.util.List;

public class RespawnAction implements Action {
    @Override
    public void execute(WorldMap worldMap) {
        EntitiesFactory entitiesFactory = new EntitiesFactory();
        List<Entity> entitiesOnMap = List.of(new Grass(), new Herbivore());

        for (Entity entity : entitiesOnMap) {
            int entitiesQuantityOnMap = getEntitiesQuantityOnMap(worldMap, entity);
            if (entitiesQuantityOnMap < 1) {
                entitiesFactory.addEntityType(worldMap, entity);
            }
        }
    }

    private int getEntitiesQuantityOnMap(WorldMap worldMap, Entity entity) {
        List<Entity> allEntities = worldMap.getAllEntities();
        int entitiesQuantity = 0;

        for (Entity e : allEntities) {
            if (e != null && entity != null && e.getClass() == entity.getClass()) {
                entitiesQuantity++;
            }
        }
        return entitiesQuantity;
    }
}
