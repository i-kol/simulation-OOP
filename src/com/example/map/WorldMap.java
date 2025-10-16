package com.example.map;

import com.example.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {
    private final int height;
    private final int width;
    protected final Map<Coordinates, Entity> entities;

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
        if (isWithinMap(coordinates)) {
            throw new IllegalArgumentException("Coordinates is out of world map borders: " + coordinates);
        }
    }
}
