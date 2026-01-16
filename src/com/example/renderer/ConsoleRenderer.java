package com.example.renderer;

import com.example.Menu;
import com.example.entities.Entity;
import com.example.map.Coordinates;
import com.example.map.WorldMap;

import static com.example.renderer.ConsoleIcons.*;

public class ConsoleRenderer implements Renderer {
    @Override
    public void show(WorldMap worldMap) {
        int height = worldMap.getHeight();
        int width = worldMap.getWidth();

        System.out.println();
        for (int row = 0; row < height; row++) {
            StringBuilder line = new StringBuilder();
            for (int column = 0; column < width; column++) {
                Coordinates coordinates = new Coordinates(row, column);
                if (worldMap.isEmpty(coordinates)) {
                    line.append(GROUND_ICON);
                } else {
                    Entity entity = worldMap.get(coordinates);
                    line.append(getEntityIcon(entity, coordinates));
                }
            }
            System.out.println(line);
        }
    }

    private String getEntityIcon(Entity entity, Coordinates coordinates) {
        return switch (entity.getClass().getSimpleName()) {
            case "Herbivore" -> HERBIVORE_ICON;
            case "Predator" -> PREDATOR_ICON;
            case "Grass" -> GRASS_ICON;
            case "Rock" -> ROCK_ICON;
            case "Tree" -> TREE_ICON;
            default -> throw new IllegalArgumentException("Unknown type of entity at coordinates: " + coordinates);
        };
    }
}
