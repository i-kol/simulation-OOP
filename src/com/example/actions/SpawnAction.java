package com.example.actions;

import com.example.entities.*;
import com.example.factories.EntitiesFactory;
import com.example.map.WorldMap;

import java.util.List;

public class SpawnAction implements Action {

    @Override
    public void execute(WorldMap worldMap) {
        List<Entity> entitiesOnMap = List.of(new Rock(), new Tree(), new Grass(), new Herbivore(), new Predator());
        EntitiesFactory entitiesFactory = new EntitiesFactory();
        entitiesFactory.spawnEntities(worldMap, entitiesOnMap);
    }
}
