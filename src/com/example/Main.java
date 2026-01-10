package com.example;

import com.example.actions.MoveAction;
import com.example.actions.RespawnAction;
import com.example.actions.SpawnAction;
import com.example.callback.ModelCallbackManager;
import com.example.map.WorldMap;
import com.example.view.renderer.ConsoleRenderer;
import com.example.view.renderer.Renderer;
import com.example.view.dialog.ConsoleViewMessage;

public class Main {
    public static void main(String[] args) {
        WorldMap worldMap = new WorldMap(10, 10);
        ConsoleViewMessage consoleViewMessage = new ConsoleViewMessage();
        ModelCallbackManager modelCallbackManager = new ModelCallbackManager(consoleViewMessage);
        Renderer renderer = new ConsoleRenderer();

//        modelCallbackManager.setupHealthCallBack(herbivore);
//        modelCallbackManager.setupHealthCallBack(herbivore2);
//        modelCallbackManager.setupActionCallBack(predator);
        // Теперь ходы — коллбеки сработают во время makeMove

        RespawnAction respawnAction = new RespawnAction();
        SpawnAction spawnAction = new SpawnAction();
        MoveAction moveAction = new MoveAction();

//        Predator predator = new Predator();
//        Herbivore herbivore = new Herbivore();
//        worldMap.put(predator, new Coordinates(5,5));
//        worldMap.put(herbivore, new Coordinates(0,0));

        spawnAction.execute(worldMap);
        renderer.show(worldMap);

        moveAction.execute(worldMap);
        renderer.show(worldMap);

        moveAction.execute(worldMap);
        renderer.show(worldMap);

        moveAction.execute(worldMap);
        renderer.show(worldMap);

//        predator.makeMove(worldMap, predatorCoordinates);
//        renderer.show(worldMap);
//
//        predator.makeMove(worldMap, predatorCoordinates);
//        renderer.show(worldMap);
//
//        predator.makeMove(worldMap, predatorCoordinates);
//        renderer.show(worldMap);
//
//        predator.makeMove(worldMap, predatorCoordinates);
//        renderer.show(worldMap);
//
//        predator.makeMove(worldMap, predatorCoordinates);
//        renderer.show(worldMap);
//
//        predator.makeMove(worldMap, predatorCoordinates);
//        renderer.show(worldMap);
    }
}