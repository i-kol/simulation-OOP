package com.example.actions;

import com.example.entities.Creature;
import com.example.entities.Entity;
import com.example.map.Coordinates;
import com.example.map.WorldMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MoveAction implements Action{
    @Override
    public void execute(WorldMap worldMap) {
        List<Entity> allEntities = worldMap.getAllEntities();

        for (Entity entity : allEntities) {
            if (entity instanceof Creature) {
                Optional<Coordinates> coordinates = worldMap.getCoordinates(entity);
                ((Creature) entity).makeMove(worldMap, coordinates);
            }
        }
    }

//    @Override
//    public void execute(WorldMap worldMap) {
//        Map<Coordinates, Entity> entitiesCopy = new HashMap<>((Map) worldMap);
//
//        for (Map.Entry<Coordinates, Entity> entity : entitiesCopy.entrySet()) {
//            if (entity instanceof Creature) {
//                Coordinates coordinates = entity.getKey();
//                ((Creature) entity).makeMove(worldMap, coordinates);
//            }
//        }
//    }
}
