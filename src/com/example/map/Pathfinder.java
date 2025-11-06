package com.example.map;

import com.example.entities.Entity;

import java.util.*;

public class Pathfinder {

    public List<Coordinates> findPath(WorldMap worldMap, Coordinates startCell, Class<? extends Entity> target) {

        Map<Coordinates, Coordinates> parentMap = new HashMap<>();
        Queue<Coordinates> queue = new LinkedList<>();
        Set<Coordinates> visited = new HashSet<>();
        Coordinates targetCell = null;

        queue.add(startCell);
        visited.add(startCell);
        parentMap.put(startCell, null);

        while (!queue.isEmpty()) {
            Coordinates currentCell = queue.poll();

            for (Coordinates neighborForTargetSearch : worldMap.getNeighborCells(currentCell)) {
                Entity currentEntity = worldMap.get(neighborForTargetSearch);
                if (target.isInstance(currentEntity)) {
                    targetCell = neighborForTargetSearch;
                    parentMap.put(targetCell, currentCell);
                    break;
                }
            }

            if (targetCell != null) {
                break;
            }

            for (Coordinates neighborForPathSearch : worldMap.getAdjacentCells(currentCell)) {
                if (!visited.contains(neighborForPathSearch)) {
                    visited.add(neighborForPathSearch);
                    queue.add(neighborForPathSearch);
                    parentMap.put(neighborForPathSearch, currentCell);
                }
            }
        }

        List<Coordinates> path = new ArrayList<>();

        for (Coordinates cell = targetCell; cell != null; cell = parentMap.get(cell)) {
            path.add(cell);
        }

        Collections.reverse(path);

        return path;
    }
}