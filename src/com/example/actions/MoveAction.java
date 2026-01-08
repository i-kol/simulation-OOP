package com.example.actions;

import com.example.entities.Creature;
import com.example.entities.Entity;
import com.example.entities.Predator;
import com.example.map.Coordinates;
import com.example.map.WorldMap;

import java.util.*;

public class MoveAction implements Action {
    @Override
    public void execute(WorldMap worldMap) {
        Map<Coordinates, Entity> mapCopy = worldMap.getCopyOfMap();

        for (Map.Entry<Coordinates, Entity> entry : mapCopy.entrySet()) {
            Entity entity = entry.getValue();

            if (entity instanceof Creature) {
                Coordinates coordinates = entry.getKey();
                ((Creature) entity).makeMove(worldMap, coordinates);
            }
        }
    }
}
