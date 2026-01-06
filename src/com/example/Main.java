package com.example;

import com.example.actions.MoveAction;
import com.example.actions.RespawnAction;
import com.example.actions.SpawnAction;
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
        WorldMap worldMap = new WorldMap(7, 7);
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

        spawnAction.execute(worldMap);
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