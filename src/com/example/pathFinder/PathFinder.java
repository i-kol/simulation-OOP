package com.example.pathFinder;

import com.example.entities.Entity;
import com.example.map.Coordinates;
import com.example.map.WorldMap;

import java.util.List;

public interface PathFinder {
    List<Coordinates> findPath(WorldMap worldMap, Coordinates startCell, Class<? extends Entity> target);
}
