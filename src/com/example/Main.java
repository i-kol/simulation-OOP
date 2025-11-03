package com.example;

import com.example.entities.Grass;
import com.example.entities.Herbivore;
import com.example.map.Coordinates;
import com.example.map.WorldMap;

public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap(5, 5);
        worldMap.put(new Grass(), new Coordinates(2, 2));
        worldMap.put(new Herbivore(), new Coordinates(3, 3));


    }
}