package com.example;

import com.example.callback.ModelCallbackManager;
import com.example.entities.Herbivore;
import com.example.entities.Predator;
import com.example.map.Coordinates;
import com.example.map.WorldMap;
import com.example.view.ConsoleRenderer;
import com.example.view.Renderer;
import com.example.view.dialog.ConsoleViewMessage;

public class Main {
    public static void main(String[] args) {
//        worldMap.put(new Grass(), new Coordinates(0, 0));
        WorldMap worldMap = new WorldMap(5, 5);
        ConsoleViewMessage consoleViewMessage = new ConsoleViewMessage();
        ModelCallbackManager modelCallbackManager = new ModelCallbackManager(consoleViewMessage);

        Herbivore herbivore = new Herbivore();
        Herbivore herbivore2 = new Herbivore();
        Predator predator = new Predator();
        Coordinates herbivoreCoordinates = new Coordinates(2, 2);
        Coordinates herbivoreCoordinates2 = new Coordinates(0, 0);
        Coordinates predatorCoordinates = new Coordinates(3, 3);
        worldMap.put(herbivore, herbivoreCoordinates);
        worldMap.put(herbivore2, herbivoreCoordinates2);
        worldMap.put(predator, predatorCoordinates);

        Renderer renderer = new ConsoleRenderer();

        modelCallbackManager.setupHealthCallBack(herbivore);
        modelCallbackManager.setupHealthCallBack(herbivore2);
        modelCallbackManager.setupActionCallBack(predator);
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

        predator.makeMove(worldMap, predatorCoordinates);
        renderer.show(worldMap);
    }
}