package com.example.map;

import java.util.HashMap;

public class Map<T> {
    private final int height;
    private final int width;
    protected final Map<Coordinates, T> entities;

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        this.entities = new HashMap<>();
    }
}
