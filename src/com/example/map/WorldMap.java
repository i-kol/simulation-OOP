package com.example.map;

import com.example.entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldMap {
    private final int height;
    private final int width;
    private final Map<Coordinates, Entity> entities;

    public WorldMap(int height, int width) {
        this.height = height;
        this.width = width;
        this.entities = new HashMap<>();
    }

    public Entity get(Coordinates coordinates) {
        validate(coordinates);
        return entities.get(coordinates);
    }

    public void put(Entity entity, Coordinates coordinates) {
        validate(coordinates);
        entities.put(coordinates, entity);
    }

    public void remove(Coordinates coordinates) {
        validate(coordinates);
        entities.remove(coordinates);
    }

    public List<Entity> getAllEntities() {
        return new ArrayList<>(entities.values());
    }

    public boolean isEmpty(Coordinates coordinates) {
        validate(coordinates);
        return !entities.containsKey(coordinates);
    }

    private boolean isWithinMap(Coordinates coordinates) {
        return coordinates.row() >= 0 && coordinates.row() < height && coordinates.column() >= 0 && coordinates.column() < width;
    }

    private void validate(Coordinates coordinates) {
        if (coordinates == null) {
            throw new IllegalArgumentException("Coordinates is null!");
        }
        if (!isWithinMap(coordinates)) {
            throw new IllegalArgumentException("Coordinates is out of world map borders: " + coordinates);
        }
    }

    public List<Coordinates> getNeighborCells(Coordinates coordinates) {
        List<Coordinates> listOfNeighboringCells = new ArrayList<>();

        for (int row = -1; row <= 1; row++) {
            for (int column = -1; column <= 1; column++) {
                Coordinates cell = new Coordinates(coordinates.row() + row, coordinates.column() + column);

                if (isWithinMap(cell)) {
                    if (row == 0 && column == 0) {
                        continue;
                    }
                    listOfNeighboringCells.add(cell);
                }
            }
        }
        return listOfNeighboringCells;
    }

    protected List<Coordinates> getAdjacentCells(Coordinates coordinates) {
        ArrayList<Coordinates> listOfAdjacentCells = new ArrayList<>();
        List<Coordinates> listOfNeighboringCells = getNeighborCells(coordinates);

        for (Coordinates cell : listOfNeighboringCells) {
            if (isEmpty(cell)) {
                listOfAdjacentCells.add(cell);
            }
        }
        return listOfAdjacentCells;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
