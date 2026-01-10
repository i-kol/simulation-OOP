package com.example.factories;

import com.example.map.WorldMap;

public class WorldMapFactory {
    public WorldMap createWorldMap(int row, int column) {
        return new WorldMap(row, column);
    }
}
