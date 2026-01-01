package com.example;

import com.example.callback.ModelCallbackManager;
import com.example.entities.Creature;
import com.example.entities.Entity;
import com.example.entities.Herbivore;
import com.example.entities.Predator;
import com.example.map.Coordinates;
import com.example.map.WorldMap;
import com.example.view.ConsoleRenderer;
import com.example.view.Renderer;

public class Main {
    public static void main(String[] args) {
//        worldMap.put(new Grass(), new Coordinates(0, 0));
        WorldMap worldMap = new WorldMap(5, 5);
        ModelCallbackManager modelCallbackManager = new ModelCallbackManager();

        Herbivore herbivore = new Herbivore();
        Predator predator = new Predator();
        Coordinates herbivoreCoordinates = new Coordinates(2, 2);
        Coordinates predatorCoordinates = new Coordinates(4, 4);
        worldMap.put(herbivore, herbivoreCoordinates);
        worldMap.put(predator, predatorCoordinates);

        Renderer renderer = new ConsoleRenderer();

        modelCallbackManager.setupHealthUpdateCallBack(herbivore);
        modelCallbackManager.setupCallBack(predator);
        // Теперь ходы — коллбеки сработают во время makeMove

        renderer.show(worldMap);

        predator.makeMove(worldMap, predatorCoordinates);
        renderer.show(worldMap);

        predator.makeMove(worldMap, predatorCoordinates);
        renderer.show(worldMap);

        predator.makeMove(worldMap, predatorCoordinates);
        renderer.show(worldMap);

        predator.makeMove(worldMap, predatorCoordinates);
        renderer.show(worldMap);

        predator.makeMove(worldMap, predatorCoordinates);
        renderer.show(worldMap);

        //TODO волк подходит к зайцу, но не атакует (пытается сделать makeStep, вместо attackTarget)
    }
}