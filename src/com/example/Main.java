package com.example;

import com.example.entities.Entity;
import com.example.entities.Grass;
import com.example.entities.Herbivore;
import com.example.map.Coordinates;
import com.example.map.WorldMap;
import com.example.renderer.ConsoleRenderer;
import com.example.renderer.Renderer;

public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap(5, 5);
        worldMap.put(new Grass(), new Coordinates(0, 0));
        worldMap.put(new Herbivore(), new Coordinates(3, 3));
        Renderer renderer = new ConsoleRenderer();
        renderer.show(worldMap);

        Herbivore rabbit = (Herbivore) worldMap.get(new Coordinates(3, 3));
        rabbit.makeMove(worldMap, new Coordinates(3, 3));
        renderer.show(worldMap);

    }
}