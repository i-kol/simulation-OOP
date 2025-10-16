package com.example.entities;

import com.example.map.Coordinates;
import com.example.map.WorldMap;

import java.util.List;

public class Creature extends Entity {
    private final int speed;
    private final int health;

    public Creature(int speed, int health) {
        this.speed = speed;
        this.health = health;
    }

    public void makeMove(WorldMap worldMap, Coordinates coordinates) {
        if (worldMap.isEmpty(coordinates)) {
            worldMap.put(this, coordinates);
        }
    }

    public List<Coordinates> getAvailableCellsForMove(WorldMap worldMap, Coordinates coordinates, Direction direction) {
        for (Coordinates coordinates1 : )
    }

    private List<Coordinates>

    public enum Direction {
        UP(-1,0),
        LEFT(0, -1),
        DOWN(1, 0),
        RIGHT(0, 1);
        private final int rowShift;
        private final int columnShift;

        Direction(int rowShift, int columnShift) {
            this.rowShift = rowShift;
            this.columnShift = columnShift;
        }

        public int getRowShift() {
            return rowShift;
        }

        public int getColumnShift() {
            return columnShift;
        }
    }
}
